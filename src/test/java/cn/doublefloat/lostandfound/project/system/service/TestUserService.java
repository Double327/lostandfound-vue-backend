package cn.doublefloat.lostandfound.project.system.service;

import cn.doublefloat.lostandfound.project.system.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/15 1:44 下午
 */
@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;


    @Test
    public void testUserList() {
        User user = new User();
        user.setSex(0);
        List<User> list = userService.list(user);
        list.forEach(System.out::println);
    }

    @Test
    public void testAddUser() {

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUsername("test" + i);
            user.setPassword("123456");
            Integer result = userService.addUser(user);
            if (result == 1) {
                System.out.println("添加成功" + i);
            } else {
                System.out.println("添加失败");
            }
        }

    }
}
