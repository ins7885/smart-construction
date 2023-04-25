package com.zkjd.business.mapper;

import com.zkjd.business.domain.MonitorPoint;
import com.zkjd.business.domain.Record;

import java.util.List;

/**
 * 监测点Mapper接口
 * 
 * @author wangtao
 * @date 2021-12-01
 */
public interface MonitorPointMapper 
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
     * 删除监测点
     * 
     * @param monitorPid 监测点主键
     * @return 结果
     */
    public int deleteMonitorPointById(Long monitorPid);

    /**
     * 批量删除监测点
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMonitorPointByIds(Long[] ids);

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
    List<MonitorPoint> getMonitorPoints();
}
