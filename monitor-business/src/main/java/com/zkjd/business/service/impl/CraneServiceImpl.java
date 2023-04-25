package com.zkjd.business.service.impl;

import com.zkjd.business.domain.Crane;
import com.zkjd.business.mapper.CraneMapper;
import com.zkjd.business.service.ICraneService;
import com.zkjd.business.vo.AppCraneVO;
import com.zkjd.business.vo.CraneVO;
import com.zkjd.common.exception.ServiceException;
import com.zkjd.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 电葫芦设备Service业务层处理
 *
 * @author wangtao
 * @date 2021-11-17
 */
@Service
public class CraneServiceImpl implements ICraneService {
    @Autowired
    private CraneMapper craneMapper;

    /**
     * 查询电葫芦设备
     *
     * @param craneId 电葫芦设备主键
     * @return 电葫芦设备
     */
    @Override
    public Crane selectCraneByCraneId(Long craneId) {
        return craneMapper.selectCraneByCraneId(craneId);
    }

    /**
     * 查询电葫芦设备列表
     *
     * @param crane 电葫芦设备
     * @return 电葫芦设备
     */
    @Override
    public List<Crane> selectCraneList(Crane crane) {
        return craneMapper.selectCraneList(crane);
    }

    /**
     * 新增电葫芦设备
     *
     * @param crane 电葫芦设备
     * @return 结果
     */
    @Override
    public int insertCrane(Crane crane) {
        crane.setCreateTime(DateUtils.getNowDate());
        return craneMapper.insertCrane(crane);
    }

    /**
     * 修改电葫芦设备
     *
     * @param crane 电葫芦设备
     * @return 结果
     */
    @Override
    public int updateCrane(Crane crane) {
        crane.setUpdateTime(DateUtils.getNowDate());
        return craneMapper.updateCrane(crane);
    }

    /**
     * 批量删除电葫芦设备
     *
     * @param craneIds 需要删除的电葫芦设备主键
     * @return 结果
     */
    @Override
    public int deleteCraneByCraneIds(Long[] craneIds) {
        if (craneIds.length > 0) {
            Integer count = craneMapper.getCountByCraneIds(Arrays.asList(craneIds));
            if (count > 0) {
                throw new ServiceException("已关联监测点的电葫芦，无法删除");
            }
        }
        return craneMapper.deleteCraneByCraneIds(craneIds);
    }

    /**
     * 删除电葫芦设备信息
     *
     * @param craneId 电葫芦设备主键
     * @return 结果
     */
    @Override
    public int deleteCraneByCraneId(Long craneId) {
        return craneMapper.deleteCraneByCraneId(craneId);
    }

    @Override
    public List<Crane> getCranesByclimbFrameId(Long climbFrameId) {
        return craneMapper.getCranesByclimbFrameId(climbFrameId);
    }

