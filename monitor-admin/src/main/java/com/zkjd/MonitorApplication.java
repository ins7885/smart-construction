package com.zkjd;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author zkjd
 */
@EnableCanalClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MonitorApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(MonitorApplication.class, args);
        System.out.println("启动成功");
    }
}
/*
    测试
 */