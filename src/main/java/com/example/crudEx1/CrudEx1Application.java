package com.example.crudEx1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CrudEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudEx1Application.class, args);
	}
	@Bean
	public Docket api() {
		HashSet<String> consumesAndProduces = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata())
				.consumes(consumesAndProduces)
				.produces(consumesAndProduces)
				.pathMapping("/");
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("My awesome API")
				.description("My awesome API Description")
				.version("1.0")
				.contact(new Contact("Ranga", "http://www.in28minutes.com",
						"in28minutes@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
@Bean
public LocaleResolver localeResolver() {
	AcceptHeaderLocaleResolver localeResolvr=new AcceptHeaderLocaleResolver();
	localeResolvr.setDefaultLocale(Locale.US);
	return localeResolvr;
}
/*@Bean 
public ResourceBundleMessageSource bundleMessageSource() {
	ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
messageSource.setBasename("messages");
	return messageSource;
}*/
}

