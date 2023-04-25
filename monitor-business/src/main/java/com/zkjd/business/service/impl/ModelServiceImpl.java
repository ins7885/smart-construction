package com.zkjd.business.service.impl;

import java.util.List;

import com.zkjd.business.domain.ModelPoint;
import com.zkjd.business.mapper.ModelPointMapper;
import com.zkjd.common.utils.DateUtils;
import com.zkjd.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zkjd.business.mapper.ModelMapper;
import com.zkjd.business.domain.Model;
import com.zkjd.business.service.IModelService;

/**
 * BIM模型Service业务层处理
 * 
 * @author wangtao
 * @date 2021-12-02
 */
@Service
public class ModelServiceImpl implements IModelService 
{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelPointMapper modelPointMapper;

    /**
     * 查询BIM模型
     * 
     * @param modelId BIM模型主键
     * @return BIM模型
     */
    @Override
    public Model selectModelByModelId(Long modelId)
    {
        Model model = modelMapper.selectModelByModelId(modelId);
        List<ModelPoint> modelPoints = modelPointMapper.selectModelPointByModelId(modelId);
        model.setPositions(modelPoints);
        return model;
    }

    /**
     * 查询BIM模型列表
     * 
     * @param model BIM模型
     * @return BIM模型
     */
    @Override
    public List<Model> selectModelList(Model model)
    {
        return modelMapper.selectModelList(model);
    }

    /**
     * 新增BIM模型
     * 
     * @param model BIM模型
     * @return 结果
     */
    @Override
    public int insertModel(Model model)
    {
        model.setCreateTime(DateUtils.getNowDate());
        modelMapper.insertModel(model);
        //保存点位数据
        List<ModelPoint> positions = model.getPositions();
        if(StringUtils.isNotEmpty(positions)){
            positions.forEach(o->{
                o.setCreateTime(DateUtils.getNowDate());
                o.setModelId(model.getModelId());
                modelPointMapper.insertModelPoint(o);
            });
        }
        return 1;
    }

    /**
     * 修改BIM模型
     * 
     * @param model BIM模型
     * @return 结果
     */
    @Override
    public int updateModel(Model model)
    {
        model.setUpdateTime(DateUtils.getNowDate());
        modelMapper.updateModel(model);
        Long id = model.getModelId();
        modelPointMapper.deleteModelPointByModelIds(new Long[]{model.getModelId()});
        //保存点位数据
        List<ModelPoint> positions = model.getPositions();
        if(StringUtils.isNotEmpty(positions)){
            positions.forEach(o->{
                o.setCreateTime(DateUtils.getNowDate());
                o.setModelId(id);
                modelPointMapper.insertModelPoint(o);
            });
        }
        return 1;
    }

    /**
     * 批量删除BIM模型
     * 
     * @param modelIds 需要删除的BIM模型主键
     * @return 结果
     */
    @Override
    public int deleteModelByModelIds(Long[] modelIds)
    {
        int i = modelMapper.deleteModelByModelIds(modelIds);
        //批量删除BIM点位数据
        modelPointMapper.deleteModelPointByModelIds(modelIds);
        return i;
    }

    /**
     * 删除BIM模型信息
     * 
     * @param modelId BIM模型主键
     * @return 结果
     */
    @Override
    public int deleteModelByModelId(Long modelId)
    {
        return modelMapper.deleteModelByModelId(modelId);
    }
}


/**
 "OperatingStateOfVacuumPump":"1",
 "OperatingStateOfStageBoosterPump":"1",
 "OperatingStateOfOilFeedPump":"0",
 "OperatingStateOfDrainOilPump":"0",
 "OperatingStateOfOneGroupOfHeater":"0",
 "OperatingStateOfTwoGroupOfHeater":"0",
 "OperatingStateOfThreeGroupOfHeater":"0",
 "OperatingStateOfFourGroupOfHeater":"0",
 "OperatingStateOfFiveGroupOfHeater":"0",
 "OperatingStateOfSixGroupOfHeater":"0",
 "PressureWarnStatus":"0",
 "CondenserWarnStatus":"0",
 "Vacuum":"181.898834",
 "Traffic":"0.000000",
 "TotalTraffic":"16.688644",
 "InputOilTemperature":"13.206440",
 "OutputOilTemperature":"-0.908999",
 "InputOilPressure":"12.840221",
 "OutputOilPressure":"-1.025463",
 "TotalRunningTime":"7.34",
 "ThisRunningTime":"4.99",
 "Longitude":"",
 "Latitude":"",


 */