package com.zkjd.business.mapper;

import com.zkjd.business.domain.Device;
import com.zkjd.business.vo.AppDeviceVO;

import java.util.List;

/**
 * 监测设备Mapper接口
 *
 * @author xuxiang
 * @date 2021-11-04
 */
public interface DeviceMapper {
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
     * 删除监测设备
     *
     * @param deviceId 监测设备主键
     * @return 结果
     */
    public int deleteDeviceByDeviceId(String deviceId);

    /**
     * 批量删除监测设备
     *
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceByDeviceIds(String[] deviceIds);

    /**
     * app端技术人员获取最新设备信息
     * @author XuXiang  @time 2021/11/4 15:11
     * @return
     */
    List<AppDeviceVO> getOneDeviceByUser(Long userId);

    /**
     * 获取警告项目数量
     * @return
     */
    Integer getWarnCont();
}
