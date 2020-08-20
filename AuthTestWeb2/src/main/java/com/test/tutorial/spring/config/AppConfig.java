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
@Configuration// 해당 java 파일을 Spring에서 설정으로 사용하겠다
@PropertySource("classpath:db.properties")//Environment객체에 해당 경로에 있는 프로터티 값이 자동으로 주입된다.
@EnableTransactionManagement//DataSourceTransactionManager 빈을 찾아 Transaction Manager로 사용합니다.
//interface 형태가 제공되기 때문에 DataSource를 찾아 사용한다(?)
@ComponentScans(value = { @ComponentScan("com.test.tutorial.spring.dao"),
      @ComponentScan("com.test.tutorial.spring.service") })//com.blbl.*로 사용하여도 무방하다.
public class AppConfig {

	 @Autowired//Bean으로 등록되어 있는것들중 Environment 형태를 차즌다.
	   private Environment env;

	   @Bean// 이 함수는 스프링에서 사용하는 Bean을 리턴해준다는 것은 언급하는 어노테이션
	   public DataSource getDataSource() {// DBeCP 설정 함수
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(env.getProperty("db.driver"));
	      dataSource.setUrl(env.getProperty("db.url"));
	      dataSource.setUsername(env.getProperty("db.username"));
	      dataSource.setPassword(env.getProperty("db.password"));
	      return dataSource;
	   }

	   @Bean
	   public LocalSessionFactoryBean getSessionFactory() {
		   //빈 선언시 객체를 반환하는게 아니라 getObject() 메소드가 호출되고 이 메소드에 의해서 반환된다.
	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();//factoryBean 객체 생성
	      factoryBean.setDataSource(getDataSource());
	      
	      Properties props=new Properties();//팩토리빈에 사용할 프로퍼티 객체 생성
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