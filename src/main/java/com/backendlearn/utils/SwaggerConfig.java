package com.backendlearn.utils;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any()).
				paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {
		
		
		return new ApiInfo("Blog Application", "Developed by falam", "1.0.1", "terms of service", "falame","lisence",null);
		
//		return new ApiInfo("Blog Application","Developed By: Falame",
//				"1.0.1","","Lisence of APIs","API Liscense url",Collections.emptyList());
	}
}
