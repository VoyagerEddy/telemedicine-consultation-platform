package com.iflytek.modules.doc.dao;

import com.iflytek.modules.doc.entity.DoctorEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医生表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 20:46:04
 */
@Mapper
public interface DoctorDao extends BaseMapper<DoctorEntity> {

}
