package cn.doublefloat.lostandfound.common.exception;

import cn.doublefloat.lostandfound.common.utils.MessageUtils;
import cn.doublefloat.lostandfound.common.utils.StringUtils;
import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/7/3 4:16 下午
 */
@Data
public class BaseException extends RuntimeException {

    private String module;

    private String code;

    private Object[] args;

    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!StringUtils.isEmpty(code)) {
            message = MessageUtils.message(code, args);
        }
        if (message == null) {
            message = defaultMessage;
        }
        return message;
    }
}
