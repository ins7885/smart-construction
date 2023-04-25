package com.zkjd.business.service.impl;

import java.util.List;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zkjd.business.mapper.ModelPointMapper;
import com.zkjd.business.domain.ModelPoint;
import com.zkjd.business.service.IModelPointService;

/**
 * BIM点位Service业务层处理
 * 
 * @author wangtao
 * @date 2021-12-02
 */
@Service
public class ModelPointServiceImpl implements IModelPointService 
{
    @Autowired
    private ModelPointMapper modelPointMapper;

    /**
     * 查询BIM点位
     * 
     * @param modelPointId BIM点位主键
     * @return BIM点位
     */
    @Override
    public ModelPoint selectModelPointByModelPointId(Long modelPointId)
    {
        return modelPointMapper.selectModelPointByModelPointId(modelPointId);
    }

    @Override
    public List<ModelPoint> selectModelPointByModelId(Long modelId) {
        return modelPointMapper.selectModelPointByModelId(modelId);
    }

    /**
     * 查询BIM点位列表
     * 
     * @param modelPoint BIM点位
     * @return BIM点位
     */
    @Override
    public List<ModelPoint> selectModelPointList(ModelPoint modelPoint)
    {
        return modelPointMapper.selectModelPointList(modelPoint);
    }

    /**
     * 新增BIM点位
     * 
     * @param modelPoint BIM点位
     * @return 结果
     */
    @Override
    public int insertModelPoint(ModelPoint modelPoint)
    {
        modelPoint.setCreateTime(DateUtils.getNowDate());
        return modelPointMapper.insertModelPoint(modelPoint);
    }

    /**
     * 修改BIM点位
     * 
     * @param modelPoint BIM点位
     * @return 结果
     */
    @Override
    public int updateModelPoint(ModelPoint modelPoint)
    {
        modelPoint.setUpdateTime(DateUtils.getNowDate());
        return modelPointMapper.updateModelPoint(modelPoint);
    }

    /**
     * 批量删除BIM点位
     * 
     * @param modelPointIds 需要删除的BIM点位主键
     * @return 结果
     */
    @Override
    public int deleteModelPointByModelPointIds(Long[] modelPointIds)
    {
        return modelPointMapper.deleteModelPointByModelPointIds(modelPointIds);
    }

    /**
     * 删除BIM点位信息
     * 
     * @param modelPointId BIM点位主键
     * @return 结果
     */
    @Override
    public int deleteModelPointByModelPointId(Long modelPointId)
    {
        return modelPointMapper.deleteModelPointByModelPointId(modelPointId);
    }
}
