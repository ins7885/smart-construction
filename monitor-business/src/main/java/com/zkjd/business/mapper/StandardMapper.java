package com.zkjd.business.mapper;


import com.zkjd.business.domain.Standard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标准规范Mapper接口
 *
 * @author zkjd
 * @date 2022-01-27
 */
public interface StandardMapper
{
    /**
     * 查询标准规范
     *
     * @param standardId 标准规范主键
     * @return 标准规范
     */
    public Standard selectStandardByStandardId(Long standardId);

    /**
     * 查询标准规范列表
     *
     * @param standard 标准规范
     * @return 标准规范集合
     */
    public List<Standard> selectStandardList(Standard standard);

    /**
     * 新增标准规范
     *
     * @param standard 标准规范
     * @return 结果
     */
    public int insertStandard(Standard standard);

    /**
     * 修改标准规范
     *
     * @param standard 标准规范
     * @return 结果
     */
    public int updateStandard(Standard standard);

    /**
     * 删除标准规范
     *
     * @param standardId 标准规范主键
     * @return 结果
     */
    public int deleteStandardByStandardId(Long standardId);

    /**
     * 批量删除标准规范
     *
     * @param standardIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStandardByStandardIds(Long[] standardIds);

    List<Standard> getStandardlist(@Param("page") Integer page, @Param("pageSize") Integer pageSize);
}

