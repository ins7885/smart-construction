package com.zkjd.business.mapper;

import com.zkjd.business.domain.CheckRecord;
import com.zkjd.business.domain.RiseCheck;
import com.zkjd.business.qo.StatisticsQO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 升降脚手架提升作业前检查Mapper接口
 *
 * @author zkjd
 * @date 2021-12-01
 */
public interface RiseCheckMapper {
    /**
     * 查询升降脚手架提升作业前检查
     *
     * @param id 升降脚手架提升作业前检查主键
     * @return 升降脚手架提升作业前检查
     */
    public RiseCheck selectRiseCheckById(Long id);

    /**
     * 查询升降脚手架提升作业前检查列表
     *
     * @param riseCheck 升降脚手架提升作业前检查
     * @return 升降脚手架提升作业前检查集合
     */
    public List<RiseCheck> selectRiseCheckList(RiseCheck riseCheck);

    /**
     * 新增升降脚手架提升作业前检查
     *
     * @param riseCheck 升降脚手架提升作业前检查
     * @return 结果
     */
    public int insertRiseCheck(RiseCheck riseCheck);

    /**
     * 修改升降脚手架提升作业前检查
     *
     * @param riseCheck 升降脚手架提升作业前检查
     * @return 结果
     */
    public int updateRiseCheck(RiseCheck riseCheck);

    /**
     * 删除升降脚手架提升作业前检查
     *
     * @param id 升降脚手架提升作业前检查主键
     * @return 结果
     */
    public int deleteRiseCheckById(Long id);

    /**
     * 批量删除升降脚手架提升作业前检查
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRiseCheckByIds(Long[] ids);

    /**
     * 技术人员 - 升降脚手架提升作业前检查分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<RiseCheck> getRiseCheckPage(@Param("page") Integer page, @Param("pageSize") Integer pageSize,@Param("climbFrameId") Long climbFrameId);

    /**
     * 根据爬架ID获取脚手架提升作业前检查记录
     * @param climbFrameId
     * @return
     */
    List<RiseCheck> getRiseCheckByClimbId(@Param("climbFrameId") Long climbFrameId);

    /**
     * 提升作业前检查验收数
     * @param statisticsQO
     * @return
     */
    Integer getRiseCheckNumber(StatisticsQO statisticsQO);
}
