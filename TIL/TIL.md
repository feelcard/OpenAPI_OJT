# JPA, Hibernate, Spring Data JPA

![JPA, Hibernate, Spring Data JPA의 전반적인 그림](./image/overall_design.png)



# DBCP

> JDBC에서 쿼리마다 매번 DB접속을 위한 드라이버 로딩 및 커넥션 객체 생성을 해야만 했던 부분을 메모리풀을 만들어서 커넥션 상태를 유지한채 쿼리를 보내는 것



Spring 어노테이션 설정시 주의사항

> @ComponentScan 시 최초 실행 될때 베이직 패키지 단위에서 한번에 컴포넌트를 스캔할 수있도록 구성해야함

오늘 했던거 박살남 내일 다시해서 반드시 완성 시킨다....

```java
//타임리프 설정소스
package com.test.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.ISpringTemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.test.tutorial.spring")
public class ThymeleafViewResolverConfig {

	ThymeleafViewResolverConfig() {
		super();
		System.out.println("ThymeleafViewResolverConfig created");
	}

	@Autowired
	private ApplicationContext applicationContext;

	private ITemplateResolver templateResolver() {

		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

		resolver.setApplicationContext(applicationContext);

		resolver.setPrefix("/WEB-INF/templates/");

		resolver.setSuffix(".html");

		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCacheable(false);

		return resolver;

	}

	@Bean

	public ViewResolver viewResolver() {

		ThymeleafViewResolver resolver = new ThymeleafViewResolver();

		resolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());

		resolver.setCharacterEncoding("UTF-8");

		return resolver;

	}

	@Bean

	public TemplateEngine templateEngine() {

		SpringTemplateEngine engine = new SpringTemplateEngine();

		engine.setEnableSpringELCompiler(true);

		engine.setTemplateResolver(templateResolver());

		return engine;

	}

}

```

**UUID** 가 **Auto increment** 보다 좋은 이유

UUID 테이블 안에서의 형식적 고유함이 아니라 범용적 고유함을 가질 수 있다는 점에서 다음과 같은 장점을 가질 수 있다.

1. 테이블을 분리하거나 합치는 과정에서 훨씬 편리함을 가져올 수 있다.
2. 분산 환경에서 개발할때 각자의 데이터를 병합하거나 테이블을 옮기는 과정에서 키값 때문에 충돌하는 상황을 배제할 수 있다.
3. 기본 키를 만들기 위해 데이터베이스에 연결할 필요가 없다. 각 언어에서 제공되는 라이브러리를 통해 객관적인 형태의 키생성을 할 수 있다. (insert 하는데 있어서 큰 제약이 없다.)