package com.zkjd.business.mapper;

import com.zkjd.business.domain.Record;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-12-12 22:48
 * @Description:
 */
public interface RecordMapper {

    /**
     * 历史记录列表
     * @param record
     * @return
     */
    List<Record> selectRecordList(Record record);

    /**
     * 查询历史记录列表(没有查询条件)
     *
     * @param record 历史记录
     * @return 历史记录集合
     */
    List<Record> selectNoConditionRecord(Record record);

    /**
     * 获取数据行数
     * @return
     */
    Integer selectRecordCount(Record record);
}
