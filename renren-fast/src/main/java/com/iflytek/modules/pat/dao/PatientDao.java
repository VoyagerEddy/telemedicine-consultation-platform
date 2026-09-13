package com.iflytek.modules.pat.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.modules.pat.entity.PatientEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 患者表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 20:29:58
 */
@Mapper
public interface PatientDao extends BaseMapper<PatientEntity> {

}
