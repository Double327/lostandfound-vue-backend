package cn.doublefloat.lostandfound.project.notification.service.impl;

import cn.doublefloat.lostandfound.project.notification.domain.Notification;
import cn.doublefloat.lostandfound.project.notification.mapper.NotificationMapper;
import cn.doublefloat.lostandfound.project.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/7/1 11:16 上午
 */
@Service
public class NotificationImpl implements NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public List<Notification> list(Notification notification) {
        return notificationMapper.list(notification);
    }

    @Override
    public Integer add(Notification notification) {
        return notificationMapper.insert(notification);
    }

    @Override
    public Integer delete(String id) {
        return notificationMapper.deleteById(id);
    }

    @Override
    public Integer update(Notification notification) {
        return notificationMapper.updateById(notification);
    }
}
