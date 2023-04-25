package com.zkjd.web.controller.device;

import com.zkjd.business.domain.Standard;
import com.zkjd.business.service.IStandardService;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.config.RuoYiConfig;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.core.page.TableDataInfo;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.common.utils.SecurityUtils;
import com.zkjd.common.utils.file.FileUploadUtils;
import com.zkjd.common.utils.poi.ExcelUtil;
import com.zkjd.framework.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 标准规范Controller
 *
 * @author zkjd
 * @date 2022-01-27
 */
@RestController
@RequestMapping("/device/standard")
public class StandardController extends BaseController
{

    @Value("${server.port}")
    private String port;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private IStandardService standardService;

    /**
     * 查询标准规范列表
     */
    @PreAuthorize("@ss.hasPermi('device:standard:list')")
    @GetMapping("/list")
    public TableDataInfo list(Standard standard)
    {
        startPage();
        List<Standard> list = standardService.selectStandardList(standard);
        return getDataTable(list);
    }

    /**
     * 导出标准规范列表
     */
    @PreAuthorize("@ss.hasPermi('device:standard:export')")
    @Log(title = "标准规范", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Standard standard)
    {
        List<Standard> list = standardService.selectStandardList(standard);
        ExcelUtil<Standard> util = new ExcelUtil<Standard>(Standard.class);
        return util.exportExcel(list, "标准规范数据");
    }

    /**
     * 获取标准规范详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:standard:query')")
    @GetMapping(value = "/{standardId}")
    public AjaxResult getInfo(@PathVariable("standardId") Long standardId)
    {
        return AjaxResult.success(standardService.selectStandardByStandardId(standardId));
    }

    /**
     * 新增标准规范
     */
    @PreAuthorize("@ss.hasPermi('device:standard:add')")
    @Log(title = "标准规范", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Standard standard)
    {
        return toAjax(standardService.insertStandard(standard));
    }

    /**
     * 修改标准规范
     */
    @PreAuthorize("@ss.hasPermi('device:standard:edit')")
    @Log(title = "标准规范", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Standard standard)
    {
        return toAjax(standardService.updateStandard(standard));
    }

    /**
     * 删除标准规范
     */
    @PreAuthorize("@ss.hasPermi('device:standard:remove')")
    @Log(title = "标准规范", businessType = BusinessType.DELETE)
    @DeleteMapping("/{standardIds}")
    public AjaxResult remove(@PathVariable Long[] standardIds)
    {
        return toAjax(standardService.deleteStandardByStandardIds(standardIds));
    }

    /**
     * 附件上传
     */
    @Log(title = "附件上传", businessType = BusinessType.UPDATE)
    @PostMapping("/upload")
    public AjaxResult uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            Long standardId = Long.valueOf(request.getParameter("standardId"));
            Long fileSize = Long.valueOf(request.getParameter("fileSize"));
            String fileFormat = request.getParameter("fileFormat");
            String fileName = request.getParameter("fileName");
            Standard standard = standardService.selectStandardByStandardId(standardId);
            standard.setUploadTime(new Date());
            standard.setFileSize(fileSize);
            standard.setFileFormat(fileFormat);
            standard.setUploader(SecurityUtils.getUsername());
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String upload = FileUploadUtils.uploadFile(filePath, file);
            String fileUrl = "";
            String url = serverConfig.getUrl();
            //服务器部署到nginx重新设置端口
            if(url.contains("localhost")){
                fileUrl = serverConfig.getUrl() + upload;
            }else{
                fileUrl = serverConfig.getUrl() +":" + port + upload;
            }
            standard.setFilePath(fileUrl);
            standard.setFileName(fileName);
            standardService.updateStandard(standard);
            AjaxResult ajax = AjaxResult.success();
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
