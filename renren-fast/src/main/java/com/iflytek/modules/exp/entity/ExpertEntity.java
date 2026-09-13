package com.iflytek.modules.exp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 专家表
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-05 19:08:00
 */
@Data
@TableName("expert")
public class ExpertEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer expId;

	private String expName;

	private Integer expAge;

	private String expSex;

	private String expField;

}
