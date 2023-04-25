package com.zkjd.web.controller.statistics;

import java.util.List;

import com.zkjd.business.domain.DangerCheck;
import com.zkjd.business.service.IDangerCheckService;
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
 * 安全隐患排查Controller
 *
 * @author zkjd
 * @date 2022-01-26
 */
@RestController
@RequestMapping("/system/dangerCheck")
public class DangerCheckController extends BaseController {
    @Autowired
    private IDangerCheckService dangerCheckService;

    /**
     * 查询安全隐患排查列表
     */
    @PreAuthorize("@ss.hasPermi('system:dangerCheck:list')")
    @GetMapping("/list")
    public TableDataInfo list(DangerCheck dangerCheck) {
        startPage();
        List<DangerCheck> list = dangerCheckService.selectDangerCheckList(dangerCheck);
        return getDataTable(list);
    }

    /**
     * 导出安全隐患排查列表
     */
    @PreAuthorize("@ss.hasPermi('system:dangerCheck:export')")
    @Log(title = "安全隐患排查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DangerCheck dangerCheck) {
        List<DangerCheck> list = dangerCheckService.selectDangerCheckList(dangerCheck);
        ExcelUtil<DangerCheck> util = new ExcelUtil<DangerCheck>(DangerCheck.class);
        return util.exportExcel(list, "安全隐患排查数据");
    }

    /**
     * 获取安全隐患排查详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dangerCheck:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(dangerCheckService.selectDangerCheckById(id));
    }

    /**
     * 新增安全隐患排查
     */
    @PreAuthorize("@ss.hasPermi('system:dangerCheck:add')")
    @Log(title = "安全隐患排查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DangerCheck dangerCheck) {
        return toAjax(dangerCheckService.insertDangerCheck(dangerCheck));
    }

    /**
     * 修改安全隐患排查
     */
    @PreAuthorize("@ss.hasPermi('system:dangerCheck:edit')")
    @Log(title = "安全隐患排查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DangerCheck dangerCheck) {
        return toAjax(dangerCheckService.updateDangerCheck(dangerCheck));
    }

    /**
     * 删除安全隐患排查
     */
    @PreAuthorize("@ss.hasPermi('system:dangerCheck:remove')")
    @Log(title = "安全隐患排查", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(dangerCheckService.deleteDangerCheckByIds(ids));
    }
}
