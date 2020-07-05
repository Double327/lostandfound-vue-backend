package cn.doublefloat.lostandfound.common.utils;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author 李广帅
 * @date 2020/7/4 5:09 下午
 */
public class SecurityUtils {

    /**
     * 获取 Authentication
     * @return Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
