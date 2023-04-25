package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.WorkTask;
import com.zkjd.business.mapper.WorkTaskMapper;
import com.zkjd.business.service.IWorkTaskService;
import com.zkjd.common.utils.DateUtils;
import com.zkjd.common.utils.SecurityUtils;
import com.zkjd.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工作任务Service业务层处理
 * 
 * @author zkjd
 * @date 2022-02-22
 */
@Service
public class WorkTaskServiceImpl implements IWorkTaskService
{
    @Autowired
    private WorkTaskMapper workTaskMapper;

    /**
     * 查询工作任务
     * 
     * @param taskId 工作任务主键
     * @return 工作任务
     */
    @Override
    public WorkTask selectWorkTaskByTaskId(Long taskId)
    {
        return workTaskMapper.selectWorkTaskByTaskId(taskId);
    }

    /**
     * 查询工作任务列表
     * 
     * @param workTask 工作任务
     * @return 工作任务
     */
    @Override
    public List<WorkTask> selectWorkTaskList(WorkTask workTask)
    {
        return workTaskMapper.selectWorkTaskList(workTask);
    }

    /**
     * 新增工作任务
     * 
     * @param workTask 工作任务
     * @return 结果
     */
    @Override
    public int insertWorkTask(WorkTask workTask)
    {
        workTask.setCreateBy(SecurityUtils.getUsername());
        workTask.setCreateTime(DateUtils.getNowDate());
        return workTaskMapper.insertWorkTask(workTask);
    }

    /**
     * 修改工作任务
     * 
     * @param workTask 工作任务
     * @return 结果
     */
    @Override
    public int updateWorkTask(WorkTask workTask)
    {
        workTask.setUpdateBy(SecurityUtils.getUsername());
        workTask.setUpdateTime(DateUtils.getNowDate());
        return workTaskMapper.updateWorkTask(workTask);
    }

    /**
     * 批量删除工作任务
     * 
     * @param taskIds 需要删除的工作任务主键
     * @return 结果
     */
    @Override
    public int deleteWorkTaskByTaskIds(Long[] taskIds)
    {
        return workTaskMapper.deleteWorkTaskByTaskIds(taskIds);
    }

    /**
     * 删除工作任务信息
     * 
     * @param taskId 工作任务主键
     * @return 结果
     */
    @Override
    public int deleteWorkTaskByTaskId(Long taskId)
    {
        return workTaskMapper.deleteWorkTaskByTaskId(taskId);
    }
}
