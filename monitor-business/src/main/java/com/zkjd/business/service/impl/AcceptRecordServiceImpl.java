package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.AcceptRecord;
import com.zkjd.business.mapper.AcceptRecordMapper;
import com.zkjd.business.service.IAcceptRecordService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 爬架卸料平台验收记录Service业务层处理
 *
 * @author zkjd
 * @date 2021-12-01
 */
@Service
public class AcceptRecordServiceImpl implements IAcceptRecordService {
    @Autowired
    private AcceptRecordMapper acceptRecordMapper;

    /**
     * 查询爬架卸料平台验收记录
     *
     * @param id 爬架卸料平台验收记录主键
     * @return 爬架卸料平台验收记录
     */
    @Override
    public AcceptRecord selectAcceptRecordById(Long id) {
        return acceptRecordMapper.selectAcceptRecordById(id);
    }

    /**
     * 查询爬架卸料平台验收记录列表
     *
     * @param acceptRecord 爬架卸料平台验收记录
     * @return 爬架卸料平台验收记录
     */
    @Override
    public List<AcceptRecord> selectAcceptRecordList(AcceptRecord acceptRecord) {
        return acceptRecordMapper.selectAcceptRecordList(acceptRecord);
    }

    /**
     * 新增爬架卸料平台验收记录
     *
     * @param acceptRecord 爬架卸料平台验收记录
     * @return 结果
     */
    @Override
    public int insertAcceptRecord(AcceptRecord acceptRecord) {
        acceptRecord.setCreateTime(DateUtils.getNowDate());
        return acceptRecordMapper.insertAcceptRecord(acceptRecord);
    }

    /**
     * 修改爬架卸料平台验收记录
     *
     * @param acceptRecord 爬架卸料平台验收记录
     * @return 结果
     */
    @Override
    public int updateAcceptRecord(AcceptRecord acceptRecord) {
        acceptRecord.setUpdateTime(DateUtils.getNowDate());
        return acceptRecordMapper.updateAcceptRecord(acceptRecord);
    }

    /**
     * 批量删除爬架卸料平台验收记录
     *
     * @param ids 需要删除的爬架卸料平台验收记录主键
     * @return 结果
     */
    @Override
    public int deleteAcceptRecordByIds(Long[] ids) {
        return acceptRecordMapper.deleteAcceptRecordByIds(ids);
    }

    /**
     * 删除爬架卸料平台验收记录信息
     *
     * @param id 爬架卸料平台验收记录主键
     * @return 结果
     */
    @Override
    public int deleteAcceptRecordById(Long id) {
        return acceptRecordMapper.deleteAcceptRecordById(id);
    }

    @Override
    public List<AcceptRecord> getAcceptRecordPage(Integer page, Integer pageSize,Long projectId) {
        return acceptRecordMapper.getAcceptRecordPage(page, pageSize,projectId);
    }
}
