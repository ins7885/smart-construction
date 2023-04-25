package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.RiseCheckSub;
import com.zkjd.business.mapper.RiseCheckSubMapper;
import com.zkjd.business.service.IRiseCheckSubService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 升降脚手架提升作业前检查子Service业务层处理
 *
 * @author zkjd
 * @date 2021-12-01
 */
@Service
public class RiseCheckSubServiceImpl implements IRiseCheckSubService {
    @Autowired
    private RiseCheckSubMapper riseCheckSubMapper;

    /**
     * 查询升降脚手架提升作业前检查子
     *
     * @param id 升降脚手架提升作业前检查子主键
     * @return 升降脚手架提升作业前检查子
     */
    @Override
    public RiseCheckSub selectRiseCheckSubById(Long id) {
        return riseCheckSubMapper.selectRiseCheckSubById(id);
    }

    /**
     * 查询升降脚手架提升作业前检查子列表
     *
     * @param riseCheckSub 升降脚手架提升作业前检查子
     * @return 升降脚手架提升作业前检查子
     */
    @Override
    public List<RiseCheckSub> selectRiseCheckSubList(RiseCheckSub riseCheckSub) {
        return riseCheckSubMapper.selectRiseCheckSubList(riseCheckSub);
    }

    /**
     * 新增升降脚手架提升作业前检查子
     *
     * @param riseCheckSub 升降脚手架提升作业前检查子
     * @return 结果
     */
    @Override
    public int insertRiseCheckSub(RiseCheckSub riseCheckSub) {
        riseCheckSub.setCreateTime(DateUtils.getNowDate());
        return riseCheckSubMapper.insertRiseCheckSub(riseCheckSub);
    }

    /**
     * 修改升降脚手架提升作业前检查子
     *
     * @param riseCheckSub 升降脚手架提升作业前检查子
     * @return 结果
     */
    @Override
    public int updateRiseCheckSub(RiseCheckSub riseCheckSub) {
        riseCheckSub.setUpdateTime(DateUtils.getNowDate());
        return riseCheckSubMapper.updateRiseCheckSub(riseCheckSub);
    }

    /**
     * 批量删除升降脚手架提升作业前检查子
     *
     * @param ids 需要删除的升降脚手架提升作业前检查子主键
     * @return 结果
     */
    @Override
    public int deleteRiseCheckSubByIds(Long[] ids) {
        return riseCheckSubMapper.deleteRiseCheckSubByIds(ids);
    }

    /**
     * 删除升降脚手架提升作业前检查子信息
     *
     * @param id 升降脚手架提升作业前检查子主键
     * @return 结果
     */
    @Override
    public int deleteRiseCheckSubById(Long id) {
        return riseCheckSubMapper.deleteRiseCheckSubById(id);
    }
}
