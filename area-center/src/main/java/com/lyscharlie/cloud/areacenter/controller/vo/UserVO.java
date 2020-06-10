package com.lyscharlie.cloud.areacenter.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserVO {

	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String userName;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	private String email;
	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String mobile;
	/**
	 * 最近一次登录时间
	 */
	@ApiModelProperty(value = "最近一次登录时间")
	private String lastLoginTime;

}
