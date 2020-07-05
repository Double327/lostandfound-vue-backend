package cn.doublefloat.lostandfound.project.system.service;

import cn.doublefloat.lostandfound.project.system.domain.User;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/15 1:10 下午
 */
public interface UserService {

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User findUserByUsername(String username);

    /**
     * 查找用户
     *
     * @param user 查找条件
     * @return 用户列表
     */
    List<User> list(User user);

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 数据库影响行数
     */
    Integer addUser(User user);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 结果
     */
    Integer deleteUser(String id);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    Integer updateUser(User user);
}
