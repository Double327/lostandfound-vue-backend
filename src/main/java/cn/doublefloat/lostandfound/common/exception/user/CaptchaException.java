package cn.doublefloat.lostandfound.common.exception.user;

import cn.doublefloat.lostandfound.common.exception.UserException;

/**
 * @author 李广帅
 * @date 2020/7/3 4:35 下午
 */
public class CaptchaException extends UserException {
    public CaptchaException() {
        super("user.captcha.error", null);
    }
}
