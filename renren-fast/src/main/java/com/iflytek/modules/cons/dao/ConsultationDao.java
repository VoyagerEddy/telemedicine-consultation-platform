package com.iflytek.modules.cons.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.modules.cons.entity.ConsultationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会诊表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 21:02:36
 */
@Mapper
public interface ConsultationDao extends BaseMapper<ConsultationEntity> {

}
