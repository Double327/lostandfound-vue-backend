package cn.doublefloat.lostandfound.common.exception.user;

import cn.doublefloat.lostandfound.common.exception.UserException;

/**
 * @author 李广帅
 * @date 2020/7/3 4:20 下午
 */
public class UserPasswordErrorException extends UserException {
    public UserPasswordErrorException() {
        super("user.password.not.match", null);
    }
}
