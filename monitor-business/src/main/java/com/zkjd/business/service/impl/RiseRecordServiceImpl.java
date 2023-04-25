package com.zkjd.business.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.zkjd.business.domain.RiseRecord;
import com.zkjd.business.mapper.RiseRecordMapper;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.IRiseRecordService;
import com.zkjd.business.vo.RiseDataByTimeRangeVO;
import com.zkjd.business.vo.RiseDataVO;
import com.zkjd.common.core.domain.model.LoginUser;
import com.zkjd.common.utils.DateUtils;
import com.zkjd.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 提升记录Service业务层处理
 *
 * @author zkjd
 * @date 2021-11-18
 */
@Service
public class RiseRecordServiceImpl implements IRiseRecordService {
    @Autowired
    private RiseRecordMapper riseRecordMapper;

    /**
     * 查询提升记录
     *
     * @param id 提升记录主键
     * @return 提升记录
     */
    @Override
    public RiseRecord selectRiseRecordById(Long id) {
        return riseRecordMapper.selectRiseRecordById(id);
    }

    /**
     * 查询提升记录列表
     *
     * @param riseRecord 提升记录
     * @return 提升记录
     */
    @Override
    public List<RiseRecord> selectRiseRecordList(RiseRecord riseRecord) {
        return riseRecordMapper.selectRiseRecordList(riseRecord);
    }


    @Override
    public List<RiseDataByTimeRangeVO> selectTimeRangeRiseRecordList(RiseRecord riseRecord) {
        List<RiseRecord> riseRecords = riseRecordMapper.selectRiseRecordList(riseRecord);
        // 先进行排序
        riseRecords = riseRecords.stream().sorted(Comparator.comparing(RiseRecord::getRiseTime)).collect(Collectors.toList());
        // 再进行分组
        Map<Long, List<RiseRecord>> collect = riseRecords.stream().collect(Collectors.groupingBy(RiseRecord::getClimbFrameId));
        Iterator<Map.Entry<Long, List<RiseRecord>>> iterator = collect.entrySet().iterator();
        List<RiseDataByTimeRangeVO> resultList = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<Long, List<RiseRecord>> entry = iterator.next();
            List<RiseRecord> value = entry.getValue();
            RiseDataByTimeRangeVO riseDataByTimeRangeVOTemp = new RiseDataByTimeRangeVO();
            if (value != null && value.size() > 0) {
                RiseRecord riseRecordTemp1 = value.get(0);
                riseDataByTimeRangeVOTemp.setClimbFrameId(riseRecordTemp1.getClimbFrameId());
                riseDataByTimeRangeVOTemp.setProjectName(riseRecordTemp1.getProjectName());
                riseDataByTimeRangeVOTemp.setMonomer(riseRecordTemp1.getMonomer());
                // 最早的提升时间作为开始时间
                riseDataByTimeRangeVOTemp.setStartTime(riseRecordTemp1.getRiseTime());
                RiseRecord riseRecordTemp2 = value.get(value.size()-1);
                // 最新的提升时间作为结束时间(可能和开始时间是同一个时间)
                riseDataByTimeRangeVOTemp.setEndTime(riseRecordTemp2.getRiseTime());
                resultList.add(riseDataByTimeRangeVOTemp);
            }
        }
        return resultList;
    }

    /**
     * 新增提升记录
     *
     * @param riseRecord 提升记录
     * @return 结果
     */
    @Override
    public int insertRiseRecord(RiseRecord riseRecord) {
        riseRecord.setCreateTime(DateUtils.getNowDate());
        LoginUser loginUser = SecurityUtils.getLoginUser();
        riseRecord.setCreateBy(loginUser.getUsername());
        return riseRecordMapper.insertRiseRecord(riseRecord);
    }

    /**
     * 修改提升记录
     *
     * @param riseRecord 提升记录
     * @return 结果
     */
    @Override
    public int updateRiseRecord(RiseRecord riseRecord) {
        riseRecord.setUpdateTime(DateUtils.getNowDate());
        return riseRecordMapper.updateRiseRecord(riseRecord);
    }

    /**
     * 批量删除提升记录
     *
     * @param ids 需要删除的提升记录主键
     * @return 结果
     */
    @Override
    public int deleteRiseRecordByIds(Long[] ids) {
        return riseRecordMapper.deleteRiseRecordByIds(ids);
    }

    /**
     * 删除提升记录信息
     *
     * @param id 提升记录主键
     * @return 结果
     */
    @Override
    public int deleteRiseRecordById(Long id) {
        return riseRecordMapper.deleteRiseRecordById(id);
    }

    /**
     * 技术人员提升记录分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<RiseRecord> getRiseRecordList(Integer page, Integer pageSize,Long climbFrameId) {
        return riseRecordMapper.getRiseRecordList(page, pageSize,climbFrameId);
    }

    /**
     * 管理员 - 根据爬架ID,获取提升记录
     * @param climbFrameId
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<RiseRecord> adminGetRiseRecordList(Integer climbFrameId, Integer page, Integer pageSize) {
        return riseRecordMapper.adminGetRiseRecordList(climbFrameId, page, pageSize);
    }

    @Override
    public Integer getRiseRecordTodayCount() {
        return riseRecordMapper.getRiseRecordTodayCount();
    }

    @Override
    public Integer getRiseNumberByTime(StatisticsQO statisticsQO) {
        return riseRecordMapper.getRiseNumberByTime(statisticsQO);
    }

    @Override
    public List<RiseDataVO> getRiseNumberByDateRange(StatisticsQO statisticsQO) {
        return riseRecordMapper.getRiseNumberByDateRange(statisticsQO);
    }
}