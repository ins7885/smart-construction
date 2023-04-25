package com.zkjd.web.core.config;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.ListenPoint;
import com.zkjd.business.service.WarnService;
import com.zkjd.common.constant.Constants;
import com.zkjd.system.mapper.SysDictDataMapper;
import com.zkjd.web.core.utils.UniPushUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zkjd
 * @Description: 事件监听器
 * @Date: create in 2022/7/1 0:41
 */
@Slf4j
@CanalEventListener
public class CanalListener {

    @Autowired
    private WarnService warnService;

    @Autowired
    private SysDictDataMapper dictDataMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UniPushConfig uniPushConfig;

    /**
     * 监听intelligent-monitor数据库的tab_warn表数据插入操作
     * @param eventType 操作类型
     * @param rowData 操作当前行数据
     */
    @ListenPoint(schema = "intelligent-monitor",table = "tab_warn",eventType = CanalEntry.EventType.INSERT)
    public void saveData(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
        pushWarn(rowData.getAfterColumnsList());
    }

    /**
     * 推送告警信息
     * @param columns 字段和数据
     */
    private void pushWarn(List<CanalEntry.Column> columns) {
        String title = "";
        String content = "";
        String time = "";
        List<Long> userIds = new ArrayList<>();
        for (CanalEntry.Column column : columns) {
            log.info(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
            if("point_id".equals(column.getName())){
                userIds = warnService.getUserIdByPointId(column.getValue());
            }
            if("warn_type".equals(column.getName())){
                title = dictDataMapper.selectDictLabel(column.getName(),column.getValue());
            }
            if("warn_desc".equals(column.getName())){
                content = column.getValue();
            }
            if("warn_time".equals(column.getName())){
                time = column.getValue();
            }
        }
        // 循环推送告警信息
        for (Long o : userIds){
            String clientId = redisTemplate.opsForValue().get(Constants.UNI_PUSH_KEY_PREFIX + o);
            // 没有在缓存中的,说明该用户未进行注册到uni-push
            if(clientId != null){
                UniPushUtils.singlePush(title,content + "[" + time + "]",clientId,uniPushConfig);
            }
        }
    }
}
