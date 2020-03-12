# Data Manipulation

> 데이터 조작 (**data manipulation**)
>
> ​	SQL처럼 빅데이터 내에서 필요한 정보를 추출하는 방법

> 실습에는 `ggplot2` package 내부의 `mpg` dataset을 사용한다.
>
> ```R
> install.packages("ggplot2")
> library(ggplot2)
> 
> mpg     # table 형식
>         # Fuel Economy Data From 1999 To 2008 For 38 Popular Models Of Cars
> 
> df <- as.data.frame(mpg)
> ```



## 기본함수

> 데이터 조작에서 쓸 수 있는
>
> R에서 제공되는 기본적인 함수들에 대해서 알아본다.

### 0. 목차

1. [class()](#1.-class())
2. [ls()](#2.-ls())
3. [head()](#3.-head())
4. [tail()](#4.-tail())
5. [View()](#5.-view())
6. [dim()](#6.-dim())
7. [nrow()](#7.-nrow())
8. [ncol()](#8.-ncol())
9. [str()](#9.-str())
10. [length()](#10.-length())
11. [summary()](#11.-summary())



### 1. class()

```R
# > 1. class()  : 자료구조를 알고싶을때 - 자료구조가 문자열로 출력
# 
class(df)     # [1] "data.frame"
```



### 2. ls()

```R
# > 2. ls()     : data frame에 적용하면 컬럼을 출력(retrun vector)
# 
ls(df)
# [1] "class"        "cty"          "cyl"          "displ"        "drv"          "fl"          
# [7] "hwy"          "manufacturer" "model"        "trans"        "year" 
```



### 3. head()

```R
# > 3. head()   : 데이터의 앞쪽 6개만 출력
#				 head(df, row) - row 개만 출력
# 
head(df)
#   manufacturer model displ year cyl      trans drv cty hwy fl   class
# 1         audi    a4   1.8 1999   4   auto(l5)   f  18  29  p compact
# 2         audi    a4   1.8 1999   4 manual(m5)   f  21  29  p compact
# 3         audi    a4   2.0 2008   4 manual(m6)   f  20  31  p compact
# 4         audi    a4   2.0 2008   4   auto(av)   f  21  30  p compact
# 5         audi    a4   2.8 1999   6   auto(l5)   f  16  26  p compact
# 6         audi    a4   2.8 1999   6 manual(m5)   f  18  26  p compact
```



### 4. tail()

```R
# > 4. tail()   : 데이터의 뒤쪽 6개 출력
# 
tail(df)
#     manufacturer  model displ year cyl      trans drv cty hwy fl   class
# 229   volkswagen passat   1.8 1999   4   auto(l5)   f  18  29  p midsize
# 230   volkswagen passat   2.0 2008   4   auto(s6)   f  19  28  p midsize
# 231   volkswagen passat   2.0 2008   4 manual(m6)   f  21  29  p midsize
# 232   volkswagen passat   2.8 1999   6   auto(l5)   f  16  26  p midsize
# 233   volkswagen passat   2.8 1999   6 manual(m5)   f  18  26  p midsize
# 234   volkswagen passat   3.6 2008   6   auto(s6)   f  17  26  p midsize
```



### 5. View()

```r
# > 5. View()   : View 창을 이용해서 데이터 출력
# 
View(df)
```



### 6. dim()

```R
# > 6. dim()    : 행과 열의 갯수를 출력
# 
dim(df)     # [1] 234  11
```



### 7. nrow()

```R
# > 7. nrow()   : 행의 갯수
# 
nrow(df)    # [1] 234
```



### 8. ncol()

```R
# > 8. ncol()   : 열의 갯수
# 
ncol(df)    # [1] 11
```



### 9. str()

```R
# > 9. str()    : data frame의 전반적인 정보를 출력
# 
str(df)
# 'data.frame':	234 obs. of  11 variables:
# $ manufacturer: chr  "audi" "audi" "audi" "audi" ...
# $ model       : chr  "a4" "a4" "a4" "a4" ...
# $ displ       : num  1.8 1.8 2 2 2.8 2.8 3.1 1.8 1.8 2 ...
# $ year        : int  1999 1999 2008 2008 1999 1999 2008 1999 1999 2008 ...
# $ cyl         : int  4 4 4 4 6 6 6 4 4 4 ...
# $ trans       : chr  "auto(l5)" "manual(m5)" "manual(m6)" "auto(av)" ...
# $ drv         : chr  "f" "f" "f" "f" ...
# $ cty         : int  18 21 20 21 16 18 18 18 16 20 ...
# $ hwy         : int  29 29 31 30 26 26 27 26 25 28 ...
# $ fl          : chr  "p" "p" "p" "p" ...
# $ class       : chr  "compact" "compact" "compact" "compact" ...
```



### 10. length()

```R
# > 10. length()  : 갯수를 구하는 함수
#               ! data frame에 적용시키면 column의 갯수 반환
# 
length(df)    # [1] 11
```



### 11. summary()

```R
# > 11. summary() : 간단한 통계치를 보여준다.(숫자에 대해서)
# 
summary(df)
# manufacturer          model               displ            year           cyl       
# Length:234         Length:234         Min.   :1.600   Min.   :1999   Min.   :4.000  
# Class :character   Class :character   1st Qu.:2.400   1st Qu.:1999   1st Qu.:4.000  
# Mode  :character   Mode  :character   Median :3.300   Median :2004   Median :6.000  
#                                       Mean   :3.472   Mean   :2004   Mean   :5.889  
#                                       3rd Qu.:4.600   3rd Qu.:2008   3rd Qu.:8.000  
#                                       Max.   :7.000   Max.   :2008   Max.   :8.000  
# trans               drv                 cty             hwy             fl           
# Length:234         Length:234         Min.   : 9.00   Min.   :12.00   Length:234        
# Class :character   Class :character   1st Qu.:14.00   1st Qu.:18.00   Class :character  
# Mode  :character   Mode  :character   Median :17.00   Median :24.00   Mode  :character  
#                                       Mean   :16.86   Mean   :23.44                   
#                                       3rd Qu.:19.00   3rd Qu.:27.00                     
#                                       Max.   :35.00   Max.   :44.00                     
# class          
# Length:234        
# Class :character  
# Mode  :character
```



## dplyr 패키지







```R
install.packages("ggplot2")
library(ggplot2)
install.packages("dplyr")
library(dplyr)
library(xlsx)
```

