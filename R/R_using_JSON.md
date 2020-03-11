# R에서 JSON 사용하기

> JSON 형식의 데이터를 어디서 가져오는가?
>
> 1. DB에서 간단한 Servlet을 이용해 JSON을 받아온다.
> 2. Open API를 이용하여 JSON(또는 XML)을 받아온다.



## Database에서 JSON 받아오기

> 도서검색 프로그램을 이용해서 JSON을 사용하기

### 1. Database Setting

1. MySQL 설치 (standalon 방식 사용)
2. MySQL Demon 실행
3. DB 설정



#### 1-1. MySQL 설치 (standalon 방식 사용)

> `mysql-5.6.47-winx64.zip` 를 다운받아 압축 해제한다.



#### 1-2. MySQL Demon 실행

> 압축 해제된 경로에서 CMD(consol) 실행한다.
>
> 해당 consol이 실행되는 동안 서비스(Demon)이 실행된다.
>
> ```r
> > mysqld
> ```
>
> 서비스 종료는 별도 창에서 다음 명령어를 실행한다.
>
> ``` R
> > mysqladmin -u root shutdown
> ```
>
> 



#### 1-3. DB 설정

> 별도의 CMD(consol)을 실행한다.
>
> ```r
> 
> C:\App\mysql-5.6.47-winx64\bin > mysql -u root
> #-------------------------------------------------
> Welcome to the MySQL monitor.
> .....
> 
> # 유저 생성
> mysql> create user book identified by "book";
> Query OK, 0 rows affected (0.00 sec)
> 
> mysql> create user book@localhost identified by "book";
> Query OK, 0 rows affected (0.00 sec)
> 
> # DB 생성
> mysql> create database library;
> Query OK, 1 row affected (0.01 sec)
> 
> # DB 권한설정
> mysql> grant all privileges on library.* to book;
> Query OK, 0 rows affected (0.00 sec)
> 
> mysql> grant all privileges on library.* to book@localhost;
> Query OK, 0 rows affected (0.00 sec)
> 
> # 적용사항 새로고침
> mysql> flush privileges;
> Query OK, 0 rows affected (0.00 sec)
> 
> mysql> exit
> Bye
> 
> #-------------------------------------------------
> 
> C:\App\mysql-5.6.47-winx64\bin >
> mysql -u book -p library < _BookTableDump.sql
> 
> ```



### 2. Server Setting

> apache-tomcat-7.0.100-windows-x64.zip
>
> eclipse 기본설정(encoding)
>
> 프로젝트 import(제공)
>
> web program 호출 테스트
>
> - http://localhost:8080/bookSearch/search?keyword= {검색어}



### 3. R에서 외부 Web Application 호출

> R에서 외부 Web Application에 요청하여 받은 결과를
>
> Data Frame으로 받는다.

#### 3-1. JSON -> Data Frame

> JSON 데이터를 Data Frame으로 바꾸기 위해
>
> 외부 Package  `jsonlite`  를 사용한다.

1. `jsonlite`  설치

   ```R
   install.packages("jsonlite")
   install.packages("curl")
   require(jsonlite)       # JSON 처리를 위해
   require(stringr)        # 문자열 처리를 위해
   require(curl)			# jsonlite package의 의존성 package
   ```

    

2. `jsonlite`  사용하기

   ```R
   # 수업에서 제공받은 외부 Web Application 호출 경로 (return JSON)
   url <- "http://localhost:8080/bookSearch/search?keyword="
   
   # 기본 url에 검색 키워드 입력
   request_url <- str_c(url, scan(what=character()))
   request_url
   
   # 요청 결과(JSON)을 Data Frame에 저장
   df <- fromJSON(request_url)
   
   # 결과 확인
   View(df)
   
   # 콘솔 출력
   df$title
   # or
   for (i in 1:nrow(df)) {
     print(df$title[i])
   }
   ```



---

## 외부 API에서 JSON 받아오기

> 영화진흥위원회 Open API를 사용한다.
>
> 날짜 기준 일별 박스오피스 순위(1~10위)를 받아온다.



``` r
# 인증 key를 포함한 요청 url
mUrl <- "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=@___I'm_Sorry___@="

# 기준일 설정
request_mUrl <- str_c(mUrl, "20200310")
request_mUrl

# 데이터 요청 및 저장
mdf <- fromJSON(request_mUrl)
mdf
View(mdf)

# 데이터 세부내용 확인
# my
mdf <- mdf$boxOfficeResult$dailyBoxOfficeList

mdf
View(mdf)

# prof
mdf[[1]]
mdf[["boxOfficeResult"]]
mdf[["boxOfficeResult"]][["dailyBoxOfficeList"]]
```



### 추가

> 기상청의 날씨 예보정보를 불러오는 것도 테스트 해보았다.

```R
wUrl <- "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=@___I'm_Sorry___@&base_date=20200311&base_time=1100&nx=61&ny=125&numOfRows=160&pageNo=1&dataType=json"

wdf <- fromJSON(wUrl)
wdf_items <- wdf$response$body$items$item
View(wdf$response$body$items)
View(wdf_items)
```

