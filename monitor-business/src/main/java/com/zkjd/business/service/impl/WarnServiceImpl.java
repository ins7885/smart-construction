package com.zkjd.business.service.impl;

import java.util.List;
import java.util.Map;

import com.zkjd.business.domain.Warn;
import com.zkjd.business.mapper.WarnMapper;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.WarnService;
import com.zkjd.business.vo.AppRiseDataVO;
import com.zkjd.business.vo.WarnDataVO;
import com.zkjd.business.vo.WarnMessageVO;
import com.zkjd.business.vo.WarningDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 告警记录Service业务层处理
 *
 * @author XuXiang
 * @date 2021-11-10
 */
@Service
public class WarnServiceImpl implements WarnService {
    @Autowired
    private WarnMapper warnMapper;

    /**
     * 查询告警记录
     *
     * @param warnId 告警记录主键
     * @return 告警记录
     */
    @Override
    public Warn selectWarnByWarnId(String warnId) {
        return warnMapper.selectWarnByWarnId(warnId);
    }

    /**
     * 查询告警记录列表
     *
     * @param warn 告警记录
     * @return 告警记录
     */
    @Override
    public List<Warn> selectWarnList(Warn warn) {
        return warnMapper.selectWarnList(warn);
    }

    @Override
    public List<WarnMessageVO> selectWarnDataList(StatisticsQO statisticsQO) {
        return warnMapper.selectWarnDataList(statisticsQO);
    }

    /**
     * 新增告警记录
     *
     * @param warn 告警记录
     * @return 结果
     */
    @Override
    public int insertWarn(Warn warn) {
        return warnMapper.insertWarn(warn);
    }

    /**
     * 修改告警记录
     *
     * @param warn 告警记录
     * @return 结果
     */
    @Override
    public int updateWarn(Warn warn) {
        return warnMapper.updateWarn(warn);
    }

    /**
     * 批量删除告警记录
     *
     * @param warnIds 需要删除的告警记录主键
     * @return 结果
     */
    @Override
    public int deleteWarnByWarnIds(String[] warnIds) {
        return warnMapper.deleteWarnByWarnIds(warnIds);
    }

    /**
     * 删除告警记录信息
     *
     * @param warnId 告警记录主键
     * @return 结果
     */
    @Override
    public int deleteWarnByWarnId(String warnId) {
        return warnMapper.deleteWarnByWarnId(warnId);
    }

    @Override
    public List<WarnMessageVO> getWarnMessagePage(Integer climbFrameId, Integer page, Integer pageSize) {
        return warnMapper.getWarnMessagePage(climbFrameId,page, pageSize);
    }

    /**
     * app端获取按月份查询告警数量
     * @author XuXiang  @time 2021/11/17 14:20
     * @param firstSecond
     * @param lastSecond
     * @param climbFrameId
     * @return
     */
    @Override
    public List<WarningDataVO> getWarningByMonth(String firstSecond, String lastSecond,Long climbFrameId) {
        return warnMapper.getWarningByMonth(firstSecond, lastSecond,climbFrameId);
    }

    @Override
    public AppRiseDataVO getRiseDataByMon(Long climbFrameId) {
        return warnMapper.getRiseDataByMon(climbFrameId);
    }

    @Override
    public Integer getWarnTodayCount() {
        return warnMapper.getWarnTodayCount();
    }

    @Override
    public List<Warn> selectLatelyWarn() {
        return warnMapper.selectLatelyWarn();
    }

    @Override
    public List<WarningDataVO> getMonthWarnCount() {
        return warnMapper.getMonthWarnCount();
    }

    @Override
    public Integer getWarnNumberByTime(StatisticsQO statisticsQO) {
        return warnMapper.getWarnNumberByTime(statisticsQO);
    }

    @Override
    public List<WarnDataVO> getEveryWarnNumberByTime(StatisticsQO statisticsQO) {
        return warnMapper.getEveryWarnNumberByTime(statisticsQO);
    }

    @Override
    public List<Long> getUserIdByPointId(String pointId) {
        return warnMapper.getUserIdByPointId(pointId);
    }
}
