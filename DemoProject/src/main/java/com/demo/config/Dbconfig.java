package com.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import net.bytebuddy.build.ToStringPlugin.Enhance.Prefix;

@Configuration
public class Dbconfig {
	@Bean
	@Primary
	@ConfigurationProperties(prefix ="spring.firstdatasource" )
	public DataSource primaryds()
	{
		return DataSourceBuilder.create().build();
	}
    @Bean
    @ConfigurationProperties(prefix = "spring.seconddatasource")
	public DataSource secondarydb() {
    	return DataSourceBuilder.create().build();
		
	}
}
