package com.zkjd.web.controller.statistics;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.qvs.DeviceManager;
import com.qiniu.qvs.NameSpaceManager;
import com.qiniu.qvs.StreamManager;
import com.qiniu.qvs.model.DynamicLiveRoute;
import com.qiniu.qvs.model.Stream;
import com.qiniu.util.Auth;
import com.zkjd.business.service.IMonitorPointService;
import com.zkjd.business.vo.*;
import com.zkjd.common.core.domain.AjaxResult;
import com.zkjd.web.core.config.QiNiuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频监控Controller
 *
 * @author zkjd
 * @date 2022-06-21
 */
@RestController
@RequestMapping("/video/")
public class VideoController {

    @Autowired
    private IMonitorPointService monitorPointService;
    
    @Autowired
    private QiNiuConfig qiNiuConfig;

    /**
     * 查询视频监控监测点
     */
    @GetMapping("/tree")
    public AjaxResult tree() {
        List<TreeData> list = monitorPointService.getMonitorPoints();
        return AjaxResult.success(list);
    }

    /**
     * 查询视频监控namespace下的所有监控设备
     */
    @GetMapping("/namespace/device")
    public AjaxResult device() {
        // 获取空间列表
        int offset = 0;
        // 查询行数
        int line = 1;
        // 按设备类型查询，0:全部, 1:摄像头, 2:平台
        int qtype = 1;
        // 按设备状态查询，offline: 离线, online: 在线, notReg: 未注册, locked: 锁定
        String state = "online";
        //asc:updatedAt表示更新时间从小到大排序, desc:updatedAt表示更新时间从大到小排序
        String sortBy = "asc:updatedAt";
        // 前缀
        String prefix = "test";
        // 认证
        Auth auth = Auth.create(qiNiuConfig.getAccessKey(), qiNiuConfig.getSecretKey());
        NameSpaceManager nameSpaceManager = new NameSpaceManager(auth);
        DeviceManager deviceManager = new DeviceManager(auth);
        List<VideoDevice.ItemsBean> items = new ArrayList<>();
        try {
            // 获取命名空间
            Response response = nameSpaceManager.listNameSpace(offset, line, sortBy);
            NameSpace nameSpace = new Gson().fromJson(response.bodyString(), NameSpace.class);
            String namespaceId = nameSpace.getItems().get(0).getId();
            // 获取设备信息
            Response dresponse = deviceManager.listDevice(namespaceId, offset, line, prefix, state, qtype);
            VideoDevice videoDevice = new Gson().fromJson(dresponse.bodyString(), VideoDevice.class);
            items = videoDevice.getItems();
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return AjaxResult.success(items);
    }

    /**
     * 获取视频监控流
     * @param qiNiuVO
     * @return
     */
    @PostMapping("/namespace/stream")
    public AjaxResult stream(QiNiuVO qiNiuVO) {
        // 认证
        Auth auth = Auth.create(qiNiuConfig.getAccessKey(), qiNiuConfig.getSecretKey());
        StreamManager streamManager = new StreamManager(auth);
        VideoStream videoStream = new VideoStream ();
        try {
            DynamicLiveRoute dynamicLiveRoute = new DynamicLiveRoute(qiNiuConfig.getIp(), qiNiuConfig.getIp(), 3600);
            Response response = streamManager.dynamicPublishPlayURL(qiNiuVO.getNameSpace(), qiNiuVO.getDeviceId(), dynamicLiveRoute);
            videoStream = new Gson().fromJson(response.bodyString(), VideoStream.class);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return AjaxResult.success(videoStream);
    }

    public static void main(String[] args) {
        Auth auth = Auth.create("xHEo197IVOMveLxL12EEXw1Hk2Pe1lezIebIT33t", "fzwo8ot-QyPGFQP9uwR-rD9MGZVSGge5ib2LXzYE");
        NameSpaceManager nameSpaceManager = new NameSpaceManager(auth);
        // 获取空间列表
        int offset = 0;
        int line = 10;
        String sortBy = "asc:updatedAt";
        NameSpace nameSpace = new NameSpace();
        try {
            Response response = nameSpaceManager.listNameSpace(offset, line, sortBy);
            nameSpace = new Gson().fromJson(response.bodyString(), NameSpace.class);

            System.out.println(response.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        int qtype = 1;
        String prefix = "test";
        String namespaceId = nameSpace.getItems().get(0).getId();
        String deviceId = "";
        String state = "offline";
        DeviceManager deviceManager = new DeviceManager(auth);
        try {
            Response response = deviceManager.listDevice(namespaceId, offset, line, prefix, state, qtype);
            System.out.println(response.bodyString());
            VideoDevice videoDevice = new Gson().fromJson(response.bodyString(), VideoDevice.class);
            deviceId = videoDevice.getItems().get(0).getGbId();
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        // 获取流列表
        StreamManager streamManager = new StreamManager(auth);
        DynamicLiveRoute dynamicLiveRoute = new DynamicLiveRoute("223.112.103.37", "223.112.103.37", 3600);
        try {
            Response response = streamManager.dynamicPublishPlayURL(namespaceId, deviceId, dynamicLiveRoute);
            VideoStream videoStream = new Gson().fromJson(response.bodyString(), VideoStream.class);
            System.out.println(response.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        try {
            Response response = streamManager.listStream(namespaceId, offset, line, qtype, prefix, sortBy);
            System.out.println(response.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}
