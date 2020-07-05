package cn.doublefloat.lostandfound.project.system.domain;

import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/6/16 12:31 下午
 */
@Data
public class LoginInfo {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * uuid
     */
    private String uuid;


    public Boolean checkInfo() {
        if (this.username == null) {
            return false;
        } else if (this.password == null) {
            return false;
        } else if (this.code == null) {
            return false;
        } else if (this.uuid == null) {
            return false;
        } else {
            return true;
        }
    }
}
