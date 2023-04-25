package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.CheckRecord;
import com.zkjd.business.mapper.CheckRecordMapper;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.ICheckRecordService;
import com.zkjd.business.vo.CheckRecordVO;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用前检查Service业务层处理
 *
 * @author zkjd
 * @date 2021-11-16
 */
@Service
public class CheckRecordServiceImpl implements ICheckRecordService {
    @Autowired
    private CheckRecordMapper checkRecordMapper;

    /**
     * 查询使用前检查
     *
     * @param id 使用前检查主键
     * @return 使用前检查
     */
    @Override
    public CheckRecord selectCheckRecordById(Long id) {
        return checkRecordMapper.selectCheckRecordById(id);
    }

    /**
     * 查询使用前检查列表
     *
     * @param checkRecord 使用前检查
     * @return 使用前检查
     */
    @Override
    public List<CheckRecord> selectCheckRecordList(CheckRecord checkRecord) {
        return checkRecordMapper.selectCheckRecordList(checkRecord);
    }

    /**
     * 新增使用前检查
     *
     * @param checkRecord 使用前检查
     * @return 结果
     */
    @Override
    public int insertCheckRecord(CheckRecord checkRecord) {
        checkRecord.setCreateTime(DateUtils.getNowDate());
        return checkRecordMapper.insertCheckRecord(checkRecord);
    }

    /**
     * 修改使用前检查
     *
     * @param checkRecord 使用前检查
     * @return 结果
     */
    @Override
    public int updateCheckRecord(CheckRecord checkRecord) {
        checkRecord.setUpdateTime(DateUtils.getNowDate());
        return checkRecordMapper.updateCheckRecord(checkRecord);
    }

    /**
     * 批量删除使用前检查
     *
     * @param ids 需要删除的使用前检查主键
     * @return 结果
     */
    @Override
    public int deleteCheckRecordByIds(Long[] ids) {
        return checkRecordMapper.deleteCheckRecordByIds(ids);
    }

    /**
     * 删除使用前检查信息
     *
     * @param id 使用前检查主键
     * @return 结果
     */
    @Override
    public int deleteCheckRecordById(Long id) {
        return checkRecordMapper.deleteCheckRecordById(id);
    }

    /**
     * 技术人员 - 使用前检查分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<CheckRecord> getCheckRecordPage(Integer page, Integer pageSize,Long climbFrameId) {
        return checkRecordMapper.getCheckRecordPage(page, pageSize,climbFrameId);
    }

    @Override
    public List<CheckRecordVO> getLatelyCheckRecord() {
        return checkRecordMapper.getLatelyCheckRecord();
    }

    @Override
    public Integer getUseCheckNumber(StatisticsQO statisticsQO) {
        return checkRecordMapper.getUseCheckNumber(statisticsQO);
    }
}
