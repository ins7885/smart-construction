package com.zkjd.business.mapper;

import com.zkjd.business.domain.OperateRecord;

import java.util.List;

/**
 * 设备操作记录Mapper接口
 *
 * @author zkjd
 * @date 2022-06-21
 */
public interface OperateRecordMapper {

    /**
     * 查询设备操作记录列表
     *
     * @param operateRecord 设备操作记录
     * @return 设备操作记录集合
     */
    public List<OperateRecord> selectOperateRecordList(OperateRecord operateRecord);
}
