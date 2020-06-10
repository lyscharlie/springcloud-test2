package com.lyscharlie.cloud.usercenter.feign.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lyscharlie.cloud.usercenter.controller.vo.AreaVO;
import com.lyscharlie.cloud.usercenter.feign.AreaFeignClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AreaFeignClientFallback implements AreaFeignClient {

	@Override
	public List<AreaVO> queryCityListByProvinceId(Long provinceId) {
		log.warn("run areaFeignClientFallback.queryCityListByProvinceId");
		return new ArrayList<>();
	}

}
