package com.iflytek.modules.exp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.modules.exp.entity.ExpertEntity;


import java.util.Map;

/**
 * 专家表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 19:08:00
 */
public interface ExpertService extends IService<ExpertEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

