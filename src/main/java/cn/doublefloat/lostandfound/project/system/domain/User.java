package cn.doublefloat.lostandfound.project.system.domain;

import cn.doublefloat.lostandfound.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 李广帅
 * @date 2020/6/12 8:04 下午
 */
@Data
@ToString
public class User extends BaseEntity {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 用户性别
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;


    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;


    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginTime;

    /**
     * 用户角色
     */
    private String role;


    public boolean isAdmin() {
        return isAdmin(this.id);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }
}
