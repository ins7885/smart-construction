package com.zkjd.web.controller.business;

import java.util.Date;
import java.util.List;

import com.zkjd.business.domain.AppVersion;
import com.zkjd.business.domain.Standard;
import com.zkjd.business.service.IAppVersionService;
import com.zkjd.common.config.RuoYiConfig;
import com.zkjd.common.utils.SecurityUtils;
import com.zkjd.common.utils.file.FileUploadUtils;
import com.zkjd.framework.config.ServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.common.utils.poi.ExcelUtil;
import com.zkjd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * app版本配置Controller
 *
 * @author zkjd
 * @date 2022-02-21
 */
@RestController
@RequestMapping("/system/appVersion")
public class AppVersionController extends BaseController {
    @Autowired
    private IAppVersionService appVersionService;

    @Autowired
    private ServerConfig serverConfig;

    @Value("${server.port}")
    private String port;

    /**
     * 查询app版本配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppVersion appVersion) {
        startPage();
        List<AppVersion> list = appVersionService.selectAppVersionList(appVersion);
        return getDataTable(list);
    }

    /**
     * 导出app版本配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:export')")
    @Log(title = "app版本配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AppVersion appVersion) {
        List<AppVersion> list = appVersionService.selectAppVersionList(appVersion);
        ExcelUtil<AppVersion> util = new ExcelUtil<AppVersion>(AppVersion.class);
        return util.exportExcel(list, "app版本配置数据");
    }

    /**
     * 获取app版本配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(appVersionService.selectAppVersionById(id));
    }

    /**
     * 新增app版本配置
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:add')")
    @Log(title = "app版本配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppVersion appVersion) {
        return toAjax(appVersionService.insertAppVersion(appVersion));
    }

    /**
     * 修改app版本配置
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:edit')")
    @Log(title = "app版本配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppVersion appVersion) {
        return toAjax(appVersionService.updateAppVersion(appVersion));
    }

    /**
     * 删除app版本配置
     */
    @PreAuthorize("@ss.hasPermi('system:appVersion:remove')")
    @Log(title = "app版本配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(appVersionService.deleteAppVersionByIds(ids));
    }


    @Log(title = "附件上传", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadApk")
    public AjaxResult uploadApk(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String upload = FileUploadUtils.uploadApk(filePath, file);
            System.out.println(upload);
            String fileName = request.getParameter("fileName");
            String fileUrl = "";
            String url = serverConfig.getUrl();
            //服务器部署到nginx重新设置端口
            if (url.contains("localhost")) {
                fileUrl = serverConfig.getUrl() + upload;
            } else {
                fileUrl = serverConfig.getUrl() + ":" + port + upload;
            }
            return AjaxResult.success(fileUrl);
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
