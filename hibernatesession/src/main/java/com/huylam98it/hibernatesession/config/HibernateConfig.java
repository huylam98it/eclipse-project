package com.huylam98it.hibernatesession.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		datasource.setUrl(env.getProperty("spring.datasource.url"));
		datasource.setUsername(env.getProperty("spring.datasource.username"));
		datasource.setPassword(env.getProperty("spring.datasource.password"));
		return datasource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean sessionf = new LocalSessionFactoryBean();
		sessionf.setDataSource(dataSource());
		sessionf.setPackagesToScan("com.huylam98it.hibernatesession.model");
		Properties p = new Properties();
		p.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		p.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		sessionf.setHibernateProperties(p);
		sessionf.afterPropertiesSet();
		return sessionf.getObject();
	}

	@Bean
	public HibernateTransactionManager transactionManager() throws IOException {
		return new HibernateTransactionManager(sessionFactory());
	}
}
