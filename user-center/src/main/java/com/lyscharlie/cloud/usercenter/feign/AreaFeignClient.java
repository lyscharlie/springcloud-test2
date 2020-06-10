package com.lyscharlie.cloud.usercenter.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyscharlie.cloud.usercenter.controller.vo.AreaVO;
import com.lyscharlie.cloud.usercenter.feign.impl.AreaFeignClientFallback;

@FeignClient(value = "area-center", fallback = AreaFeignClientFallback.class)
public interface AreaFeignClient {

	@PostMapping(value = "/area/queryCityListByProvinceId")
	List<AreaVO> queryCityListByProvinceId(@RequestParam(name = "provinceId") Long provinceId);

}
