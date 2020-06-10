package com.lyscharlie.cloud.usercenter.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.lyscharlie.cloud.usercenter.controller.vo.AreaVO;
import com.lyscharlie.cloud.usercenter.feign.AreaFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(value = "test")
@RestController
@RequestMapping(value = "test")
@Slf4j
public class TestController {

	@Value("${myspcloud.areaCenter.url}")
	private String areaCenterUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AreaFeignClient areaFeignClient;

	@HystrixCommand(fallbackMethod = "queryCityListByProvinceIdFallback")
	@ApiOperation(value = "查询省份下所有城市列表")
	@ApiImplicitParam(name = "provinceId", value = "省份id", required = true, dataType = "Long", paramType = "form")
	@PostMapping(value = "queryCityListByProvinceId")
	public List<AreaVO> queryCityListByProvinceId(@RequestParam("provinceId") Long provinceId) {

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			MultiValueMap map = new LinkedMultiValueMap();
			map.add("provinceId", provinceId);
			HttpEntity requestBody = new HttpEntity(map, headers);

			AreaVO[] areas = this.restTemplate.postForObject(this.areaCenterUrl + "/area/queryCityListByProvinceId", requestBody, AreaVO[].class);
			return Arrays.asList(areas);
		} catch (RestClientException e) {
			log.error("TestController.queryCityListByProvinceId", e);
			return new ArrayList<>();
		}
	}

	@ApiOperation(value = "查询省份下所有城市列表(feign)")
	@ApiImplicitParam(name = "provinceId", value = "省份id", required = true, dataType = "Long", paramType = "form")
	@PostMapping(value = "queryCityListByProvinceIdFeign")
	public List<AreaVO> queryCityListByProvinceIdFeign(@RequestParam("provinceId") Long provinceId) {
		return this.areaFeignClient.queryCityListByProvinceId(provinceId);
	}

	public List<AreaVO> queryCityListByProvinceIdFallback(Long provinceId) {
		log.warn("run queryCityListByProvinceIdFallback");
		return new ArrayList<>();
	}

}
