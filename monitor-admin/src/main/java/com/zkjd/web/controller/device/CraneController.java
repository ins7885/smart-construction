package com.zkjd.web.controller.device;

import java.util.List;

import com.zkjd.business.domain.Crane;
import com.zkjd.business.service.ICraneService;
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
 * 电葫芦设备Controller
 * 
 * @author wangtao
 * @date 2021-11-17
 */
@RestController
@RequestMapping("/device/crane")
public class CraneController extends BaseController
{
    @Autowired
    private ICraneService craneService;

    /**
     * 查询电葫芦设备列表
     */
    @PreAuthorize("@ss.hasPermi('device:crane:list')")
    @GetMapping("/list")
    public TableDataInfo list(Crane crane)
    {
        startPage();
        Long projectId = getLoginUser().getUser().getProjectId();
        crane.setProjectId(projectId);
        List<Crane> list = craneService.selectCraneList(crane);
        return getDataTable(list);
    }

    /**
     * 导出电葫芦设备列表
     */
    @PreAuthorize("@ss.hasPermi('device:crane:export')")
    @Log(title = "电葫芦设备", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Crane crane)
    {
        List<Crane> list = craneService.selectCraneList(crane);
        ExcelUtil<Crane> util = new ExcelUtil<Crane>(Crane.class);
        return util.exportExcel(list, "电葫芦设备数据");
    }

    /**
     * 获取电葫芦设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:crane:query')")
    @GetMapping(value = "/{craneId}")
    public AjaxResult getInfo(@PathVariable("craneId") Long craneId)
    {
        return AjaxResult.success(craneService.selectCraneByCraneId(craneId));
    }

    /**
     * 新增电葫芦设备
     */
    @PreAuthorize("@ss.hasPermi('device:crane:add')")
    @Log(title = "电葫芦设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Crane crane)
    {
        return toAjax(craneService.insertCrane(crane));
    }

    /**
     * 修改电葫芦设备
     */
    @PreAuthorize("@ss.hasPermi('device:crane:edit')")
    @Log(title = "电葫芦设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Crane crane)
    {
        return toAjax(craneService.updateCrane(crane));
    }

    /**
     * 删除电葫芦设备
     */
    @PreAuthorize("@ss.hasPermi('device:crane:remove')")
    @Log(title = "电葫芦设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{craneIds}")
    public AjaxResult remove(@PathVariable Long[] craneIds)
    {
        return toAjax(craneService.deleteCraneByCraneIds(craneIds));
    }

    /**
     * 根据爬架ID获取电葫芦数据
     */
    @GetMapping(value = "/getById/{climbFrameId}")
    public AjaxResult getCrane(@PathVariable Long climbFrameId) {
        return AjaxResult.success(craneService.getCranesByclimbFrameId(climbFrameId));
    }
}
