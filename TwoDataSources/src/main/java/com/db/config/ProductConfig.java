package com.db.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.db.entity.Product;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		                basePackages = "com.db.repo.product",
		                entityManagerFactoryRef = "productEnityManager",
		                transactionManagerRef = "productTransactionManager")
public class ProductConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "product.datasource")
	public DataSourceProperties productDataSourceProp()
	{
		return new DataSourceProperties();
	}
    @Bean
	public DataSource productDataSource()
	{
		return productDataSourceProp().initializeDataSourceBuilder()
				.type(BasicDataSource.class).build();
				
	}
    @Bean(name="productEnityManager")
    public LocalContainerEntityManagerFactoryBean productEnityManager(EntityManagerFactoryBuilder builder)
    {
    	return builder.dataSource(productDataSource()).packages(Product.class).build();
    }
    @Bean(name ="productTransactionManager")
    public PlatformTransactionManager productTransactionManager(@Qualifier("productEnityManager") LocalContainerEntityManagerFactoryBean entityManagerfactoryBean)
    {
    	return new JpaTransactionManager(entityManagerfactoryBean.getObject());
    }
}
