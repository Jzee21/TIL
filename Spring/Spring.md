![image-20200121134225713](Image/image-20200121134225713.png)

> `Eclipse Marketplace` 에서 `Spring Tools 3 Add-On for Spring Tools 4 3.9.11.RELEASE` 설치

![image-20200121135429444](Image/image-20200121135429444.png)

![image-20200121135442296](Image/image-20200121135442296.png)





---



일반 Java 프로젝트에 pom.xml 추가하기

![image-20200123113228053](../../Docu/취업특강/프로젝트 관리/Image/image-20200123113228053.png)



일반 Java 프로젝트에 Spring Nature 추가하기

![image-20200123113300525](../../Docu/취업특강/프로젝트 관리/Image/image-20200123113300525.png)



![image-20200123132342203](../../Docu/취업특강/프로젝트 관리/Image/image-20200123132342203.png)

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <!-- ....... -->
  <build>
	<!-- ....... -->
  </build>
  
  <!-- Start -->
  <dependencies>
  	<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
	<dependency>
    	<groupId>org.springframework</groupId>
    	<artifactId>spring-context</artifactId>
    	<version>4.1.7.RELEASE</version>
	</dependency>
  </dependencies>
  <!-- End -->
</project>
```





Spring Context(Core)

![image-20200123113412884](../../Docu/취업특강/프로젝트 관리/Image/image-20200123113412884.png)



//

![image-20200123131918730](../../Docu/취업특강/프로젝트 관리/Image/image-20200123131918730.png)

//

![image-20200123132259932](../../Docu/취업특강/프로젝트 관리/Image/image-20200123132259932.png)



//

![image-20200123134116838](../../Docu/취업특강/프로젝트 관리/Image/image-20200123134116838.png)



