package com.zkjd.web.controller.statistics;

import com.zkjd.business.domain.RiseCheck;
import com.zkjd.business.domain.Warn;
import com.zkjd.business.qo.StatisticsQO;
import com.zkjd.business.service.IRiseCheckService;
import com.zkjd.business.service.WarnService;
import com.zkjd.business.vo.WarnMessageVO;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.core.page.TableDataInfo;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 升降脚手架提升作业前检查Controller
 *
 * @author zkjd
 * @date 2022-02-28
 */
@RestController
@RequestMapping("/system/warnData")
public class WarnDataController extends BaseController {
    @Autowired
    private WarnService warnService;

    /**
     * 查询升降脚手架提升作业前检查列表
     */
    @GetMapping("/list")
    public TableDataInfo list(StatisticsQO statisticsQO) {
        startPage();
        List<WarnMessageVO> list = warnService.selectWarnDataList(statisticsQO);
        return getDataTable(list);
    }

}
