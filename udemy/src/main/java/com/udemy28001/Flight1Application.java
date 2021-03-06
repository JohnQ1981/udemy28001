package com.udemy28001;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@SpringBootApplication
public class Flight1Application {

	public static void main(String[] args) {
		SpringApplication.run(Flight1Application.class, args);
	}

		@Bean
		public LocaleResolver localeResolver() {
			SessionLocaleResolver localeResolver = new SessionLocaleResolver();
			localeResolver.setDefaultLocale(Locale.US);
			return localeResolver;
		}
		
		@Bean
		public LocaleResolver localeResolver1() {
			AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
			localeResolver.setDefaultLocale(Locale.US);
			return localeResolver;
		}
		
		
//		@Bean
//		public LocaleResolver localeResolver() {
//			AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
//			localeResolver.setDefaultLocale(Locale.US);
//			return localeResolver;
//		}
		
//		@Bean
//		public LocaleResolver localeResolverfr() {
//			SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//			localeResolver.setDefaultLocale(Locale.FRANCE);
//			return localeResolver;
//		}
		
//		@Bean
//		public ResourceBundleMessageSource bundleMessageSource() {
//			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//			messageSource.setBasename("messages");
//			return messageSource;
//		}
}
