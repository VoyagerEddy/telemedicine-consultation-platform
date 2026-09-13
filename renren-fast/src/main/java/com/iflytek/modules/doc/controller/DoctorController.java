package com.iflytek.modules.doc.controller;

import java.util.Arrays;
import java.util.Map;

import com.iflytek.modules.doc.entity.DoctorEntity;
import com.iflytek.modules.doc.service.DoctorService;
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
 * 医生表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 20:46:04
 */
@RestController
@RequestMapping("doc/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("doc:doctor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = doctorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{docId}")
    @RequiresPermissions("doc:doctor:info")
    public R info(@PathVariable("docId") Integer docId){
		DoctorEntity doctor = doctorService.getById(docId);

        return R.ok().put("doctor", doctor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("doc:doctor:save")
    public R save(@RequestBody DoctorEntity doctor){
		doctorService.save(doctor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("doc:doctor:update")
    public R update(@RequestBody DoctorEntity doctor){
		doctorService.updateById(doctor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("doc:doctor:delete")
    public R delete(@RequestBody Integer[] docIds){
		doctorService.removeByIds(Arrays.asList(docIds));

        return R.ok();
    }

}
