package com.iflytek.modules.rep.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 诊断结果回复
 *
 * @author zyh
 * @email 1976333491@qq.com
 * @date 2022-07-07 00:12:47
 */
@Data
@TableName("reply")
public class ReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer repId;
	/**
	 *
	 */
	private Integer cons1Id;
	/**
	 *
	 */
	private Integer exp1Id;
	/**
	 *
	 */
	private String repCont;

}
