package com.iflytek.modules.rep.service.impl;

import com.iflytek.modules.rep.dao.ReplyDao;
import com.iflytek.modules.rep.entity.ReplyEntity;
import com.iflytek.modules.rep.service.ReplyService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iflytek.common.utils.PageUtils;
import com.iflytek.common.utils.Query;




@Service("replyService")
public class ReplyServiceImpl extends ServiceImpl<ReplyDao, ReplyEntity> implements ReplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReplyEntity> page = this.page(
                new Query<ReplyEntity>().getPage(params),
                new QueryWrapper<ReplyEntity>()
        );

        return new PageUtils(page);
    }

}
