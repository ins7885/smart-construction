package com.zkjd.web.controller.app;

import com.zkjd.common.constant.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: zkjd
 * @Description: app登录后记录uni-push的clientId
 * @Date: create in 2022/6/30 14:29
 */
@RestController
@RequestMapping("/app/message/")
@Api(value = "/app/message/", tags = "消息")
public class AppMessageController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * * 存储client信息
     * * APP用户登录系统时调用
     * @return Boolean
     */
    @ApiOperation(value = "存储clientInfo")
    @PostMapping("/save-client-info")
    public Boolean saveClientInfoToRedis(@RequestBody Map map) {
        Integer userId = (Integer) map.get("userId");
        String clientInfo = (String)map.get("clientId");
        String key = Constants.UNI_PUSH_KEY_PREFIX + userId;
        redisTemplate.opsForValue().set(key, clientInfo);
        return Boolean.TRUE;
    }


    /**
     * 清除client信息
     *
     * @param userId 用户id
     * @return Boolean
     */
    @ApiOperation(value = "清除clientInfo")
    @GetMapping("/remove-client-info/{userId}")
    public Boolean removeClientInfoForRedis(@PathVariable("userId") Integer userId) {
        String key = Constants.UNI_PUSH_KEY_PREFIX + userId;
        redisTemplate.delete(key);
        return Boolean.TRUE;
    }
}
