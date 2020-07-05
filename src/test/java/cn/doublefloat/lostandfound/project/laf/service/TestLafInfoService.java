package cn.doublefloat.lostandfound.project.laf.service;

import cn.doublefloat.lostandfound.common.constants.Constants;
import cn.doublefloat.lostandfound.project.laf.domain.LafInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/16 10:20 下午
 */
@SpringBootTest
public class TestLafInfoService {

    @Autowired
    private LafInfoService lafInfoService;

    @Test
    public void addLafInfo() {
        LafInfo lafInfo = new LafInfo();
        lafInfo.setTitle("Test");
        lafInfo.setType(1);
        lafInfo.setLostTime(new Date());
        lafInfo.setLostPosition("Test");
        lafInfo.setSummary("Test");
        Integer result = lafInfoService.addLafInfo(lafInfo);
        if (result >= 1) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void findAllLafInfoList() {
        LafInfo lafInfo = new LafInfo();
        lafInfo.setStatus(Constants.LAF_STATUS_NO);
        List<LafInfo> allLafInfo = lafInfoService.findLafInfoList(lafInfo);
        allLafInfo.forEach(System.out::println);
    }

    @Test
    public void deleteLafInfo() {
        Integer result = lafInfoService.deleteLafInfoById("1272901572423155713");
        if (result >= 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

}
