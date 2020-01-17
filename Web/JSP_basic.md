# JSP & Servlet

## 1. JSP

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- ....... -->
    <!-- scriptlet -->
    <%
        //코드 작성(변수선언, 제어문 등)
        String str = "3. JSP를 이용한 출력입니다.";
    %>

    <!-- 선언문 -->
    <%!
        // 자바의 변수, 함수 등의 선언 가능
        public int show() {
            out.print("Show method call");	// error. out cannot be resolved
            return 3+5;
        }
    %>

    <!-- 표현식 -->
    <%=
        // 내부에서 변수나 함수에 ; 를 붙이지 않고 사용
        "표현식으로 출력 : " + str
    %>
    <%= show() %>
    
    <!-- 지시어 -->
    <%@
    	// include / page / taglib
    %>
    
</html>
```



![image-20200117094612189](C:\Jzee\_Til\Web\Image\image-20200117094612189.png)

![image-20200117094527189](C:\Jzee\_Til\Web\Image\image-20200117094527189.png)



> shift + alt + s
>
> Override/Implements Methods...

![image-20200117100954388](C:\Jzee\_Til\Web\Image\image-20200117100954388.png)

![image-20200117101051415](C:\Jzee\_Til\Web\Image\image-20200117101051415.png)

> HttpServlet - doPost, doGet

![image-20200117101121558](C:\Jzee\_Til\Web\Image\image-20200117101121558.png)



> Post 방식, Get 방식 모두 요청을 받아도 처리될 수 있도록 작성

```java
package com.sds.date;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet.");
	}
	
	
}
```



> Web Server에서 해당 파일을 구동하기 위해서는 서버에 등록이 필요하다.
>
> 등록하는 방법에는 2가지가 있다.
>
> 1. xml을 이용한 경로 지정

![image-20200117102344926](C:\Jzee\_Til\Web\Image\image-20200117102344926.png)

![image-20200117102810865](C:\Jzee\_Til\Web\Image\image-20200117102810865.png)

> Web-app 하위에
>
> servlet, servlet-mapping을 추가했다.
>
> welcome-file-list 에서는 웹에 접속했을 때 최초로 보여질 페이지를 순차적으로 찾는 리스트



> 2. *어노테이션*(Annotation)(@)을 이용한 등록

![image-20200117104535995](C:\Jzee\_Til\Web\Image\image-20200117104535995.png)

> Line 11
>
> 어노테이션 `WebServlet`을 추가하고 뒤에 표시될 url을 추가한다.
>
> 이 경우 Line 6 처럼 새로운 패키지가 추가된다.