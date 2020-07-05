package cn.doublefloat.lostandfound.project.laf.mapper;

import cn.doublefloat.lostandfound.project.laf.domain.LafInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/6/16 10:06 下午
 */
@Repository
public interface LafInfoMapper extends BaseMapper<LafInfo>  {

    /**
     * 根据多种信息查找
     * @param lafInfo 信息
     * @return 查找数据
     */
    List<LafInfo> list(LafInfo lafInfo);
}
