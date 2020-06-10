package com.lyscharlie.cloud.areacenter.feign.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lyscharlie.cloud.areacenter.controller.vo.UserVO;
import com.lyscharlie.cloud.areacenter.feign.UserFeignClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserFeignClientFallback implements UserFeignClient {

	@Override
	public List<UserVO> userList() {
		log.warn("run UserFeignClientFallback.userList");
		return new ArrayList<>();
	}
}
