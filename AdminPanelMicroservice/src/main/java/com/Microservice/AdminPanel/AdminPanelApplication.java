package com.Microservice.AdminPanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableSwagger2
@EnableHystrixDashboard
public class AdminPanelApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminPanelApplication.class, args);
	}
	@Bean
	 public Docket SwaggerConfiguration() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.app"))
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
	return new ApiInfoBuilder()
			.title("Admin Panel API")
			.description("API for On Demand Car Wash System")
			.version("1.1.0")
			.license("Apache 2.0")
			.licenseUrl("https://www.apache.org/license/LICENSE-2.0\"")
			.contact("Anil")
			.build();
}


}
