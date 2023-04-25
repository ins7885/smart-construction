package com.zkjd.business.mapper;

import java.util.List;
import com.zkjd.business.domain.ModelPoint;

/**
 * BIM点位Mapper接口
 * 
 * @author wangtao
 * @date 2021-12-02
 */
public interface ModelPointMapper 
{
    /**
     * 查询BIM点位
     * 
     * @param modelPointId BIM点位主键
     * @return BIM点位
     */
    public ModelPoint selectModelPointByModelPointId(Long modelPointId);

    /**
     * 查询BIM点位
     *
     * @param modelId BIM点位模型ID
     * @return BIM点位
     */
    public List<ModelPoint> selectModelPointByModelId(Long modelId);

    /**
     * 查询BIM点位列表
     * 
     * @param modelPoint BIM点位
     * @return BIM点位集合
     */
    public List<ModelPoint> selectModelPointList(ModelPoint modelPoint);

    /**
     * 新增BIM点位
     * 
     * @param modelPoint BIM点位
     * @return 结果
     */
    public int insertModelPoint(ModelPoint modelPoint);

    /**
     * 修改BIM点位
     * 
     * @param modelPoint BIM点位
     * @return 结果
     */
    public int updateModelPoint(ModelPoint modelPoint);

    /**
     * 删除BIM点位
     * 
     * @param modelPointId BIM点位主键
     * @return 结果
     */
    public int deleteModelPointByModelPointId(Long modelPointId);

    /**
     * 批量删除BIM点位
     * 
     * @param modelPointIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteModelPointByModelPointIds(Long[] modelPointIds);

    /**
     * 批量删除BIM点位
     *
     * @param modelIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteModelPointByModelIds(Long[] modelIds);
}
