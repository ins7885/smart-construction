package com.zkjd.web.core.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.zkjd.MonitorApplication;
import com.zkjd.business.domain.ClimbFrame;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.web.core.config.FaceDeviceConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestBody;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @PackageName: com.zkjd.web.core.utils
 * @ProjectName: intelligent-monitor-server
 * @Description:
 * @version: v1.0.0
 * @author: HuangXiang Email:HuangXiang@youotech.com
 * @date: 2023-03-24  23:08
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2023-03-24     HuangXiang           v1.0.0            创建文件
 */

@Log4j2
public class FaceDeviceUtils {

    public static void main(String[] args) {

        String file_md5 = SecureUtil.md5("ztjAdmin2023");

        System.out.println("result3 = " + file_md5);
    }

    public static String faceDeviceDel(ClimbFrame faceImgeDeal,FaceDeviceConfig faceConfig) {
        try {
            String url = faceConfig.getApiRoot() + "?method=data.device.delete";
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("serial", faceImgeDeal.getDeviceSerial());
            paramMap.put("password", faceImgeDeal.getDevicePassword());


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
            return result2;
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀人脸图片注册失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return "人脸闸机绑定异常";
        }
    }

    public static String faceDeviceAdd(ClimbFrame faceImgeDeal,FaceDeviceConfig faceConfig) {
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
            paramMap.put("platform", faceConfig.getPlatform());


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
            return result2;
        } catch (Exception e) {
            log.info("☀☀☀☀☀☀☀☀☀☀人脸图片注册失败：" + e.getMessage() + "☀☀☀☀☀☀☀☀☀☀");
            return "人脸闸机绑定异常";
        }
    }

    public static String sign(String method, String date, String path, String userName, String password, String policy, String md5) {
        StringBuilder sb = new StringBuilder();
        String sp = "&";
        sb.append(method);
        sb.append(sp);
        sb.append(path);

        sb.append(sp);
        sb.append(date);

        if (policy != null && policy.length() > 0) {
            sb.append(sp);
            sb.append(policy);
        }
        if (md5 != null && md5.length() > 0) {
            sb.append(sp);
            sb.append(md5);
        }
        String raw = sb.toString();
        String hmac = null;
        try {
            hmac = HmacSHA1(SecureUtil.md5(password), raw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (hmac != null) {
            return "AIYUN " + userName + ":" + Base64.encode(hmac).trim();
        }

        return null;
    }

    public static String HmacSHA1(String data, String key) throws Exception {
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance("HmacSHA1");
        //用给定密钥初始化 Mac 对象
        mac.init(signinKey);
        //完成 Mac 操作
        byte[] rawHmac = mac.doFinal(data.getBytes());
        String hexBytes = byte2hex1(rawHmac);
        return hexBytes;
    }

    public static String byte2hex1(final byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式。
            stmp = (java.lang.Integer.toHexString(b[n] & 0xFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs;
    }

    /**
     * 获取 GMT 格式时间戳
     *
     * @return GMT 格式时间戳
     */
    public static String getGMTDate() {
        SimpleDateFormat formater = new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        formater.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formater.format(new Date());
    }

    public static String getPicName(Long userId) {
        String lhex = Long.toHexString(userId);
        return checkLength(lhex);
    }

    private static String checkLength(String lhex) {
        if (lhex.length() < 8)
            lhex = "0" + lhex;
        if (lhex.length() < 8)
            lhex = checkLength(lhex);
        return lhex.toUpperCase();
    }


    public static String getImgUploadResult(String result2) {
        String ret = "";
        try {
            if (JSONUtil.isJson(result2)) {
                JSON jsonObject = JSONUtil.parse(result2);
                String code = jsonObject.getByPath("code").toString();
                ret = getImageUploadMsg(code);
            }
        } catch (Exception ex) {
            ret = result2;
            log.info("图片上传结果解析失败：" + result2 + "\r\n" + ex.getMessage());
        }
        return ret;

    }

    public static String getFaceImgResult(String result2) {
        String ret = "";
        try {
            if (JSONUtil.isJson(result2)) {
                JSON jsonObject = JSONUtil.parse(result2);
                String code = jsonObject.getByPath("code").toString();
                ret = getFaceImageMsg(code);
            }
        } catch (Exception ex) {
            ret = result2;
            log.info("人脸调用结果解析失败：" + result2 + "\r\n" + ex.getMessage());
        }
        return ret;
    }

    public static String getImageUploadMsg(String code) {
        String msg = "";
        switch (code) {
            case "1":
                msg = "服务器异常";
                break;
            case "1000":
                msg = "缺少签名参数";
                break;
            case "1001":
                msg = "操作员不存在";
                break;
            case "1002":
                msg = "URI错误";
                break;
            case "1003":
            case "1004":
                msg = "不支持的HTTP-METHOD";
                break;
            case "1005":
                msg = "CONTENT_MD5不匹配";
                break;
            case "1006":
                msg = "POLICY为空";
                break;
            case "1007":
                msg = "POLICY格式错误";
                break;
            case "1008":
                msg = "内容为空";
                break;
            case "1009":
                msg = "签名验证失败";
                break;
            case "1010":
                msg = "文件已存在";
                break;
            case "1011":
                msg = "文件不存在";
                break;
            case "1012":
                msg = "文件保存失败";
                break;
            case "1013":
                msg = "文件内容为空";
                break;
            case "1014":
                msg = "目录已存在";
                break;
            case "1015":
                msg = "目录不存在";
                break;
            case "1016":
                msg = "请求过期";
                break;
            case "1017":
                msg = "请求超出限制";
                break;
            case "1018":
                msg = "不支持的操作";
                break;
            default:
                msg = "未找到错误代码";
                break;
        }
        return msg;
    }


    public static String getFaceImageMsg(String code) {
        String msg = "";
        switch (code) {
            case "0":
                msg = "操作成功";
                break;
            case "1000":
                msg = "缺少参数";
                break;
            case "1001":
                msg = "参数错误";
                break;
            case "1002":
                msg = "数据库连接失败";
                break;
            case "1003":
                msg = "管理用户不存在";
                break;
            case "1004":
                msg = "管理用户已存在";
                break;
            case "1005":
                msg = "设备不存在";
                break;
            case "1006":
                msg = "设备已存在";
                break;
            case "1007":
                msg = "权限用户不存在";
                break;
            case "1008":
                msg = "权限用户已存在";
                break;
            case "1009":
                msg = "keyid不存在";
                break;
            case "1010":
                msg = "keyid已存在";
                break;
            case "1011":
                msg = "数据长度或个数超出";
                break;
            case "1012":
                msg = "密码错误";
                break;
            case "1013":
                msg = "MQTT连接失败";
                break;
            case "1014":
                msg = "设备不在线";
                break;
            case "1015":
                msg = "超出请求限制（请求过快或限制访问，默认单个method每秒限制10次）";
                break;
            case "1016":
                msg = "CCID为空";
                break;
            case "1017":
                msg = "正在批量注册";
                break;
            case "1018":
                msg = "没有要注册的人脸";
                break;
            case "1019":
                msg = "文件/照片不存在";
                break;
            case "1020":
                msg = "时间段不存在";
                break;
            case "1021":
                msg = "时间段已存在";
                break;
            case "1022":
                msg = "文件大小超出限制（注册人脸目前最大允许200K。建议100K以内，96dpi，640X640像素之内）";
                break;
            case "1023":
                msg = "文件类型出错（注册人脸只支持JPG格式照片）";
                break;
            case "1024":
                msg = "二维码过期";
                break;
            case "1025":
                msg = "模板文件不存在";
                break;
            default:
                msg = "未找到错误代码";
                break;
        }
        return msg;
    }

}
