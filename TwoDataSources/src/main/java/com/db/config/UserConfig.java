package com.db.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.db.entity.User;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		               basePackages = "com.db.repo.user",
		               entityManagerFactoryRef = "userEnityManager",
		               transactionManagerRef = "userTransactionManager"
		                )
public class UserConfig {

	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "user.datasource")
	public DataSourceProperties userDataSourceProp() {
		
		return new DataSourceProperties();
	}
	
    @Bean
    @Primary
    public DataSource userDataSource() {
    	return userDataSourceProp().initializeDataSourceBuilder()
    			.type(BasicDataSource.class).build();
    }
    @Bean(name = "userEnityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean userEntityManager(EntityManagerFactoryBuilder builder)
    {
    	return builder.dataSource(userDataSource()).packages(User.class).build();
    }
    @Bean(name = "userTransactionManager")
    @Primary
    public PlatformTransactionManager userTransactionManager(@Qualifier("userEnityManager") LocalContainerEntityManagerFactoryBean enityManagerfactoryBean)
    
    {
      return new JpaTransactionManager(enityManagerfactoryBean.getObject());
    }
    
}
