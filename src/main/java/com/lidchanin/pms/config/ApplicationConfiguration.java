package com.lidchanin.pms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.lidchanin.pms.service")
@Import(HibernateConfiguration.class)
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{

}
