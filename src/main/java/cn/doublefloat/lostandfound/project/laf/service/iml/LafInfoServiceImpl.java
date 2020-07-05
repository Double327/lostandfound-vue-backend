package cn.doublefloat.lostandfound.project.laf.service.iml;

import cn.doublefloat.lostandfound.common.constants.Constants;
import cn.doublefloat.lostandfound.project.laf.domain.LafInfo;
import cn.doublefloat.lostandfound.project.laf.mapper.LafInfoMapper;
import cn.doublefloat.lostandfound.project.laf.service.LafInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/16 10:17 下午
 */
@Service
public class LafInfoServiceImpl implements LafInfoService {

    @Autowired
    private LafInfoMapper lafInfoMapper;

    @Override
    public Integer addLafInfo(LafInfo lafInfo) {
        lafInfo.setStatus(Constants.LAF_STATUS_NO);
        lafInfo.setCreateBy("admin");
        lafInfo.setUpdateBy("admin");
        return lafInfoMapper.insert(lafInfo);
    }

    @Override
    public Integer deleteLafInfoById(String id) {
        return lafInfoMapper.deleteById(id);
    }

    @Override
    public Integer updateLafInfo(LafInfo lafInfo) {
        return lafInfoMapper.updateById(lafInfo);
    }

    @Override
    public List<LafInfo> findLafInfoList(LafInfo lafInfo) {
        return lafInfoMapper.list(lafInfo);
    }

    @Override
    public LafInfo findLafInfoById(String id) {
        return lafInfoMapper.selectById(id);
    }
}
