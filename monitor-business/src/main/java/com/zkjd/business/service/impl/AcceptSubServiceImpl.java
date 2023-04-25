package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.AcceptSub;
import com.zkjd.business.mapper.AcceptSubMapper;
import com.zkjd.business.service.IAcceptSubService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 爬架卸料平台验收记录子Service业务层处理
 *
 * @author zkjd
 * @date 2021-12-01
 */
@Service
public class AcceptSubServiceImpl implements IAcceptSubService {
    @Autowired
    private AcceptSubMapper acceptSubMapper;

    /**
     * 查询爬架卸料平台验收记录子
     *
     * @param id 爬架卸料平台验收记录子主键
     * @return 爬架卸料平台验收记录子
     */
    @Override
    public AcceptSub selectAcceptSubById(Long id) {
        return acceptSubMapper.selectAcceptSubById(id);
    }

    /**
     * 查询爬架卸料平台验收记录子列表
     *
     * @param acceptSub 爬架卸料平台验收记录子
     * @return 爬架卸料平台验收记录子
     */
    @Override
    public List<AcceptSub> selectAcceptSubList(AcceptSub acceptSub) {
        return acceptSubMapper.selectAcceptSubList(acceptSub);
    }

    /**
     * 新增爬架卸料平台验收记录子
     *
     * @param acceptSub 爬架卸料平台验收记录子
     * @return 结果
     */
    @Override
    public int insertAcceptSub(AcceptSub acceptSub) {
        acceptSub.setCreateTime(DateUtils.getNowDate());
        return acceptSubMapper.insertAcceptSub(acceptSub);
    }

    /**
     * 修改爬架卸料平台验收记录子
     *
     * @param acceptSub 爬架卸料平台验收记录子
     * @return 结果
     */
    @Override
    public int updateAcceptSub(AcceptSub acceptSub) {
        acceptSub.setUpdateTime(DateUtils.getNowDate());
        return acceptSubMapper.updateAcceptSub(acceptSub);
    }

    /**
     * 批量删除爬架卸料平台验收记录子
     *
     * @param ids 需要删除的爬架卸料平台验收记录子主键
     * @return 结果
     */
    @Override
    public int deleteAcceptSubByIds(Long[] ids) {
        return acceptSubMapper.deleteAcceptSubByIds(ids);
    }

    /**
     * 删除爬架卸料平台验收记录子信息
     *
     * @param id 爬架卸料平台验收记录子主键
     * @return 结果
     */
    @Override
    public int deleteAcceptSubById(Long id) {
        return acceptSubMapper.deleteAcceptSubById(id);
    }
}
