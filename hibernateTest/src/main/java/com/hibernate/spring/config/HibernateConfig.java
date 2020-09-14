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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.hibernate.spring.entity"})
@ComponentScan(basePackages = "com.hibernate.spring.*")
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
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(getDataSource());
    em.setPackagesToScan(new String[] {"com.hibernate.spring.entity"});
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    Properties props = new Properties();
    props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    props.put("hibernate.physical_naming_strategy",
        env.getProperty("hibernate.physical_naming_strategy"));
    props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    em.setJpaProperties(props);

    return em;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    System.out.println("PlatformTransactionManager execute");
    JpaTransactionManager transactionManager = new JpaTransactionManager();
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
// * hibernate 5���� ���� ī�� ���̽��� ������ũ ���̽��� �ٲٴ� ����Ʈ�� �������. ���� �ش����� ����ϱ� ����
// �̸���å�� ����ϱ� ����
// * PhysicalNamingStrategy �������̽��� ��ӹ޾� Ŀ�������� �����Ͽ� ���丮�� �������ش�.
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
