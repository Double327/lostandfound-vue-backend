package cn.doublefloat.lostandfound.project.notification.mapper;

import cn.doublefloat.lostandfound.project.notification.domain.Notification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/19 10:37 下午
 */
@Repository
public interface NotificationMapper extends BaseMapper<Notification> {

    /**
     * 根据查询条件查询
     *
     * @param notification 查询条件
     * @return 查询结果
     */
    List<Notification> list(Notification notification);
}
