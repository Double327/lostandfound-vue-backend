package cn.doublefloat.lostandfound.project.notification.service;

import cn.doublefloat.lostandfound.project.notification.domain.Notification;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/19 10:44 下午
 */
public interface NotificationService {

    /**
     * 根据查询条件查询
     * @param notification 查询条件
     * @return 查询结果
     */
    List<Notification> list(Notification notification);

    /**
     * 添加Notification信息
     * @param notification 信息
     * @return 添加结果
     */
    Integer add(Notification notification);

    /**
     * 删除
     * @param id id
     * @return 删除结果
     */
    Integer delete(String id);

    /**
     * 修改
     * @param notification 修改信息
     * @return 修改结果
     */
    Integer update(Notification notification);
}
