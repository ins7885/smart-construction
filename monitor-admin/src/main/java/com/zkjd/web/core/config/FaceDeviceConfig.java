package com.zkjd.web.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @PackageName: com.zkjd.common.config
 * @ProjectName: intelligent-monitor-server
 * @Description: 人脸识别设备账号及地址配置
 * @version: v1.0.0
 * @author: HuangXiang Email:HuangXiang@youotech.com
 * @date: 2023-03-24  21:49
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2023-03-24     HuangXiang           v1.0.0            创建文件
 */

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "face")
public class FaceDeviceConfig {
    private String webRoot;
    private String apiRoot;
    private String mqttName;
    private String mqttPassword;
    private String facePicPath;
    private long adminId;
    private String adminName;
    private String adminPassword;
    private String platform;
}
