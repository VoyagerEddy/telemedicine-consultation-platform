package com.iflytek.modules.appl.service.impl;

import com.iflytek.modules.appl.dao.ApplicationDao;
import com.iflytek.modules.appl.entity.ApplicationEntity;
import com.iflytek.modules.appl.service.ApplicationService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.common.utils.Query;




@Service("applicationService")
public class ApplicationServiceImpl extends ServiceImpl<ApplicationDao, ApplicationEntity> implements ApplicationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ApplicationEntity> page = this.page(
                new Query<ApplicationEntity>().getPage(params),
                new QueryWrapper<ApplicationEntity>().eq("appl_id",(String)params.get("key"))
        );

        return new PageUtils(page);
    }

}
