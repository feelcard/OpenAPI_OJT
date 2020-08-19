package com.test.tutorial.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author feelcard
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.test.tutorial.spring.dao"),
      @ComponentScan("com.test.tutorial.spring.service") })
public class AppConfig {

   @Bean
   public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
      LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
      factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
      System.out.println("LocalEntityManagerFactoryBean Created");
      return factoryBean;
   }

   @Bean
   public JpaTransactionManager geJpaTransactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      System.out.println("JpaTransactionManager construtor");
      transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
      System.out.println("JpaTransactionManager Created");
      return transactionManager;
   }
}