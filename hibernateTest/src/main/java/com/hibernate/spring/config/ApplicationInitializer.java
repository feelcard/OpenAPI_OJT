package com.hibernate.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {SecurityConfig.class};
  } // ... other overrides ... }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected String[] getServletMappings() {
    // TODO Auto-generated method stub
    return null;
  }

}
