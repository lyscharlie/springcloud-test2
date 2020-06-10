package com.lyscharlie.cloud.usercenter.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyscharlie.cloud.usercenter.biz.entity.UserDO;

public interface UserMapper extends BaseMapper<UserDO> {

	public Integer selectCountByRegisterReferId(Long registerReferId);

	public UserDO selectRandomUser();

}
