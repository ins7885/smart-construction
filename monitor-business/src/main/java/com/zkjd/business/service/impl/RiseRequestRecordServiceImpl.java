package com.zkjd.business.service.impl;

import com.zkjd.business.domain.RiseRecord;
import com.zkjd.business.domain.RiseRequestInfo;
import com.zkjd.business.domain.RiseRequestProcess;
import com.zkjd.business.mapper.RiseRecordMapper;
import com.zkjd.business.mapper.RiseRequestRecordMapper;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.IRiseRecordService;
import com.zkjd.business.service.IRiseRequestRecordService;
import com.zkjd.business.vo.RiseDataByTimeRangeVO;
import com.zkjd.business.vo.RiseDataVO;
import com.zkjd.common.core.domain.model.LoginUser;
import com.zkjd.common.utils.DateUtils;
import com.zkjd.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 提升记录Service业务层处理
 *
 * @author zkjd
 * @date 2021-11-18
 */
@Service
public class RiseRequestRecordServiceImpl implements IRiseRequestRecordService {
    @Autowired
    private RiseRequestRecordMapper riseRecordMapper;

    @Override
    public List<RiseRequestInfo> getRiseRequestRecordList(Integer page, Integer pageSize, Long climbFrameId) {
        return riseRecordMapper.getRiseRequestRecordList(page, pageSize, climbFrameId);
    }

    @Override
    public int insertRiseRequestRecord(RiseRequestInfo riseRecord) {
        riseRecord.setCreateTime(DateUtils.getNowDate());
//        LoginUser loginUser = SecurityUtils.getLoginUser();
//        riseRecord.setCreateBy(loginUser.getUsername());
        return riseRecordMapper.insertRiseRequestRecord(riseRecord);
    }

    @Override
    public RiseRequestInfo getRiseRequestInfoById(Long id) {
        return riseRecordMapper.getRiseRequestInfoById(id);
    }

    @Override
    public int updateRiseRequestInfo(RiseRequestInfo riseRecord) {
        riseRecord.setUpdateTime(DateUtils.getNowDate());
        return riseRecordMapper.updateRiseRequestInfo(riseRecord);
    }

    @Override
    public int createProcess(RiseRequestProcess riseRecord) {
        riseRecord.setCreateTime(DateUtils.getNowDate());
        int a = riseRecordMapper.createProcess(riseRecord);
        if (riseRecord.getRequestResult() == 1 || riseRecord.getRequestResult() == -1) {
            riseRecord.setCurrentProcess(2);
        } else {
            riseRecord.setRequestResult(0);
        }
        a = riseRecordMapper.updateRiseRequestProcess(riseRecord);

        return a;
    }

    @Override
    public RiseRequestProcess getProcessInfoByRequestId(Long id) {
        return riseRecordMapper.getProcessInfoByRequestId(id);
    }


}