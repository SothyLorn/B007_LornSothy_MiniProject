package org.khshrd.app.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("org.khshrd.app.repository")
public class MybatisConfiguration {
	private DataSource datasource;
	@Autowired
	public MybatisConfiguration(DataSource datasource){
		this.datasource=datasource;
	}
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(){
		return new DataSourceTransactionManager(datasource);
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception{
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(datasource);
		return sessionFactoryBean;
	}
}
