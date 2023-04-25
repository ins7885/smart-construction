package com.zkjd.business.mapper;

import com.zkjd.business.domain.CheckRecord;
import com.zkjd.business.domain.DangerCheck;
import com.zkjd.business.qo.StatisticsQO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 安全隐患排查Mapper接口
 *
 * @author zkjd
 * @date 2022-01-26
 */
public interface DangerCheckMapper {
    /**
     * 查询安全隐患排查
     *
     * @param id 安全隐患排查主键
     * @return 安全隐患排查
     */
    public DangerCheck selectDangerCheckById(Long id);

    /**
     * 查询安全隐患排查列表
     *
     * @param dangerCheck 安全隐患排查
     * @return 安全隐患排查集合
     */
    public List<DangerCheck> selectDangerCheckList(DangerCheck dangerCheck);

    /**
     * 新增安全隐患排查
     *
     * @param dangerCheck 安全隐患排查
     * @return 结果
     */
    public int insertDangerCheck(DangerCheck dangerCheck);

    /**
     * 修改安全隐患排查
     *
     * @param dangerCheck 安全隐患排查
     * @return 结果
     */
    public int updateDangerCheck(DangerCheck dangerCheck);

    /**
     * 删除安全隐患排查
     *
     * @param id 安全隐患排查主键
     * @return 结果
     */
    public int deleteDangerCheckById(Long id);

    /**
     * 批量删除安全隐患排查
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDangerCheckByIds(Long[] ids);

    /**
     * 获取自己提交的安全隐患检查记录
     * @param page
     * @param pageSize
     * @param checkManId
     * @return
     */
    List<DangerCheck> getDangerCheckOwnerList(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("checkManId") Integer checkManId);

    /**
     * 获取自己提交的安全隐患检查记录
     * @param page
     * @param pageSize
     * @param modifyManId
     * @return
     */
    List<DangerCheck> getWaitModifyList(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("modifyManId") Integer modifyManId);

    /**
     * 获取待复查记录
     * @param page
     * @param pageSize
     * @param reviewManId
     * @return
     */
    List<DangerCheck> getWaitReviewList(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("reviewManId") Integer reviewManId);

    /**
     * 获取已完结记录
     * @param page
     * @param pageSize
     * @param reviewManId
     * @return
     */
    List<DangerCheck> getCompletedList(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("reviewManId") Integer reviewManId);

    /**
     * 安全检查总数
     * @param statisticsQO
     * @return
     */
    Integer getSafeNumberAll(StatisticsQO statisticsQO);

    /**
     * 安全检查整改数
     * @param statisticsQO
     * @return
     */
    Integer getSafeModifyNumber(StatisticsQO statisticsQO);

    /**
     * 安全检查 - 验收数
     * @param statisticsQO
     * @return
     */
    Integer getSafePassNumber(StatisticsQO statisticsQO);
}
