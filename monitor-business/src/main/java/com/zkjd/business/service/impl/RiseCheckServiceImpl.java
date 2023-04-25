package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.RiseCheck;
import com.zkjd.business.mapper.RiseCheckMapper;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.IRiseCheckService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 升降脚手架提升作业前检查Service业务层处理
 *
 * @author zkjd
 * @date 2021-12-01
 */
@Service
public class RiseCheckServiceImpl implements IRiseCheckService {
    @Autowired
    private RiseCheckMapper riseCheckMapper;

    /**
     * 查询升降脚手架提升作业前检查
     *
     * @param id 升降脚手架提升作业前检查主键
     * @return 升降脚手架提升作业前检查
     */
    @Override
    public RiseCheck selectRiseCheckById(Long id) {
        return riseCheckMapper.selectRiseCheckById(id);
    }

    /**
     * 查询升降脚手架提升作业前检查列表
     *
     * @param riseCheck 升降脚手架提升作业前检查
     * @return 升降脚手架提升作业前检查
     */
    @Override
    public List<RiseCheck> selectRiseCheckList(RiseCheck riseCheck) {
        return riseCheckMapper.selectRiseCheckList(riseCheck);
    }

    /**
     * 新增升降脚手架提升作业前检查
     *
     * @param riseCheck 升降脚手架提升作业前检查
     * @return 结果
     */
    @Override
    public int insertRiseCheck(RiseCheck riseCheck) {
        riseCheck.setCreateTime(DateUtils.getNowDate());
        return riseCheckMapper.insertRiseCheck(riseCheck);
    }

    /**
     * 修改升降脚手架提升作业前检查
     *
     * @param riseCheck 升降脚手架提升作业前检查
     * @return 结果
     */
    @Override
    public int updateRiseCheck(RiseCheck riseCheck) {
        riseCheck.setUpdateTime(DateUtils.getNowDate());
        return riseCheckMapper.updateRiseCheck(riseCheck);
    }

    /**
     * 批量删除升降脚手架提升作业前检查
     *
     * @param ids 需要删除的升降脚手架提升作业前检查主键
     * @return 结果
     */
    @Override
    public int deleteRiseCheckByIds(Long[] ids) {
        return riseCheckMapper.deleteRiseCheckByIds(ids);
    }

    /**
     * 删除升降脚手架提升作业前检查信息
     *
     * @param id 升降脚手架提升作业前检查主键
     * @return 结果
     */
    @Override
    public int deleteRiseCheckById(Long id) {
        return riseCheckMapper.deleteRiseCheckById(id);
    }

    @Override
    public List<RiseCheck> getRiseCheckPage(Integer page, Integer pageSize,Long climbFrameId) {
        return riseCheckMapper.getRiseCheckPage(page, pageSize,climbFrameId);
    }

    /**
     * 根据爬架ID获取脚手架提升作业前检查记录
     * @param climbFrameId
     * @return
     */
    @Override
    public List<RiseCheck> getRiseCheckByClimbId(Long climbFrameId) {
        return riseCheckMapper.getRiseCheckByClimbId(climbFrameId);
    }

    @Override
    public Integer getRiseCheckNumber(StatisticsQO statisticsQO) {
        return riseCheckMapper.getRiseCheckNumber(statisticsQO);
    }
}
