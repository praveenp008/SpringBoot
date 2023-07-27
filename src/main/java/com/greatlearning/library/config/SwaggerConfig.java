
package com.greatlearning.library.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.greatlearning.library.controller.ExampleContoller;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class SwaggerConfig {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerConfig.class, args);
	}
*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Library-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.greatlearning.library.controller")).build();

	}

	/*
	 * private ApiInfo apiInfo() { return new ApiInfoBuilder().title("Library API").
	 * description("Library API references for developers")
	 * .termsOfServiceUrl("http://fakelibrary.com") .contact(new
	 * Contact("Libary Api", "http://fakelibrary.com", "fakelibrary@gmail.com"))
	 * .license("Library-license").licenseUrl("http://fakelibrary.com").version(
	 * "1.0").build();
	 * 
	 * }
	 */

}
