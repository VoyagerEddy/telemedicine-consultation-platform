package com.iflytek.modules.cons.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 会诊表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 21:02:36
 */
@Data
@TableName("consultation")
public class ConsultationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer consId;
	/**
	 *
	 */
	private String medicine;
	/**
	 *
	 */
	private Integer price;
	/**
	 *
	 */
	@JsonFormat(pattern = "YYYY-MM-dd")
	private String time;
	/**
	 *
	 */
	private Integer patId;
	/**
	 *
	 */
	private Integer docId;
	/**
	 *
	 */
	private Integer expId;

}
