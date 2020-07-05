package cn.doublefloat.lostandfound.project.system.mapper;

import cn.doublefloat.lostandfound.project.system.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/15 1:09 下午
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查找用户信息
     *
     * @param user 查询条件
     * @return 用户列表
     */
    List<User> list(User user);
}