    /**
     * 根据爬架ID获取电葫芦列表
     *
     * @param climbFrameId
     * @return
     */
    @Override
    public List<AppCraneVO> getCraneByClimbFrameId(Long climbFrameId) {
        List<CraneVO> craneVOList = craneMapper.getRecordNewByCraneId(climbFrameId);
        // 接收结果
        List<AppCraneVO> resultList = new ArrayList<>();
        if (craneVOList != null && craneVOList.size() > 0) {
            Map<Long, List<CraneVO>> collect = craneVOList.stream().collect(Collectors.groupingBy(item -> item.getCraneId()));
            for (Map.Entry<Long, List<CraneVO>> entry : collect.entrySet()) {
                AppCraneVO appCraneVO = new AppCraneVO();
                appCraneVO.setCraneId(entry.getKey());
                List<CraneVO> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    value.forEach(itemTemp -> {
                        /** ABC电压只有一个,在app端进行获取判断 */
                        // A相电压
                        if ("monitor_point_type_01".equals(itemTemp.getType())) {
                            String recordValue = itemTemp.getRecordValue();
                            Double voltageTemp = recordValue == null ? 0 : Double.valueOf(recordValue);
                            appCraneVO.setaVoltage(voltageTemp);
                        }
                        // B相电压
                        if ("monitor_point_type_08".equals(itemTemp.getType())) {
                            String recordValue = itemTemp.getRecordValue();
                            Double voltageTemp = recordValue == null ? 0 : Double.valueOf(recordValue);
                            appCraneVO.setbVoltage(voltageTemp);
                        }
                        // C相电压
                        if ("monitor_point_type_09".equals(itemTemp.getType())) {
                            String recordValue = itemTemp.getRecordValue();
                            Double voltageTemp = recordValue == null ? 0 : Double.valueOf(recordValue);
                            appCraneVO.setcVoltage(voltageTemp);
                        }
                        // 电流
                        if ("monitor_point_type_02".equals(itemTemp.getType())) {
                            String recordValue = itemTemp.getRecordValue();
                            Double electricTemp = recordValue == null ? 0 : Double.valueOf(recordValue);
                            appCraneVO.setElectric(electricTemp);
                        }
                        // 拉力
                        if ("monitor_point_type_03".equals(itemTemp.getType())) {
                            // 设置拉力比例
                            Double rateResult = 0.00;
                            String recordValue = itemTemp.getRecordValue();
                            Double maxValue = itemTemp.getMaxValue();
                            Double minValue = itemTemp.getMinValue();
                            Double diffValue = 0.0;
                            // 存在拉力相关参数且合法时候进行计算
                            if (recordValue != null && maxValue != null && minValue != null && (maxValue - minValue != 0)) {
                                Double aDouble = Double.valueOf(recordValue);
                                Double temp = maxValue - minValue;
                                Double temp2 = aDouble - minValue;
                                diffValue = temp;
                                BigDecimal b1 = new BigDecimal(temp);
                                BigDecimal b2 = new BigDecimal(temp2);
                                rateResult = b2.divide(b1, 2,
                                        BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
                                if (rateResult > 100) {
                                    rateResult = 100.00;
                                }
                                if (rateResult < 0) {
                                    rateResult = 0.00;
                                }
                            }
                            appCraneVO.setForceRate(rateResult);
                            // 电葫芦荷载
                            appCraneVO.setPull(recordValue);
                            // 预警值 maxValue
                            appCraneVO.setWarnValue(maxValue);
                            // 差值
                            appCraneVO.setDiffValue(diffValue);
                        }
                        // 限位
                        if ("monitor_point_type_06".equals(itemTemp.getType())) {
                            String recordValue = itemTemp.getRecordValue();
                            String limitTemp = recordValue == "0" ? "正常" : "异常";
                            appCraneVO.setLimit(limitTemp);
                        }
                        // 顶撑受力
                        if ("monitor_point_type_07".equals(itemTemp.getType())) {
                            String recordValue = itemTemp.getRecordValue();
                            Double stressTemp = recordValue == null ? 0.0 : Double.valueOf(recordValue);
                            appCraneVO.setStress(stressTemp);
                        }
                        // 状态
                        appCraneVO.setStatus(itemTemp.getStatus());
                        // 采集时间
                        appCraneVO.setRecordTime(itemTemp.getRecordTime());
                    });
                }
                resultList.add(appCraneVO);
            }
        }
        return resultList;
    }

    /**
     * 根据爬架ID获取监测点列表(注意:这里的CraneVO名称是和实际意义不符的,是借过来用的,因为该VO中的字段符合实际意义)
     *
     * @param climbFrameId
     * @return
     */
    @Override
    public List<CraneVO> getPointsByClimbFrameId(Long climbFrameId) {
        List<CraneVO> craneVOList = craneMapper.getPointsByClimbFrameId(climbFrameId);
        return craneVOList;
    }

    /**
     * 根据爬架ID和监测点ID获取监测点信息
     *
     * @param climbFrameId
     * @param monitorPid
     * @return
     */
    @Override
    public CraneVO getPointInfo(Integer climbFrameId, Integer monitorPid) {
        CraneVO pointInfo = craneMapper.getPointInfo(climbFrameId, monitorPid);
        return pointInfo;
    }
}
