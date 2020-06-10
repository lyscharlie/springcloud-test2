package com.lyscharlie.cloud.areacenter.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.enable}")
	private boolean enableSwagger;

	@Bean
	public Docket createAllRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(enableSwagger)
				.apiInfo(apiInfo())
				.groupName("all")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lyscharlie.cloud.areacenter.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("lyscharlie", "www.lyscharlie.com", "lyscharlie@hotmail.com");
		return new ApiInfoBuilder()
				.title("我是文档标题")
				.description("我是文档描述")
				.contact(contact)   // 联系方式
				.version("1.0.0")  // 版本
				.build();
	}
}
