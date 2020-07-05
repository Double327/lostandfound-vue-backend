package cn.doublefloat.lostandfound.framework.security;

import cn.doublefloat.lostandfound.project.system.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author 李广帅
 * @date 2020/6/14 7:30 下午
 */
@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    /**
     * Token令牌
     */
    private String token;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * expire time
     */
    private Long expireTime;

    /**
     * 用户信息
     */
    private User user;

    public LoginUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
