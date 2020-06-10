package com.lyscharlie.cloud.usercenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lyscharlie.cloud.usercenter.biz.entity.UserDO;
import com.lyscharlie.cloud.usercenter.biz.service.UserService;
import com.lyscharlie.cloud.usercenter.controller.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(value = "user")
@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "用户列表")
	@GetMapping(value = "userList")
	public List<UserVO> userList() {
		List<UserVO> resultList = new ArrayList<>();
		List<UserDO> list = this.userService.list(Wrappers.<UserDO>lambdaQuery().eq(UserDO::getIsDelete, 0));
		for (UserDO userDO : list) {
			UserVO vo = new UserVO();
			BeanUtils.copyProperties(userDO, vo);
			resultList.add(vo);
		}
		return resultList;
	}

}
