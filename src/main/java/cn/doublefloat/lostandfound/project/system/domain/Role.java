package cn.doublefloat.lostandfound.project.system.domain;

import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/6/15 4:06 下午
 */
@Data
public class Role {

    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 角色排序值
     */
    private Integer roleSort;

    /**
     * 角色状态
     */
    private Integer status;

}
