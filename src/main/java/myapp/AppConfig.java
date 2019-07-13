package myapp;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Config class for application
 */
@EnableJpaRepositories("myapp")
@Configuration
public class AppConfig {

    /**
     *Bean for multipart
     * Need to uploading files
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(Long.MAX_VALUE);
        return multipartResolver;
    }

    /**
     *Bean for entity
     */
    @Bean
    @DependsOn("flyway")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("myapp","myapp.controller","myapp.db","myapp.dto","myapp.model","myapp.repository"
        ,"myapp.service.api","myapp.service.impl");

       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());


        return em;
    }

    /**
     *Bean for database connecting
     */
    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/elearning?characterEncoding=utf8&useConfigs=maxPerformance&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "admin" );
        return dataSource;
    }

    /**
     *Bean for flyway migration
     */
    @Bean(initMethod = "migrate")
    Flyway flyway() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource())
                .baselineOnMigrate(true)
                .load();
        //flyway.migrate();

/*
        Flyway flyway = new Flyway();
        flyway.setBaselineOnMigrate(true);
        return flyway;
*/
        return flyway;
    }

    /**
     * Bean for transaction
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * Properties for database dialect
     */
    Properties additionalProperties() {
        Properties properties = new Properties();
        //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql","true");
        return properties;
    }
}
