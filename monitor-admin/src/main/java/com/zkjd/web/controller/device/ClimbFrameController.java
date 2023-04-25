package com.zkjd.web.controller.device;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.zkjd.business.domain.ClimbFrame;
import com.zkjd.business.service.ClimbFrameService;
import com.zkjd.business.service.OrderService;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.config.RuoYiConfig;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.core.domain.model.LoginUser;
import com.zkjd.common.core.page.TableDataInfo;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.common.utils.file.FileUploadUtils;
import com.zkjd.framework.config.ServerConfig;
import com.zkjd.web.core.config.FaceDeviceConfig;
import com.zkjd.web.core.utils.FaceDeviceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static com.zkjd.web.core.utils.FaceDeviceUtils.getFaceImgResult;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 20:59
 * @Description: 爬架管理
 */
@RestController
@RequestMapping("/device/climbFrame")
public class ClimbFrameController extends BaseController {

    @Autowired
    private FaceDeviceConfig faceConfig;
    @Autowired
    private ClimbFrameService climbFrameService;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private String port;

    /**
     * 获取爬架列表
     */
    @PreAuthorize("@ss.hasPermi('device:climbFrame:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClimbFrame climbFrame) {
        startPage();
        Long projectId = getLoginUser().getUser().getProjectId();
        climbFrame.setProjectId(projectId);
        List<ClimbFrame> list = climbFrameService.selectClimbFrameList(climbFrame);
        return getDataTable(list);
    }

    /**
     * 获取爬架列表
     */
    @GetMapping("/noPageList")
    public AjaxResult noPageList(ClimbFrame climbFrame) {
        List<ClimbFrame> list = climbFrameService.selectClimbFrameList(climbFrame);
        return AjaxResult.success(list);
    }

    /**
     * 根据爬架编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:climbFrame:query')")
    @GetMapping(value = "/{climbFrameId}")
    public AjaxResult getInfo(@PathVariable Long climbFrameId) {
        return AjaxResult.success(climbFrameService.selectClimbFrameById(climbFrameId));
    }

    /**
     * 新增爬架
     */
    @PreAuthorize("@ss.hasPermi('device:climbFrame:add')")
    @Log(title = "爬架管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ClimbFrame climbFrame) {
        climbFrame.setCreateBy(getUsername());
        if (climbFrame.getDeviceSerial() != null && climbFrame.getDeviceSerial().length() > 0
                && climbFrameService.checkDeviceSerialUnique(climbFrame.getDeviceSerial()) > 0) {
            return AjaxResult.error("新增爬架失败，人脸闸机编号已存在");
        }
        return toAjax(climbFrameService.insertClimbFrame(climbFrame));
    }

    /**
     * 解绑闸机
     */
    @PreAuthorize("@ss.hasPermi('device:climbFrame:edit')")
    @PostMapping("/cancelBindFaceDevice")
    public AjaxResult cancelBindFaceDevice(@Validated @RequestBody ClimbFrame climbFrame) {
        climbFrame.setUpdateBy(getUsername());
        ClimbFrame checkClimb = climbFrameService.selectClimbFrameById(climbFrame.getClimbFrameId());
        System.out.println("result2 = " + climbFrame);
        String result = "操作成功";//FaceDeviceUtils.faceDeviceDel(checkClimb, faceConfig);
        if (result.equals("操作成功")) {
            climbFrame.setDeviceNo("");
            climbFrame.setDeviceMac("");
            climbFrame.setDevicePassword("");
            climbFrame.setDeviceMac("");
            return toAjax(climbFrameService.updateClimbFrame(climbFrame));
        } else
            return AjaxResult.error("0000", result);
    }

