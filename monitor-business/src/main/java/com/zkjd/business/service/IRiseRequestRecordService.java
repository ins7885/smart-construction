package com.zkjd.business.service;

import com.zkjd.business.domain.RiseRecord;
import com.zkjd.business.domain.RiseRequestInfo;
import com.zkjd.business.domain.RiseRequestProcess;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.vo.RiseDataByTimeRangeVO;
import com.zkjd.business.vo.RiseDataVO;

import java.util.List;


/**
 * 提升记录Service接口
 *
 * @author zkjd
 * @date 2021-11-18
 */
public interface IRiseRequestRecordService {
    List<RiseRequestInfo> getRiseRequestRecordList(Integer page, Integer pageSize, Long climbFrameId);

    int insertRiseRequestRecord(RiseRequestInfo riseRecord);

    RiseRequestInfo getRiseRequestInfoById(Long id);

    int updateRiseRequestInfo(RiseRequestInfo riseRecord);

    int createProcess(RiseRequestProcess riseRecord);

    RiseRequestProcess getProcessInfoByRequestId(Long id);
}
