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



#### 1. MySQL 설치 (standalon 방식 사용)

> `mysql-5.6.47-winx64.zip` 를 다운받아 압축 해제한다.



#### 2. MySQL Demon 실행

> 압축 해제된 경로에서 CMD(consol) 실행한다.
>
> 해당 consol이 실행되는 동안 서비스(Demon)이 실행된다.
>
> ```r
> > mysqld
> ```



#### 3. DB 설정

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



