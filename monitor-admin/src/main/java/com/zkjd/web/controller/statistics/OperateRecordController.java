package com.zkjd.web.controller.statistics;

import com.zkjd.business.domain.OperateRecord;
import com.zkjd.business.service.IOperateRecordService;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 设备操作记录Controller
 *
 * @author zkjd
 * @date 2022-06-21
 */
@RestController
@RequestMapping("/device/operate/")
public class OperateRecordController extends BaseController {

    @Autowired
    private IOperateRecordService operateRecordService;

    /**
     * 查询设备操作记录列表
     */
    @PreAuthorize("@ss.hasPermi('device:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(OperateRecord operateRecord)
    {
        startPage();
        List<OperateRecord> list = operateRecordService.selectOperateRecordList(operateRecord);
        return getDataTable(list);
    }
}
