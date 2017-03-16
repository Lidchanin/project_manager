package com.lidchanin.pms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@ComponentScan
@EnableJpaRepositories(basePackages = {"com.lidchanin.pms.repository"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    @Value("hibernate.driver")
    private String PROPERTY_NAME_DB_DRIVER_CLASS;

    @Value("hibernate.password")
    private String PROPERTY_NAME_DB_PASSWORD;

    @Value("hibernate.url")
    private String PROPERTY_NAME_DB_URL;

    @Value("hibernate.username")
    private String PROPERTY_NAME_DB_USER;

    @Value("hibernate.dialect")
    private String PROPERTY_NAME_DB_DIALECT;

    @Bean
    public DriverManagerDataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
        dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DB_URL));
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DB_USER));
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.lidchanin.pms.model");
        return entityManagerFactoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
    {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
