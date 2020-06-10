package com.lyscharlie.cloud.usercenter.common;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class CloudConfig {

	/**
	 * 向Spring容器中定义RestTemplate对象
	 *
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * 自定义ribbon策略
	 *
	 * @return
	 */
	@Bean
	public IRule myRule() {
		//return new RoundRobinRule(); // 线性轮询
		//return new RandomRule(); //随机算法
		return new RetryRule();  //负载均衡算法
	}

}
