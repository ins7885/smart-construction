package com.zkjd.business.mapper;

import com.zkjd.business.domain.CheckSub;

import java.util.List;


/**
 * 设备检查子Mapper接口
 *
 * @author zkjd
 * @date 2021-11-16
 */
public interface CheckSubMapper {
    /**
     * 查询设备检查子
     *
     * @param id 设备检查子主键
     * @return 设备检查子
     */
    public CheckSub selectCheckSubById(Long id);

    /**
     * 查询设备检查子列表
     *
     * @param checkSub 设备检查子
     * @return 设备检查子集合
     */
    public List<CheckSub> selectCheckSubList(CheckSub checkSub);

    /**
     * 新增设备检查子
     *
     * @param checkSub 设备检查子
     * @return 结果
     */
    public int insertCheckSub(CheckSub checkSub);

    /**
     * 修改设备检查子
     *
     * @param checkSub 设备检查子
     * @return 结果
     */
    public int updateCheckSub(CheckSub checkSub);

    /**
     * 删除设备检查子
     *
     * @param id 设备检查子主键
     * @return 结果
     */
    public int deleteCheckSubById(Long id);

    /**
     * 批量删除设备检查子
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCheckSubByIds(Long[] ids);
}
