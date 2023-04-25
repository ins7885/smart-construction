package com.zkjd.business.service;

import java.util.List;
import com.zkjd.business.domain.Model;

/**
 * BIM模型Service接口
 * 
 * @author wangtao
 * @date 2021-12-02
 */
public interface IModelService 
{
    /**
     * 查询BIM模型
     * 
     * @param modelId BIM模型主键
     * @return BIM模型
     */
    public Model selectModelByModelId(Long modelId);

    /**
     * 查询BIM模型列表
     * 
     * @param model BIM模型
     * @return BIM模型集合
     */
    public List<Model> selectModelList(Model model);

    /**
     * 新增BIM模型
     * 
     * @param model BIM模型
     * @return 结果
     */
    public int insertModel(Model model);

    /**
     * 修改BIM模型
     * 
     * @param model BIM模型
     * @return 结果
     */
    public int updateModel(Model model);

    /**
     * 批量删除BIM模型
     * 
     * @param modelIds 需要删除的BIM模型主键集合
     * @return 结果
     */
    public int deleteModelByModelIds(Long[] modelIds);

    /**
     * 删除BIM模型信息
     * 
     * @param modelId BIM模型主键
     * @return 结果
     */
    public int deleteModelByModelId(Long modelId);
}
