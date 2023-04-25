package com.zkjd.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.zkjd.business.domain.MonitorPoint;
import com.zkjd.business.domain.Record;
import com.zkjd.business.mapper.MonitorPointMapper;
import com.zkjd.business.service.IMonitorPointService;
import com.zkjd.business.vo.TreeData;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 监测点Service业务层处理
 * 
 * @author wangtao
 * @date 2021-12-01
 */
@Service
public class MonitorPointServiceImpl implements IMonitorPointService
{
    @Autowired
    private MonitorPointMapper monitorPointMapper;

    /**
     * 查询监测点
     * 
     * @param monitorPid 监测点主键
     * @return 监测点
     */
    @Override
    public MonitorPoint selectMonitorPointById(Long monitorPid)
    {
        return monitorPointMapper.selectMonitorPointById(monitorPid);
    }

    /**
     * 查询监测点列表
     * 
     * @param monitorPoint 监测点
     * @return 监测点
     */
    @Override
    public List<MonitorPoint> selectMonitorPointList(MonitorPoint monitorPoint)
    {
        return monitorPointMapper.selectMonitorPointList(monitorPoint);
    }

    /**
     * 新增监测点
     * 
     * @param monitorPoint 监测点
     * @return 结果
     */
    @Override
    public int insertMonitorPoint(MonitorPoint monitorPoint)
    {
        monitorPoint.setCreateTime(DateUtils.getNowDate());
        return monitorPointMapper.insertMonitorPoint(monitorPoint);
    }

    /**
     * 修改监测点
     * 
     * @param monitorPoint 监测点
     * @return 结果
     */
    @Override
    public int updateMonitorPoint(MonitorPoint monitorPoint)
    {
        monitorPoint.setUpdateTime(DateUtils.getNowDate());
        return monitorPointMapper.updateMonitorPoint(monitorPoint);
    }

    /**
     * 批量删除监测点
     * 
     * @param ids 需要删除的监测点主键
     * @return 结果
     */
    @Override
    public int deleteMonitorPointByIds(Long[] ids)
    {
        return monitorPointMapper.deleteMonitorPointByIds(ids);
    }

    /**
     * 删除监测点信息
     * 
     * @param monitorPid 监测点主键
     * @return 结果
     */
    @Override
    public int deleteMonitorPointById(Long monitorPid)
    {
        return monitorPointMapper.deleteMonitorPointById(monitorPid);
    }

    @Override
    public List<Record> selectMonitorPointChartById(Long monitorPid) {
        return monitorPointMapper.selectMonitorPointChartById(monitorPid);
    }

    @Override
    public List<TreeData> getMonitorPoints() {
        List<MonitorPoint> monitorPoints = monitorPointMapper.getMonitorPoints();
        List<TreeData> data = new ArrayList<>();
        if(monitorPoints != null && monitorPoints.size()>0){
            // 根据项目分组
            Map<Long, List<MonitorPoint>> pMap = monitorPoints.stream().collect(Collectors.groupingBy(MonitorPoint::getProjectId));
            for(Map.Entry<Long, List<MonitorPoint>> entry : pMap.entrySet()){
                List<MonitorPoint> value = entry.getValue();
                //项目级别数据
                TreeData pTree = new TreeData();
                pTree.setId(value.get(0).getMonitorPid());
                pTree.setLabel(value.get(0).getProjectName());
                pTree.setDisabled(true);
                List<TreeData> pChild = new ArrayList<>();
                // 根据爬架分组
                Map<Long, List<MonitorPoint>> cMap = value.stream().collect(Collectors.groupingBy(MonitorPoint::getClimbFrameId));
                value.forEach(o->{
                    // 项目子级数据
                    TreeData pTreeChild = new TreeData();
                    pTreeChild.setId(o.getMonitorPid());
                    pTreeChild.setLabel(o.getClimbFrameName());
                    pTreeChild.setDisabled(true);
                    pChild.add(pTreeChild);
                    List<MonitorPoint> points = cMap.get(o.getClimbFrameId());
                    // 爬架级别数据
                    List<TreeData> cChild = new ArrayList<>();
                    points.forEach(e->{
                        // 爬架子级数据
                        TreeData cTreeChild = new TreeData();
                        cTreeChild.setId(e.getMonitorPid());
                        cTreeChild.setLabel(e.getPointName());
                        cTreeChild.setVideoUrl(e.getVideoUrl());
                        cTreeChild.setNameSpace(e.getNameSpace());
                        cTreeChild.setDeviceId(e.getDeviceId());
                        cChild.add(cTreeChild);
                    });
                    pTreeChild.setChildren(cChild);
                });
                pTree.setChildren(pChild);
                data.add(pTree);
            }
        }
        return data;
    }
}
