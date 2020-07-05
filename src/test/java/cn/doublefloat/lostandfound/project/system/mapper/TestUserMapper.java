package cn.doublefloat.lostandfound.project.system.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 李广帅
 * @date 2020/6/15 1:42 下午
 */
@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindUserByUsername() {

    }
}
