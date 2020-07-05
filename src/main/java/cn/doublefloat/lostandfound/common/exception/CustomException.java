package cn.doublefloat.lostandfound.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author 李广帅
 * @date 2020/7/3 9:53 下午
 */
public class CustomException extends RuntimeException {

    private HttpStatus code;

    private String message;

    public CustomException(String message) {
        this.message = message;
    }

    public CustomException(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
