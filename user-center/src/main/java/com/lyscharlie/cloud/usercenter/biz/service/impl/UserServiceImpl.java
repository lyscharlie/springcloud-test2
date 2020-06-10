package com.lyscharlie.cloud.usercenter.biz.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyscharlie.cloud.usercenter.biz.entity.UserDO;
import com.lyscharlie.cloud.usercenter.biz.mapper.UserMapper;
import com.lyscharlie.cloud.usercenter.biz.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

	@Override
	public UserDO randomUser() {
		return this.baseMapper.selectRandomUser();
	}

	@Override
	public UserDO findUserByNameAndPassword(String userName, String password) {
		QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
		wrapper.eq("user_name", userName)
				.eq("password", DigestUtils.md5DigestAsHex(password.getBytes()))
				.eq("is_delete", 0)
				.orderByAsc("user_id")
				.last("limit 1");
		return this.baseMapper.selectOne(wrapper);
	}

}
