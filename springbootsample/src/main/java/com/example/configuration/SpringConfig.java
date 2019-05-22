package com.example.configuration;


import java.util.Properties;

import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "com.example.entity")
@ComponentScan(basePackages = "com.example.dao com.example.service com.example.utility com.example.validator")
public class SpringConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
	}
	
	@Bean("sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        
        sessionFactoryBean.setDataSource(dataSource);
        
        sessionFactoryBean.setPackagesToScan("com.example.entity");
        
        Properties hibernateProperties = new Properties();
       
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.format_sql", "false");
        
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        
        return sessionFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory, DataSource dataSource) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
	}
}
