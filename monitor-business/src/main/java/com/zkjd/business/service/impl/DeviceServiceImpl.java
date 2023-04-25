package com.zkjd.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zkjd.business.domain.Device;
import com.zkjd.business.mapper.DeviceMapper;
import com.zkjd.business.service.DeviceService;
import com.zkjd.business.vo.AppDeviceVO;
import com.zkjd.common.constant.UserConstants;
import com.zkjd.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 监测设备Service业务层处理
 *
 * @author xuxiang
 * @date 2021-11-04
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 查询监测设备
     *
     * @param deviceId 监测设备主键
     * @return 监测设备
     */
    @Override
    public Device selectDeviceByDeviceId(String deviceId) {
        return deviceMapper.selectDeviceByDeviceId(deviceId);
    }

    /**
     * 查询监测设备列表
     *
     * @param device 监测设备
     * @return 监测设备
     */
    @Override
    public List<Device> selectDeviceList(Device device) {
        return deviceMapper.selectDeviceList(device);
    }

    /**
     * 新增监测设备
     *
     * @param device 监测设备
     * @return 结果
     */
    @Override
    public int insertDevice(Device device) {
        return deviceMapper.insertDevice(device);
    }

    /**
     * 修改监测设备
     *
     * @param device 监测设备
     * @return 结果
     */
    @Override
    public int updateDevice(Device device) {
        return deviceMapper.updateDevice(device);
    }

    /**
     * 批量删除监测设备
     *
     * @param deviceIds 需要删除的监测设备主键
     * @return 结果
     */
    @Override
    public int deleteDeviceByDeviceIds(String[] deviceIds) {
        return deviceMapper.deleteDeviceByDeviceIds(deviceIds);
    }

    /**
     * 删除监测设备信息
     *
     * @param deviceId 监测设备主键
     * @return 结果
     */
    @Override
    public int deleteDeviceByDeviceId(String deviceId) {
        return deviceMapper.deleteDeviceByDeviceId(deviceId);
    }

    /**
     * 根据用户信息,加载最近一条设备信息
     * @author XuXiang  @time 2021/11/4 13:49
     * @param userId
     * @param roleKey
     * @return
     */
    @Override
    public AjaxResult getOneDeviceByUser(Long userId, String roleKey) {
        // 原本是技术人员才能看到的爬架信息,现在所有角色都能看到了
        // if (!"staff".equals(roleKey)) {
        //     return AjaxResult.error("当前用户非技术人员,无法获取设备信息!");
        // }
        // 后期项目和技术人员可能会绑定,需要userId,暂时仅查询最新的一条设备信息
        List<AppDeviceVO> deviceList = new ArrayList<>();
        if(UserConstants.USER_ROLE_01.equals(roleKey)){ // 查询所有
            deviceList = deviceMapper.getOneDeviceByUser(null);
        }else{
            deviceList = deviceMapper.getOneDeviceByUser(userId);
        }
        if (deviceList != null && deviceList.size() > 0) {
            return AjaxResult.success(deviceList.get(0));
        }
        return AjaxResult.error("暂无设备信息");
    }

    @Override
    public Integer getWarnCont() {
        return deviceMapper.getWarnCont();
    }
}
