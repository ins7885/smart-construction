package com.zkjd.business.mapper;

import com.zkjd.business.domain.RiseRecord;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.vo.RiseDataVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 提升记录Mapper接口
 *
 * @author zkjd
 * @date 2021-11-18
 */
public interface RiseRecordMapper {
    /**
     * 查询提升记录
     *
     * @param id 提升记录主键
     * @return 提升记录
     */
    public RiseRecord selectRiseRecordById(Long id);

    /**
     * 查询提升记录列表
     *
     * @param riseRecord 提升记录
     * @return 提升记录集合
     */
    public List<RiseRecord> selectRiseRecordList(RiseRecord riseRecord);

    /**
     * 新增提升记录
     *
     * @param riseRecord 提升记录
     * @return 结果
     */
    public int insertRiseRecord(RiseRecord riseRecord);

    /**
     * 修改提升记录
     *
     * @param riseRecord 提升记录
     * @return 结果
     */
    public int updateRiseRecord(RiseRecord riseRecord);

    /**
     * 删除提升记录
     *
     * @param id 提升记录主键
     * @return 结果
     */
    public int deleteRiseRecordById(Long id);

    /**
     * 批量删除提升记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRiseRecordByIds(Long[] ids);

    /**
     * 技术人员提升记录分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<RiseRecord> getRiseRecordList(@Param("page") Integer page, @Param("pageSize") Integer pageSize,@Param("climbFrameId") Long climbFrameId);

    /**
     * 管理员 - 根据爬架ID,获取提升记录
     * @param climbFrameId
     * @param page
     * @param pageSize
     * @return
     */
    List<RiseRecord> adminGetRiseRecordList(@Param("climbFrameId") Integer climbFrameId, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * 获取当天的提升记录数量
     * @return
     */
    Integer getRiseRecordTodayCount();

    /**
     * 根据时间段和爬架ID获取提升次数
     * @param statisticsQO
     * @return
     */
    Integer getRiseNumberByTime(StatisticsQO statisticsQO);

    /**
     * 根据日期范围获取,某天的提升次数
     * @param statisticsQO
     * @return
     */
    List<RiseDataVO> getRiseNumberByDateRange(StatisticsQO statisticsQO);
}