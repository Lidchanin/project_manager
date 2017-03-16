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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * Annotation <code>Configuration</code> indicates that a class declares
 * one or more {@link Bean} methods and may be processed by the
 * Spring container to generate bean definitions and service requests for
 * those beans at runtime.
 * @see Configuration
 *
 * Annotation <code>EnableTransactionManagement</code> enables Spring's
 * annotation-driven transaction management capability, similar to
 * the support found in Spring's {<code><tx:*></code>} XML namespace.
 * @see EnableTransactionManagement
 *
 * Annotation <code>ComponentScan</code> configures component scanning
 * directives for use with {@link Configuration} classes.
 * @see ComponentScan
 *
 * Annotation <code>EnableJpaRepositories</code> to enable JPA repositories.
 * @see EnableJpaRepositories
 *
 * Annotation <code>PropertySource</code> need to work with .properties files.
 * @see PropertySource
 */
@Configuration
@EnableTransactionManagement
@ComponentScan
@EnableJpaRepositories(basePackages = {"com.lidchanin.pms.repository"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {

    private final Environment environment;

    @Autowired
    public HibernateConfiguration(Environment environment) {
        this.environment = environment;
    }

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

    /**
     * Method <code>DriverManagerDataSource</code> need to connect database.
     * @return required data source with some options
     * @see DriverManagerDataSource
     *
     * Annotation <code>Bean</code> indicates that a method produces a bean to be
     * managed by the Spring container.
     * @see Bean
     */
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
        dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DB_URL));
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DB_USER));
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
        return dataSource;
    }

    /**
     * Method <code>entityManagerFactory</code> configures entity manager factory
     * with the DataSource to use Hibernate as the JPA adapter.
     * @return configured entity manager factory.
     * @see LocalContainerEntityManagerFactoryBean
     *
     * Annotation <code>Bean</code> indicates that a method produces a bean to be
     * managed by the Spring container.
     * @see Bean
     */
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.lidchanin.pms.model");
        return entityManagerFactoryBean;
    }

    /**
     * Method <code>transactionManager</code> configures JPA transactional
     * manager with the existing entity manager factory.
     * @param entityManagerFactory configured before entity manager factory.
     * @return configured transactional manager.
     * @see JpaTransactionManager
     *
     * Annotation <code>Bean</code> indicates that a method produces a bean to be
     * managed by the Spring container.
     * @see Bean
     */
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    /**
     * Method <code>PasswordEncoder</code> to setup password encoding in your
     * application using Spring Security’s BCrypt implementation.
     * @return bcrypt password encoder
     * @see PasswordEncoder
     * @see BCryptPasswordEncoder
     *
     * Annotation <code>Bean</code> indicates that a method produces a bean to be
     * managed by the Spring container.
     * @see Bean
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
