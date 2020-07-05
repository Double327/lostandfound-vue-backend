package cn.doublefloat.lostandfound;

import cn.doublefloat.lostandfound.project.system.domain.User;
import cn.doublefloat.lostandfound.project.system.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LostandfoundApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
