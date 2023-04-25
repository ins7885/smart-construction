package com.zkjd.business.service;


import com.zkjd.business.domain.DangerCheck;
import com.zkjd.business.domain.Standard;

import java.util.List;

/**
 * 标准规范Service接口
 *
 * @author zkjd
 * @date 2022-01-27
 */
public interface IStandardService {
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
     * 批量删除标准规范
     *
     * @param standardIds 需要删除的标准规范主键集合
     * @return 结果
     */
    public int deleteStandardByStandardIds(Long[] standardIds);

    /**
     * 删除标准规范信息
     *
     * @param standardId 标准规范主键
     * @return 结果
     */
    public int deleteStandardByStandardId(Long standardId);

    /**
     * 安装标准分页(app端使用)
     * @param page
     * @param pageSize
     * @return
     */
    List<Standard> getStandardlist(Integer page, Integer pageSize);
}
