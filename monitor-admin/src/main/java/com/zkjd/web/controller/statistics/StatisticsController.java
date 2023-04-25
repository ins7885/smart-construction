package com.zkjd.web.controller.statistics;

import com.github.pagehelper.PageHelper;
import com.zkjd.business.domain.DangerCheck;
import com.zkjd.business.domain.Record;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.*;
import com.zkjd.business.vo.RiseDataVO;
import com.zkjd.business.vo.StatisticsVO;
import com.zkjd.business.vo.WarnDataVO;
import com.zkjd.common.constant.HttpStatus;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: xuxiang
 * @CreateTime: 2022-02-24 10:37
 * @Description: 统计分析Controller
 */
@RestController
@RequestMapping("/device/statistics")
public class StatisticsController extends BaseController {

    @Autowired
    private IRiseRecordService riseRecordService;

    @Autowired
    private IDangerCheckService dangerCheckService;

    @Autowired
    private ICheckRecordService checkRecordService;

    @Autowired
    private IRiseCheckService riseCheckService;

    @Autowired
    private WarnService warnService;

    /**
     * 查询中部的统计数据
     * @param statisticsQO
     * @return
     */
    @PostMapping(value = "/getStatisticsData")
    public AjaxResult getInfo(@RequestBody StatisticsQO statisticsQO) {
        StatisticsVO statisticsVO = new StatisticsVO();
        Integer riseNumber = riseRecordService.getRiseNumberByTime(statisticsQO);
        if (riseNumber != null) {
            // 提升次数
            statisticsVO.setRiseNumber(riseNumber);
        }
        // 安全检查总数
        Integer safeNumberAll = dangerCheckService.getSafeNumberAll(statisticsQO);
        if (safeNumberAll != null) {
            statisticsVO.setSafeCheckNumber(safeNumberAll);
        }
        // 安全检查 - 整改数
        Integer safeModifyNumber = dangerCheckService.getSafeModifyNumber(statisticsQO);
        if (safeModifyNumber != null) {
            statisticsVO.setSafeModifyNumber(safeModifyNumber);
        }
        // 安全检查 - 验收数
        Integer safePassNumber = dangerCheckService.getSafePassNumber(statisticsQO);
        if (safePassNumber != null) {
            statisticsVO.setSafePassNumber(safePassNumber);
        }
        // 使用前检查验收数
        Integer useCheckNumber = checkRecordService.getUseCheckNumber(statisticsQO);
        if (useCheckNumber != null) {
            statisticsVO.setUseCheckNumber(useCheckNumber);
        }
        // 提升作业前检查验收数
        Integer riseCheckNumber = riseCheckService.getRiseCheckNumber(statisticsQO);
        if (riseCheckNumber != null) {
            statisticsVO.setRiseCheckNumber(riseCheckNumber);
        }
        // 告警数
        Integer warnNumberByTime = warnService.getWarnNumberByTime(statisticsQO);
        if (warnNumberByTime != null) {
            statisticsVO.setWarnNumber(warnNumberByTime);
        }
        return AjaxResult.success(statisticsVO);
    }

    /**
     * 根据日期范围查询每天告警数量
     * @param statisticsQO
     * @return
     */
    @PostMapping(value = "/getWarnNumberByDate")
    public AjaxResult getWarnNumberByDate(@RequestBody StatisticsQO statisticsQO) throws ParseException {
        String startTime = statisticsQO.getStartTime();
        String endTime = statisticsQO.getEndTime();
        List<WarnDataVO> everyWarnNumberByTime = warnService.getEveryWarnNumberByTime(statisticsQO);
        List<String> dayStrByTime = getDayStrByTime(startTime, endTime);
        List<WarnDataVO> resultList = new ArrayList();
        for (int i = 0; i < dayStrByTime.size(); i++) {
            WarnDataVO warnDataVO = new WarnDataVO();
            warnDataVO.setDateStr(dayStrByTime.get(i));
            warnDataVO.setNumber(0);
            resultList.add(warnDataVO);
        }
        if (everyWarnNumberByTime != null && everyWarnNumberByTime.size() > 0) {
            for (int i = 0; i < resultList.size(); i++) {
                for (int j = 0; j < everyWarnNumberByTime.size(); j++) {
                    if (resultList.get(i).getDateStr().equals(everyWarnNumberByTime.get(j).getDateStr())) {
                        // 替换结果中的值
                        resultList.get(i).setNumber(everyWarnNumberByTime.get(j).getNumber());
                    }
                }
            }
        }
        return AjaxResult.success(resultList);
    }

    /**
     * 根据日期范围查询每天提升次数
     * @param statisticsQO
     * @return
     */
    @PostMapping(value = "/getRiseNumberByDateRange")
    public AjaxResult getRiseNumberByDateRange(@RequestBody StatisticsQO statisticsQO) throws ParseException {
        List<RiseDataVO> riseNumberByDateRange = riseRecordService.getRiseNumberByDateRange(statisticsQO);
        String startTime = statisticsQO.getStartTime();
        String endTime = statisticsQO.getEndTime();
        List<String> dayStrByTime = getDayStrByTime(startTime, endTime);
        List<RiseDataVO> resultList = new ArrayList();
        for (int i = 0; i < dayStrByTime.size(); i++) {
            RiseDataVO riseDataVO = new RiseDataVO();
            riseDataVO.setDateStr(dayStrByTime.get(i));
            riseDataVO.setNumber(0);
            resultList.add(riseDataVO);
        }
        if (riseNumberByDateRange != null && riseNumberByDateRange.size() > 0) {
            for (int i = 0; i < resultList.size(); i++) {
                for (int j = 0; j < riseNumberByDateRange.size(); j++) {
                    if (resultList.get(i).getDateStr().equals(riseNumberByDateRange.get(j).getDateStr())) {
                        // 替换结果中的值
                        resultList.get(i).setNumber(riseNumberByDateRange.get(j).getNumber());
                    }
                }
            }
        }
        return AjaxResult.success(resultList);
    }

    /** 根据日期范围获取范围内的所有日期 */
    public static List<String> getDayStrByTime(String startTime, String endTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(startTime));
        List<String> dayList = new ArrayList<>();
        for (long d = cal.getTimeInMillis(); d <= sdf.parse(endTime).getTime(); d = getDayPlusOne(cal)) {
            dayList.add(sdf.format(d));
        }
        return dayList;
    }

    /** 天数增加一天 */
    private static long getDayPlusOne(Calendar c) {
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
        return c.getTimeInMillis();
    }

}
