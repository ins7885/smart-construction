package com.zkjd.business.service.impl;

import com.zkjd.business.domain.Record;
import com.zkjd.business.mapper.RecordMapper;
import com.zkjd.business.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-12-12 23:02
 * @Description:
 */
@Service
public class RecordServiceImpl implements IRecordService {
    @Autowired
    private RecordMapper recordMapper;

    /**
     * 查询历史记录列表
     *
     * @param record 历史记录
     * @return 历史记录
     */
    @Override
    public List<Record> selectRecordList(Record record) {
        return recordMapper.selectRecordList(record);
    }

    @Override
    public List<Record> selectNoConditionRecord(Record record) {
        return recordMapper.selectNoConditionRecord(record);
    }

    @Override
    public Integer selectRecordCount(Record record) {
        return recordMapper.selectRecordCount(record);
    }
}
