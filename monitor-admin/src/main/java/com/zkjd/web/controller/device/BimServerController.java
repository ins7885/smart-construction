package com.zkjd.web.controller.device;

import com.bimface.api.bean.response.FileTranslateBean;
import com.bimface.exception.BimfaceException;
import com.bimface.file.bean.FileBean;
import com.bimface.sdk.BimfaceClient;
import com.bimface.sdk.bean.request.FileUploadRequest;
import com.zkjd.business.domain.Model;
import com.zkjd.business.service.IModelService;
import com.zkjd.common.core.controller.BaseController;
import com.zkjd.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-24 08:59
 * @Description:
 */
@RestController
@RequestMapping("/device/bim")
public class BimServerController extends BaseController {

    @Autowired
    private BimfaceClient bimfaceClient;

    @Autowired
    private IModelService iModelService;

    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) {
        //上传文件
        FileBean fileBean = null;
        Long fileId = null;
        try {
            FileUploadRequest fileUploadRequest = new FileUploadRequest();
            fileUploadRequest.setContentLength(file.getSize());
            fileUploadRequest.setName(file.getOriginalFilename());
            fileUploadRequest.setInputStream(file.getInputStream());
            fileBean = bimfaceClient.upload(fileUploadRequest);
        // 获取fileId
        fileId = fileBean.getFileId();
        // 发起文件转换
        FileTranslateBean translateBean = null;
        translateBean = bimfaceClient.translate(fileId);
        }catch (IOException e){
            e.printStackTrace();
        } catch (BimfaceException e) {
            e.printStackTrace();
        }
        return AjaxResult.success(fileId);
    }

    @GetMapping("/status")
    public AjaxResult pullStatus(Model model){
        //调用BIMFACE-SDK获取文件转换状态
        FileTranslateBean translateBean = null;
        String fileId = model.getFileId();
        Long modelId = model.getModelId();
        try {
            translateBean = bimfaceClient.getTranslate(Long.valueOf(fileId));
            //fileId存入数据库,用于下次请求使用
            Model m = iModelService.selectModelByModelId(modelId);
            m.setFileId(fileId);
            iModelService.updateModel(m);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (BimfaceException e) {
            e.printStackTrace();
        }
        return AjaxResult.success("转化成功",fileId);
    }

    @GetMapping("/view/{fileId}")
    public AjaxResult view(@PathVariable("fileId") String fileId){
        // 获取view token
        String viewToken = null;
        try {
            if(!"null".equals(fileId)){
                viewToken = bimfaceClient.getViewTokenByFileId(Long.valueOf(fileId));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (BimfaceException e) {
            e.printStackTrace();
        }
        return AjaxResult.success("获取成功",viewToken);
    }
}
