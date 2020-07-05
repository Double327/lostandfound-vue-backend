package cn.doublefloat.lostandfound.common.utils;

import java.util.UUID;

/**
 * @author 李广帅
 * @date 2020/6/6 9:27 下午
 */
public class IdUtils {

    /**
     * 获取UUID字符串
     *
     * @return UUID
     */
    public static String simpleUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
