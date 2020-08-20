package com.test.tutorial.spring.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.test.tutorial.spring.entity.User;

/**
 * @author feelcard
 *
 */
@Configuration// �ش� java ������ Spring���� �������� ����ϰڴ�
@PropertySource("classpath:db.properties")//Environment��ü�� �ش� ��ο� �ִ� ������Ƽ ���� �ڵ����� ���Եȴ�.
@EnableTransactionManagement//DataSourceTransactionManager ���� ã�� Transaction Manager�� ����մϴ�.
//interface ���°� �����Ǳ� ������ DataSource�� ã�� ����Ѵ�(?)
@ComponentScans(value = { @ComponentScan("com.test.tutorial.spring.dao"),
      @ComponentScan("com.test.tutorial.spring.service") })//com.blbl.*�� ����Ͽ��� �����ϴ�.
public class AppConfig {

	 @Autowired//Bean���� ��ϵǾ� �ִ°͵��� Environment ���¸� �����.
	   private Environment env;

	   @Bean// �� �Լ��� ���������� ����ϴ� Bean�� �������شٴ� ���� ����ϴ� ������̼�
	   public DataSource getDataSource() {// DBeCP ���� �Լ�
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(env.getProperty("db.driver"));
	      dataSource.setUrl(env.getProperty("db.url"));
	      dataSource.setUsername(env.getProperty("db.username"));
	      dataSource.setPassword(env.getProperty("db.password"));
	      return dataSource;
	   }

	   @Bean
	   public LocalSessionFactoryBean getSessionFactory() {
		   //�� ����� ��ü�� ��ȯ�ϴ°� �ƴ϶� getObject() �޼ҵ尡 ȣ��ǰ� �� �޼ҵ忡 ���ؼ� ��ȯ�ȴ�.
	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();//factoryBean ��ü ����
	      factoryBean.setDataSource(getDataSource());
	      
	      Properties props=new Properties();//���丮�� ����� ������Ƽ ��ü ����
	      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

	      factoryBean.setHibernateProperties(props);
	      factoryBean.setAnnotatedClasses(User.class);
	      return factoryBean;
	   }

	   @Bean
	   public HibernateTransactionManager getTransactionManager() {
	      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	      transactionManager.setSessionFactory(getSessionFactory().getObject());
	      return transactionManager;
	   }
}