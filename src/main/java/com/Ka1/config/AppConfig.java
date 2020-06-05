package com.Ka1.config;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.Ka1")
@EnableTransactionManagement     //启用基于注解的事务管理
public class AppConfig {
	private Logger log = Logger.getLogger(AppConfig.class);
	
	@Bean   //由spring 自动调用这个代码，并创建  datasource , 交由spring托管
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/res?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");//
		dataSource.setUsername("root");
		dataSource.setPassword("a");
		log.info("创建数据源"+ dataSource+"成功");
		return dataSource;
	}

	@Bean
	public    DataSourceTransactionManager  tx(  DriverManagerDataSource ds    ){
		log.info(   "创建事务管理器,"+  ds );
		DataSourceTransactionManager dtm=new DataSourceTransactionManager();   // jdbc 事务管理器
		dtm.setDataSource(   ds );
		return dtm;
	}
}
