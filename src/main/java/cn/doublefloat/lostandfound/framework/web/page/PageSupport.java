package cn.doublefloat.lostandfound.framework.web.page;

import cn.doublefloat.lostandfound.common.utils.ServletUtils;
import cn.doublefloat.lostandfound.common.utils.StringUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李广帅
 * @date 2020/6/21 8:02 下午
 */
@Data
@NoArgsConstructor
public class PageSupport {

    private static final String PAGE_NUM = "pageNum";

    private static final String PAGE_SIZE = "pageSize";

    private static final String ORDER_BY_COLUMN = "orderByColumn";

    private static final String IS_ASC = "isAsc";

    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PAGE_SIZE));
        pageDomain.setOrderByColumn(StringUtils.isEmpty(ServletUtils.getParameter(ORDER_BY_COLUMN)) ? "create_time" : ServletUtils.getParameter(ORDER_BY_COLUMN));
        pageDomain.setIsAsc(StringUtils.isEmpty(ServletUtils.getParameter(IS_ASC)) ? "desc" : ServletUtils.getParameter(IS_ASC));
        return pageDomain;
    }
}
