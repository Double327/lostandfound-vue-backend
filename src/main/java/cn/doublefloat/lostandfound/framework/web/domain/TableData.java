package cn.doublefloat.lostandfound.framework.web.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/16 10:11 下午
 */
@Data
@NoArgsConstructor
public class TableData {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 信息
     */
    private List<?> rows;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    public TableData(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
        this.msg = "成功";
    }
}
