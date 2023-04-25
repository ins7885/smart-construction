package com.zkjd.business.service.impl;

import com.zkjd.business.domain.DangerCheck;
import com.zkjd.business.mapper.DangerCheckMapper;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.IDangerCheckService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 安全隐患排查Service业务层处理
 *
 * @author zkjd
 * @date 2022-01-26
 */
@Service
public class DangerCheckServiceImpl implements IDangerCheckService {
    @Autowired
    private DangerCheckMapper dangerCheckMapper;

    /**
     * 查询安全隐患排查
     *
     * @param id 安全隐患排查主键
     * @return 安全隐患排查
     */
    @Override
    public DangerCheck selectDangerCheckById(Long id) {
        return dangerCheckMapper.selectDangerCheckById(id);
    }

    /**
     * 查询安全隐患排查列表
     *
     * @param dangerCheck 安全隐患排查
     * @return 安全隐患排查
     */
    @Override
    public List<DangerCheck> selectDangerCheckList(DangerCheck dangerCheck) {
        return dangerCheckMapper.selectDangerCheckList(dangerCheck);
    }

    /**
     * 新增安全隐患排查
     *
     * @param dangerCheck 安全隐患排查
     * @return 结果
     */
    @Override
    public int insertDangerCheck(DangerCheck dangerCheck) {
        dangerCheck.setCreateTime(DateUtils.getNowDate());
        return dangerCheckMapper.insertDangerCheck(dangerCheck);
    }

    /**
     * 修改安全隐患排查
     *
     * @param dangerCheck 安全隐患排查
     * @return 结果
     */
    @Override
    public int updateDangerCheck(DangerCheck dangerCheck) {
        dangerCheck.setUpdateTime(DateUtils.getNowDate());
        return dangerCheckMapper.updateDangerCheck(dangerCheck);
    }

    /**
     * 批量删除安全隐患排查
     *
     * @param ids 需要删除的安全隐患排查主键
     * @return 结果
     */
    @Override
    public int deleteDangerCheckByIds(Long[] ids) {
        return dangerCheckMapper.deleteDangerCheckByIds(ids);
    }

    /**
     * 删除安全隐患排查信息
     *
     * @param id 安全隐患排查主键
     * @return 结果
     */
    @Override
    public int deleteDangerCheckById(Long id) {
        return dangerCheckMapper.deleteDangerCheckById(id);
    }

    @Override
    public List<DangerCheck> getDangerCheckOwnerList(Integer page, Integer pageSize, Integer checkManId) {
        return dangerCheckMapper.getDangerCheckOwnerList(page, pageSize, checkManId);
    }

    @Override
    public List<DangerCheck> getWaitModifyList(Integer page, Integer pageSize, Integer modifyManId) {
        return dangerCheckMapper.getWaitModifyList(page, pageSize, modifyManId);
    }

    @Override
    public List<DangerCheck> getWaitReviewList(Integer page, Integer pageSize, Integer reviewManId) {
        return dangerCheckMapper.getWaitReviewList(page, pageSize, reviewManId);
    }

    @Override
    public List<DangerCheck> getCompletedList(Integer page, Integer pageSize, Integer reviewManId) {
        return dangerCheckMapper.getCompletedList(page, pageSize, reviewManId);
    }

    @Override
    public Integer getSafeNumberAll(StatisticsQO statisticsQO) {
        return dangerCheckMapper.getSafeNumberAll(statisticsQO);
    }

    @Override
    public Integer getSafeModifyNumber(StatisticsQO statisticsQO) {
        return dangerCheckMapper.getSafeModifyNumber(statisticsQO);
    }

    @Override
    public Integer getSafePassNumber(StatisticsQO statisticsQO) {
        return dangerCheckMapper.getSafePassNumber(statisticsQO);
    }


}
