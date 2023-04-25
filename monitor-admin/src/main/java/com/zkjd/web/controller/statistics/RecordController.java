package com.zkjd.web.controller.statistics;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkjd.business.domain.Record;
import com.zkjd.business.service.IRecordService;
import com.zkjd.common.constant.HttpStatus;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.page.TableDataInfo;
import com.zkjd.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-12-12 22:01
 * @Description: 历史记录Controller
 */
@RestController
@RequestMapping("/device/record")
public class RecordController  extends BaseController {

    @Autowired
    private IRecordService recordService;

    /**
     * 查询历史记录列表
     */
    @PreAuthorize("@ss.hasPermi('equipment:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(Record record)
    {
//        startPage();
        //清除分页拼接的LIMIT
        PageHelper.clearPage();
        //重新计算页码
        record.setNum((record.getNum()-1)*record.getSize());
        //获取列表(分页属性不能是pageSize和pageNum(会和PageHelper冲突),不然会存在执行select count(0)和SQL后面自动拼接LIMIT)
        // 需要判断是否带有查询条件
        List<Record> list;
        // 不带查询条件
        if(StringUtils.isEmpty(record.getMonomer())&&StringUtils.isEmpty(record.getType())
                &&StringUtils.isEmpty(record.getPointName())&&StringUtils.isEmpty(record.getRecordValue())
                &&StringUtils.isEmpty(record.getIsWarn())&&record.getProjectId()==null
                &&record.getMonitorPid()==null&&record.getRecordTime() == null){
            list = recordService.selectNoConditionRecord(record);
        }else{// 带有查询条件
            list = recordService.selectRecordList(record);
        }
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        //获取行数
        rspData.setTotal(recordService.selectRecordCount(record));
        return rspData;
    }
}
