package cn.doublefloat.lostandfound.project.system.service.impl;

import cn.doublefloat.lostandfound.common.utils.StringUtils;
import cn.doublefloat.lostandfound.project.system.domain.User;
import cn.doublefloat.lostandfound.project.system.mapper.UserMapper;
import cn.doublefloat.lostandfound.project.system.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/15 1:12 下午
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User findUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public List<User> list(User user) {
        return userMapper.list(user);
    }

    @Override
    public Integer addUser(User user) {
        User userByUsername = findUserByUsername(user.getUsername());
        if (StringUtils.isNotNull(userByUsername)) {
            return 0;
        } else {
            user.setNickname("laf-" + user.getUsername());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreateBy("admin");
            user.setUpdateBy("admin");
            return userMapper.insert(user);
        }
    }

    @Override
    public Integer deleteUser(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }
}
