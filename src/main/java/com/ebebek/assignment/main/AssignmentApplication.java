package com.ebebek.assignment.main;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.ebebek.assignment.configuration.SecurityConfiguration;
import com.ebebek.assignment.configuration.WebMvcConfig;


@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.ebebek.assignment.repository"})
@EntityScan(basePackages= {"com.ebebek.assignment.model"})
@ComponentScan(basePackages= {"com.ebebek.assignment.controller","com.ebebek.assignment.services"})
@Import({SecurityConfiguration.class,WebMvcConfig.class})

public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(new Locale("tr"));
	    return slr;
	}
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		 messageSource.setDefaultEncoding("UTF-8");
	      messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}
}
