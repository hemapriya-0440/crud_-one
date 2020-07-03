package com.example.crudEx1;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class CrudEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudEx1Application.class, args);
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

