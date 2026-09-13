package com.iflytek.modules.pat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.modules.pat.entity.PatientEntity;


import java.util.Map;

/**
 * 患者表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 20:29:58
 */
public interface PatientService extends IService<PatientEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

