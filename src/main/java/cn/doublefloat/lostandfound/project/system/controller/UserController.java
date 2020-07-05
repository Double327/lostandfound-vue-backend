package cn.doublefloat.lostandfound.project.system.controller;

import cn.doublefloat.lostandfound.framework.web.controller.BaseController;
import cn.doublefloat.lostandfound.framework.web.domain.AjaxResult;
import cn.doublefloat.lostandfound.framework.web.domain.TableData;
import cn.doublefloat.lostandfound.project.system.domain.User;
import cn.doublefloat.lostandfound.project.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/12 8:00 下午
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @param user 查找条件
     * @return 用户信息
     */
    @PostMapping("/list")
    public TableData list(User user) {
        startPage();
        List<User> userList = userService.list(user);
        TableData result = getTableData(userList);
        return result;
    }

    /**
     * 添加用户信息
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/add")
    public AjaxResult add(User user) {
        AjaxResult response;
        Integer result = userService.addUser(user);
        if (result >= 1) {
            response = AjaxResult.success();
        } else {
            response = AjaxResult.error("用户注册失败!");
        }
        return response;
    }

    /**
     * 删除用户信息
     *
     * @param id 用户编号
     * @return 结果
     */
    @PostMapping("/delete")
    public AjaxResult delete(String id) {
        AjaxResult response;
        Integer result = userService.deleteUser(id);
        if (result >= 1) {
            response = AjaxResult.success();
        } else {
            response = AjaxResult.error("用户删除失败!");
        }
        return response;
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/update")
    public AjaxResult update(User user) {
        AjaxResult response;
        Integer result = userService.updateUser(user);
        if (result >= 1) {
            response = AjaxResult.success();
        } else {
            response = AjaxResult.error("用户更新失败!");
        }
        return response;
    }

}
