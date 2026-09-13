package com.iflytek.modules.doc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 医生表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 20:46:04
 */
@Data
@TableName("doctor")
public class DoctorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer docId;
	/**
	 *
	 */
	private String docName;
	/**
	 *
	 */
	private String docSex;
	/**
	 *
	 */
	private Integer docAge;
	/**
	 *
	 */
	private String docField;

}
