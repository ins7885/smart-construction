package com.zkjd.common.utils;


import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Map;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-26 11:21
 * @Description: 地图工具类
 */
public class MapUtil {

    //百度地图AK
    private static String key = "wqt9VzgXnXWUn3KsGpsHlnrOitCAHNRG";

    /**
     * 根据经纬度获取位置信息
     * @param lon 经度
     * @param lat 纬度
     * @return
     */
    public static Map<String, Object> getCityByLocate(double lon, double lat) {
        Map<String, Object> map = null;
        String url = "http://api.map.baidu.com/reverse_geocoding/v3/?"
                + "ak="+key+"&output=json&coordtype=wgs84ll&location="
                + lat + "," + lon;
        try {
            HttpClient client = HttpClientBuilder.create().build();//构建一个Client
            HttpGet get = new HttpGet(url);    //构建一个GET请求
            HttpResponse response = client.execute(get);//提交GET请求
            HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            JSONObject res = JSONObject.fromObject(content);
            map = JsonUtil.parseJSONToMap(res); //通过下面的函数将json转化为map
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据位置获取省份信息
     * @param lon
     * @param lat
     * @return
     */
    public static String getProvince(double lon, double lat){
        Map<String, Object> locate = getCityByLocate(lon, lat);
        //只获取省份数据
        JSONObject address = (JSONObject)((JSONObject) locate.get("result")).get("addressComponent");
        String province =   (String) address.get("province");
        return province;
    }

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        String province = getProvince(116.4494550000, 39.8474920000);
        System.out.println(province);
        long endTime = System.currentTimeMillis();
        System.out.println("post use time:" + (endTime - beginTime) + "ms");
    }
}
