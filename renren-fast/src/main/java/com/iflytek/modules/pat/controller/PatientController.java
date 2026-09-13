package com.iflytek.modules.pat.controller;

import java.util.Arrays;
import java.util.Map;

import com.iflytek.modules.pat.entity.PatientEntity;
import com.iflytek.modules.pat.service.PatientService;
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
 * 患者表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 20:29:58
 */
@RestController
@RequestMapping("pat/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pat:patient:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = patientService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{patId}")
    @RequiresPermissions("pat:patient:info")
    public R info(@PathVariable("patId") Integer patId){
		PatientEntity patient = patientService.getById(patId);

        return R.ok().put("patient", patient);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pat:patient:save")
    public R save(@RequestBody PatientEntity patient){
		patientService.save(patient);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pat:patient:update")
    public R update(@RequestBody PatientEntity patient){
		patientService.updateById(patient);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pat:patient:delete")
    public R delete(@RequestBody Integer[] patIds){
		patientService.removeByIds(Arrays.asList(patIds));

        return R.ok();
    }

}
