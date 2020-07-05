package cn.doublefloat.lostandfound.framework.security.service;

import cn.doublefloat.lostandfound.common.constants.Constants;
import cn.doublefloat.lostandfound.common.exception.CustomException;
import cn.doublefloat.lostandfound.common.exception.user.CaptchaException;
import cn.doublefloat.lostandfound.common.exception.user.CaptchaExpireException;
import cn.doublefloat.lostandfound.common.exception.user.UserPasswordErrorException;
import cn.doublefloat.lostandfound.framework.redis.RedisCacheService;
import cn.doublefloat.lostandfound.framework.security.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


/**
 * @author 李广帅
 * @date 2020/6/14 6:30 下午
 */
@Slf4j
@Service
public class LoginService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCacheService redisCacheService;

    public String login(String username, String password, String code, String uuid) {
        // 验证码检测
        String captchaCodeKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCacheService.getCacheObject(captchaCodeKey);
        redisCacheService.deleteObject(captchaCodeKey);
        log.info("正确验证码:{}", captcha);
        log.info("用户输入验证码:{}", code);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }

        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException();
        }


        // 用户信息
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new UserPasswordErrorException();
            } else {
                throw new CustomException(e.getMessage());
            }
        }

        LoginUser loginUser =  (LoginUser) authentication.getPrincipal();

        // 返回Token
        return tokenService.createToken(loginUser);
    }
}
