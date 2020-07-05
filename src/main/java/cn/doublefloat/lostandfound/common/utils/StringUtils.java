package cn.doublefloat.lostandfound.common.utils;

/**
 * @author 李广帅
 * @date 2020/6/6 10:11 下午
 */
public class StringUtils {

    private static String EMPTY_STRING = "";

    /**
     * 判断一个字符串是否为空
     * @param str 字符串
     * @return true：空 false：非空
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || EMPTY_STRING.equals(str.trim());
    }

    /**
     * 判断一个对象是否不为空
     * @param object 对象
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }



    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotEmpty(String str) {
        return str.length() > 0;
    }
}
