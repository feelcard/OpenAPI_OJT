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



spring boot로 만든 프로젝트가 아닌데 springframework.boot 라이브러리를 사용해도 되는지?

칼럼은 uuid 로 id를 만들기로 하였고 어노테이션 설정을 이용해 BINARY로 저장하도록 구성함 ,  UUID.randomUUID()를 통해 값을 생성하고 toString을 이용해 값을 확인한 후 insert 함, 해당  결과를 워크벤치를 이용해 쿼리를 불렀을때 id값이 BLOB로 insert되어 있는것을 확인 그리고 JPA를 통해 해당 값들을 호출 하였을때는 기존에 insert 하였던 UUID 값과 다른 값이 불러져 오는것을 확인 이유가 무엇인지?

 현재 구성한 DaoTest 클래스의 형태는 스프링 컨테이너 위에서 동작하는 테스팅이 아닌 단순히 JVM에 스프링컨테이너의 형태인것 처럼 올려서 동작시키는 테스트 형태라고 생각함 처음에 질문했던 문제가 해결되면 스프링부트 관련 어노테이션을 사용하여 가능할 것 이라고 생각되는데 이 외에도 다른 방법이 존재하는지?

