package cn.doublefloat.lostandfound.common.exception.user;

import cn.doublefloat.lostandfound.common.exception.UserException;

/**
 * @author 李广帅
 * @date 2020/7/3 4:28 下午
 */
public class CaptchaExpireException extends UserException {
    public CaptchaExpireException() {
        super("user.captcha.expire", null);
    }
}
