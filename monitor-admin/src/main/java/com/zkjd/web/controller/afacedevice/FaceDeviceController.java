package com.zkjd.web.controller.afacedevice;

import cn.hutool.json.JSON;
import com.google.gson.JsonObject;
import com.zkjd.business.domain.ClimbFrame;
import com.zkjd.common.annotation.Log;
import com.zkjd.common.config.RuoYiConfig;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.common.core.domain.entity.SysUser;
import com.zkjd.common.enums.BusinessType;
import com.zkjd.system.service.ISysUserService;
import com.zkjd.web.core.config.FaceDeviceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONUtil;

import static com.zkjd.common.utils.StringUtils.isEmpty;
import static com.zkjd.web.core.utils.FaceDeviceUtils.*;

/**
 * @PackageName: com.zkjd.web.controller.afacedevice
 * @ProjectName: intelligent-monitor-server
 * @Description: 人脸闸机相关接口
 * @version: v1.0.0
 * @author: HuangXiang
 * @date: 2023-03-08  21:31
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2023-03-08     HuangXiang           v1.0.0            创建文件
 */

@RestController
@RequestMapping("/faceDevice")
public class FaceDeviceController {

    @Autowired
    private FaceDeviceConfig faceConfig;

    @Autowired
    private ISysUserService userService;
    private static final Logger log = LoggerFactory.getLogger(FaceDeviceController.class);

    @PostMapping("/faceRecord")
    @ResponseBody
    public AjaxResult faceRecord(@RequestParam Map<String, String> params) {
        System.out.println("接收到的x-www-form-urlencoded");
        System.out.println(params);
        String faceUrl = params.get("faceUrl");
        if (faceUrl != null && faceUrl.length() > 0)
            getFaceImage(faceUrl);
        return AjaxResult.success();
    }

    public AjaxResult getFaceImage(String saveKey) {
        String AdminName = faceConfig.getMqttName();
        String AdminPassword = faceConfig.getMqttPassword();
        String webRoot = faceConfig.getWebRoot();
        String date = "2022-03-15";
        String method = "POST";
        method = "GET";
        String bucket = "face";
//        String saveKey = "/face/1111/00A99306.jpg";

        try {
            String file_md5 = "";

            String sign = sign(method, date, saveKey, AdminName, AdminPassword, "", "");

            Object result2 = HttpRequest.get(webRoot + "?" + saveKey)
                    .header(Header.DATE, date)
                    .header(Header.CONTENT_TYPE, "")
                    .header("Content-MD5", "")
                    .header(Header.AUTHORIZATION, sign)
//                    .form(paramMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            System.out.println("result2 = " + result2);
            return AjaxResult.success(result2);
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀图片上传失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return AjaxResult.success("图片上传失败：" + e.getMessage());
        }
    }


