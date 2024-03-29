
package com.greatlearning.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Library-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.greatlearning.library.controller")).build();

	}

	// customize api info
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Library API").description("Library API references for developers")
				.termsOfServiceUrl("http://fakelibrary.com")
				.contact(new Contact("Libary Api", "http://fakelibrary.com", "fakelibrary@gmail.com"))
				.license("Library-license").licenseUrl("http://fakelibrary.com").version("1.0").build();

	}

}
