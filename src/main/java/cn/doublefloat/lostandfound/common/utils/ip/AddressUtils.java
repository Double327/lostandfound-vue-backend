package cn.doublefloat.lostandfound.common.utils.ip;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.doublefloat.lostandfound.common.utils.StringUtils;
import cn.doublefloat.lostandfound.common.utils.http.HttpUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @className: AddressUtils
 * @description: 获取地址类
 * @author: Dimple
 * @date: 10/22/19
 */
@Slf4j
public class AddressUtils {
    private AddressUtils() {
    }

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip) {
        String address = "XX XX";
        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }
        String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
        if (StringUtils.isEmpty(rspStr)) {
            log.error("获取地理位置异常 {}", ip);
            return address;
        }
        JSONObject obj = JSON.parseObject(rspStr);
        JSONObject data = obj.getObject("data", JSONObject.class);
        String region = data.getString("region");
        String city = data.getString("city");
        address = region + " " + city;
        return address;
    }

}
