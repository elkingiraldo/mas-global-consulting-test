package com.masglobalconsulting.test.employees.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration for swagger documentation
 * 
 * @author elkin.giraldo
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Elkin Giraldo", "elkin.giraldo.pinedo@gmail.com",
			"elkin.giraldo.pinedo@gmail.com");
	public static final ApiInfo DEFAULT = new ApiInfo("Api Documentation for Employees",
			"This module is in charge of managing employees for a company", "1.0", "urn:tos", DEFAULT_CONTACT,
			"Elkin Giraldo rights reserved", "elkin.giraldo.pinedo@gmail.com", new ArrayList<VendorExtension>());

	private static final Set<String> DEFAULT_PRODUCES = new HashSet<>(Arrays.asList("application/json"));

	private static final Set<String> DEFAULT_CONSUMES = new HashSet<>(Arrays.asList("application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).produces(DEFAULT_PRODUCES)
				.consumes(DEFAULT_CONSUMES);
	}

}
