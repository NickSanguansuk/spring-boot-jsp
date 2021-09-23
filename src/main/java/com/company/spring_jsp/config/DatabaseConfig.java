package com.company.spring_jsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.company.spring_jsp.data")
public class DatabaseConfig {

}
