package com.zkjd.web.controller.device;

import java.util.List;

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
import com.zkjd.business.domain.Model;
import com.zkjd.business.service.IModelService;
import com.zkjd.common.utils.poi.ExcelUtil;
import com.zkjd.common.core.page.TableDataInfo;

/**
 * BIM模型Controller
 * 
 * @author wangtao
 * @date 2021-12-02
 */
@RestController
@RequestMapping("/device/model")
public class ModelController extends BaseController
{
    @Autowired
    private IModelService modelService;

    /**
     * 查询BIM模型列表
     */
    @PreAuthorize("@ss.hasPermi('device:model:list')")
    @GetMapping("/list")
    public TableDataInfo list(Model model)
    {
        startPage();
        Long projectId = getLoginUser().getUser().getProjectId();
        model.setProjectId(projectId);
        List<Model> list = modelService.selectModelList(model);
        return getDataTable(list);
    }

    /**
     * 查询BIM模型列表(不分页)
     */
    @GetMapping("/models")
    public TableDataInfo models(Model model)
    {
        List<Model> list = modelService.selectModelList(model);
        return getDataTable(list);
    }

    /**
     * 导出BIM模型列表
     */
    @PreAuthorize("@ss.hasPermi('device:model:export')")
    @Log(title = "BIM模型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Model model)
    {
        List<Model> list = modelService.selectModelList(model);
        ExcelUtil<Model> util = new ExcelUtil<Model>(Model.class);
        return util.exportExcel(list, "BIM模型数据");
    }

    /**
     * 获取BIM模型详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:model:query')")
    @GetMapping(value = "/{modelId}")
    public AjaxResult getInfo(@PathVariable("modelId") Long modelId)
    {
        return AjaxResult.success(modelService.selectModelByModelId(modelId));
    }

    /**
     * 新增BIM模型
     */
    @PreAuthorize("@ss.hasPermi('device:model:add')")
    @Log(title = "BIM模型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Model model)
    {

        return toAjax(modelService.insertModel(model));
    }

    /**
     * 修改BIM模型
     */
    @PreAuthorize("@ss.hasPermi('device:model:edit')")
    @Log(title = "BIM模型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Model model)
    {
        return toAjax(modelService.updateModel(model));
    }

    /**
     * 删除BIM模型
     */
    @PreAuthorize("@ss.hasPermi('device:model:remove')")
    @Log(title = "BIM模型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{modelIds}")
    public AjaxResult remove(@PathVariable Long[] modelIds)
    {
        return toAjax(modelService.deleteModelByModelIds(modelIds));
    }
}
