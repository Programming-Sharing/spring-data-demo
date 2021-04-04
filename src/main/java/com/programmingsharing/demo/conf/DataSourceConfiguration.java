package com.programmingsharing.demo.conf;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DataSourceConfiguration {

	private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);

	@Bean
	public DataSource dataSource(C3P0DataSourceProperties dataSourcePros) throws PropertyVetoException {

		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		
		pooledDataSource.setDriverClass(dataSourcePros.getDriverClass());
		pooledDataSource.setUser(dataSourcePros.getUsername());
		pooledDataSource.setPassword(dataSourcePros.getPassword());
		pooledDataSource.setJdbcUrl(dataSourcePros.getUrl());
		pooledDataSource.setMaxPoolSize(dataSourcePros.getMaxPoolSize());
		pooledDataSource.setMaxIdleTime(dataSourcePros.getMaxIdleTime());
		pooledDataSource.setCheckoutTimeout(30000);
		pooledDataSource.setBreakAfterAcquireFailure(true);

		return pooledDataSource;
	}
}
