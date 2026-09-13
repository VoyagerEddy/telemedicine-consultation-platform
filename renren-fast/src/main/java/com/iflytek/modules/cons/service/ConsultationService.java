package com.iflytek.modules.cons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.modules.cons.entity.ConsultationEntity;


import java.util.Map;

/**
 * 会诊表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 21:02:36
 */
public interface ConsultationService extends IService<ConsultationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

