package cn.doublefloat.lostandfound.framework.security.service;

import cn.doublefloat.lostandfound.framework.security.LoginUser;
import cn.doublefloat.lostandfound.project.system.domain.User;
import cn.doublefloat.lostandfound.project.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 李广帅
 * @date 2020/6/15 1:22 下午
 */
@Slf4j
@Service
public class LoginUserDetailsServerImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("查找用户=====>username:" + username);
        User user = userService.findUserByUsername(username);
        log.info("查找用户结果:" + user);
        if (user == null) {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户:" + username + ",不存在");
        }
        return createUserDetails(user);
    }

    public UserDetails createUserDetails(User user) {
        return new LoginUser(user);
    }
}
