package com.iflytek.modules.doc.service.impl;

import com.iflytek.modules.doc.dao.DoctorDao;
import com.iflytek.modules.doc.entity.DoctorEntity;
import com.iflytek.modules.doc.service.DoctorService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.common.utils.Query;




@Service("doctorService")
public class DoctorServiceImpl extends ServiceImpl<DoctorDao, DoctorEntity> implements DoctorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DoctorEntity> page = this.page(
                new Query<DoctorEntity>().getPage(params),
                new QueryWrapper<DoctorEntity>().like("doc_name",(String)params.get("key"))
        );

        return new PageUtils(page);
    }

}
