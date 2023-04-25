package com.zkjd.common.config;

import com.bimface.sdk.BimfaceClient;
import com.zkjd.common.constant.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-24 09:06
 * @Description: Bimface配置类
 */
@Component
public class BimfaceConfig {

    @Value("${app.key}")
    private String APP_KEY;

    @Value("${app.secret}")
    private String APP_SECRET;

    @Bean
    public BimfaceClient bimfaceClient(){
        return new BimfaceClient(APP_KEY,APP_SECRET);
    }
}
