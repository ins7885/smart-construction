package com.zkjd.web.controller.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.zkjd.business.domain.RiseAuto;
import com.zkjd.business.domain.RiseRecord;
import com.zkjd.business.mapper.CraneMapper;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.ICraneService;
import com.zkjd.business.service.IRiseAutoService;
import com.zkjd.business.service.IRiseRecordService;
import com.zkjd.business.vo.*;
import com.zkjd.common.utils.DateUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.common.utils.poi.ExcelUtil;
import com.zkjd.common.core.page.TableDataInfo;

/**
 * 提升记录Controller
 *
 * @author zkjd
 * @date 2021-11-18
 */
@RestController
@RequestMapping("/system/riseRecord")
public class RiseRecordController extends BaseController {
    @Autowired
    private IRiseRecordService riseRecordService;

    @Autowired
    private ICraneService craneService;

    @Autowired
    private CraneMapper craneMapper;

    @Autowired
    private IRiseAutoService riseAutoService;

    /** 荷载类型(暂时弃用) */
    private final String STRESS_TYPE = "monitor_point_type_03";

    /**
     * 查询提升记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:riseRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(RiseRecord riseRecord) {
        startPage();
        List<RiseRecord> list = riseRecordService.selectRiseRecordList(riseRecord);
        return getDataTable(list);
    }

    /**
     * 查询系统自动获取的提升记录
     * @param riseRecord
     * @return
     */
    @GetMapping("/listByAuto")
    public TableDataInfo listByAuto(RiseAuto riseAuto) {
        startPage();
        List<RiseAutoVO> list = riseAutoService.listByAuto(riseAuto);
        return getDataTable(list);
    }

    /**
     * 导出提升记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:riseRecord:export')")
    @Log(title = "提升记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RiseRecord riseRecord) {
        List<RiseRecord> list = riseRecordService.selectRiseRecordList(riseRecord);
        ExcelUtil<RiseRecord> util = new ExcelUtil<RiseRecord>(RiseRecord.class);
        return util.exportExcel(list, "提升记录数据");
    }

    /**
     * 获取提升记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:riseRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(riseRecordService.selectRiseRecordById(id));
    }

    /**
     * 新增提升记录
     */
    @PreAuthorize("@ss.hasPermi('system:riseRecord:add')")
    @Log(title = "提升记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RiseRecord riseRecord) {
        return toAjax(riseRecordService.insertRiseRecord(riseRecord));
    }

    /**
     * 修改提升记录
     */
    @PreAuthorize("@ss.hasPermi('system:riseRecord:edit')")
    @Log(title = "提升记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RiseRecord riseRecord) {
        return toAjax(riseRecordService.updateRiseRecord(riseRecord));
    }

    /**
     * 删除提升记录
     */
    @PreAuthorize("@ss.hasPermi('system:riseRecord:remove')")
    @Log(title = "提升记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(riseRecordService.deleteRiseRecordByIds(ids));
    }

    /**
     * 获取爬架记录,根据爬架进行分组,取提升时间的最早时间及最晚时间分别作为开始时间和结束时间,形成一条记录
     * @author XuXiang  @time 2022-03-14 9:28
     * @param riseRecord
     * @return
     */
    @GetMapping("/listByTimeRange")
    public TableDataInfo listByTimeRange(RiseRecord riseRecord) {
        startPage();
        List<RiseDataByTimeRangeVO> list = riseRecordService.selectTimeRangeRiseRecordList(riseRecord);
        return getDataTable(list);
    }

