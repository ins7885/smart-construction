package com.zkjd.business.mapper;

import com.zkjd.business.domain.ClimbFrame;
import com.zkjd.business.vo.ClimbFrameVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 19:30
 * @Description: 爬架信息数据库接口
 */
public interface ClimbFrameMapper {

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
     * 查询关联的楼栋信息个数
     *
     * @param ids
     * @return
     */
    Integer getCountByMonomerIds(@Param("list") List<Long> ids);


    /**
     * 校验人脸设备是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    Integer checkDeviceSerialUnique(String userName);

}
