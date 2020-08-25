# JPA, Hibernate, Spring Data JPA

![JPA, Hibernate, Spring Data JPA의 전반적인 그림](./image/overall_design.png)



# DBCP

> JDBC에서 쿼리마다 매번 DB접속을 위한 드라이버 로딩 및 커넥션 객체 생성을 해야만 했던 부분을 메모리풀을 만들어서 커넥션 상태를 유지한채 쿼리를 보내는 것



Spring 어노테이션 설정시 주의사항

> @ComponentScan 시 최초 실행 될때 베이직 패키지 단위에서 한번에 컴포넌트를 스캔할 수있도록 구성해야함


오늘 했던거 박살남 내일 다시해서 반드시 완성 시킨다....