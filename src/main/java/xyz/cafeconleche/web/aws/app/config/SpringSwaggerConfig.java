package xyz.cafeconleche.web.aws.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringSwaggerConfig {

	@Bean
	public Docket api() {
		
		ResponseMessageBuilder responseMessage430 = new ResponseMessageBuilder()
				.code(403)
				.message("Nah nah, you are not allowed!");
				
		ResponseMessageBuilder responseMessage500 = new ResponseMessageBuilder()
				.code(500)
				.message("Error 500")
				.responseModel(new ModelRef("Error"));
		
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(responseMessage430.build());
		responseMessages.add(responseMessage500.build());
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("xyz.cafeconleche.web.aws.controller.rest"))
				.paths(PathSelectors.ant("/babyNames/**"))
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessages);
	}

	private ApiInfo apiInfo() {

		String title = "Baby REST API";
		String description = "Description of the baby API";
		String version = "API BABY V1";
		String termsOfServiceUrl = "Terms of service URL";
		String license = "License of the API";
		String licenseUrl = "API License URL";
		Contact contact = new Contact("Topiltzin Dominguez", "topi.cafeconleche.xyz", "topiltzin.dominguez@gmail.com");

		ApiInfo apiInfo = new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl);

		return apiInfo;
	}
	
}