    /**
     * 统计分析中获取电葫芦荷载统计数据
     * @param statisticsQO
     * @return
     */
    @PostMapping("/getCraneByClimbFrameId")
    @ResponseBody
    public AjaxResult getCraneByClimbFrameId(@RequestBody StatisticsQO statisticsQO) throws ParseException {
        Long climbFrameId = statisticsQO.getClimbFrameId();
        String startTime = statisticsQO.getStartTime();
        String endTime = statisticsQO.getEndTime();
        List<CraneVO> craneVOList = craneMapper.getRecordDataByCraneId(climbFrameId,startTime,endTime);
        LineChartVO data = new LineChartVO();
        // 处理x轴和y轴的数据
        if (craneVOList != null && craneVOList.size() > 0) {
            // 根据荷载名称分组
            Map<String, List<CraneVO>> mapByPointName = craneVOList.stream().collect(Collectors.groupingBy(CraneVO::getPointName));
            Iterator<Map.Entry<String, List<CraneVO>>> iterator = mapByPointName.entrySet().iterator();
            HashMap<String, List> yResult = new HashMap<>();
            List<String> x = new ArrayList<>();
            craneVOList.forEach(o -> {
                x.add(o.getTime().substring(5, o.getTime().length() - 2));
            });
            while (iterator.hasNext()) {
                Map.Entry<String, List<CraneVO>> next = iterator.next();
                String key = next.getKey();
                List<String> valueTemp = new ArrayList<>();
                List<CraneVO> value = next.getValue();
                List<CraneVO> listTemp = new ArrayList<>();
                x.forEach(a -> {
                    CraneVO craneVO = new CraneVO();
                    craneVO.setTime(a);
                    craneVO.setRecordValue(0 + "");
                    listTemp.add(craneVO);
                    valueTemp.add(0 + "");
                });
                for (int i = 0; i < listTemp.size(); i++) {
                    for (int j = 0; j < value.size(); j++) {
                        String temp2 = listTemp.get(i).getTime();
                        String temp1 = value.get(j).getTime().substring(5, value.get(j).getTime().length() - 2);
                        if (temp2.equals(temp1)) {
                            // valueTemp.add(value.get(j).getRecordValue());
                            String recordValue = value.get(j).getRecordValue();
                            valueTemp.set(i,recordValue);
                        }
                    }
                }
                yResult.put(key, valueTemp);
            }

            data.setxData(x);
            data.setyData(yResult);
        }
        // 存在空的情况
        return AjaxResult.success(data);
    }

    /**
     * 统计分析中获取电葫芦荷载统计数据(弃用)
     * @param statisticsQO
     * @return
     */
    @PostMapping("/getCraneByClimbFrameId_")
    @ResponseBody
    public AjaxResult getCraneByClimbFrameId_(@RequestBody StatisticsQO statisticsQO) throws ParseException {
        Long climbFrameId = statisticsQO.getClimbFrameId();
        String startTime = statisticsQO.getStartTime();
        String endTime = statisticsQO.getEndTime();
        List<String> dayStrByTime = DateUtils.getDayStrByTime(startTime, endTime);
        List<StressDataVO> resultList = new ArrayList();

        List<String> stressList = new ArrayList<>();
        for (int i = 0; i < dayStrByTime.size(); i++) {
            stressList.add(0 + "");
        }
        // 构建结果数据
        StressDataVO stressDataVO = new StressDataVO();
        stressDataVO.setDateStr(dayStrByTime);
        stressDataVO.setStress(stressList);

        List<CraneVO> craneVOList = craneMapper.getRecordNewByCraneId(climbFrameId);
        // 处理x轴和y轴的数据
        if (craneVOList != null && craneVOList.size() > 0) {
            // 过滤荷载的数据
            List<CraneVO> collect = craneVOList.stream().filter(s -> STRESS_TYPE.equals(s.getType())).collect(Collectors.toList());
            if (collect != null && collect.size() > 0) {
                // 根据记录时间排序
                List<CraneVO> collect1 = collect.stream().sorted(Comparator.comparing(c -> c.getRecordTime())).collect(Collectors.toList());
                // 根据电葫芦分组
                Map<Long, List<CraneVO>> collect2 = collect1.stream().collect(Collectors.groupingBy(CraneVO::getCraneId));
                Iterator<Map.Entry<Long, List<CraneVO>>> iterator = collect2.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Long, List<CraneVO>> entry = iterator.next();
                    Long key = entry.getKey();
                    stressDataVO.setCraneId(key);
                    List<CraneVO> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        // 电葫芦名称是一致的
                        String craneName = value.get(0).getCraneName();
                        stressDataVO.setCraneName(craneName);
                        for (int i = 0; i < value.size(); i++) {
                            for (int j = 0; j < stressDataVO.getDateStr().size(); j++) {
                                // 日期一致时,更改荷载值
                                if (stressDataVO.getDateStr().get(j).equals(getDateStr(value.get(i).getRecordTime()))) {
                                    // 替换指定下标的值
                                    stressDataVO.getStress().set(j, value.get(i).getRecordValue());
                                    resultList.add(stressDataVO);
                                }
                            }
                        }
                    }
                }
            }
        }
        // 存在空的情况
        return AjaxResult.success(resultList);
    }

    /**
     * 日期转字符串
     * @param date
     * @return
     */
    private static String getDateStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateNew = formatter.format(date);
        return dateNew;
    }
}