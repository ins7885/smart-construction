package com.zkjd.web.core.utils;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.Constants;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import com.google.gson.Gson;
import com.zkjd.web.core.config.UniPushConfig;
import lombok.extern.log4j.Log4j2;

/**
 * @Author: wangtao
 * @Description: uni-push 工具类
 * @Date: create in 2022/6/30 14:19
 */
@Log4j2
public class UniPushUtils {

    /**
     * 单消息推送(安卓)
     *
     * @param title         标题
     * @param content       内容
     * @param clientId      推送者clientId
     */
    public static void singlePush(String title, String content, String clientId,UniPushConfig uniPushConfig) {
        System.setProperty(Constants.GEXIN_PUSH_SINGLE_ALIAS_DETAIL, "true");
        IGtPush push = new IGtPush(uniPushConfig.getUrl(), uniPushConfig.getAppKey(), uniPushConfig.getMasterSecret());
        log.info("unipush info(title - content - clientId) [{}] - [{}] - [{}]", title, content, clientId);
//        log.info("unipush config data. {}", new Gson().toJson(uniPushConfig));

        Style0 style = new Style0();
        // STEP2：设置推送标题、推送内容
        style.setTitle(title);
        style.setText(content);
        // 设置推送图标
//        style.setLogo("./src/main/resources/static/push.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // STEP3：设置响铃、震动等推送效果
        // 设置响铃
        style.setRing(true);
        // 设置震动
        style.setVibrate(true);

        // STEP4：选择通知模板
        NotificationTemplate template = new NotificationTemplate();
        template.setTransmissionType(1);
        template.setAppId(uniPushConfig.getAppId());
        template.setAppkey(uniPushConfig.getAppKey());
        template.setStyle(style);
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(uniPushConfig.getAppId());
        target.setClientId(clientId);

        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
//            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            log.info("unipush result." + ret.getResponse().toString());
        } else {
            log.error("服务器响应异常");
        }
    }

    /**
     * 单消息推送(IOS)
     *
     * @param title         标题
     * @param content       内容
     * @param clientId      推送者clientId
     * @param uniPushConfig unipush配置信息
     */
    public static void singlePushForIOS(String title, String content, String clientId, UniPushConfig uniPushConfig) {
        System.setProperty(Constants.GEXIN_PUSH_SINGLE_ALIAS_DETAIL, "true");
        IGtPush push = new IGtPush(uniPushConfig.getUrl(), uniPushConfig.getAppKey(), uniPushConfig.getMasterSecret());
        log.info("unipush info(title - content - clientId) [{}] - [{}] - [{}]", title, content, clientId);
        log.info("unipush config data. {}", new Gson().toJson(uniPushConfig));
        TransmissionTemplate transmissionTemplate = transmissionTemplate(title, content, uniPushConfig.getAppId(), uniPushConfig.getAppKey());

        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(transmissionTemplate);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        // 厂商通道下发策略
        message.setStrategyJson("{\"default\":4,\"ios\":4,\"st\":4}");

        Target target = new Target();
        target.setAppId(uniPushConfig.getAppId());
        target.setClientId(clientId);

        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
//            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            log.info("uni-push result." + ret.getResponse().toString());
        } else {
            log.error("服务器响应异常");
        }
    }

    /**
     * 取得IOS透传消息模板
     *
     * @param title   消息标题
     * @param content 消息内容
     * @return
     */
    public static TransmissionTemplate transmissionTemplate(String title, String content, String appId, String appKey) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTransmissionType(2);
        template.setTransmissionContent(content);
        template.setAPNInfo(getAPNPayload(title, content));
        //详见本页iOS通知样式设置
        return template;
    }

    /**
     * 取得IOS透传消息配置
     *
     * @param title   消息标题
     * @param content 消息内容
     * @return
     */
    private static APNPayload getAPNPayload(String title, String content) {
        APNPayload payload = new APNPayload();
        //在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
        payload.setAutoBadge("+1");
        payload.setContentAvailable(0);
        //ios 12.0 以上可以使用 Dictionary 类型的 sound
        payload.setSound("default");
        payload.setCategory("$由客户端定义");
        payload.addCustomMsg("由客户自定义消息key", "由客户自定义消息value");

        //简单模式APNPayload.SimpleMsg
        payload.setAlertMsg(getDictionaryAlertMsg(title, content));
        //字典模式使用APNPayload.DictionaryAlertMsg
        return payload;
    }

    /**
     * IOS自定义消息标题和内容
     *
     * @param title   消息标题
     * @param content 消息内容
     * @return
     */
    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(String title, String content) {
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        // 设置通知内容
        alertMsg.setBody(content);
        // 设置通知标题
        alertMsg.setTitle(title);
        return alertMsg;
    }
}
