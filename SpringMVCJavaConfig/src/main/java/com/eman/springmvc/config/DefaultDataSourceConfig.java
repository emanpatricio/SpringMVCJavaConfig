package com.eman.springmvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("default")
public class DefaultDataSourceConfig implements DataSourceConfig{

	@Value("${dataSource.driverClassName}")
	private String driver;
	
	@Value("${dataSource.url}")
	private String url;
	
	@Value("@{dataSource.username}")
	private String username;
	
	@Value("@{dataSource.password}")
	private String password;
	
	@Override
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	
}
