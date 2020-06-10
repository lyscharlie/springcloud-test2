package com.lyscharlie.cloud.areacenter.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName(value = "lys_area")
@Data
public class AreaDO {

	/**
	 * 地区id
	 */
	@TableId(value = "area_id", type = IdType.AUTO)
	private Long areaId;
	/**
	 * 地区名称
	 */
	@TableField(value = "area_name")
	private String areaName;
	/**
	 * 地区等级：1-国家，2-省，3-市，4-区/县/镇
	 */
	@TableField(value = "area_level")
	private Integer areaLevel;
	/**
	 * 地区信息
	 */
	@TableField(value = "area_info")
	private String areaInfo;
	/**
	 * 上级地区id
	 */
	@TableField(value = "parent_id")
	private Long parentId;
	/**
	 * 状态：1-启用，2-停用
	 */
	@TableField(value = "status")
	private Integer status;

}
