# 이피앱 - 쿠폰시스템 

### 환경
- windows10
- jdk1.8
- IntelliJ
- 인코딩 utf-8

### 의존성

- Sring Boot DevTools
- Lombok
- Maria DB
- Spring Web


### DB 설정

```sql
create database yippeeapp;
use yippeeapp;
create user 'yippeeapp'@'%' identified by 'yippeeapp';
GRANT ALL PRIVILEGES ON *.* TO 'yippeeapp'@'%';
```

### yml 설정
```
server:
  servlet:
    context-path: /
    encoding:
      charset: utf-8
      enabled: true

spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp

  datasource:
    hikari:
    url: jdbc:mariadb://localhost:3306/yippeeapp?allowMultiQueries=true
    driver-class-name: org.mariadb.jdbc.Driver
    username: yippeeapp
    password: yippeeapp

  jpa:
    open-in-view: false
    generate-ddl: true
    show-sql: true
    hibernate:
      ddl-auto: update

jackson:
  serialization:
    fail-on-empty-beans: false
```
