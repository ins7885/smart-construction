package com.zkjd.business.mapper;

import com.zkjd.business.domain.RiseRecord;
import com.zkjd.business.domain.RiseRequestInfo;
import com.zkjd.business.domain.RiseRequestProcess;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.vo.RiseDataVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 提升记录Mapper接口
 *
 * @author zkjd
 * @date 2021-11-18
 */
public interface RiseRequestRecordMapper {
    List<RiseRequestInfo> getRiseRequestRecordList(@Param("page") Integer page, @Param("pageSize") Integer pageSize,@Param("climbFrameId") Long climbFrameId);

    int insertRiseRequestRecord(RiseRequestInfo riseRecord);

    RiseRequestInfo getRiseRequestInfoById(Long id);

    int updateRiseRequestInfo(RiseRequestInfo riseRecord);

    int createProcess(RiseRequestProcess riseRecord);

    int updateRiseRequestProcess(RiseRequestProcess riseRecord);

    RiseRequestProcess getProcessInfoByRequestId(Long id);
}