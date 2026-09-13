package com.iflytek.modules.appl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.modules.appl.entity.ApplicationEntity;


import java.util.Map;

/**
 * 会诊申请
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-06 22:48:23
 */
public interface ApplicationService extends IService<ApplicationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

