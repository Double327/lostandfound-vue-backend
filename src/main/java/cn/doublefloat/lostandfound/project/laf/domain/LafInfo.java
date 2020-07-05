package cn.doublefloat.lostandfound.project.laf.domain;

import cn.doublefloat.lostandfound.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 李广帅
 * @date 2020/6/16 9:49 下午
 */
@Data
@ToString
public class LafInfo extends BaseEntity {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型 1 未找到、未认领   2 已找到、已认领
     */
    private Integer type;

    /**
     * 丢失时间
     */
    private Date lostTime;

    /**
     * 丢失地点
     */
    private String lostPosition;

    /**
     * 物品描述
     */
    private String summary;

    /**
     * 图片
     */
    private String image;

    /**
     * 状态
     */
    private Integer status;
}
