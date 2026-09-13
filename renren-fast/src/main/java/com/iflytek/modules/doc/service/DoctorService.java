package com.iflytek.modules.doc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.modules.doc.entity.DoctorEntity;


import java.util.Map;

/**
 * 医生表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 20:46:04
 */
public interface DoctorService extends IService<DoctorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

