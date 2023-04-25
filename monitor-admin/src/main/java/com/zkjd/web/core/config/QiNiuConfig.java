package com.zkjd.web.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: zkjd
 * @Description: 七牛云配置
 * @Date: create in 2022/7/1 9:47
 */
@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuConfig {

    private String accessKey;

    private String secretKey;

    private String ip;
}
