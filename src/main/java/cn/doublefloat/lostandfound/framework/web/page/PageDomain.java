package cn.doublefloat.lostandfound.framework.web.page;

import lombok.Data;

/**
 * @author 李广帅
 * @date 2020/6/21 8:02 下午
 */
@Data
public class PageDomain {

    /**
     * 起始页
     */
    private Integer pageNum;

    /**
     * 每页记录条数
     */
    private Integer pageSize;

    /**
     * 排序属性
     */
    private String orderByColumn;

    /**
     * 排序方式desc asc
     */
    private String isAsc;

    public String getOrderBy() {
        return orderByColumn + " " + isAsc;
    }

}
