package com.iflytek.modules.pat.service.impl;

import com.iflytek.modules.pat.dao.PatientDao;
import com.iflytek.modules.pat.entity.PatientEntity;
import com.iflytek.modules.pat.service.PatientService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.common.utils.Query;




@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientDao, PatientEntity> implements PatientService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PatientEntity> page = this.page(
                new Query<PatientEntity>().getPage(params),
                new QueryWrapper<PatientEntity>().like("pat_name",(String)params.get("key"))
        );

        return new PageUtils(page);
    }

}
