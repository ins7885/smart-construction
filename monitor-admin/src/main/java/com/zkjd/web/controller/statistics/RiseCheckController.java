package com.zkjd.web.controller.statistics;

import java.util.List;

import com.zkjd.business.domain.RiseCheck;
import com.zkjd.business.service.IRiseCheckService;
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
 * 升降脚手架提升作业前检查Controller
 *
 * @author zkjd
 * @date 2022-02-28
 */
@RestController
@RequestMapping("/system/riseCheck")
public class RiseCheckController extends BaseController {
    @Autowired
    private IRiseCheckService riseCheckService;

    /**
     * 查询升降脚手架提升作业前检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:riseCheck:list')")
    @GetMapping("/list")
    public TableDataInfo list(RiseCheck riseCheck) {
        startPage();
        List<RiseCheck> list = riseCheckService.selectRiseCheckList(riseCheck);
        return getDataTable(list);
    }

    /**
     * 导出升降脚手架提升作业前检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:riseCheck:export')")
    @Log(title = "升降脚手架提升作业前检查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RiseCheck riseCheck) {
        List<RiseCheck> list = riseCheckService.selectRiseCheckList(riseCheck);
        ExcelUtil<RiseCheck> util = new ExcelUtil<RiseCheck>(RiseCheck.class);
        return util.exportExcel(list, "升降脚手架提升作业前检查数据");
    }

    /**
     * 获取升降脚手架提升作业前检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:riseCheck:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(riseCheckService.selectRiseCheckById(id));
    }

    /**
     * 新增升降脚手架提升作业前检查
     */
    @PreAuthorize("@ss.hasPermi('system:riseCheck:add')")
    @Log(title = "升降脚手架提升作业前检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RiseCheck riseCheck) {
        return toAjax(riseCheckService.insertRiseCheck(riseCheck));
    }

    /**
     * 修改升降脚手架提升作业前检查
     */
    @PreAuthorize("@ss.hasPermi('system:riseCheck:edit')")
    @Log(title = "升降脚手架提升作业前检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RiseCheck riseCheck) {
        return toAjax(riseCheckService.updateRiseCheck(riseCheck));
    }

    /**
     * 删除升降脚手架提升作业前检查
     */
    @PreAuthorize("@ss.hasPermi('system:riseCheck:remove')")
    @Log(title = "升降脚手架提升作业前检查", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(riseCheckService.deleteRiseCheckByIds(ids));
    }
}
