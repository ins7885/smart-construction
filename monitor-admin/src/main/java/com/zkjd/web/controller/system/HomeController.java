package com.zkjd.web.controller.system;

import com.zkjd.business.domain.Project;
import com.zkjd.business.domain.Warn;
import com.zkjd.business.service.*;
import com.zkjd.business.vo.*;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-26 09:06
 * @Description:
 */
@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ClimbFrameService climbFrameService;

    @Autowired
    private IRiseRecordService iRiseRecordService;

    @Autowired
    private WarnService warnService;

    @Autowired
    private ICheckRecordService iCheckRecordService;

    private Integer [] arr = new Integer[12];

    /**
     * 获取各项指标数量数据
     * @return
     */
    @GetMapping("/targetCount")
    public AjaxResult getTargetCount(){
        TargetCountVO count = new TargetCountVO();
        Integer projectCount = projectService.getProjectCount();
        Integer climbFrameCount = climbFrameService.getClimbFrameCount();
        Integer riseRecordTodayCount = iRiseRecordService.getRiseRecordTodayCount();
        Integer warnTodayCount = warnService.getWarnTodayCount();
        count.setProCount(projectCount);
        count.setCfCount(climbFrameCount);
        count.setRrCount(riseRecordTodayCount);
        count.setwCount(warnTodayCount);
        return AjaxResult.success("查询成功",count);
    }

    /**
     * 查询最新十条告警信息
     * @return
     */
    @GetMapping("/messages")
    public AjaxResult getWarnMessages(){
        List<Warn> warns = warnService.selectLatelyWarn();
        return AjaxResult.success("查询成功",warns);
    }

    /**
     * 查询最新十条检查信息
     * @return
     */
    @GetMapping("/checkRecords")
    public AjaxResult getCheckRecords(){
        List<CheckRecordVO> checkRecords = iCheckRecordService.getLatelyCheckRecord();
        return AjaxResult.success("查询成功",checkRecords);
    }

    /**
     * 当月告警次数
     * @return
     */
    @GetMapping("/warnTrend")
    public AjaxResult getWarnTrend(){
        //查询当年每个月告警数量
        Map<String, Integer> map = warnService.getMonthWarnCount().stream().collect(Collectors.toMap(WarningDataVO::getMonth, WarningDataVO::getNumber));
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            Integer num = map.get(i + 1 + "");
            if(num == null){
                list.add(0);
            }else {
                list.add(num);
            }
        }
        return AjaxResult.success("查询成功",list);
    }

    /**
     * 查询项目区域分布占比
     * @return
     */
    @GetMapping("/projectPie")
    public AjaxResult getProjectPie(){
        //查询各省份数据
        List<ProjectVO> projects = projectService.getProjectProvince();
        //求和
        Integer sum = projects.stream().collect(Collectors.summingInt(ProjectVO::getNumber));
        ProjectDistributionVO distribution = new ProjectDistributionVO();
        List<String> titles = new ArrayList<>();
        List<Double> ratio = new ArrayList<>();
        projects.forEach(o->{
            titles.add(o.getProvince());
            if(sum == 0){
                ratio.add(0.0);
            }else {
                ratio.add(new BigDecimal((float)o.getNumber()/sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
        });
        distribution.setTitles(titles);
        distribution.setRatio(ratio);
        return AjaxResult.success("查询成功",distribution);
    }
}
