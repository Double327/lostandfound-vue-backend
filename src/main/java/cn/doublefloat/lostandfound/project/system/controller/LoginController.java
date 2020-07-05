package cn.doublefloat.lostandfound.project.system.controller;

import cn.doublefloat.lostandfound.common.constants.Constants;
import cn.doublefloat.lostandfound.common.utils.ServletUtils;
import cn.doublefloat.lostandfound.framework.security.LoginUser;
import cn.doublefloat.lostandfound.framework.security.service.LoginService;
import cn.doublefloat.lostandfound.framework.security.service.TokenService;
import cn.doublefloat.lostandfound.framework.web.domain.AjaxResult;
import cn.doublefloat.lostandfound.project.system.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李广帅
 * @date 2020/6/14 6:25 下午
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;


    @PostMapping(path = "/login")
    public AjaxResult login(String username, String password, String code, String uuid) {
        AjaxResult result = AjaxResult.success();
        String token = loginService.login(username, password, code, uuid);
        result.put(Constants.TOKEN, token);
        return result;
    }

    @GetMapping("/getUserInfo")
    public AjaxResult getUserInfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        AjaxResult ajaxResult = AjaxResult.success();
        User user = loginUser.getUser();
        ajaxResult.put("user", user);
        return ajaxResult;
    }
}
