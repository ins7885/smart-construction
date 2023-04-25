package com.zkjd.business.service.impl;

import com.zkjd.business.domain.OperateRecord;
import com.zkjd.business.mapper.OperateRecordMapper;
import com.zkjd.business.service.IOperateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备操作记录Service业务层处理
 *
 * @author zkjd
 * @date 2022-06-21
 */
@Service
public class OperateRecordServiceImpl implements IOperateRecordService {
    @Autowired
    private OperateRecordMapper operateRecordMapper;

    /**
     * 查询设备操作记录列表
     *
     * @param operateRecord 设备操作记录
     * @return 设备操作记录
     */
    @Override
    public List<OperateRecord> selectOperateRecordList(OperateRecord operateRecord) {
        return operateRecordMapper.selectOperateRecordList(operateRecord);
    }
}
