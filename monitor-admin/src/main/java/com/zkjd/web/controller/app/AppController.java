package com.zkjd.web.controller.app;

import com.alibaba.fastjson.JSON;
import com.zkjd.business.domain.*;
import com.zkjd.business.mapper.WarnMapper;
import com.zkjd.business.service.*;
import com.zkjd.business.vo.*;
import com.zkjd.common.config.RuoYiConfig;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.core.domain.entity.SysDictData;
import com.zkjd.common.core.domain.entity.SysDictType;
import com.zkjd.common.core.domain.entity.SysUser;
import com.zkjd.common.utils.SecurityUtils;
import com.zkjd.common.utils.file.FileUploadUtils;
import com.zkjd.framework.config.ServerConfig;
import com.zkjd.system.service.ISysDictDataService;
import com.zkjd.system.service.ISysDictTypeService;
import com.zkjd.system.service.ISysUserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: XuXiang  @createTime: 2021/11/4 10:27
 * Description: app相关接口控制层
 */
@RestController
@RequestMapping("/app")
public class AppController extends BaseController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ClimbFrameService climbFrameService;

    @Autowired
    private WarnService warnService;

    @Autowired
    private ISysDictTypeService sysDictTypeService;

    @Autowired
    private IRiseRecordService riseRecordService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private WarnMapper warnMapper;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private ICheckRecordService checkRecordService;

    @Autowired
    private ICheckSubService checkSubService;

    @Autowired
    private IRiseCheckService riseCheckService;

    @Autowired
    private IRiseCheckSubService riseCheckSubService;

    @Autowired
    private IAcceptRecordService acceptRecordService;

    @Autowired
    private IAcceptSubService acceptSubService;

    @Autowired
    private ISysDictDataService sysDictDataService;

    @Autowired
    private IMaintainService maintainService;

    @Autowired
    private StockService stockService;

    @Autowired
    private ICraneService craneService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IDangerCheckService dangerCheckService;

    @Autowired
    private IStandardService standardService;

    @Autowired
    private IAppVersionService appVersionService;

    @Autowired
    private IMonitorPointService monitorPointService;

    /**
     * 使用前检查 - 字典类型
     */
    private String deviceCheck = "device_check";

    /**
     * 升降脚手架提升作业前检查 - 字典类型
     */
    private String deviceCheckRise = "device_check_rise";

    /**
     * 爬架卸料平台验收记录 - 字典类型
     */
    private String climbCheck = "climb_check";

    /**
     * 附着式升降脚手架提升及维修保养 - 字典类型
     */
    private String climbMaintain = "climb_maintain";

    /**
     * 更换平面图
     *
     * @author XuXiang  @time 2022/02/27 10:24
     */
    @PostMapping("/changeImage")
    @ResponseBody
    public AjaxResult changeImage(@RequestBody Map map) {
        String imageUrl = (String) map.get("imageUrl");
        String imageName = (String) map.get("imageName");
        Integer climbFrameId = (Integer) map.get("climbFrameId");
        ClimbFrame climbFrame = climbFrameService.selectClimbFrameById(Long.valueOf(climbFrameId));
        climbFrame.setImageUrl(imageUrl);
        climbFrame.setImageName(imageName);
        int i = climbFrameService.updateClimbFrame(climbFrame);
        if (i > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("更换平面图失败");
    }

    /**
     * 技术人员 - 根据用户信息,加载最近一条设备信息
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getOneDeviceByUser")
    @ResponseBody
    public AjaxResult getOneDeviceByUser(@RequestBody AppUserVO appUserVO) {
        // 当前用户未与设备关联userId暂时接收但不做处理
        Long userId = appUserVO.getUserId();
        String roleKey = appUserVO.getRoleKey();
        AjaxResult result = deviceService.getOneDeviceByUser(userId, roleKey);
        return result;
    }

    /**
     * 获取项目列表
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getProjectList")
    @ResponseBody
    public AjaxResult getProjectList() {
        // Project project = new Project();
        // project.setDelFlag(0);
        List<Project> projects = projectService.selectProjectList(null);
        if (projects != null && projects.size() > 0) {
            return AjaxResult.success(projects);
        }
        return error("暂无项目信息");
    }

    /**
     * 根据项目ID获取项目下的爬架信息
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getFrameListByProjectId/{projectId}")
    @ResponseBody
    public AjaxResult getFrameListByProjectId(@PathVariable("projectId") Long projectId) {
        ClimbFrame climbFrame = new ClimbFrame();
        climbFrame.setProjectId(projectId);
        List<ClimbFrame> climbFrames = climbFrameService.selectClimbFrameList(climbFrame);
        if (climbFrames != null && climbFrames.size() > 0) {
            return AjaxResult.success(climbFrames);
        }
        return error("暂无爬架信息");
    }

    /**
     * 根据项目ID获取项目下的爬架信息
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getDeviceListByFrameId/{frameId}")
    @ResponseBody
    public AjaxResult getDeviceListByFrameId(@PathVariable("frameId") Long frameId) {
        Device device = new Device();
        device.setClimbFrameId(frameId);
        List<Device> devices = deviceService.selectDeviceList(device);
        if (devices != null && devices.size() > 0) {
            return AjaxResult.success(devices);
        }
        return error("暂无设备信息");
    }

    /**
     * 管理员 - 获取生产指标数据
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @GetMapping("/getProductionTarget")
    @ResponseBody
    public AjaxResult getProductionTarget() {
        List<ClimbFrameVO> climbFrames = climbFrameService.selectCurrentYear();
        if (climbFrames != null && climbFrames.size() > 0) {
            ProductionTargetVO data = new ProductionTargetVO();
            // 年度生产指标
            data.setAnnualProduction(climbFrames.size());
            // 年度已完成产量
            int completeAnnualNum = climbFrames.stream().filter(o -> o.getInstallState() != null && o.getInstallState() == 3).collect(Collectors.toList()).size();
            data.setCompleteAnnualProduction(completeAnnualNum);
            //当前月份
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String month = sdf.format(new Date());
            //当月数据
            List<ClimbFrameVO> mlist = climbFrames.stream().filter(o -> o.getMonth().equals(month)).collect(Collectors.toList());
            data.setMonthlyProduction(mlist.size());
            //当月已完成数据
            int annualShipments = mlist.stream().filter(o -> o.getInstallState() != null && o.getInstallState() == 3).collect(Collectors.toList()).size();
            data.setAnnualShipments(annualShipments);
            return AjaxResult.success(data);
        }
        return error("暂无生产指标数据");
    }

    /**
     * 管理员 - 获取项目和设备数量信息
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @GetMapping("/getQuantityStatistics")
    @ResponseBody
    public AjaxResult getQuantityStatistics() {
        QuantityStatisticsVO data = new QuantityStatisticsVO();
        List<Project> projects = projectService.selectProjectList(null);
        // 项目数
        Integer psize = 0;
        // 告警项目数
        Integer warnp = 0;
        if (projects != null && projects.size() > 0) {
            psize = projects.size();
            warnp = projectService.getWarnCont();
        }
        List<Device> devices = deviceService.selectDeviceList(null);
        // 设备数
        Integer dsize = 0;
        // 告警设备数
        Integer warnd = 0;
        if (devices != null && devices.size() > 0) {
            dsize = devices.size();
            warnd = deviceService.getWarnCont();
        }
        //安装项目和设备信息
        data.setInstalledItems(psize);
        data.setInstalledEquipment(dsize);
        data.setAlertItems(warnp);
        data.setAlertEquipment(warnd);
        return AjaxResult.success(data);
    }

    /**
     * 技术人员 - 获取设备检查所需的设备类别
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getCheckTypes")
    @ResponseBody
    public AjaxResult getCheckTypes() {
        SysDictType sysDictType = sysDictTypeService.selectDictTypeByType(deviceCheck);
        SysDictType sysDictType2 = sysDictTypeService.selectDictTypeByType(deviceCheckRise);
        SysDictType sysDictType3 = sysDictTypeService.selectDictTypeByType(climbCheck);
        // app单独拎出来了,这里不再获取
        // SysDictType sysDictType4 = sysDictTypeService.selectDictTypeByType(climbMaintain);
        List<SysDictType> dictTypes = new ArrayList<>();
        if (sysDictType != null) {
            dictTypes.add(sysDictType);
        }
        if (sysDictType2 != null) {
            dictTypes.add(sysDictType2);
        }
        if (sysDictType3 != null) {
            dictTypes.add(sysDictType3);
        }
        // if (sysDictType4 != null) {
        //     dictTypes.add(sysDictType4);
        // }
        return AjaxResult.success(dictTypes);
    }

    /**
     * 图片上传
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public AjaxResult uploadFile(HttpServletRequest request) throws Exception {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
            // 对应前端的upload的name参数"file"
            MultipartFile file = req.getFile("file");
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            Map<String, Object> result = new HashMap<>();
            result.put("fileName", fileName);
            result.put("url", url);
            return AjaxResult.success(result);
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 按月份展示告警信息数量
     *
     * @author XuXiang  @time 2021/11/17 13:46
     */
    @PostMapping("/getWarningByMonth")
    @ResponseBody
    public AjaxResult getWarningByMonth(@RequestBody Map map) {
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        // 当前年第一秒
        String firstSecond = year + "-01-01 00:00:00";
        // 当前年最后一秒
        String lastSecond = year + "-12-31 23:59:59";
        Long climbFrameId = null;
        if (map != null && map.size() > 0) {
            climbFrameId = ((Integer) map.get("climbFrameId")).longValue();
        }
        // 数据库中各月份的告警数量
        List<WarningDataVO> warningByMonth = warnService.getWarningByMonth(firstSecond, lastSecond, climbFrameId);
        List<WarningDataVO> monthDataList = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            WarningDataVO warningDataVOTemp = new WarningDataVO();
            String temp = (i + "").length() == 1 ? (year + "-0" + i) : (year + "-" + i);
            warningDataVOTemp.setMonth(temp);
            warningDataVOTemp.setNumber(0);
            monthDataList.add(warningDataVOTemp);
        }
        if (warningByMonth != null && warningByMonth.size() > 0) {
            for (int i = 0; i < monthDataList.size(); i++) {
                for (int j = 0; j < warningByMonth.size(); j++) {
                    if (monthDataList.get(i).getMonth().equals(warningByMonth.get(j).getMonth())) {
                        WarningDataVO warningDataVO = new WarningDataVO();
                        warningDataVO.setMonth(monthDataList.get(i).getMonth());
                        warningDataVO.setNumber(warningByMonth.get(j).getNumber());
                        monthDataList.set(i, warningDataVO);
                    }
                }
            }
        }
        return AjaxResult.success(monthDataList);
    }

    /**
     * app端获取按月份查询提升次数
     *
     * @author XuXiang  @time 2021/11/17 13:46
     */
    @PostMapping("/getRiseDataByMon")
    @ResponseBody
    public AjaxResult getRiseDataByMon(@RequestBody Map map) {
        Long climbFrameId = null;
        if (map != null && map.size() > 0) {
            climbFrameId = ((Integer) map.get("climbFrameId")).longValue();
        }
        AppRiseDataVO riseDataByMon = warnService.getRiseDataByMon(climbFrameId);
        return AjaxResult.success(riseDataByMon);
    }

    /**
     * 技术人员 - 保存提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/saveRiseRecord")
    @ResponseBody
    public AjaxResult saveRiseRecord(@RequestBody RiseRecord riseRecord) {
        int i = riseRecordService.insertRiseRecord(riseRecord);
        if (1 > 0) {
            return AjaxResult.success("保存成功");
        }
        return AjaxResult.error("保存失败");
    }

    /**
     * 技术人员 - 更新提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/updateRiseRecord")
    @ResponseBody
    public AjaxResult updateRiseRecord(@RequestBody RiseRecord riseRecord) {
        int i = riseRecordService.updateRiseRecord(riseRecord);
        if (1 > 0) {
            return AjaxResult.success("保存成功");
        }
        return AjaxResult.error("保存失败");
    }

    /**
     * 技术人员 - 获取提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getRiseRecordList")
    @ResponseBody
    public AjaxResult getRiseRecordList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        Long climbFrameId = null;
        if (map != null && map.size() > 0) {
            climbFrameId = ((Integer) map.get("climbFrameId")).longValue();
        }
        List<RiseRecord> riseRecordList = riseRecordService.getRiseRecordList(page, pageSize, climbFrameId);
        return AjaxResult.success(riseRecordList);
    }


    /**
     * 管理员 - 根据爬架ID,获取提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/adminGetRiseRecordList")
    @ResponseBody
    public AjaxResult adminGetRiseRecordList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer climbFrameId = (Integer) map.get("climbFrameId");
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        List<RiseRecord> riseRecordList = riseRecordService.adminGetRiseRecordList(climbFrameId, page, pageSize);
        return AjaxResult.success(riseRecordList);
    }


    /**
     * 技术人员 - 获取消息记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getMessageList")
    @ResponseBody
    public AjaxResult getMessageList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        List<Message> messageList = messageService.getMessageList(page, pageSize);
        return AjaxResult.success(messageList);
    }

    /**
     * 技术人员 - 删除提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/deleteRiseRecord/{id}")
    @ResponseBody
    public AjaxResult deleteRiseRecord(@PathVariable("id") Long id) {
        int i = riseRecordService.deleteRiseRecordById(id);
        if (i > 0) {
            return AjaxResult.success("操作成功");
        }
        return error("删除失败");
    }

    /**
     * 技术人员 - 根据id获取提升记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getRiseRecordById/{id}")
    @ResponseBody
    public AjaxResult getRiseRecordById(@PathVariable("id") Long id) {
        RiseRecord result = riseRecordService.selectRiseRecordById(id);
        if (result != null) {
            return AjaxResult.success(result);
        }
        return error("获取提升记录失败");
    }

    /**
     * 技术人员 - 根据id获取消息详情
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getMessageDetailById/{id}")
    @ResponseBody
    public AjaxResult getMessageDetailById(@PathVariable("id") Long id) {
        Message result = messageService.selectMessageById(id);
        if (result != null) {
            return AjaxResult.success(result);
        }
        return error("获取消息详情失败");
    }

    /**
     * 技术人员 - 根据检查类别获取检查详情列表
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getDetailByType/{dictType}")
    @ResponseBody
    public AjaxResult getDetailByType(@PathVariable("dictType") String dictType) {
        // 获取需要的数据结构为:字典标签分组的list
        List<SysDictData> sysDictDataList = sysDictTypeService.selectDictDataByType(dictType);
        List<DictDataVO> resultList = new ArrayList<>();
        if (sysDictDataList != null && sysDictDataList.size() > 0) {
            Map<String, List<SysDictData>> groupByLabel = sysDictDataList.stream().collect(Collectors.groupingBy(SysDictData::getDictLabel));
            for (Map.Entry<String, List<SysDictData>> entryUser : groupByLabel.entrySet()) {
                DictDataVO dictDataVO = new DictDataVO();
                String key = entryUser.getKey();
                dictDataVO.setDictLabel(key);
                List<SysDictData> entryUserList = entryUser.getValue();
                dictDataVO.setDictDataList(entryUserList);
                resultList.add(dictDataVO);
            }
        }
        // 根据字典数据的标号排序
        resultList.sort(Comparator.comparing(e -> e.getDictLabel().substring(0, 2)));
        return AjaxResult.success(resultList);
    }

    /**
     * 技术人员 - 获取使用前检查记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getCheckRecordPage")
    @ResponseBody
    public AjaxResult getCheckRecordPage(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Long climbFrameId = null;
        if (map != null && map.size() > 0) {
            climbFrameId = ((Integer) map.get("climbFrameId")).longValue();
        }
        Integer page = (pageNum - 1) * pageSize;
        List<CheckRecord> checkRecordPage = checkRecordService.getCheckRecordPage(page, pageSize, climbFrameId);
        return AjaxResult.success(checkRecordPage);
    }

    /**
     * 技术人员 - 根据id获取使用前检查记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getCheckRecordById/{id}")
    @ResponseBody
    public AjaxResult getCheckRecordById(@PathVariable("id") Long id) {
        CheckRecord checkRecord = checkRecordService.selectCheckRecordById(id);
        if (checkRecord != null) {
            CheckSub checkSub = new CheckSub();
            checkSub.setCheckId(id);
            List<CheckSub> checkSubs = checkSubService.selectCheckSubList(checkSub);
            checkRecord.setCheckSubs(checkSubs);
            return AjaxResult.success(checkRecord);
        }
        return error("获取使用前检查记录失败");
    }

    /**
     * 技术人员 -保存使用前检查记录
     *
     * @author XuXiang  @time 2021/11/16 16:42
     */
    @PostMapping("/saveCheckRecord")
    @ResponseBody
    public AjaxResult saveCheckRecord(@RequestBody CheckRecord checkRecord) {
        String username = SecurityUtils.getUsername();
        checkRecord.setCreateBy(username);
        int i = checkRecordService.insertCheckRecord(checkRecord);
        if (i > 0) {
            String checkValues = checkRecord.getCheckValues();
            // 检查类别,这里是"使用前检查 device_check"
            String dictType = checkRecord.getDictType();
            // 检查项对象
            HashMap hashMap = JSON.parseObject(checkValues, HashMap.class);
            hashMap.forEach((key, value) -> {
                CheckSub checkSub = new CheckSub();
                checkSub.setDictType(dictType);
                checkSub.setCheckId(checkRecord.getId());
                checkSub.setDictValue(String.valueOf(key));
                checkSub.setCheckValue(Integer.valueOf(value.toString()));
                checkSub.setCreateBy(username);
                checkSubService.insertCheckSub(checkSub);
                // System.out.println(key + "=>" + value);
            });
            return AjaxResult.success();
        }
        return AjaxResult.error("新增检查记录失败");
    }

    /**
     * 保存监测点信息
     *
     * @author XuXiang  @time 2021/11/16 16:42
     */
    @PostMapping("/savePointInfo")
    @ResponseBody
    public AjaxResult savePointInfo(@RequestBody MonitorPoint monitorPoint) {
        String username = SecurityUtils.getUsername();
        monitorPoint.setCreateBy(username);
        int i = monitorPointService.insertMonitorPoint(monitorPoint);
        if (i > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("新增检测点信息失败");
    }

    /**
     * 技术人员 - 更新使用前检查记录
     *
     * @author XuXiang  @time 2021/11/16 16:42
     */
    @PostMapping("/updateCheckRecord")
    @ResponseBody
    public AjaxResult updateCheckRecord(@RequestBody CheckRecord checkRecord) {
        String username = SecurityUtils.getUsername();
        checkRecord.setUpdateBy(username);
        int i = checkRecordService.updateCheckRecord(checkRecord);
        if (i > 0) {
            // 先删除之前的子表信息
            CheckSub checkSubTemp = new CheckSub();
            checkSubTemp.setCheckId(checkRecord.getId());
            List<CheckSub> checkSubs = checkSubService.selectCheckSubList(checkSubTemp);
            ArrayList<Long> idList = new ArrayList<>();
            checkSubs.forEach(item -> {
                idList.add(item.getId());
            });
            Long[] ids = idList.toArray(new Long[idList.size()]);
            checkSubService.deleteCheckSubByIds(ids);

            String checkValues = checkRecord.getCheckValues();
            // 检查类别,这里是"使用前检查 device_check"
            String dictType = checkRecord.getDictType();
            // 检查项对象
            HashMap hashMap = JSON.parseObject(checkValues, HashMap.class);
            hashMap.forEach((key, value) -> {
                CheckSub checkSub = new CheckSub();
                checkSub.setDictType(dictType);
                checkSub.setCheckId(checkRecord.getId());
                checkSub.setDictValue(String.valueOf(key));
                checkSub.setCheckValue(Integer.valueOf(value.toString()));
                checkSub.setCreateBy(username);
                checkSubService.insertCheckSub(checkSub);
            });
            return AjaxResult.success();
        }
        return AjaxResult.error("更新检查记录失败");
    }

    /**
     * 技术人员 - 删除使用前检查记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/deleteCheckRecord/{id}")
    @ResponseBody
    public AjaxResult deleteCheckRecord(@PathVariable("id") Long id) {
        // 逻辑删除
        CheckRecord checkRecord = checkRecordService.selectCheckRecordById(id);
        checkRecord.setDelFlag(1);
        int i = checkRecordService.updateCheckRecord(checkRecord);
        if (i > 0) {
            CheckSub checkSubTemp = new CheckSub();
            checkSubTemp.setCheckId(checkRecord.getId());
            List<CheckSub> checkSubs = checkSubService.selectCheckSubList(checkSubTemp);
            if (checkSubs != null && checkSubs.size() > 0) {
                for (int j = 0; j < checkSubs.size(); j++) {
                    CheckSub checkSub = checkSubs.get(j);
                    checkSub.setDelFlag(1);
                    checkSubService.updateCheckSub(checkSub);
                }
            }
            return AjaxResult.success("操作成功");
        }
        return error("删除失败");
    }

    /**
     * 技术人员 -保存 升降脚手架提升作业前检查
     *
     * @author XuXiang  @time 2021/11/16 16:42
     */
    @PostMapping("/saveRiseCheck")
    @ResponseBody
    public AjaxResult saveRiseCheck(@RequestBody RiseCheck riseCheck) {
        String username = SecurityUtils.getUsername();
        riseCheck.setCreateBy(username);
        int i = riseCheckService.insertRiseCheck(riseCheck);
        if (i > 0) {
            String checkValues = riseCheck.getCheckValues();
            // 检查类别,这里是"使用前检查 device_check_rise"
            String dictType = riseCheck.getDictType();
            // 检查项对象
            HashMap hashMap = JSON.parseObject(checkValues, HashMap.class);
            hashMap.forEach((key, value) -> {
                RiseCheckSub riseCheckSub = new RiseCheckSub();
                riseCheckSub.setDictType(dictType);
                riseCheckSub.setRiseCheckId(riseCheck.getId());
                riseCheckSub.setDictValue(String.valueOf(key));
                riseCheckSub.setCheckValue(Integer.valueOf(value.toString()));
                riseCheckSub.setCreateBy(username);
                riseCheckSubService.insertRiseCheckSub(riseCheckSub);
            });
            return AjaxResult.success();
        }
        return AjaxResult.error("新增提升作业前检查记录失败");
    }

    /**
     * 技术人员 - 获取  升降脚手架提升作业前检查 检查记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getRiseCheckPage")
    @ResponseBody
    public AjaxResult getRiseCheckPage(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        Long climbFrameId = null;
        if (map != null && map.size() > 0) {
            climbFrameId = ((Integer) map.get("climbFrameId")).longValue();
        }
        List<RiseCheck> riseCheckPage = riseCheckService.getRiseCheckPage(page, pageSize, climbFrameId);
        return AjaxResult.success(riseCheckPage);
    }

    /**
     * 技术人员 - 根据id获取升降脚手架提升作业前检查记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getRiseCheckById/{id}")
    @ResponseBody
    public AjaxResult getRiseCheckById(@PathVariable("id") Long id) {
        RiseCheck riseCheck = riseCheckService.selectRiseCheckById(id);
        if (riseCheck != null) {
            RiseCheckSub riseCheckSub = new RiseCheckSub();
            riseCheckSub.setRiseCheckId(id);
            List<RiseCheckSub> riseCheckSubs = riseCheckSubService.selectRiseCheckSubList(riseCheckSub);
            riseCheck.setRiseCheckSubs(riseCheckSubs);
            return AjaxResult.success(riseCheck);
        }
        return error("获取升降脚手架提升作业前检查记录失败");
    }

    /**
     * 技术人员 - 更新 升降脚手架提升作业前检查
     *
     * @author XuXiang  @time 2021/11/16 16:42
     */
    @PostMapping("/updateRiseCheck")
    @ResponseBody
    public AjaxResult updateRiseCheck(@RequestBody RiseCheck riseCheck) {
        String username = SecurityUtils.getUsername();
        riseCheck.setUpdateBy(username);
        int i = riseCheckService.updateRiseCheck(riseCheck);
        if (i > 0) {
            // 先删除之前的子表信息
            // CheckSub checkSubTemp = new CheckSub();
            RiseCheckSub riseCheckSubTemp = new RiseCheckSub();
            riseCheckSubTemp.setRiseCheckId(riseCheck.getId());
            List<RiseCheckSub> riseCheckSubs = riseCheckSubService.selectRiseCheckSubList(riseCheckSubTemp);
            ArrayList<Long> idList = new ArrayList<>();
            riseCheckSubs.forEach(item -> {
                idList.add(item.getId());
            });
            Long[] ids = idList.toArray(new Long[idList.size()]);
            riseCheckSubService.deleteRiseCheckSubByIds(ids);
            String checkValues = riseCheck.getCheckValues();
            // 检查类别,这里是"升降脚手架提升作业前检查 device_check_rise"
            String dictType = riseCheck.getDictType();
            // 检查项对象
            HashMap hashMap = JSON.parseObject(checkValues, HashMap.class);
            hashMap.forEach((key, value) -> {
                RiseCheckSub riseCheckSub = new RiseCheckSub();
                riseCheckSub.setDictType(dictType);
                riseCheckSub.setRiseCheckId(riseCheck.getId());
                riseCheckSub.setDictValue(String.valueOf(key));
                riseCheckSub.setCheckValue(Integer.valueOf(value.toString()));
                riseCheckSub.setCreateBy(username);
                riseCheckSubService.insertRiseCheckSub(riseCheckSub);
            });
            return AjaxResult.success();
        }
        return AjaxResult.error("更新升降脚手架提升作业前检查记录失败");
    }

    /**
     * 技术人员 - 删除升降脚手架提升作业前检查记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/deleteRiseCheck/{id}")
    @ResponseBody
    public AjaxResult deleteRiseCheck(@PathVariable("id") Long id) {
        // 逻辑删除
        RiseCheck riseCheck = riseCheckService.selectRiseCheckById(id);
        riseCheck.setDelFlag(1);
        int i = riseCheckService.updateRiseCheck(riseCheck);
        if (i > 0) {
            RiseCheckSub riseCheckSubTemp = new RiseCheckSub();
            riseCheckSubTemp.setRiseCheckId(riseCheck.getId());
            List<RiseCheckSub> riseCheckSubs = riseCheckSubService.selectRiseCheckSubList(riseCheckSubTemp);
            if (riseCheckSubs != null && riseCheckSubs.size() > 0) {
                for (int j = 0; j < riseCheckSubs.size(); j++) {
                    RiseCheckSub riseCheckSub = riseCheckSubs.get(j);
                    riseCheckSub.setDelFlag(1);
                    riseCheckSubService.updateRiseCheckSub(riseCheckSub);
                }
            }
            return AjaxResult.success("操作成功");
        }
        return error("删除失败");
    }

    /**
     * 技术人员 - 获取  爬架卸料平台验收记录 检查记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getAcceptRecordPage")
    @ResponseBody
    public AjaxResult getAcceptRecordPage(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        Long projectId = null;
        if (map != null && map.size() > 0) {
            projectId = ((Integer) map.get("projectId")).longValue();
        }
        List<AcceptRecord> acceptRecordPage = acceptRecordService.getAcceptRecordPage(page, pageSize, projectId);
        return AjaxResult.success(acceptRecordPage);
    }

    /**
     * 技术人员 - 根据id获取爬架卸料平台验收记录记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getAcceptRecordById/{id}")
    @ResponseBody
    public AjaxResult getAcceptRecordById(@PathVariable("id") Long id) {
        AcceptRecord acceptRecord = acceptRecordService.selectAcceptRecordById(id);
        if (acceptRecord != null) {
            AcceptSub acceptSub = new AcceptSub();
            acceptSub.setAcceptId(id);
            List<AcceptSub> acceptSubs = acceptSubService.selectAcceptSubList(acceptSub);
            acceptRecord.setAcceptSubs(acceptSubs);
            return AjaxResult.success(acceptRecord);
        }
        return error("获取升降脚手架提升作业前检查记录失败");
    }

    /**
     * 技术人员 -保存 爬架卸料平台验收记录
     *
     * @author XuXiang  @time 2021/11/16 16:42
     */
    @PostMapping("/saveAcceptRecord")
    @ResponseBody
    public AjaxResult saveAcceptRecord(@RequestBody AcceptRecord acceptRecord) {
        String username = SecurityUtils.getUsername();
        acceptRecord.setCreateBy(username);
        int i = acceptRecordService.insertAcceptRecord(acceptRecord);
        if (i > 0) {
            String checkValues = acceptRecord.getCheckValues();
            // 检查类别,这里是"爬架卸料平台验收记录 climb_check"
            String dictType = acceptRecord.getDictType();
            // 检查项对象
            HashMap hashMap = JSON.parseObject(checkValues, HashMap.class);
            hashMap.forEach((key, value) -> {
                AcceptSub acceptSub = new AcceptSub();
                acceptSub.setDictType(dictType);
                acceptSub.setAcceptId(acceptRecord.getId());
                acceptSub.setDictValue(String.valueOf(key));
                acceptSub.setCheckValue(Integer.valueOf(value.toString()));
                acceptSub.setCreateBy(username);
                acceptSubService.insertAcceptSub(acceptSub);
            });
            return AjaxResult.success();
        }
        return AjaxResult.error("新增爬架卸料平台验收记录失败");
    }

    /**
     * 技术人员 - 更新 爬架卸料平台验收记录
     *
     * @author XuXiang  @time 2021/11/16 16:42
     */
    @PostMapping("/updateAcceptRecord")
    @ResponseBody
    public AjaxResult updateAcceptRecord(@RequestBody AcceptRecord acceptRecord) {
        String username = SecurityUtils.getUsername();
        acceptRecord.setUpdateBy(username);
        int i = acceptRecordService.updateAcceptRecord(acceptRecord);
        if (i > 0) {
            // 先删除之前的子表信息
            AcceptSub acceptSubTemp = new AcceptSub();
            acceptSubTemp.setAcceptId(acceptRecord.getId());
            List<AcceptSub> acceptSubs = acceptSubService.selectAcceptSubList(acceptSubTemp);
            ArrayList<Long> idList = new ArrayList<>();
            acceptSubs.forEach(item -> {
                idList.add(item.getId());
            });
            Long[] ids = idList.toArray(new Long[idList.size()]);
            acceptSubService.deleteAcceptSubByIds(ids);
            String checkValues = acceptRecord.getCheckValues();
            // 检查类别,这里是"爬架卸料平台验收记录 climb_check"
            String dictType = acceptRecord.getDictType();
            // 检查项对象
            HashMap hashMap = JSON.parseObject(checkValues, HashMap.class);
            hashMap.forEach((key, value) -> {
                AcceptSub acceptSub = new AcceptSub();
                acceptSub.setDictType(dictType);
                acceptSub.setAcceptId(acceptRecord.getId());
                acceptSub.setDictValue(String.valueOf(key));
                acceptSub.setCheckValue(Integer.valueOf(value.toString()));
                acceptSub.setCreateBy(username);
                acceptSubService.insertAcceptSub(acceptSub);
            });
            return AjaxResult.success();
        }
        return AjaxResult.error("更新爬架卸料平台验收记录失败");
    }

    /**
     * 技术人员 - 删除爬架卸料平台验收记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/deleteAcceptRecord/{id}")
    @ResponseBody
    public AjaxResult deleteAcceptRecord(@PathVariable("id") Long id) {
        // 逻辑删除
        AcceptRecord acceptRecord = acceptRecordService.selectAcceptRecordById(id);
        acceptRecord.setDelFlag(1);
        int i = acceptRecordService.updateAcceptRecord(acceptRecord);
        if (i > 0) {
            AcceptSub acceptSub = new AcceptSub();
            acceptSub.setAcceptId(acceptRecord.getId());
            List<AcceptSub> acceptSubs = acceptSubService.selectAcceptSubList(acceptSub);
            if (acceptSubs != null && acceptSubs.size() > 0) {
                for (int j = 0; j < acceptSubs.size(); j++) {
                    AcceptSub acceptSub1 = acceptSubs.get(j);
                    acceptSub1.setDelFlag(1);
                    acceptSubService.updateAcceptSub(acceptSub1);
                }
            }
            return AjaxResult.success("操作成功");
        }
        return error("删除失败");
    }

    /**
     * 技术人员 - 获取附着式升降脚手架提升及维护保养记录 的维护主项列表(字符串列表)
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getMainStrList")
    @ResponseBody
    public AjaxResult getMainStrList() {
        // 获取需要的数据结构为:字典标签分组的list
        List<SysDictData> sysDictDataList = sysDictTypeService.selectDictDataByType(climbMaintain);
        List<String> resultList = new ArrayList<>();
        if (sysDictDataList != null && sysDictDataList.size() > 0) {
            Map<String, List<SysDictData>> groupByLabel = sysDictDataList.stream().collect(Collectors.groupingBy(SysDictData::getDictLabel));
            for (Map.Entry<String, List<SysDictData>> entryUser : groupByLabel.entrySet()) {
                String key = entryUser.getKey();
                resultList.add(key);
            }
        }
        return AjaxResult.success(resultList);
    }

    /**
     * 技术人员 - 根据维护主项的dictLabel获取分项列表
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getMainItem/{dictLabel}")
    @ResponseBody
    public AjaxResult getMainItem(@PathVariable("dictLabel") String dictLabel) {
        SysDictData sysDictDataTemp = new SysDictData();
        sysDictDataTemp.setDictLabel(dictLabel);
        sysDictDataTemp.setStatus("0");
        List<SysDictData> sysDictDataList = sysDictDataService.selectDictDataList(sysDictDataTemp);
        return AjaxResult.success(sysDictDataList);
    }

    /**
     * 技术人员 - 附着式升降脚手架提升及维护保养记录分页查询
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getMaintainPage")
    @ResponseBody
    public AjaxResult getMaintainPage(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        Long climbFrameId = null;
        if (map != null && map.size() > 0) {
            climbFrameId = ((Integer) map.get("climbFrameId")).longValue();
        }
        List<Maintain> maintainPage = maintainService.getMaintainPage(page, pageSize, climbFrameId);
        return AjaxResult.success(maintainPage);
    }


    /**
     * 技术人员 - 保存附着式升降脚手架提升及维护保养记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/saveMaintain")
    @ResponseBody
    public AjaxResult saveMaintain(@RequestBody Maintain maintain) {
        String username = SecurityUtils.getUsername();
        maintain.setCreateBy(username);
        int i = maintainService.insertMaintain(maintain);
        if (i > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("新增附着式升降脚手架提升及维护保养记录失败");
    }

    /**
     * 技术人员 - 根据id获取附着式升降脚手架提升及维护保养记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getMaintainById/{id}")
    @ResponseBody
    public AjaxResult getMaintainById(@PathVariable("id") Long id) {
        Maintain maintain = maintainService.selectMaintainById(id);
        if (maintain != null) {
            return AjaxResult.success(maintain);
        }
        return error("获取附着式升降脚手架提升及维护保养记录失败");
    }

    /**
     * 技术人员 - 更新附着式升降脚手架提升及维护保养记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/updateMaintain")
    @ResponseBody
    public AjaxResult updateMaintain(@RequestBody Maintain maintain) {
        String username = SecurityUtils.getUsername();
        maintain.setUpdateBy(username);
        int i = maintainService.updateMaintain(maintain);
        if (i > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("更新附着式升降脚手架提升及维护保养记录失败");
    }

    /**
     * 技术人员 - 删除附着式升降脚手架提升及维护保养记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/deleteMaintain/{id}")
    @ResponseBody
    public AjaxResult deleteMaintain(@PathVariable("id") Long id) {
        // 逻辑删除
        Maintain maintain = maintainService.selectMaintainById(id);
        maintain.setDelFlag(1);
        int i = maintainService.updateMaintain(maintain);
        if (i > 0) {
            return AjaxResult.success("操作成功");
        }
        return error("删除失败");
    }

    /**
     * 管理员/技术人员 - 获取告警信息
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getWarnMessage")
    @ResponseBody
    public AjaxResult getWarnMessage(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer climbFrameId = (Integer) map.get("climbFrameId");
        Integer page = (pageNum - 1) * pageSize;
        List<WarnMessageVO> warnMessagePage = warnService.getWarnMessagePage(climbFrameId, page, pageSize);
        return AjaxResult.success(warnMessagePage);
    }

    /**
     * 管理员 - 获取出货记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getStockList")
    @ResponseBody
    public AjaxResult getStockList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        List<Stock> stockPage = stockService.getStockList(page, pageSize);
        return AjaxResult.success(stockPage);
    }

    /**
     * 根据爬架ID获取脚手架提升作业前检查记录
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getRiseCheckByClimbId/{climbFrameId}")
    @ResponseBody
    public AjaxResult getRiseCheckByClimbId(@PathVariable("climbFrameId") Long climbFrameId) {
        List<RiseCheck> riseCheckByClimbId = riseCheckService.getRiseCheckByClimbId(climbFrameId);
        if (riseCheckByClimbId != null && riseCheckByClimbId.size() > 0) {
            return AjaxResult.success(riseCheckByClimbId.get(0));
        }
        return error("该爬架暂无使用前检查记录");
    }

    /**
     * 获取监测点类型
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @GetMapping("/getPointType")
    @ResponseBody
    public AjaxResult getPointType() {
        List<SysDictData> data = sysDictTypeService.selectDictDataByType("monitor_point_type");
        if (data != null && data.size() > 0) {
            return AjaxResult.success(data);
        }
        return error("暂无监测点类型");
    }

    /**
     * 根据爬架ID获取电葫芦列表(仅获取列表)
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getCraneInfoByClimbFrameId/{climbFrameId}")
    @ResponseBody
    public AjaxResult getCraneInfoByClimbFrameId(@PathVariable("climbFrameId") Long climbFrameId) {
        List<Crane> cranes = craneService.getCranesByclimbFrameId(climbFrameId);
        if (cranes != null && cranes.size() > 0) {
            return AjaxResult.success(cranes);
        }
        return error("暂无电葫芦信息");
    }

    /**
     * 根据爬架ID获取电葫芦列表及所含信息
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getCraneByClimbFrameId/{climbFrameId}")
    @ResponseBody
    public AjaxResult getCraneByClimbFrameId(@PathVariable("climbFrameId") Long climbFrameId) {
        List<AppCraneVO> resultList = craneService.getCraneByClimbFrameId(climbFrameId);
        if (resultList != null && resultList.size() > 0) {
            return AjaxResult.success(resultList);
        }
        return error("暂无电葫芦信息");
    }

    /**
     * 根据爬架ID获取监测点列表
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getPointsByClimbFrameId/{climbFrameId}")
    @ResponseBody
    public AjaxResult getPointsByClimbFrameId(@PathVariable("climbFrameId") Long climbFrameId) {
        List<CraneVO> resultList = craneService.getPointsByClimbFrameId(climbFrameId);
        if (resultList != null && resultList.size() > 0) {
            return AjaxResult.success(resultList);
        }
        return error("暂无监测点信息");
    }

    /**
     * 根据爬架ID和监测点ID获取监测点信息
     *
     * @author XuXiang  @time 2021/11/4 10:37
     */
    @PostMapping("/getPointInfo")
    @ResponseBody
    public AjaxResult getPointInfo(@RequestBody Map map) {
        // map中封装了分页信息
        String climbFrameId = (String) map.get("climbFrameId");
        String monitorPid = (String) map.get("monitorPid");
        CraneVO pointInfo = craneService.getPointInfo(Integer.valueOf(climbFrameId), Integer.valueOf(monitorPid));
        if (pointInfo != null) {
            return AjaxResult.success(pointInfo);
        }
        return error("暂无监测点信息");
    }

    /**
     * 根据爬架id获取爬架信息(主要是获取爬架中的监测平面图)
     *
     * @author XuXiang  @time 2022/1/20 10:17
     */
    @PostMapping("/getClimbById/{id}")
    @ResponseBody
    public AjaxResult getClimbById(@PathVariable("id") Long id) {
        ClimbFrame climbFrame = climbFrameService.selectClimbFrameById(id);
        if (climbFrame != null) {
            return AjaxResult.success(climbFrame);
        }
        return error("获取爬架信息失败");
    }

    /**
     * 获取公司管理人员和公司维护人员姓名及用户ID列表,用于安全隐患排查选择人员
     *
     * @author XuXiang  @time 2022/02/26 16:06
     */
    @GetMapping("/getAppUserNames/{projectId}")
    @ResponseBody
    public AjaxResult getAppUserNames(@PathVariable("projectId") Long projectId) {
        List<SysUser> appUserNames = userService.getAppUserNames(projectId);
        return AjaxResult.success(appUserNames);
    }

    /**
     * 新增安全巡检记录
     *
     * @author XuXiang  @time 2022/02/27 09:29
     */
    @PostMapping("/saveDangerCheck")
    @ResponseBody
    public AjaxResult saveDangerCheck(@RequestBody DangerCheck dangerCheck) {
        String username = SecurityUtils.getUsername();
        dangerCheck.setCreateBy(username);
        // 问题状态(1：未整改；2：待复查；3：已复查)
        dangerCheck.setStatus(1);
        int i = dangerCheckService.insertDangerCheck(dangerCheck);
        if (i > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("新增现场检查记录失败");
    }

    /**
     * 自己的安全隐患排查记录
     *
     * @author XuXiang  @time 2022/02/27 10:24
     */
    @PostMapping("/getDangerCheckOwnerList")
    @ResponseBody
    public AjaxResult getDangerCheckOwnerList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer checkManId = (Integer) map.get("checkManId");
        Integer page = (pageNum - 1) * pageSize;
        List<DangerCheck> dangerCheckOwnerList = dangerCheckService.getDangerCheckOwnerList(page, pageSize, checkManId);
        return AjaxResult.success(dangerCheckOwnerList);
    }

    /**
     * 获取待整改的安全隐患排查记录
     *
     * @author XuXiang  @time 2022/02/27 10:24
     */
    @PostMapping("/getWaitModifyList")
    @ResponseBody
    public AjaxResult getWaitModifyList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer modifyManId = (Integer) map.get("modifyManId");
        Integer page = (pageNum - 1) * pageSize;
        List<DangerCheck> dangerCheckOwnerList = dangerCheckService.getWaitModifyList(page, pageSize, modifyManId);
        return AjaxResult.success(dangerCheckOwnerList);
    }

    /**
     * 获取待复查的安全隐患排查记录
     *
     * @author XuXiang  @time 2022/02/27 10:24
     */
    @PostMapping("/getWaitReviewList")
    @ResponseBody
    public AjaxResult getWaitReviewList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer reviewManId = (Integer) map.get("reviewManId");
        Integer page = (pageNum - 1) * pageSize;
        List<DangerCheck> dangerCheckOwnerList = dangerCheckService.getWaitReviewList(page, pageSize, reviewManId);
        return AjaxResult.success(dangerCheckOwnerList);
    }

    /**
     * 获取已完结的安全隐患排查记录
     *
     * @author XuXiang  @time 2022/02/27 10:24
     */
    @PostMapping("/getCompletedList")
    @ResponseBody
    public AjaxResult getCompletedList(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer reviewManId = (Integer) map.get("reviewManId");
        Integer page = (pageNum - 1) * pageSize;
        List<DangerCheck> dangerCheckOwnerList = dangerCheckService.getCompletedList(page, pageSize, reviewManId);
        return AjaxResult.success(dangerCheckOwnerList);
    }

    /**
     * 根据安全隐患排查记录ID,获取待整改记录详情
     *
     * @author XuXiang  @time 2022/01/27 15:39
     */
    @PostMapping("/getModifyInfo/{id}")
    @ResponseBody
    public AjaxResult getModifyInfo(@PathVariable("id") Long id) {
        DangerCheck dangerCheck = dangerCheckService.selectDangerCheckById(id);
        if (dangerCheck != null) {
            return AjaxResult.success(dangerCheck);
        }
        return error("获取安全隐患排查记录失败");
    }

    /**
     * 更新整改信息,更改后数据状态变为待复查
     *
     * @author XuXiang  @time 2022/02/27 09:29
     */
    @PostMapping("/updateDangerCheck")
    @ResponseBody
    public AjaxResult updateDangerCheck(@RequestBody DangerCheck dangerCheck) {
        int i = dangerCheckService.updateDangerCheck(dangerCheck);
        if (i > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("更新整改信息记录失败");
    }

    /**
     * 更新复查信息,如复查不合格则数据状态为待整改;如为合格则数据状态为已完结
     *
     * @author XuXiang  @time 2022/02/27 09:29
     */
    @PostMapping("/reviewDangerCheck")
    @ResponseBody
    public AjaxResult reviewDangerCheck(@RequestBody DangerCheck dangerCheck) {
        Integer reviewResult = dangerCheck.getReviewResult();
        if (reviewResult == 1) {
            // 合格
            dangerCheck.setStatus(3);
        } else if (reviewResult == 2) {
            // 不合格
            dangerCheck.setStatus(1);
        }
        int i = dangerCheckService.updateDangerCheck(dangerCheck);
        if (i > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error("更新复查信息记录失败");
    }

    /**
     * 获取安装标准列表
     *
     * @author XuXiang  @time 2022/02/27 19:01
     */
    @PostMapping("/getStandardlist")
    @ResponseBody
    public AjaxResult getStandardlist(@RequestBody Map map) {
        // map中封装了分页信息
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer page = (pageNum - 1) * pageSize;
        List<Standard> standardlist = standardService.getStandardlist(page, pageSize);
        return AjaxResult.success(standardlist);
    }

    /**
     * 获取安装标准详情
     *
     * @author XuXiang  @time 2022/01/27 15:39
     */
    @PostMapping("/getStandardDetail/{standardId}")
    @ResponseBody
    public AjaxResult getStandardDetail(@PathVariable("standardId") Long standardId) {
        Standard standard = standardService.selectStandardByStandardId(standardId);
        if (standard != null) {
            return AjaxResult.success(standard);
        }
        return error("获取详情失败");
    }

    /**
     * 获取当前app版本信息
     *
     * @author XuXiang  @time 2022/02/21 09:42
     */
    @GetMapping("/getCurrentApp")
    @ResponseBody
    public AjaxResult getCurrentApp() {
        AppVersion appVersion = new AppVersion();
        appVersion.setIsCurrent(1);
        List<AppVersion> appVersions = appVersionService.selectAppVersionList(appVersion);
        if (!CollectionUtils.isEmpty(appVersions)) {
            AppVersion appVersionResult = appVersions.get(0);
            return AjaxResult.success(appVersionResult);
        }
        return error("获取最新版本app信息失败");
    }
}
