package com.zkjd.quartz.task;

import org.springframework.stereotype.Component;
import com.zkjd.common.utils.StringUtils;

/**
 * 定时任务调度测试
 * 
 * @author zkjd
 */
@Component("MonitorTask")
public class MonitorTask
{
    public void monitorMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void monitorParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void monitorNoParams()
    {
        System.out.println("执行无参方法");
    }
}
