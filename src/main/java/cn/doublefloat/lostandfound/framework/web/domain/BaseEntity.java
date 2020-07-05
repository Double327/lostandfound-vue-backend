package cn.doublefloat.lostandfound.framework.web.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础类
 *
 * @author 李广帅
 * @date 2020/6/20 10:44 下午
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 删除人
     */
    private String deleteBy;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
