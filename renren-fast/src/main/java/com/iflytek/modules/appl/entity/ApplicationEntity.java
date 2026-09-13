package com.iflytek.modules.appl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会诊申请
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-06 22:48:23
 */
@Data
@TableName("application")
public class ApplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer applId;
	/**
	 *
	 */
	private String applTime;
	/**
	 *
	 */
	private Integer pat1Id;
	/**
	 *
	 */
	private Integer doc1Id;

}
