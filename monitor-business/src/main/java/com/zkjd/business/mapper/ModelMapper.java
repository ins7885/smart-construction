package com.zkjd.business.mapper;

import java.util.List;
import com.zkjd.business.domain.Model;

/**
 * BIM模型Mapper接口
 * 
 * @author wangtao
 * @date 2021-12-02
 */
public interface ModelMapper 
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
     * 删除BIM模型
     * 
     * @param modelId BIM模型主键
     * @return 结果
     */
    public int deleteModelByModelId(Long modelId);

    /**
     * 批量删除BIM模型
     * 
     * @param modelIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteModelByModelIds(Long[] modelIds);
}
