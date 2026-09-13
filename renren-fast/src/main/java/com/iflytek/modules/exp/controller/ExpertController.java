package com.iflytek.modules.exp.controller;

import java.util.Arrays;
import java.util.Map;

import com.iflytek.modules.exp.entity.ExpertEntity;
import com.iflytek.modules.exp.service.ExpertService;
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
 * 专家表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 19:08:00
 */
@RestController
@RequestMapping("exp/expert")
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("exp:expert:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = expertService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{expId}")
    @RequiresPermissions("exp:expert:info")
    public R info(@PathVariable("expId") Integer expId){
		ExpertEntity expert = expertService.getById(expId);

        return R.ok().put("expert", expert);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("exp:expert:save")
    public R save(@RequestBody ExpertEntity expert){
		expertService.save(expert);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("exp:expert:update")
    public R update(@RequestBody ExpertEntity expert){
		expertService.updateById(expert);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("exp:expert:delete")
    public R delete(@RequestBody Integer[] expIds){
		expertService.removeByIds(Arrays.asList(expIds));

        return R.ok();
    }

}
