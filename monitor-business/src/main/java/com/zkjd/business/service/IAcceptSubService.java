package com.zkjd.business.service;

import com.zkjd.business.domain.AcceptSub;

import java.util.List;


/**
 * 爬架卸料平台验收记录子Service接口
 *
 * @author zkjd
 * @date 2021-12-01
 */
public interface IAcceptSubService {
    /**
     * 查询爬架卸料平台验收记录子
     *
     * @param id 爬架卸料平台验收记录子主键
     * @return 爬架卸料平台验收记录子
     */
    public AcceptSub selectAcceptSubById(Long id);

    /**
     * 查询爬架卸料平台验收记录子列表
     *
     * @param acceptSub 爬架卸料平台验收记录子
     * @return 爬架卸料平台验收记录子集合
     */
    public List<AcceptSub> selectAcceptSubList(AcceptSub acceptSub);

    /**
     * 新增爬架卸料平台验收记录子
     *
     * @param acceptSub 爬架卸料平台验收记录子
     * @return 结果
     */
    public int insertAcceptSub(AcceptSub acceptSub);

    /**
     * 修改爬架卸料平台验收记录子
     *
     * @param acceptSub 爬架卸料平台验收记录子
     * @return 结果
     */
    public int updateAcceptSub(AcceptSub acceptSub);

    /**
     * 批量删除爬架卸料平台验收记录子
     *
     * @param ids 需要删除的爬架卸料平台验收记录子主键集合
     * @return 结果
     */
    public int deleteAcceptSubByIds(Long[] ids);

    /**
     * 删除爬架卸料平台验收记录子信息
     *
     * @param id 爬架卸料平台验收记录子主键
     * @return 结果
     */
    public int deleteAcceptSubById(Long id);
}
