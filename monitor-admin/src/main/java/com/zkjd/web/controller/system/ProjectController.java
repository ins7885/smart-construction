package com.zkjd.web.controller.system;

import com.zkjd.business.domain.Project;
import com.zkjd.business.service.ProjectService;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.core.page.TableDataInfo;
import com.zkjd.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 20:03
 * @Description: 项目信息处理
 */
@RestController
@RequestMapping("/system/project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    /**
     * 获取项目列表(分页)
     */
    @PreAuthorize("@ss.hasPermi('system:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(Project project) {
        startPage();
        List<Project> list = projectService.selectProjectList(project);
        return getDataTable(list);
    }

    /**
     * 获取项目列表（不分页）
     */
    @GetMapping("/projects")
    public TableDataInfo projects(Project project) {
        List<Project> list = projectService.selectProjectList(project);
        return getDataTable(list);
    }


    /**
     * 根据项目编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable Long projectId) {
        return AjaxResult.success(projectService.selectProjectById(projectId));
    }

    /**
     * 新增项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:add')")
    @Log(title = "工程项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Project project) {
        project.setCreateBy(getUsername());
        return toAjax(projectService.insertProject(project));
    }

    /**
     * 修改项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "工程项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Project project) {
        project.setUpdateBy(getUsername());
        return toAjax(projectService.updateProject(project));
    }

    /**
     * 删除项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:remove')")
    @Log(title = "工程项目", businessType = BusinessType.DELETE)
    @DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds) {
        return toAjax(projectService.deleteProjectByIds(projectIds));
    }
}
