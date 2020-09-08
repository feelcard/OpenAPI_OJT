package com.hibernate.spring.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
// @EnableJpaRepositories(basePackages = "com.hiberante.spring.entity")
@ComponentScan(basePackages = "com.hibernate.spring")
public class HibernateConfig {

  @Autowired
  private Environment env;

  @Bean // DB config
  public DataSource getDataSource() {
    System.out.println("DataSource execute");
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getProperty("db.driver"));
    dataSource.setUrl(env.getProperty("db.url"));
    dataSource.setUsername(env.getProperty("db.username"));
    dataSource.setPassword(env.getProperty("db.password"));
    return dataSource;
  }


  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    System.out.println("PersistenceExceptionTranslationPostProcessor execute");
    return new PersistenceExceptionTranslationPostProcessor();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    System.out.println("LocalContainerEntityManagerFactoryBean execute");
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(getDataSource());
    em.setPackagesToScan(new String[] {"com.hiberante.spring.entity"});
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);


    Properties props = new Properties();
    props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    em.setJpaProperties(props);

    return em;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    System.out.println("PlatformTransactionManager execute");
    final JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }



}


// @Bean // Hibernate config
// public LocalSessionFactoryBean getSessionFactory() {
// LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
// factoryBean.setDataSource(getDataSource()); // set DB configuration data
// factoryBean.setPhysicalNamingStrategy(new CustomPhysicalNamingStrategy());
// /*
// * hibernate 5버젼 부터 카멜 케이스를 스네이크 케이스로 바꾸는 디폴트가 사라졌다. 따라서 해당기능을 사용하기 위해 이름정책을 사용하기 위해
// * PhysicalNamingStrategy 인터페이스를 상속받아 커스텀으로 구현하여 팩토리빈에 설정해준다.
// */
// Properties props = new Properties();
// props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
// props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
// factoryBean.setHibernateProperties(props);
// factoryBean.setPackagesToScan("com.hibernate.spring.entity.*");
//
// return factoryBean;
// }


// @Bean
// public HibernateTransactionManager getTransactionManager() {
// HibernateTransactionManager transactionManager = new HibernateTransactionManager();
// transactionManager.setSessionFactory(entityManagerFactory().getObject());
// return transactionManager;
// }
