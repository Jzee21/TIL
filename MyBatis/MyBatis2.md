# MyBatis

> MyBatis with Spring



## Java Application 에서 사용

> Run As - Java Application

1. 라이브러리
   - `porm.xml `에 `mybatis.jar` 요청 작성
   - 프로젝트 설정의 `Java Build Path`에서 `ojdbc6.jar` 등록
2. mybatis-config.xml
   - JDBC Driver, URL, ID, PW 등록  >>  `SqlSession` 생성
3. mapping.xml
   - Qurey문 관리(select, insert, delete, update)



## Web Server 에서 사용

> Run As - Run on Server

1. 라이브러리

   - `porm.xml` 에 필요 라이브러리들 요청 작성
     - [mybatis.jar](https://mvnrepository.com/artifact/org.mybatis/mybatis) - 기존과 동일
     - [spring-jdbc.jar](https://mvnrepository.com/artifact/org.springframework/spring-jdbc) - Spring의 버전과 동일한 버전(4.3.18)
     - [mybatis-spring.jar](https://mvnrepository.com/artifact/org.mybatis/mybatis-spring) - user 수가 제일 많은 버전(1.3.2)
   - Oracle Driver 추가
     - `src \ main \ webapp \ WEB-INF \ lib \ ojdbc6.jar` 등록
     - (lib 폴더는 생성해야한다)
     - (기존의 Java Build Path에 등록한 것은 Spring에서 읽지 않는다)

2. DB 연결정보 설정

   - mybatis-config.xml
     - `<typeAliases>`만 지정
     - 나머지는 Spring에서 설정
   - mapping.xml
     - Query문 관리
     - 기존과 동일

3. VO 작성

   - sql 결과(레코드) - mapping 등록
   
4. DAO 작성

   - mybatis 코드 작성

5. Main 대신 Controller 작성

6. MyBatis-Spring 연동 설정파일(Spring Bean 설정파일)

   > JDBC의 Mybatis와 Spring에서의 Mybatis의 차이
   >
   > - JDBC : ConnectionPool == Spring : DataSource
   > - JDBC : Connection == Spring : SqlSessionTemplate == Mybatis SqlSession

    `src \ main \ webapp \ WEB-INF \ spring \ mybatis-spring.xml` 를

    새로 만들고, 아래 내용을 작성한다.

   

   1. DataSource : jdbc 설정(driver, url, id, pw)

   2. Config File 연결
      1. Typealias Name (mybatis-config.xml)
      2. Mapper File Name (emp-mapping.xml)

   3. SqlSessionTemplate Bean 생성

   

   - `mybatis-spring.xml`

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
   
   <!-- 1. DataSource 생성 -->
   	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
   		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
   		<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"></property>
   		<property name="username" value="hr"></property>
   		<property name="password" value="hr"></property>
   	</bean>
   
   <!-- 2. Mapper, Mybatis config file info -->
   	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
   		<property name="dataSource" ref="dataSource" />
   		<property name="configLocation" value="classpath:/edu/multi/mybatis/mybatis-config.xml" />
   		<property name="mapperLocations" value="classpath:/edu/multi/mybatis/emp-mapping.xml" />
   	</bean>
   
   <!-- 3. SqlSessionTemplate (Spring API) 생성 -->
   	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
   		<constructor-arg ref="sqlSessionFactory" />
   	</bean>
   
   </beans>
   ```

   





web.xml

```xml
<context-param>
	<param-name>contextConfigLocation</param-name>
	<!-- 경로가 여러개일 때 ',' 또는 줄바꿈으로 구분 -->
    <param-value>
		/WEB-INF/spring/root-context.xml 
		/WEB-INF/spring/mybatis-spring.xml
	</param-value>
</context-param>
```

servlet-context.xml

```xml
<!-- Enables the Spring MVC @Controller programming model -->
<annotation-driven />
<!-- Enables @Component @Service @Repository @Autowired  -->
<!--<context:component-scan base-package="edu.multi.mvc" />-->
<context:component-scan base-package="edu.multi.mybatis" />
<!-- 기존 context 아래에 사용할 패키지 경로 추가 -->
```

> `edu.multi.mvc`와 `edu.multi.mybatis`가 같은 내용이 있어 문제 발생
>
> 중첩되는 내용이 없고, 다수의 패키지를 사용할 때 `<context:componemt-scan>` 태그를 다수 사용하여 등록할 수 있다.









---

```java
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
    @Qualifier	<--	다수의 DB 사용 시
        			다수의 mybatis-spring.xml 파일 생성, 연결
	SqlSession session;
	
```

