package com.zkjd.web.controller.device;

import java.util.ArrayList;
import java.util.List;

import com.zkjd.business.domain.MonitorPoint;
import com.zkjd.business.domain.Record;
import com.zkjd.business.service.IMonitorPointService;
import com.zkjd.business.vo.ChartVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.common.utils.poi.ExcelUtil;
import com.zkjd.common.core.page.TableDataInfo;

/**
 * 监测点Controller
 * 
 * @author wangtao
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/device/point")
public class MonitorPointController extends BaseController
{
    @Autowired
    private IMonitorPointService monitorPointService;

    /**
     * 查询监测点列表
     */
    @PreAuthorize("@ss.hasPermi('device:point:list')")
    @GetMapping("/list")
    public TableDataInfo list(MonitorPoint monitorPoint)
    {
        startPage();
        Long projectId = getLoginUser().getUser().getProjectId();
        monitorPoint.setProjectId(projectId);
        List<MonitorPoint> list = monitorPointService.selectMonitorPointList(monitorPoint);
        return getDataTable(list);
    }

    /**
     * 导出监测点列表
     */
    @PreAuthorize("@ss.hasPermi('device:point:export')")
    @Log(title = "监测点", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MonitorPoint monitorPoint)
    {
        List<MonitorPoint> list = monitorPointService.selectMonitorPointList(monitorPoint);
        ExcelUtil<MonitorPoint> util = new ExcelUtil<MonitorPoint>(MonitorPoint.class);
        return util.exportExcel(list, "监测点数据");
    }

    /**
     * 获取监测点详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:point:query')")
    @GetMapping(value = "/{monitorPid}")
    public AjaxResult getInfo(@PathVariable("monitorPid") Long monitorPid)
    {
        return AjaxResult.success(monitorPointService.selectMonitorPointById(monitorPid));
    }

    /**
     * 新增监测点
     */
    @PreAuthorize("@ss.hasPermi('device:point:add')")
    @Log(title = "监测点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MonitorPoint monitorPoint)
    {
        return toAjax(monitorPointService.insertMonitorPoint(monitorPoint));
    }

    /**
     * 修改监测点
     */
    @PreAuthorize("@ss.hasPermi('device:point:edit')")
    @Log(title = "监测点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MonitorPoint monitorPoint)
    {
        return toAjax(monitorPointService.updateMonitorPoint(monitorPoint));
    }

    /**
     * 删除监测点
     */
    @PreAuthorize("@ss.hasPermi('device:point:remove')")
    @Log(title = "监测点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(monitorPointService.deleteMonitorPointByIds(ids));
    }

    /**
     * 查询监测点列表(不分页)
     */
    @GetMapping("/getById")
    public TableDataInfo getById(MonitorPoint monitorPoint)
    {
        List<MonitorPoint> list = monitorPointService.selectMonitorPointList(monitorPoint);
        return getDataTable(list);
    }

    /**
     * 获取监测点趋势信息
     */
    @PreAuthorize("@ss.hasPermi('device:point:chart')")
    @GetMapping(value = "/chart/{monitorPid}")
    public AjaxResult chart(@PathVariable("monitorPid") Long monitorPid)
    {
        List<Record> records = monitorPointService.selectMonitorPointChartById(monitorPid);
        ChartVO data = new ChartVO();
        List<Double> y = new ArrayList<>();
        List<String> x = new ArrayList<>();
        records.forEach(o->{
            x.add(o.getTime().substring(5,o.getTime().length()));
            y.add(Double.valueOf(o.getRecordValue()));
        });
        data.setxData(x);
        data.setyData(y);
        return AjaxResult.success("查询成功",data);
    }
}
