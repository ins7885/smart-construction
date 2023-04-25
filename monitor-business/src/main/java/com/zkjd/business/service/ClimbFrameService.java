package com.zkjd.business.service;

import com.zkjd.business.domain.ClimbFrame;
import com.zkjd.business.vo.ClimbFrameVO;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 19:26
 * @Description: 爬架业务层接口
 */
public interface ClimbFrameService {

    /**
     * 查询爬架信息
     *
     * @param climbFrameId 公告ID
     * @return 爬架信息
     */
    ClimbFrame selectClimbFrameById(Long climbFrameId);

    /**
     * 查询爬架列表
     *
     * @param climbFrame 爬架信息
     * @return 爬架集合
     */
    List<ClimbFrame> selectClimbFrameList(ClimbFrame climbFrame);

    /**
     * 新增爬架
     *
     * @param climbFrame 爬架信息
     * @return 结果
     */
    int insertClimbFrame(ClimbFrame climbFrame);

    /**
     * 修改爬架
     *
     * @param climbFrame 爬架信息
     * @return 结果
     */
    int updateClimbFrame(ClimbFrame climbFrame);

    /**
     * 批量删除爬架
     *
     * @param climbFrameId 爬架ID
     * @return 结果
     */
    int deleteClimbFrameById(Long climbFrameId);

    /**
     * 批量删除爬架信息
     *
     * @param climbFrameIds 需要删除的爬架ID
     * @return 结果
     */
    int deleteClimbFrameByIds(Long[] climbFrameIds);

    /**
     * 查询当年数据
     *
     * @return
     * @author XuXiang  @time 2021/11/10 9:16
     */
    List<ClimbFrameVO> selectCurrentYear();

    /**
     * 根据项目ID查询爬架信息
     *
     * @param projectId
     * @return
     */
    List<ClimbFrame> getListByProjectId(Long projectId);

    /**
     * 获取爬架数量
     *
     * @return
     */
    Integer getClimbFrameCount();

    /**
     * 锁定爬架
     *
     * @param climbFrame 爬架信息
     * @return 结果
     */
    int lockClimbFrame(ClimbFrame climbFrame);

    /**
     * 校验人脸设备是否唯一
     *
     * @param deviceSerial 人脸设备编号
     * @return 结果
     */
    Integer checkDeviceSerialUnique(String deviceSerial);
}
