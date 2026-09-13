package com.iflytek.modules.cons.service.impl;

import com.iflytek.modules.cons.dao.ConsultationDao;
import com.iflytek.modules.cons.entity.ConsultationEntity;
import com.iflytek.modules.cons.service.ConsultationService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.common.utils.Query;




@Service("consultationService")
public class ConsultationServiceImpl extends ServiceImpl<ConsultationDao, ConsultationEntity> implements ConsultationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ConsultationEntity> page = this.page(
                new Query<ConsultationEntity>().getPage(params),
                new QueryWrapper<ConsultationEntity>().like("cons_id",(String)params.get("key"))
        );

        return new PageUtils(page);
    }

}
