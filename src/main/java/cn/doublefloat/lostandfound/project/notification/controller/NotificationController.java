package cn.doublefloat.lostandfound.project.notification.controller;

import cn.doublefloat.lostandfound.framework.web.controller.BaseController;
import cn.doublefloat.lostandfound.framework.web.domain.AjaxResult;
import cn.doublefloat.lostandfound.framework.web.domain.TableData;
import cn.doublefloat.lostandfound.project.notification.domain.Notification;
import cn.doublefloat.lostandfound.project.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/19 10:43 下午
 */
@RestController
@RequestMapping("/notification")
public class NotificationController extends BaseController {

    @Autowired
    private NotificationService notificationService;

    /**
     * 获取通知列表
     *
     * @param notification 查询条件
     * @return 结果
     */
    @GetMapping("/list")
    public TableData list(Notification notification) {
        startPage();
        List<Notification> list = notificationService.list(notification);
        return getTableData(list);
    }

    /**
     * 添加通知信息
     *
     * @param notification 通知信息
     * @return 添加结果
     */
    @PostMapping("/add")
    public AjaxResult add(Notification notification) {
        AjaxResult result = AjaxResult.success("添加成功!");
        notificationService.add(notification);
        return result;
    }

    /**
     * 删除通知信息
     *
     * @param id 编号
     * @return 结果
     */
    @PutMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable String id) {
        AjaxResult result = AjaxResult.success("删除成功!");
        notificationService.delete(id);
        return result;
    }

    /**
     * 更新通知信息
     *
     * @param notification 通知信息
     * @return 更新结果
     */
    @PostMapping("/update")
    public AjaxResult update(Notification notification) {
        AjaxResult result = AjaxResult.success("更新成功");
        notificationService.update(notification);
        return result;
    }


    @GetMapping("/detail/{id}")
    public AjaxResult getDetail(@PathVariable String id) {
        return AjaxResult.success();
    }
}
