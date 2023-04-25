package com.zkjd.web.controller.statistics;

import java.util.List;

import com.zkjd.business.domain.CheckRecord;
import com.zkjd.business.service.ICheckRecordService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.common.utils.poi.ExcelUtil;
import com.zkjd.common.core.page.TableDataInfo;

/**
 * 使用前检查Controller
 *
 * @author zkjd
 * @date 2022-02-28
 */
@RestController
@RequestMapping("/system/checkRecord")
public class CheckRecordController extends BaseController {
    @Autowired
    private ICheckRecordService checkRecordService;

    /**
     * 查询使用前检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:checkRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(CheckRecord checkRecord) {
        startPage();
        List<CheckRecord> list = checkRecordService.selectCheckRecordList(checkRecord);
        return getDataTable(list);
    }

    /**
     * 导出使用前检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:checkRecord:export')")
    @Log(title = "使用前检查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CheckRecord checkRecord) {
        List<CheckRecord> list = checkRecordService.selectCheckRecordList(checkRecord);
        ExcelUtil<CheckRecord> util = new ExcelUtil<CheckRecord>(CheckRecord.class);
        return util.exportExcel(list, "使用前检查数据");
    }

    /**
     * 获取使用前检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:checkRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(checkRecordService.selectCheckRecordById(id));
    }

    /**
     * 新增使用前检查
     */
    @PreAuthorize("@ss.hasPermi('system:checkRecord:add')")
    @Log(title = "使用前检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CheckRecord checkRecord) {
        return toAjax(checkRecordService.insertCheckRecord(checkRecord));
    }

    /**
     * 修改使用前检查
     */
    @PreAuthorize("@ss.hasPermi('system:checkRecord:edit')")
    @Log(title = "使用前检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CheckRecord checkRecord) {
        return toAjax(checkRecordService.updateCheckRecord(checkRecord));
    }

    /**
     * 删除使用前检查
     */
    @PreAuthorize("@ss.hasPermi('system:checkRecord:remove')")
    @Log(title = "使用前检查", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(checkRecordService.deleteCheckRecordByIds(ids));
    }
}
