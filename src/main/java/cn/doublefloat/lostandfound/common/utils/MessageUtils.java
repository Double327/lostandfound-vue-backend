package cn.doublefloat.lostandfound.common.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author 李广帅
 * @date 2020/7/3 4:36 下午
 */
@Data
@NoArgsConstructor
public class MessageUtils {
    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
