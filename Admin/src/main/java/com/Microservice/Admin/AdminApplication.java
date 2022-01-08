package com.Microservice.Admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*");
			}
		};
	}
	
	@Bean
	 public Docket SwaggerConfiguration() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.Microservice"))
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
	return new ApiInfoBuilder()
			.title("CarWasherMicroService API")
			.description("API for On Demand Car Wash System")
			.version("1.1.0")
			.license("Apache 2.0")
			.licenseUrl("https://www.apache.org/license/LICENSE-2.0\"")
			.build();
	}

}
