package com.zkjd.business.service;

import com.zkjd.business.domain.CheckRecord;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.vo.CheckRecordVO;

import java.util.List;

/**
 * 使用前检查Service接口
 *
 * @author zkjd
 * @date 2021-11-16
 */
public interface ICheckRecordService {
    /**
     * 查询使用前检查
     *
     * @param id 使用前检查主键
     * @return 使用前检查
     */
    public CheckRecord selectCheckRecordById(Long id);

    /**
     * 查询使用前检查列表
     *
     * @param checkRecord 使用前检查
     * @return 使用前检查集合
     */
    public List<CheckRecord> selectCheckRecordList(CheckRecord checkRecord);

    /**
     * 新增使用前检查
     *
     * @param checkRecord 使用前检查
     * @return 结果
     */
    public int insertCheckRecord(CheckRecord checkRecord);

    /**
     * 修改使用前检查
     *
     * @param checkRecord 使用前检查
     * @return 结果
     */
    public int updateCheckRecord(CheckRecord checkRecord);

    /**
     * 批量删除使用前检查
     *
     * @param ids 需要删除的使用前检查主键集合
     * @return 结果
     */
    public int deleteCheckRecordByIds(Long[] ids);

    /**
     * 删除使用前检查信息
     *
     * @param id 使用前检查主键
     * @return 结果
     */
    public int deleteCheckRecordById(Long id);

    /**
     * 技术人员 - 使用前检查分页查询
     * @param page
     * @param pageSize
     * @return
     */
    List<CheckRecord> getCheckRecordPage(Integer page, Integer pageSize,Long climbFrameId);

    /**
     * 获取最新十条检查记录
     * @return
     */
    List<CheckRecordVO> getLatelyCheckRecord();

    /**
     * 获取使用前检查验收数
     * @param statisticsQO
     * @return
     */
    Integer getUseCheckNumber(StatisticsQO statisticsQO);

}
