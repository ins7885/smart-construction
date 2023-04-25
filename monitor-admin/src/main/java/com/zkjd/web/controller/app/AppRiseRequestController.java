package com.zkjd.web.controller.app;

import com.alibaba.fastjson.JSON;
import com.zkjd.business.domain.*;
import com.zkjd.business.service.IRiseRequestRecordService;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author luckyS
 * @Date 11.12 21:12
 **/

@RestController
@RequestMapping("/appRise")
public class AppRiseRequestController  extends BaseController {

    @Autowired
    private IRiseRequestRecordService riseRequestRecordService;

    /**
     * 技术人员 - 获取提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getRiseRequestInfoList")
    @ResponseBody
    public AjaxResult getRiseRequestInfoList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        Long climbFrameId = null;
        if (map != null && map.size() > 0) {
            climbFrameId = ((Integer) map.get("climbFrameId")).longValue();
        }
        List<RiseRequestInfo> riseRecordList = riseRequestRecordService.getRiseRequestRecordList(page, pageSize, climbFrameId);
        return AjaxResult.success(riseRecordList);
    }


    /**
     * 技术人员 -保存使用前检查记录
     *
     * @author XuXiang  @time 2021/11/16 16:42
     */

    /**
     * 技术人员 - 保存提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/saveRiseRequestRecord")
    @ResponseBody
    public AjaxResult saveRiseRecord(@RequestBody RiseRequestInfo riseRecord) {
        int i = riseRequestRecordService.insertRiseRequestRecord(riseRecord);
        if (i > 0) {
            return AjaxResult.success("保存成功");
        }
        return AjaxResult.error("保存失败");
    }

    /**
     * 技术人员 - 根据id获取提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getRiseRequestInfoById/{id}")
    @ResponseBody
    public AjaxResult getRiseRequestInfoById(@PathVariable("id") Long id) {
        RiseRequestInfo result = riseRequestRecordService.getRiseRequestInfoById(id);
        if (result != null) {
            return AjaxResult.success(result);
        }
        return error("获取提升记录失败");
    }

    /**
     * 技术人员 - 更新提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/updateRiseRequestInfo")
    @ResponseBody
    public AjaxResult updateRiseRecord(@RequestBody RiseRequestInfo riseRecord) {
        int i = riseRequestRecordService.updateRiseRequestInfo(riseRecord);
        if (i > 0) {
            return AjaxResult.success("保存成功");
        }
        return AjaxResult.error("保存失败");
    }


    /**
     * 技术人员 - 更新提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/createProcess")
    @ResponseBody
    public AjaxResult createProcess(@RequestBody RiseRequestProcess riseRecord) {
        int i = riseRequestRecordService.createProcess(riseRecord);
        if (i > 0) {
            return AjaxResult.success("保存成功");
        }
        return AjaxResult.error("保存失败");
    }
    /**
     * 技术人员 - 更新提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getProcessInfoByRequestId/{id}")
    @ResponseBody
    public AjaxResult getProcessInfoByRequestId(@PathVariable("id") Long id) {
        RiseRequestProcess result = riseRequestRecordService.getProcessInfoByRequestId(id);
        if (result != null) {
            return AjaxResult.success(result);
        }
        return error("获取提升记录失败");
    }

}
