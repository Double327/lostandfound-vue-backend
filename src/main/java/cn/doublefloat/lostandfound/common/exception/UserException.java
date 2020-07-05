package cn.doublefloat.lostandfound.common.exception;

/**
 * @author 李广帅
 * @date 2020/7/3 4:20 下午
 */
public class UserException extends BaseException {
    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
