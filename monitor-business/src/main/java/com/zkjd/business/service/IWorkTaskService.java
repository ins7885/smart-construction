package com.zkjd.business.service;

import com.zkjd.business.domain.WorkTask;
import java.util.List;

/**
 * 工作任务Service接口
 *
 * @author zkjd
 * @date 2022-02-22
 */
public interface IWorkTaskService
{
    /**
     * 查询工作任务
     *
     * @param taskId 工作任务主键
     * @return 工作任务
     */
    public WorkTask selectWorkTaskByTaskId(Long taskId);

    /**
     * 查询工作任务列表
     *
     * @param workTask 工作任务
     * @return 工作任务集合
     */
    public List<WorkTask> selectWorkTaskList(WorkTask workTask);

    /**
     * 新增工作任务
     *
     * @param workTask 工作任务
     * @return 结果
     */
    public int insertWorkTask(WorkTask workTask);

    /**
     * 修改工作任务
     *
     * @param workTask 工作任务
     * @return 结果
     */
    public int updateWorkTask(WorkTask workTask);

    /**
     * 批量删除工作任务
     *
     * @param taskIds 需要删除的工作任务主键集合
     * @return 结果
     */
    public int deleteWorkTaskByTaskIds(Long[] taskIds);

    /**
     * 删除工作任务信息
     *
     * @param taskId 工作任务主键
     * @return 结果
     */
    public int deleteWorkTaskByTaskId(Long taskId);
}

