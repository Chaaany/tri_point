package com.triple.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:9999/triple/swagger-ui/index.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("tripe").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.triple.controller")).paths(regex("/.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Triple REST API").description(
				"<h2>Triple API Reference for Developers</h2>Swagger를 이용한 Triple API<br>\"")
				.contact(new Contact("Chan._.yy", "https://github.com/chaaany", "ybc125@naver.com")).license("Chan._.yy License")
				.version("1.0").build();
	}
	


}
