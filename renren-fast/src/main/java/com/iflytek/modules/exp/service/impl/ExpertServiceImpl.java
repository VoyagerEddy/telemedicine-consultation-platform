package com.iflytek.modules.exp.service.impl;

import com.iflytek.modules.exp.dao.ExpertDao;
import com.iflytek.modules.exp.entity.ExpertEntity;
import com.iflytek.modules.exp.service.ExpertService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.common.utils.Query;



@Service("expertService")
public class ExpertServiceImpl extends ServiceImpl<ExpertDao, ExpertEntity> implements ExpertService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExpertEntity> page = this.page(
                new Query<ExpertEntity>().getPage(params),
                new QueryWrapper<ExpertEntity>().like("exp_name",(String)params.get("key"))
        );
        return new PageUtils(page);
    }
}
