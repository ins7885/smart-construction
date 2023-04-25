package com.zkjd.web.controller.device;

import java.util.List;

import com.zkjd.business.domain.WorkTask;
import com.zkjd.business.service.IWorkTaskService;
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
 * 工作任务Controller
 * 
 * @author zkjd
 * @date 2022-02-22
 */
@RestController
@RequestMapping("/device/workTask")
public class WorkTaskController extends BaseController
{
    @Autowired
    private IWorkTaskService workTaskService;

    /**
     * 查询工作任务列表
     */
    @PreAuthorize("@ss.hasPermi('device:work-task:list')")
    @GetMapping("/list")
    public TableDataInfo list(WorkTask workTask)
    {
        startPage();
        Long projectId = getLoginUser().getUser().getProjectId();
        workTask.setProjectId(projectId);
        List<WorkTask> list = workTaskService.selectWorkTaskList(workTask);
        return getDataTable(list);
    }

    /**
     * 导出工作任务列表
     */
    @PreAuthorize("@ss.hasPermi('device:work-task:export')")
    @Log(title = "工作任务", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WorkTask workTask)
    {
        List<WorkTask> list = workTaskService.selectWorkTaskList(workTask);
        ExcelUtil<WorkTask> util = new ExcelUtil<WorkTask>(WorkTask.class);
        return util.exportExcel(list, "工作任务数据");
    }

    /**
     * 获取工作任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:work-task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return AjaxResult.success(workTaskService.selectWorkTaskByTaskId(taskId));
    }

    /**
     * 新增工作任务
     */
    @PreAuthorize("@ss.hasPermi('device:work-task:add')")
    @Log(title = "工作任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WorkTask workTask)
    {
        return toAjax(workTaskService.insertWorkTask(workTask));
    }

    /**
     * 修改工作任务
     */
    @PreAuthorize("@ss.hasPermi('device:work-task:edit')")
    @Log(title = "工作任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WorkTask workTask)
    {
        return toAjax(workTaskService.updateWorkTask(workTask));
    }

    /**
     * 删除工作任务
     */
    @PreAuthorize("@ss.hasPermi('device:work-task:remove')")
    @Log(title = "工作任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(workTaskService.deleteWorkTaskByTaskIds(taskIds));
    }
}
