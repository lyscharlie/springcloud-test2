package com.lyscharlie.cloud.gatewayapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApiDemoApplication.class, args);
	}

}
