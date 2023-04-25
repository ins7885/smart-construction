package com.zkjd.business.mapper;

import com.zkjd.business.domain.Crane;
import com.zkjd.business.vo.CraneVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 电葫芦设备Mapper接口
 *
 * @author wangtao
 * @date 2021-11-17
 */
public interface CraneMapper {
    /**
     * 查询电葫芦设备
     *
     * @param craneId 电葫芦设备主键
     * @return 电葫芦设备
     */
    public Crane selectCraneByCraneId(Long craneId);

    /**
     * 查询电葫芦设备列表
     *
     * @param crane 电葫芦设备
     * @return 电葫芦设备集合
     */
    public List<Crane> selectCraneList(Crane crane);

    /**
     * 新增电葫芦设备
     *
     * @param crane 电葫芦设备
     * @return 结果
     */
    public int insertCrane(Crane crane);

    /**
     * 修改电葫芦设备
     *
     * @param crane 电葫芦设备
     * @return 结果
     */
    public int updateCrane(Crane crane);

    /**
     * 删除电葫芦设备
     *
     * @param craneId 电葫芦设备主键
     * @return 结果
     */
    public int deleteCraneByCraneId(Long craneId);

    /**
     * 批量删除电葫芦设备
     *
     * @param craneIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCraneByCraneIds(Long[] craneIds);

    /**
     * 根据爬架ID获取电葫芦数据
     * @param climbFrameId
     * @return
     */
    public List<Crane> getCranesByclimbFrameId(Long climbFrameId);

    /**
     * 根据电葫芦ID获取监测点及监测值列表_实时
     * @param climbFrameId
     * @return
     */
    List<CraneVO> getRecordNewByCraneId(Long climbFrameId);

    /**
     * 根据电葫芦ID获取监测点及监测值列表_历史
     * @param climbFrameId
     * @return
     */
    List<CraneVO> getRecordDataByCraneId(@Param("climbFrameId") Long climbFrameId,@Param("startTime")String startTime,@Param("endTime")String endTime);


    /**
     * 根据电葫芦ID获取监测点及监测值列表(监测点类型及值已转化)
     * @param climbFrameId
     * @return
     */
    List<CraneVO> getPointsByClimbFrameId(Long climbFrameId);

    /**
     * 根据爬架ID和监测点ID获取监测点信息
     * @param climbFrameId
     * @param monitorPid
     * @return
     */
    CraneVO getPointInfo(@Param("climbFrameId") Integer climbFrameId, @Param("monitorPid")Integer monitorPid);

    /**
     * 查询关联的电葫芦信息个数
     * @param ids
     * @return
     */
    Integer getCountByCraneIds(@Param("list") List<Long> ids);
}
