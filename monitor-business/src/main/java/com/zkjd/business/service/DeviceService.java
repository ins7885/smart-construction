package com.zkjd.business.service;

import com.zkjd.business.domain.Device;
import com.zkjd.common.core.domain.AjaxResult;

import java.util.List;


/**
 * 监测设备Service接口
 *
 * @author xuxiang
 * @date 2021-11-04
 */
public interface DeviceService {
    /**
     * 查询监测设备
     *
     * @param deviceId 监测设备主键
     * @return 监测设备
     */
    public Device selectDeviceByDeviceId(String deviceId);

    /**
     * 查询监测设备列表
     *
     * @param device 监测设备
     * @return 监测设备集合
     */
    public List<Device> selectDeviceList(Device device);

    /**
     * 新增监测设备
     *
     * @param device 监测设备
     * @return 结果
     */
    public int insertDevice(Device device);

    /**
     * 修改监测设备
     *
     * @param device 监测设备
     * @return 结果
     */
    public int updateDevice(Device device);

    /**
     * 批量删除监测设备
     *
     * @param deviceIds 需要删除的监测设备主键集合
     * @return 结果
     */
    public int deleteDeviceByDeviceIds(String[] deviceIds);

    /**
     * 删除监测设备信息
     *
     * @param deviceId 监测设备主键
     * @return 结果
     */
    public int deleteDeviceByDeviceId(String deviceId);

    /**
     * 根据用户信息,加载最近一条设备信息
     * @author XuXiang  @time 2021/11/4 13:49
     * @param userId
     * @param roleKey
     * @return
     */
    AjaxResult getOneDeviceByUser(Long userId,String roleKey);

    /**
     * 获取警告项目数量
     * @author XuXiang  @time 2021/11/10 10:14
     * @return
     */
    Integer getWarnCont();
}
