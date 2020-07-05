package cn.doublefloat.lostandfound.project.notification.domain;

import cn.doublefloat.lostandfound.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/6/19 10:37 下午
 */
@Data
public class Notification extends BaseEntity {

    /**
     * 分类
     */
    private Long id;

    /**
     * 通知标题
     */
    private String title;

    /**
     * 通知内容
     */
    private String content;

    /**
     * 图片（选填）
     */
    private String image;
}
