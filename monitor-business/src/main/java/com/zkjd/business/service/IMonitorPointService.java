package com.zkjd.business.service;

import com.zkjd.business.domain.MonitorPoint;
import com.zkjd.business.domain.Record;
import com.zkjd.business.vo.TreeData;

import java.util.List;

/**
 * 监测点Service接口
 * 
 * @author wangtao
 * @date 2021-12-01
 */
public interface IMonitorPointService 
{
    /**
     * 查询监测点
     * 
     * @param monitorPid 监测点主键
     * @return 监测点
     */
    public MonitorPoint selectMonitorPointById(Long monitorPid);

    /**
     * 查询监测点列表
     * 
     * @param monitorPoint 监测点
     * @return 监测点集合
     */
    public List<MonitorPoint> selectMonitorPointList(MonitorPoint monitorPoint);

    /**
     * 新增监测点
     * 
     * @param monitorPoint 监测点
     * @return 结果
     */
    public int insertMonitorPoint(MonitorPoint monitorPoint);

    /**
     * 修改监测点
     * 
     * @param monitorPoint 监测点
     * @return 结果
     */
    public int updateMonitorPoint(MonitorPoint monitorPoint);

    /**
     * 批量删除监测点
     * 
     * @param ids 需要删除的监测点主键集合
     * @return 结果
     */
    public int deleteMonitorPointByIds(Long[] ids);

    /**
     * 删除监测点信息
     * 
     * @param monitorPid 监测点主键
     * @return 结果
     */
    public int deleteMonitorPointById(Long monitorPid);

    /**
     * 查询监测点近十二小时数据
     *
     * @param monitorPid 监测点主键
     * @return 监测点
     */
    public List<Record> selectMonitorPointChartById(Long monitorPid);

    /**
     * 获取视频监控监测点数据
     * @return
     */
    List<TreeData> getMonitorPoints();
}
