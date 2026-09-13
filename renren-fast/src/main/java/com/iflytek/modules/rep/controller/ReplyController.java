package com.iflytek.modules.rep.controller;

import java.util.Arrays;
import java.util.Map;

import com.iflytek.modules.rep.entity.ReplyEntity;
import com.iflytek.modules.rep.service.ReplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.iflytek.common.utils.PageUtils;
import com.iflytek.common.utils.R;



/**
 * 诊断结果回复
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-07 00:12:47
 */
@RestController
@RequestMapping("rep/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("rep:reply:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = replyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{repId}")
    @RequiresPermissions("rep:reply:info")
    public R info(@PathVariable("repId") Integer repId){
		ReplyEntity reply = replyService.getById(repId);

        return R.ok().put("reply", reply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rep:reply:save")
    public R save(@RequestBody ReplyEntity reply){
		replyService.save(reply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rep:reply:update")
    public R update(@RequestBody ReplyEntity reply){
		replyService.updateById(reply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rep:reply:delete")
    public R delete(@RequestBody Integer[] repIds){
		replyService.removeByIds(Arrays.asList(repIds));

        return R.ok();
    }

}
