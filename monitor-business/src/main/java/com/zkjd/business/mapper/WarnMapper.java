package com.zkjd.business.mapper;

import com.zkjd.business.domain.Warn;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.vo.AppRiseDataVO;
import com.zkjd.business.vo.WarnDataVO;
import com.zkjd.business.vo.WarnMessageVO;
import com.zkjd.business.vo.WarningDataVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 告警记录Mapper接口
 *
 * @author XuXiang
 * @date 2021-11-10
 */
public interface WarnMapper {
    /**
     * 查询告警记录
     *
     * @param warnId 告警记录主键
     * @return 告警记录
     */
    public Warn selectWarnByWarnId(String warnId);

    /**
     * 查询告警记录列表
     *
     * @param warn 告警记录
     * @return 告警记录集合
     */
    public List<Warn> selectWarnList(Warn warn);

    /**
     * 查询告警信息
     * @param statisticsQO
     * @return
     */
    List<WarnMessageVO> selectWarnDataList(StatisticsQO statisticsQO);

    /**
     * 新增告警记录
     *
     * @param warn 告警记录
     * @return 结果
     */
    public int insertWarn(Warn warn);

    /**
     * 修改告警记录
     *
     * @param warn 告警记录
     * @return 结果
     */
    public int updateWarn(Warn warn);

    /**
     * 删除告警记录
     *
     * @param warnId 告警记录主键
     * @return 结果
     */
    public int deleteWarnByWarnId(String warnId);

    /**
     * 批量删除告警记录
     *
     * @param warnIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarnByWarnIds(String[] warnIds);

    /**
     * 分页查询告警信息
     * @author XuXiang  @time 2021/11/10 14:01
     * @param page
     * @param pageSize
     * @return
     */
    public List<WarnMessageVO> getWarnMessagePage(@Param("climbFrameId") Integer climbFrameId, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * app端获取按月份查询告警数量
     * @author XuXiang  @time 2021/11/17 14:20
     * @param firstSecond
     * @param lastSecond
     * @param climbFrameId
     * @return
     */
    List<WarningDataVO> getWarningByMonth(@Param("firstSecond") String firstSecond, @Param("lastSecond") String lastSecond,@Param("climbFrameId") Long climbFrameId);

    /**
     * app端获取按月份查询提升次数(暂时放在该mapper文件下)
     * @author XuXiang  @time 2021/11/17 15:22
     * @param climbFrameId
     * @return
     */
    AppRiseDataVO getRiseDataByMon(@Param("climbFrameId") Long climbFrameId);

    /**
     * 获取当天告警数量
     * @return
     */
    Integer getWarnTodayCount();

    /**
     * 查询最新十条数据
     * @return
     */
    List<Warn> selectLatelyWarn();

    /**
     * 获取每个月的告警数量
     * @return
     */
    List<WarningDataVO> getMonthWarnCount();

    /**
     * getWarnNumberByTime
     * @param statisticsQO
     * @return
     */
    Integer getWarnNumberByTime(StatisticsQO statisticsQO);

    /**
     * 统计分析中,根据爬架ID和时间范围获取每天的告警数
     * @param statisticsQO
     * @return
     */
    List<WarnDataVO> getEveryWarnNumberByTime(StatisticsQO statisticsQO);

    /**
     * 根据监测点获取需要推送的告警信息给对应人员
     * @param pointId
     * @return
     */
    List<Long> getUserIdByPointId(String pointId);
}
