package com.lidchanin.pms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Annotation <code>Configuration</code> indicates that a class declares
 * one or more <code>Bean</code> methods and may be processed by the
 * Spring container to generate bean definitions and service requests for
 * those beans at runtime.
 * @see Configuration
 *
 * Annotation <code>ComponentScan</code> configures component scanning
 * directives for use with {@link Configuration} classes.
 * @see ComponentScan
 */
@Configuration
@ComponentScan("com.lidchanin.pms.service")
//@Import(HibernateConfiguration.class)
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

}
