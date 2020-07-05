package cn.doublefloat.lostandfound.framework.web.controller;

import cn.doublefloat.lostandfound.common.utils.StringUtils;
import cn.doublefloat.lostandfound.framework.web.domain.TableData;
import cn.doublefloat.lostandfound.framework.web.page.PageDomain;
import cn.doublefloat.lostandfound.framework.web.page.PageSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/22 6:22 下午
 */
public class BaseController {

    /**
     * 设置分页数据
     */
    protected void startPage() {
        PageDomain pageDomain = PageSupport.getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    protected TableData getTableData(List<?> list) {
        TableData tableData = new TableData();
        tableData.setCode(HttpStatus.OK.value());
        tableData.setRows(list);
        tableData.setTotal(new PageInfo(list).getTotal());
        return tableData;
    }
}
