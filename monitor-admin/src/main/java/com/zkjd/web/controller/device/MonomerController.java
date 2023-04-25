package com.zkjd.web.controller.device;

import com.zkjd.business.domain.Monomer;
import com.zkjd.business.service.MonomerService;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-17 15:33
 * @Description: 楼栋接口
 */
@RestController
@RequestMapping("/device/monomer")
public class MonomerController extends BaseController {

    @Autowired
    private MonomerService monomerService;

    /**
     * 根据项目ID获取详细信息
     */
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable Long projectId) {
        return AjaxResult.success(monomerService.getListByProjectId(projectId));
    }
}
