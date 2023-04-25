package com.zkjd.business.mapper;

import com.zkjd.business.domain.AcceptRecord;
import com.zkjd.business.domain.RiseCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 爬架卸料平台验收记录Mapper接口
 *
 * @author zkjd
 * @date 2021-12-01
 */
public interface AcceptRecordMapper {
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
     * 删除爬架卸料平台验收记录
     *
     * @param id 爬架卸料平台验收记录主键
     * @return 结果
     */
    public int deleteAcceptRecordById(Long id);

    /**
     * 批量删除爬架卸料平台验收记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAcceptRecordByIds(Long[] ids);

    /**
     * 技术人员 - 爬架卸料平台验收记录分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<AcceptRecord> getAcceptRecordPage(@Param("page") Integer page, @Param("pageSize") Integer pageSize,@Param("projectId") Long projectId);
}
