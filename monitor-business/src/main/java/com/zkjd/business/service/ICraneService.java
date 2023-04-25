package com.zkjd.business.service;

import com.zkjd.business.domain.Crane;
import com.zkjd.business.vo.AppCraneVO;
import com.zkjd.business.vo.CraneVO;

import java.util.List;

/**
 * 电葫芦设备Service接口
 *
 * @author wangtao
 * @date 2021-11-17
 */
public interface ICraneService {
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
     * 批量删除电葫芦设备
     *
     * @param craneIds 需要删除的电葫芦设备主键集合
     * @return 结果
     */
    public int deleteCraneByCraneIds(Long[] craneIds);

    /**
     * 删除电葫芦设备信息
     *
     * @param craneId 电葫芦设备主键
     * @return 结果
     */
    public int deleteCraneByCraneId(Long craneId);

    /**
     * 根据爬架ID获取电葫芦数据
     * @param climbFrameId
     * @return
     */
    public List<Crane> getCranesByclimbFrameId(Long climbFrameId);

    /**
     * 根据爬架ID获取电葫芦列表
     * @param climbFrameId
     * @return
     */
    List<AppCraneVO> getCraneByClimbFrameId(Long climbFrameId);

    /**
     * 根据爬架ID获取监测点列表(注意:这里的CraneVO名称是和实际意义不符的,是借过来用的,因为该VO中的字段符合实际意义)
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
    CraneVO getPointInfo(Integer climbFrameId, Integer monitorPid);

}
