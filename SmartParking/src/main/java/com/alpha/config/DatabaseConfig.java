package com.alpha.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class DatabaseConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.postgresql.Driver");

		dataSource.setUrl("jdbc:postgresql://localhost:5432/SPS");

		dataSource.setUsername("postgres");

		dataSource.setPassword("root");

		return dataSource;

		
	}
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

	        LocalContainerEntityManagerFactoryBean em =
	                new LocalContainerEntityManagerFactoryBean();

	        em.setDataSource(dataSource());

	        em.setPackagesToScan("com.alpha.model");

	        HibernateJpaVendorAdapter vendorAdapter =
	                new HibernateJpaVendorAdapter();

	        em.setJpaVendorAdapter(vendorAdapter);

	        Properties properties = new Properties();

	        properties.setProperty("hibernate.hbm2ddl.auto", "update");

	        properties.setProperty(
	                "hibernate.dialect",
	                "org.hibernate.dialect.PostgreSQLDialect"
	        );

	        properties.setProperty("hibernate.show_sql", "true");

	        em.setJpaProperties(properties);

	        return em;
	    }

	    @Bean
	    public JpaTransactionManager transactionManager() {

	        JpaTransactionManager transactionManager =
	                new JpaTransactionManager();

	        transactionManager.setEntityManagerFactory(
	                entityManagerFactory().getObject()
	        );

	        return transactionManager;
	    }

	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }
	
}
