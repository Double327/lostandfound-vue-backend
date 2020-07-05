package cn.doublefloat.lostandfound.project.system.service;

import cn.doublefloat.lostandfound.project.system.domain.Role;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/7/4 9:49 上午
 */
public interface RoleService {

    /**
     * 分页查询所有角色信息
     *
     * @param role 查询条件
     * @return 角色列表
     */
    List<Role> selectRoleList(Role role);


}
