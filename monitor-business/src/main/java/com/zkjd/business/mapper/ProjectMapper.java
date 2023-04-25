package com.zkjd.business.mapper;

import com.zkjd.business.domain.Project;
import com.zkjd.business.vo.ProjectVO;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 19:29
 * @Description: 项目信息数据库接口
 */
public interface ProjectMapper {

    /**
     * 查询项目信息
     *
     * @param projectId 项目ID
     * @return 项目信息
     */
    Project selectProjectById(Long projectId);

    /**
     * 查询项目列表
     *
     * @param project 项目信息
     * @return 项目集合
     */
    List<Project> selectProjectList(Project project);

    /**
     * 新增项目
     *
     * @param project 项目信息
     * @return 结果
     */
    int insertProject(Project project);

    /**
     * 修改项目
     *
     * @param project 项目信息
     * @return 结果
     */
    int updateProject(Project project);

    /**
     * 批量删除项目
     *
     * @param projectId 项目ID
     * @return 结果
     */
    int deleteProjectById(Long projectId);

    /**
     * 批量删除项目信息
     *
     * @param projectIds 需要删除的项目ID
     * @return 结果
     */
    int deleteProjectByIds(Long[] projectIds);

    /**
     * 获取警告项目数量
     * @return
     */
    Integer getWarnCont();

    /**
     * 获取项目数据
     * @return
     */
    Integer getProjectCount();

    /**
     * 获取项目省份分布
     * @return
     */
    List<ProjectVO> getProjectProvince();
}
