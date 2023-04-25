package com.zkjd.web.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: zkjd
 * @Description: 自己根据业务需求取配置相关信息
 * @Date: create in 2022/6/30 14:15
 */
@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "unipush")
public class UniPushConfig {

    private String appId;

    private String appKey;

    private String masterSecret;

    private String url;
}
