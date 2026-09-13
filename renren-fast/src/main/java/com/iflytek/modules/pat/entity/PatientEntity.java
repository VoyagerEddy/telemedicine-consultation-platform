package com.iflytek.modules.pat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 患者表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 20:29:58
 */
@Data
@TableName("patient")
public class PatientEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer patId;
	/**
	 *
	 */
	private String patName;
	/**
	 *
	 */
	private String patSex;
	/**
	 *
	 */
	private String patAge;
	/**
	 *
	 */
	private String patIllness;

}
