package cn.doublefloat.lostandfound.project.laf.controller;

import cn.doublefloat.lostandfound.framework.web.controller.BaseController;
import cn.doublefloat.lostandfound.framework.web.domain.AjaxResult;
import cn.doublefloat.lostandfound.framework.web.domain.TableData;
import cn.doublefloat.lostandfound.project.laf.domain.LafInfo;
import cn.doublefloat.lostandfound.project.laf.service.LafInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/16 9:48 下午
 */
@Slf4j
@RestController
@RequestMapping("/laf")
public class LafController extends BaseController {

    @Autowired
    private LafInfoService lafInfoService;

    /**
     * 添加Laf信息
     *
     * @param lafInfo laf信息
     * @return 状态
     */
    @PostMapping("/add")
    public AjaxResult add(LafInfo lafInfo) {
        log.info("添加Laf信息：" + lafInfo);
        AjaxResult result = AjaxResult.success("添加成功!");
        lafInfoService.addLafInfo(lafInfo);
        return result;
    }

    /**
     * 删除Laf信息
     *
     * @param id laf ID
     * @return 状态
     */
    @GetMapping("/delete/{id}")
    public AjaxResult deleteLafInfo(@PathVariable String id) {
        AjaxResult result = AjaxResult.success("删除成功!");
        lafInfoService.deleteLafInfoById(id);
        return result;
    }


    /**
     * 更新laf信息
     *
     * @param lafInfo laf信息
     * @return 结果
     */
    @PostMapping("/update")
    public AjaxResult updateLafInfo(LafInfo lafInfo) {
        AjaxResult result = AjaxResult.success("更新成功！");
        lafInfoService.updateLafInfo(lafInfo);
        return result;
    }

    /**
     * 返回所有类型laf信息
     *
     * @return 信息
     */
    @GetMapping(value = "/list")
    public TableData list(LafInfo lafInfo) {
        startPage();
        log.info(lafInfo.toString());
        List<LafInfo> lafInfoList = lafInfoService.findLafInfoList(lafInfo);
        return getTableData(lafInfoList);
    }

}
