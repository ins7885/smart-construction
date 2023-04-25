package com.zkjd.business.service;

import com.zkjd.business.domain.AcceptRecord;

import java.util.List;


/**
 * 爬架卸料平台验收记录Service接口
 *
 * @author zkjd
 * @date 2021-12-01
 */
public interface IAcceptRecordService {
    /**
     * 查询爬架卸料平台验收记录
     *
     * @param id 爬架卸料平台验收记录主键
     * @return 爬架卸料平台验收记录
     */
    public AcceptRecord selectAcceptRecordById(Long id);

    /**
     * 查询爬架卸料平台验收记录列表
     *
     * @param acceptRecord 爬架卸料平台验收记录
     * @return 爬架卸料平台验收记录集合
     */
    public List<AcceptRecord> selectAcceptRecordList(AcceptRecord acceptRecord);

    /**
     * 新增爬架卸料平台验收记录
     *
     * @param acceptRecord 爬架卸料平台验收记录
     * @return 结果
     */
    public int insertAcceptRecord(AcceptRecord acceptRecord);

    /**
     * 修改爬架卸料平台验收记录
     *
     * @param acceptRecord 爬架卸料平台验收记录
     * @return 结果
     */
    public int updateAcceptRecord(AcceptRecord acceptRecord);

    /**
     * 批量删除爬架卸料平台验收记录
     *
     * @param ids 需要删除的爬架卸料平台验收记录主键集合
     * @return 结果
     */
    public int deleteAcceptRecordByIds(Long[] ids);

    /**
     * 删除爬架卸料平台验收记录信息
     *
     * @param id 爬架卸料平台验收记录主键
     * @return 结果
     */
    public int deleteAcceptRecordById(Long id);

    /**
     * 技术人员 - 爬架卸料平台验收记录分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<AcceptRecord> getAcceptRecordPage(Integer page, Integer pageSize,Long projectId);
}
