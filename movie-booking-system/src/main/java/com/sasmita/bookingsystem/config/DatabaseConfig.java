package com.sasmita.bookingsystem.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class DatabaseConfig {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource seoDataSource() {
		return DataSourceBuilder.create().build();
	}
}
