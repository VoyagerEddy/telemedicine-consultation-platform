package com.iflytek.modules.appl.controller;

import java.util.Arrays;
import java.util.Map;

import com.iflytek.modules.appl.entity.ApplicationEntity;
import com.iflytek.modules.appl.service.ApplicationService;
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
 * 会诊申请
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-06 22:48:23
 */
@RestController
@RequestMapping("appl/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("appl:application:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = applicationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{applId}")
    @RequiresPermissions("appl:application:info")
    public R info(@PathVariable("applId") Integer applId){
		ApplicationEntity application = applicationService.getById(applId);

        return R.ok().put("application", application);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("appl:application:save")
    public R save(@RequestBody ApplicationEntity application){
		applicationService.save(application);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("appl:application:update")
    public R update(@RequestBody ApplicationEntity application){
		applicationService.updateById(application);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("appl:application:delete")
    public R delete(@RequestBody Integer[] applIds){
		applicationService.removeByIds(Arrays.asList(applIds));

        return R.ok();
    }

}
