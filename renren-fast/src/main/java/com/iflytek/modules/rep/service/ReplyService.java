package com.iflytek.modules.rep.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.modules.rep.entity.ReplyEntity;


import java.util.Map;

/**
 * 诊断结果回复
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-07 00:12:47
 */
public interface ReplyService extends IService<ReplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

