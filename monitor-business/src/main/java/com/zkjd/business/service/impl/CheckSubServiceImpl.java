package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.CheckSub;
import com.zkjd.business.mapper.CheckSubMapper;
import com.zkjd.business.service.ICheckSubService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 设备检查子Service业务层处理
 *
 * @author zkjd
 * @date 2021-11-16
 */
@Service
public class CheckSubServiceImpl implements ICheckSubService {
    @Autowired
    private CheckSubMapper checkSubMapper;

    /**
     * 查询设备检查子
     *
     * @param id 设备检查子主键
     * @return 设备检查子
     */
    @Override
    public CheckSub selectCheckSubById(Long id) {
        return checkSubMapper.selectCheckSubById(id);
    }

    /**
     * 查询设备检查子列表
     *
     * @param checkSub 设备检查子
     * @return 设备检查子
     */
    @Override
    public List<CheckSub> selectCheckSubList(CheckSub checkSub) {
        return checkSubMapper.selectCheckSubList(checkSub);
    }

    /**
     * 新增设备检查子
     *
     * @param checkSub 设备检查子
     * @return 结果
     */
    @Override
    public int insertCheckSub(CheckSub checkSub) {
        checkSub.setCreateTime(DateUtils.getNowDate());
        return checkSubMapper.insertCheckSub(checkSub);
    }

    /**
     * 修改设备检查子
     *
     * @param checkSub 设备检查子
     * @return 结果
     */
    @Override
    public int updateCheckSub(CheckSub checkSub) {
        checkSub.setUpdateTime(DateUtils.getNowDate());
        return checkSubMapper.updateCheckSub(checkSub);
    }

    /**
     * 批量删除设备检查子
     *
     * @param ids 需要删除的设备检查子主键
     * @return 结果
     */
    @Override
    public int deleteCheckSubByIds(Long[] ids) {
        return checkSubMapper.deleteCheckSubByIds(ids);
    }

    /**
     * 删除设备检查子信息
     *
     * @param id 设备检查子主键
     * @return 结果
     */
    @Override
    public int deleteCheckSubById(Long id) {
        return checkSubMapper.deleteCheckSubById(id);
    }
}
