package com.zkjd.business.mapper;

import com.zkjd.business.domain.RiseCheckSub;

import java.util.List;

/**
 * 升降脚手架提升作业前检查子Mapper接口
 *
 * @author zkjd
 * @date 2021-12-01
 */
public interface RiseCheckSubMapper {
    /**
     * 查询升降脚手架提升作业前检查子
     *
     * @param id 升降脚手架提升作业前检查子主键
     * @return 升降脚手架提升作业前检查子
     */
    public RiseCheckSub selectRiseCheckSubById(Long id);

    /**
     * 查询升降脚手架提升作业前检查子列表
     *
     * @param riseCheckSub 升降脚手架提升作业前检查子
     * @return 升降脚手架提升作业前检查子集合
     */
    public List<RiseCheckSub> selectRiseCheckSubList(RiseCheckSub riseCheckSub);

    /**
     * 新增升降脚手架提升作业前检查子
     *
     * @param riseCheckSub 升降脚手架提升作业前检查子
     * @return 结果
     */
    public int insertRiseCheckSub(RiseCheckSub riseCheckSub);

    /**
     * 修改升降脚手架提升作业前检查子
     *
     * @param riseCheckSub 升降脚手架提升作业前检查子
     * @return 结果
     */
    public int updateRiseCheckSub(RiseCheckSub riseCheckSub);

    /**
     * 删除升降脚手架提升作业前检查子
     *
     * @param id 升降脚手架提升作业前检查子主键
     * @return 结果
     */
    public int deleteRiseCheckSubById(Long id);

    /**
     * 批量删除升降脚手架提升作业前检查子
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRiseCheckSubByIds(Long[] ids);
}
