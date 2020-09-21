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



spring boot로 만든 프로젝트가 아닌데 maven springframework.boot 라이브러리를 사용해도 되는지 궁금합니다.



칼럼은 uuid 로 id를 만들기로 하였고 어노테이션 설정을 이용해 BINARY로 저장하도록 구성함 ,  UUID.randomUUID()를 통해 값을 생성하고 toString을 이용해 값을 확인한 후 insert 함, 해당 결과를 워크벤치를 이용해 쿼리를 불렀을때 id값이 BLOB로 insert되어 있는것을 확인하였습니다.

그리고 JPA를 통해 해당 값들을 호출 하였을때는 기존에 insert 하였던 UUID 값과 다른 값이 불러져 오는것을 확인 이유가 무엇인지 궁금합니다.



 현재 구성한 DaoTest 클래스의 형태는 스프링 컨테이너 위에서 동작하는 테스팅이 아닌 단순히 JVM에 스프링컨테이너의 형태인것 처럼 올려서 동작시키는 테스트 형태라고 생각합니다.

처음에 질문했던 문제가 해결되면 스프링부트 관련 어노테이션을 사용하여 가능할 것 이라고 생각되는데 이 외에도 다른 방법이 존재하는지 궁금합니다.



https://happyer16.tistory.com/entry/Spring-JPA-%EB%8B%A4%EB%8C%80%EB%8B%A4-%EC%84%A4%EC%A0%95-%EB%B0%8F-%EC%A3%BC%EC%9D%98-Many-To-Many

Package 구조 설정

보통은 3depth를 기준으로 com(컴포넌트).기관명.프로젝트이름 이 default 구경태과장님 같은 경우







서버리스 백엔드를 위한 Managed API Gateway ㅤ 

ㅤ→ Cloud Functions, Cloud Run, App Engine 등의 기능을 하나의 관문(Gateway) 으로 관리하여 보안과 유연한 배포및 확장성을 추가한 형태



> Cloud Functions : 사용한 만큼만 지불하는 확장 가능한 서비스로서의 기능(FaaS)을 통해 서버 관리 없이 코드 실행
> 코드를 작성하여 배포하면 함수단위로 인스턴스를 생성하여 비즈니스로직을 처리하는 기능(자바 ,파이썬, js 지원)
> 
> 
>
> cloud Run : 매니지드 컴퓨트 서비스의 하나로, HTTP 요청으로는 기동할 수 있는 스테이트리스 컨테이너를 구동할 수 있다. 또한 구글 쿠버네티스 엔진에서도 이용할 수 있는데, 이를 통해 컨테이너화된 HTTP 워크로드를 매니지드 쿠버네티스 클러스터에서 구동할 수 있다. 
> 배경지식이 부족하여 간략한 설명이 불가능 하나 이해한 단계로서는 docker와 쿠버네틱스를 융합한 상위 프레임워크 정도로 이해함
> 
> 
>
> 원문보기:[http://www.ciokorea.com/news/120742#csidx6641eab692b4743b4d6d8b7e09b603f 
>
> 
>
>  App Engine
>
> 아마존의 EC2처럼 IaaS환경에서 App,DB,Webserver,OS,모니터링,로드밸런싱, 업그레이드 등
> 자원만 빌려주고 모든사항을 관리해야하는 systemAdmin이 필요한  반면 앱 엔진의 경우 애플리케이션(개발 코드) 에 대한 부분만 관리하며 그왜 systemAdmin은 Google이 담당함 다만 EC2보다 비용은 비쌈





※스프링 환경설정 구성할 때 항상 패키지 스캔 문장을 넣었는지 확인



domain이라 함은 entity와 같은 의미이므로 entity만 관리하는 것이 좋다.




커스텀 쿼리를 사용해야할 때 어떤것을 사용해야 할지?

1. spring specification
2. querydsl
3. jooq
4. 등등등



엔티티 작성시 hashcode에 대한설정을 제대로 하지않으면 중복선언이 될수있다(?)

# Spring Security

스프링 시큐리티는 인증과 인가의 개념을 알아야한다.

- 인증(Authentication): 서버에 로그인을 시도하는 유저의 정보가 서버 DB에 저장되어 있는 유저와 내용이 같은지 확인
- 인가(Auhorization): 인증을 마친 유저에 대한 특정 권한을 부여하는 것

