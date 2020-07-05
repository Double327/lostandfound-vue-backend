package cn.doublefloat.lostandfound.framework.security.handle;

import cn.doublefloat.lostandfound.common.utils.ServletUtils;
import cn.doublefloat.lostandfound.common.utils.StringUtils;
import cn.doublefloat.lostandfound.framework.security.LoginUser;
import cn.doublefloat.lostandfound.framework.security.service.TokenService;
import cn.doublefloat.lostandfound.framework.web.domain.AjaxResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李广帅
 * @date 2020/7/4 5:33 下午
 */
@Slf4j
@Configuration
public class LogoutSuccessHandleImpl implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("用户退出登录!!!");
        LoginUser loginUser = tokenService.getLoginUser(httpServletRequest);
        if (StringUtils.isNotNull(loginUser)) {
            tokenService.delLoginUser(loginUser.getToken());
        }
        ServletUtils.renderString(httpServletResponse, JSON.toJSONString(AjaxResult.error(HttpStatus.OK, "退出成功")));
    }
}
