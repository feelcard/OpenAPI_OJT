# JPA, Hibernate, Spring Data JPA

![JPA, Hibernate, Spring Data JPA의 전반적인 그림](./image/overall_design.png)



# DBCP

> JDBC에서 쿼리마다 매번 DB접속을 위한 드라이버 로딩 및 커넥션 객체 생성을 해야만 했던 부분을 메모리풀을 만들어서 커넥션 상태를 유지한채 쿼리를 보내는 것