    /**
     * 接收人脸闸机识别结果
     *
     * @author HuangXiang  @time 2022/02/27 10:24
     */
    @PostMapping("/faceRecord1")
    @ResponseBody
    public AjaxResult faceRecord1(@RequestBody faceRecord map) {
        String serial = map.getSerial();
        String count = (String) map.getCount();
        String cardNo = (String) map.getCardNo();
        String openTime = (String) map.getOpenTime();
        String openType = (String) map.getOpenType();
        String status = (String) map.getStatus();

        String data = "{serial:" + serial +
                ",count:" + count +
                ",cardNo:" + cardNo +
                ",openTime:" + openTime +
                ",openType:" + openType +
                ",status:" + status + "}";
//        String imgBase64 = cardNo;
//        uploadFile(imgBase64);

        String keyId = getPicName(176L);
        log.info("☀☀☀☀☀☀☀☀☀☀人脸识别数据接收：" + data + "☀☀☀☀☀☀☀☀☀☀");
//        System.out.println("☀☀☀☀☀☀☀☀☀☀人脸识别成功：" + data + "☀☀☀☀☀☀☀☀☀☀");
        FaceImgeDeal faceImgeDeal = new FaceImgeDeal();
        faceImgeDeal.setUserId(176L);
        faceImgeDeal.setDeviceSerial(count);
        faceImgeDeal.setDevicePassword(cardNo);
//        faceBatchRegister(faceImgeDeal);
        return AjaxResult.success();
    }

    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "人脸图片上传", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadFaceImage")
    public AjaxResult uploadFaceImage(@RequestBody Long userId) {
        SysUser user = userService.selectUserById(userId);
//        String userId = user.getUserId() + "";
        String faceImg = user.getFaceImage();
        String AdminName = faceConfig.getMqttName();
        String AdminPassword = faceConfig.getMqttPassword();
        String webRoot = faceConfig.getWebRoot();
        String date = getGMTDate();
        String method = "POST";
//        method = "GET";
        String imgName = getPicName(userId) + ".jpg";
        String url = String.format("/face/%s", imgName);

        String bucket = "face";
        String saveKey = String.format("/%s", imgName);
        String faceImgPath = RuoYiConfig.getProfile() + faceImg.replace("/profile", "");

        try {
            File file = new File(faceImgPath);
            String file_md5 = SecureUtil.md5(file);

            long expiration = DateUtil.currentSeconds() + 30;
            Map policyMap = new HashMap();
            policyMap.put("bucket", bucket);
            policyMap.put("save-key", saveKey);
            policyMap.put("expiration", expiration);//过期时间
            policyMap.put("date", date);
            policyMap.put("content-md5", file_md5);

            String policy = Base64.encode(JSONUtil.toJsonStr(policyMap));
            HashMap<String, Object> paramMap = new HashMap<>();

            paramMap.put("file", FileUtil.file(faceImgPath));
            paramMap.put("policy", policy);

            String sign = sign(method, date, "/" + bucket + saveKey, AdminName, AdminPassword, policy, file_md5);

            String result2 = HttpRequest.post(webRoot + "?" + url)
                    .header(Header.DATE, date)
                    .header(Header.CONTENT_TYPE, "multipart/form-data")
                    .header("Content-MD5", file_md5)
                    .header(Header.AUTHORIZATION, sign)
                    .form(paramMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            System.out.println("result2 = " + result2);
            if (JSONUtil.isJson(result2)) {
                result2 = getImgUploadResult(result2);
            } else result2 = "上传成功";
            return AjaxResult.success(result2);
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀图片上传失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return AjaxResult.success("图片上传失败：" + e.getMessage());
        }
    }


    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "人脸设备添加", businessType = BusinessType.UPDATE)
    @PostMapping("/faceDeviceAdd")
    public AjaxResult faceDeviceAdd(@RequestBody ClimbFrame faceImgeDeal) {
        try {
            String url = faceConfig.getApiRoot() + "?method=data.device.add";
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("serial", faceImgeDeal.getDeviceSerial());
            paramMap.put("password", faceImgeDeal.getDevicePassword());
            paramMap.put("deviceNo", faceImgeDeal.getDeviceNo());
            paramMap.put("deviceType", 1);
            paramMap.put("mac", faceImgeDeal.getDeviceMac());
            paramMap.put("btkey", "");
            paramMap.put("btkeyType", "");
            paramMap.put("algorithm", 1);
            paramMap.put("scanOpen", 0);
//            paramMap.put("platform", faceConfig.getPlatform());


            System.out.println("paramMap = " + paramMap);
            String result2 = HttpRequest.post(url)
                    .header(Header.CONTENT_TYPE, "multipart/form-data")
                    .form(paramMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            System.out.println("result2 = " + result2);
            if (JSONUtil.isJson(result2)) {
                result2 = getFaceImgResult(result2);
            }
            return AjaxResult.success(result2);
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀人脸图片注册失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return AjaxResult.success("☀☀☀☀☀☀☀☀☀☀人脸图片注册失败：" + e.getMessage());
        }
    }

    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "人脸授权", businessType = BusinessType.UPDATE)
    @PostMapping("/faceBatchRegister")
    public AjaxResult faceBatchRegister(@RequestBody FaceImgeDeal faceImgeDeal) {
        try {
            String url = faceConfig.getApiRoot() + "?method=mqtt.face.batch.register";
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("serial", faceImgeDeal.getDeviceSerial());
            paramMap.put("password", faceImgeDeal.getDevicePassword());
            paramMap.put("userId", faceImgeDeal.getUserId());


            System.out.println("paramMap = " + paramMap);
            String result2 = HttpRequest.post(url)
                    .header(Header.CONTENT_TYPE, "multipart/form-data")
                    .form(paramMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            System.out.println("result2 = " + result2);
            if (JSONUtil.isJson(result2)) {
                result2 = getFaceImgResult(result2);
            }
            return AjaxResult.success(result2);
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀人脸图片注册失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return AjaxResult.success("☀☀☀☀☀☀☀☀☀☀人脸图片注册失败：" + e.getMessage());
        }
    }

    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "权限添加", businessType = BusinessType.UPDATE)
    @PostMapping("/faceKeyAdd")
    public AjaxResult faceKeyAdd(@RequestBody FaceImgeDeal faceImgeDeal) {
        try {
            long startDate = DateUtil.currentSeconds();
            long keyDate = startDate + 60 * 60 * 24 * 365 * 20;
            String keyType = "8";
            String keyCount = "1";
            String keyId = getPicName(faceImgeDeal.getUserId());
            String periodNo = "0";
            String url = faceConfig.getApiRoot() + "?method=data.key.add";
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("serial", faceImgeDeal.getDeviceSerial());
            paramMap.put("password", faceImgeDeal.getDevicePassword());
            paramMap.put("startDate", startDate);
            paramMap.put("keyDate", keyDate);
            paramMap.put("keyType", keyType);
            paramMap.put("keyCount", keyCount);
            paramMap.put("keyId", keyId);
            paramMap.put("periodNo", periodNo);


            System.out.println("paramMap = " + paramMap);
            String result2 = HttpRequest.post(url)
                    .header(Header.CONTENT_TYPE, "multipart/form-data")
                    .form(paramMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            System.out.println("result2 = " + result2);
            if (JSONUtil.isJson(result2)) {
                result2 = getFaceImgResult(result2);
            }
            return AjaxResult.success(result2);
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀添加人脸授权失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return AjaxResult.success("☀☀☀☀☀☀☀☀☀☀添加人脸授权失败：" + e.getMessage());
        }
    }


    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "权限更新", businessType = BusinessType.UPDATE)
    @PostMapping("/mqttKeyUpdate")
    public AjaxResult mqttKeyUpdate(@RequestBody FaceImgeDeal faceImgeDeal) {
        try {
            String keyId = getPicName(faceImgeDeal.getUserId());
            String url = faceConfig.getApiRoot() + "?method=mqtt.key.update";
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("serial", faceImgeDeal.getDeviceSerial());
            paramMap.put("password", faceImgeDeal.getDevicePassword());
            paramMap.put("userId", keyId);

            System.out.println("paramMap = " + paramMap);
            String result2 = HttpRequest.post(url)
                    .header(Header.CONTENT_TYPE, "multipart/form-data")
                    .form(paramMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            System.out.println("result2 = " + result2);
            if (JSONUtil.isJson(result2)) {
                result2 = getFaceImgResult(result2);
            }
            return AjaxResult.success(result2);
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀更新设备权限失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return AjaxResult.success("☀☀☀☀☀☀☀☀☀☀更新设备权限失败：" + e.getMessage());
        }
    }

    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "添加人员名称", businessType = BusinessType.UPDATE)
    @PostMapping("/dataNameAdd")
    public AjaxResult dataNameAdd(@RequestBody FaceImgeDeal faceImgeDeal) {
        try {
            String url = faceConfig.getApiRoot() + "?method=mqtt.key.update";

            String keyType = "1";
            String keyCount = "1";
            String keyId = getPicName(faceImgeDeal.getUserId());

            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("serial", faceImgeDeal.getDeviceSerial());
            paramMap.put("password", faceImgeDeal.getDevicePassword());
            paramMap.put("keyType", keyType);
            paramMap.put("keyCount", keyCount);
            paramMap.put("keyId", keyId);
            paramMap.put("keyName", keyId);

            String result2 = HttpRequest.post(url)
                    .header(Header.CONTENT_TYPE, "multipart/form-data")
                    .form(paramMap)//表单内容
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            System.out.println("result2 = " + result2);
            if (JSONUtil.isJson(result2)) {
                result2 = getFaceImgResult(result2);
            }
            return AjaxResult.success(result2);
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀添加人员名称失败失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return AjaxResult.success("☀☀☀☀☀☀☀☀☀☀添加人员名称失败失败：" + e.getMessage());
        }
    }
}