    /**
     * 绑定闸机
     */
    @PreAuthorize("@ss.hasPermi('device:climbFrame:edit')")
    @PostMapping("/bindFaceDevice")
    public AjaxResult bindFaceDevice(@Validated @RequestBody ClimbFrame climbFrame) {
        climbFrame.setUpdateBy(getUsername());
        ClimbFrame checkClimb = climbFrameService.selectClimbFrameById(climbFrame.getClimbFrameId());
        if (climbFrame.getDeviceSerial() != null &&
                (!climbFrame.getDeviceSerial().equals(checkClimb.getDeviceSerial())) &&
                climbFrame.getDeviceSerial().length() > 0
                && climbFrameService.checkDeviceSerialUnique(climbFrame.getDeviceSerial()) > 0) {
            return AjaxResult.error("修改爬架信息失败，人脸闸机已绑定其他设备");
        }
        System.out.println("result2 = " + climbFrame);
        String result = "操作成功";// FaceDeviceUtils.faceDeviceAdd(climbFrame, faceConfig);

        if (result.equals("操作成功")) {
            checkClimb.setDeviceNo(climbFrame.getDeviceNo());
            checkClimb.setDevicePassword(climbFrame.getDevicePassword());
            checkClimb.setDeviceMac(climbFrame.getDeviceMac());
            checkClimb.setDeviceSerial(climbFrame.getDeviceSerial());
            return toAjax(climbFrameService.updateClimbFrame(checkClimb));
        } else
            return AjaxResult.error("0000", result);
    }

    /**
     * 修改爬架
     */
    @PreAuthorize("@ss.hasPermi('device:climbFrame:edit')")
    @Log(title = "爬架管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody ClimbFrame climbFrame) {
        climbFrame.setUpdateBy(getUsername());
        ClimbFrame checkClimb = climbFrameService.selectClimbFrameById(climbFrame.getClimbFrameId());
        if (climbFrame.getDeviceSerial() != null &&
                (!climbFrame.getDeviceSerial().equals(checkClimb.getDeviceSerial())) &&
                climbFrame.getDeviceSerial().length() > 0
                && climbFrameService.checkDeviceSerialUnique(climbFrame.getDeviceSerial()) > 0) {
            return AjaxResult.error("修改爬架信息失败，人脸闸机编号已存在");
        }
        return toAjax(climbFrameService.updateClimbFrame(climbFrame));
    }

    /**
     * 删除爬架
     */
    @PreAuthorize("@ss.hasPermi('device:climbFrame:remove')")
    @Log(title = "爬架管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{climbFrameIds}")
    public AjaxResult remove(@PathVariable Long[] climbFrameIds) {
        for (int i = 0; i < climbFrameIds.length; i++) {
            long id = climbFrameIds[i];
            ClimbFrame checkClimb = climbFrameService.selectClimbFrameById(id);
            if (checkClimb.getDeviceSerial().length() > 0)
                FaceDeviceUtils.faceDeviceDel(checkClimb, faceConfig);
        }
        return toAjax(climbFrameService.deleteClimbFrameByIds(climbFrameIds));
    }

    /**
     * 锁定/解锁爬架
     */
    @PreAuthorize("@ss.hasPermi('device:climbFrame:lock')")
    @Log(title = "爬架管理", businessType = BusinessType.UPDATE)
    @PutMapping("/lock")
    public AjaxResult lock(@Validated @RequestBody ClimbFrame climbFrame) {
        climbFrame.setUpdateBy(getUsername());
        return toAjax(climbFrameService.lockClimbFrame(climbFrame));
    }

    /**
     * 根据项目ID获取详细信息
     */
    @GetMapping(value = "/getById/{projectId}")
    public AjaxResult getClimbFrame(@PathVariable Long projectId) {
        return AjaxResult.success(climbFrameService.getListByProjectId(projectId));
    }

    /**
     * 爬架平面图上传
     */
    @Log(title = "爬架平面图", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadImg")
    public AjaxResult uploadImg(@RequestParam("file") MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String imageUrl = "";
            String url = serverConfig.getUrl();
            //服务器部署到nginx重新设置端口
            if (url.contains("localhost")) {
                imageUrl = serverConfig.getUrl() + fileName;
            } else {
                imageUrl = serverConfig.getUrl() + ":" + port + fileName;
            }
            AjaxResult ajax = AjaxResult.success();
            ajax.put("imageUrl", imageUrl);
            ajax.put("imageName", file.getOriginalFilename());
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
