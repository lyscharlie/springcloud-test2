package com.lyscharlie.cloud.areacenter.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyscharlie.cloud.areacenter.biz.entity.AreaDO;
import com.lyscharlie.cloud.areacenter.biz.mapper.AreaMapper;
import com.lyscharlie.cloud.areacenter.biz.service.AreaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaDO> implements AreaService {
}
