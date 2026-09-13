package com.iflytek.modules.cons.controller;

import java.util.Arrays;
import java.util.Map;

import com.iflytek.modules.cons.entity.ConsultationEntity;
import com.iflytek.modules.cons.service.ConsultationService;
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
 * 会诊表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 21:02:36
 */
@RestController
@RequestMapping("cons/consultation")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("cons:consultation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = consultationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{consId}")
    @RequiresPermissions("cons:consultation:info")
    public R info(@PathVariable("consId") Integer consId){
		ConsultationEntity consultation = consultationService.getById(consId);

        return R.ok().put("consultation", consultation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("cons:consultation:save")
    public R save(@RequestBody ConsultationEntity consultation){
		consultationService.save(consultation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("cons:consultation:update")
    public R update(@RequestBody ConsultationEntity consultation){
		consultationService.updateById(consultation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("cons:consultation:delete")
    public R delete(@RequestBody Integer[] consIds){
		consultationService.removeByIds(Arrays.asList(consIds));

        return R.ok();
    }

}
