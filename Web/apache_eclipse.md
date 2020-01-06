> tomcat path 설정

![image-20200106171109236](./Image/image-20200106171109236.png)



> Oracle, tomcat port 중복(8080)
>
> -> Oracle port 변경(9090)

```sql
sqlplus system/oracle
-- login system account
select dbms_xdb.gethttpport() from dual;
-- check oracle port
exec dbms_xdb.sethttpport(9090);
-- change oracle port 8080 to 9090
```



> Eclipse 프로젝트 생성
>
> New - Dynamic Web Project

![image-20200106171445422](./Image/image-20200106171445422.png)

> workspace content type 변경

![image-20200106170718765](./Image/image-20200106170718765.png)

> CSS
>
> Java Properties File
>
> Java Source File
>
> JavaScript Source File
>
> JSP
>
> > Default encodeing : `UTF-8`로 변경



> `WebContent` 경로 아래에 `html`, `jsp` 폴더 생성

![image-20200106164706853](./Image/image-20200106164706853.png)

![image-20200106163310696](./Image/image-20200106163310696.png)

![image-20200106163335639](./Image/image-20200106163335639.png)

> `WebContent/jsp` 경로에 `serverTest.jsp` 파일 생성

![image-20200106164636277](./Image/image-20200106164636277.png)

![image-20200106163419244](./Image/image-20200106163419244.png)

> `EUC-KR` 들을 `UTF-8`으로 변경 (3개)

![image-20200106163441120](./Image/image-20200106163441120.png)

![image-20200106163514048](./Image/image-20200106163514048.png)

![image-20200106163606325](./Image/image-20200106163606325.png)

> Error
>
> - `jsp.jar` not found

![image-20200106163632257](./Image/image-20200106163632257.png)

> Solution
>
> ~\lib    <-    jsp
>
> Tomcat's .jar -> java's lib

![image-20200106163836306](./Image/image-20200106163836306.png)

> 3개의 files
>
> C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext 에 복사

![image-20200106163956295](./Image/image-20200106163956295.png)

> add line 10

![image-20200106164313180](./Image/image-20200106164313180.png)



`Ctrl + F11` 실행

![image-20200106164534753](./Image/image-20200106164534753.png)



> browser 추가 및 기본값 설정

![image-20200106165217268](./Image/image-20200106165217268.png)

> firefox 등 다른 브라우저 사용 시 우측 New로 추가
>
> 우리는 Chrome 사용

![image-20200106165256931](./Image/image-20200106165256931.png)



> 내용 추가

![image-20200106165737362](./Image/image-20200106165737362.png)

> line 4
>
> ```html
> <%@ page import="java.util.*" %>
> ```
>
> line 14, 15
>
> ```html
> <% Date today = new Date(); %>
> <%= today %>
> ```

