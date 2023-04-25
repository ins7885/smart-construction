package com.zkjd.business.service.impl;

import com.zkjd.business.domain.Standard;
import com.zkjd.business.mapper.StandardMapper;
import com.zkjd.business.service.IStandardService;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标准规范Service业务层处理
 *
 * @author zkjd
 * @date 2022-01-27
 */
@Service
public class StandardServiceImpl implements IStandardService
{
    @Autowired
    private StandardMapper standardMapper;

    /**
     * 查询标准规范
     *
     * @param standardId 标准规范主键
     * @return 标准规范
     */
    @Override
    public Standard selectStandardByStandardId(Long standardId)
    {
        return standardMapper.selectStandardByStandardId(standardId);
    }

    /**
     * 查询标准规范列表
     *
     * @param standard 标准规范
     * @return 标准规范
     */
    @Override
    public List<Standard> selectStandardList(Standard standard)
    {
        return standardMapper.selectStandardList(standard);
    }

    /**
     * 新增标准规范
     *
     * @param standard 标准规范
     * @return 结果
     */
    @Override
    public int insertStandard(Standard standard)
    {
        standard.setCreateTime(DateUtils.getNowDate());
        return standardMapper.insertStandard(standard);
    }

    /**
     * 修改标准规范
     *
     * @param standard 标准规范
     * @return 结果
     */
    @Override
    public int updateStandard(Standard standard)
    {
        standard.setUpdateTime(DateUtils.getNowDate());
        return standardMapper.updateStandard(standard);
    }

    /**
     * 批量删除标准规范
     *
     * @param standardIds 需要删除的标准规范主键
     * @return 结果
     */
    @Override
    public int deleteStandardByStandardIds(Long[] standardIds)
    {
        return standardMapper.deleteStandardByStandardIds(standardIds);
    }

    /**
     * 删除标准规范信息
     *
     * @param standardId 标准规范主键
     * @return 结果
     */
    @Override
    public int deleteStandardByStandardId(Long standardId)
    {
        return standardMapper.deleteStandardByStandardId(standardId);
    }

    @Override
    public List<Standard> getStandardlist(Integer page, Integer pageSize) {
        return standardMapper.getStandardlist(page, pageSize);
    }
}
