package cn.doublefloat.lostandfound.project.laf.service;

import cn.doublefloat.lostandfound.project.laf.domain.LafInfo;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/16 10:17 下午
 */
public interface LafInfoService {

    /**
     * 添加Laf信息
     *
     * @param lafInfo lafInfo
     * @return 0：失败  非0：成功
     */
    Integer addLafInfo(LafInfo lafInfo);

    /**
     * 删除laf信息
     * @param id id
     * @return 0：失败  非0：成功
     */
    Integer deleteLafInfoById(String id);

    /**
     * 修改laf信息
     * @param lafInfo lafInfo
     * @return 0：失败  非0：成功
     */
    Integer updateLafInfo(LafInfo lafInfo);

    /**
     * 查找所有Laf信息
     *
     * @param lafInfo laf查询条件
     * @return 信息
     */
    List<LafInfo> findLafInfoList(LafInfo lafInfo);

    /**
     * 根据id查找lafInfo
     * @param id id
     * @return lafInfo
     */
    LafInfo findLafInfoById(String id);
}
