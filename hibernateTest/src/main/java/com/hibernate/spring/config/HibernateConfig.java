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
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.hibernate.spring")
public class HibernateConfig {

  @Autowired
  private Environment env;

  @Bean // DB config
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getProperty("db.driver"));
    dataSource.setUrl(env.getProperty("db.url"));
    dataSource.setUsername(env.getProperty("db.username"));
    dataSource.setPassword(env.getProperty("db.password"));
    return dataSource;
  }

  @Bean // Hibernate config
  public LocalSessionFactoryBean getSessionFactory() {
    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
    factoryBean.setDataSource(getDataSource()); // set DB configuration data
    factoryBean.setPhysicalNamingStrategy(new CustomPhysicalNamingStrategy());
    /*
     * hibernate 5���� ���� ī�� ���̽��� ������ũ ���̽��� �ٲٴ� ����Ʈ�� �������. ���� �ش����� ����ϱ� ���� �̸���å�� ����ϱ� ����
     * PhysicalNamingStrategy �������̽��� ��ӹ޾� Ŀ�������� �����Ͽ� ���丮�� �������ش�.
     */
    Properties props = new Properties();
    props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    factoryBean.setHibernateProperties(props);
    factoryBean.setPackagesToScan("com.hibernate.spring.entity");
    // ������Ʈ ��ĵ���� ������ ���̹�����Ʈ���� ��ƼƼ�� �ν��ϱ� ���ؼ� ��Ű�������� ��ĵ�ϴ� ���� ����

    return factoryBean;
  }

  @Bean
  public HibernateTransactionManager getTransactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(getSessionFactory().getObject());
    return transactionManager;
  }


}
