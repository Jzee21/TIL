# Data preprocessing

> 데이터 정제(데이터 전처리)
>
> 데이터 분석 이전에, Raw 데이터(현장에서 수집된 가공되지 않은 데이터)를 분석이 가능한 형태로 가공하는 작업이 선행되어야 한다.
>
> 1. 결측치 해결
> 2. 이상치 처리



## 1. 결측치 해결

> 데이터의 수집 과정에서 데이터가 존재하지 않거나 오류로 인해서
>
> `NA` 값이 수집되었을 때, NA값을 처리해주어야 한다.

> `NA` 값의 양이 데이터 전체의 크기에 비해 상대적으로 적을 경우에는
>
> 해당 row를 삭제해도 결과에 영향이 적다.

```R
df <- data.frame(id=c(1,2,NA,4,NA,6),
                 score=c(20,30,NA,50,70,NA))
df
#   id score
# 1  1    20
# 2  2    30
# 3 NA    NA
# 4  4    50
# 5 NA    70
# 6  6    NA
```



### 1-1. 결측치를 확인하는 함수

#### 1) is.na()

> `NA`값이 있으면 `TRUE`로 표시한다.

```R
is.na(df)
#         id score
# [1,] FALSE FALSE
# [2,] FALSE FALSE
# [3,]  TRUE  TRUE
# [4,] FALSE FALSE
# [5,]  TRUE FALSE
# [6,] FALSE  TRUE

is.na(df$id)
# [1] FALSE FALSE  TRUE FALSE  TRUE FALSE
```



#### 2) filter() & is.na()

> `is.na()`가 `TRUE`를 반환하는것을 이용하여
>
> `NA`가 아닌 row만 골라낼 수 있다.

```R
# id가 NA인 row를 data frame에서 삭제
result <- df %>% filter(!is.na(df$id))
result
#   id score
# 1  1    20
# 2  2    30
# 3  4    50
# 4  6    NA

# df에서 NA가 포함된 모든 row를 삭제
result <- df %>% filter(!is.na(df$id), !is.na(df$score))
result
#   id score
# 1  1    20
# 2  2    30
# 3  4    50
```



#### 3) na.omit()

> 모든 `NA`를 찾아서 `NA가 포함된 row를 삭제`하는 함수

```R
result <- na.omit(df)
result
#   id score
# 1  1    20
# 2  2    30
# 4  4    50
```



### 1-2. 결측치를 해결하는 방법

> 1. `NA`값이 존재하는 `row`를 삭제한다.
>
> 2. `NA`값을 임의의 값으로 대체한다.
>
>    ex) 해당 컬럼의 평균값, 최소값, 최대값 등등등... (간단한 방법)



- 결측치가 있을 경우

  ```R
  mean(df$score)
  # [1] NA
  ```

  일부 연산이 불가능할 수 있다.



- 결측치를 무시하는 방법

  > `일부 함수`는 결측치를 무시하고 연산할 수 있는 옵션을 제공한다.

  ```r
  mean(df$score, na.rm = T)
  # [1] 42.5
  ```



#### 1) NA값이 존재하는 row 삭제

> `na.omit()` 등의 함수를 사용하여 NA값을 제외한다.



#### 2) NA값을 임의의 값으로 대체

> score의 NA값을
>
> score 안에 있는 NA를 제외한 모든 값의 평균으로 대체한
>
> 새로운 data frame을 만들어 사용한다.

```R
df$score <- ifelse(is.na(df$score),
                   mean(df$score, na.rm = T), df$score)
df
#   id score
# 1  1  20.0
# 2  2  30.0
# 3 NA  42.5
# 4  4  50.0
# 5 NA  70.0
# 6  6  42.5
```





## 2. 이상치 해결

> 1. 값이 없는것은 아닌데 사용할 수 없는 값이 포함된 경우
> 2. 극단치값이 포함되어 있는 경우

### 2-1. 값은 있으나 사용할 수 없는 값이 포함된 경우

```R
df <- data.frame(id=c(1,2,NA,4,NA,6),
                 score=c(20,30,NA,50,70,NA),
                 gender=c("M","F","M","F","M","F"))
df  # 정상값
# ------------------------------------------------------
df <- data.frame(id=c(1,2,NA,4,NA,6),
                 score=c(20,30,NA,50,70,NA),
                 gender=c("^^","F","M","F","M","F"),
#                       #  ㄴ 이상치 (^^)
                 stringsAsFactors = F)
df
#   id score gender
# 1  1    20     ^^
# 2  2    30      F
# 3 NA    NA      M
# 4  4    50      F
# 5 NA    70      M
# 6  6    NA      F
```

> 이상치는 일단 NA로 변환한 다음, NA를 처리하는 방식으로 진행

```R
df$gender <- ifelse(df$gender %in% c("M","F"),
                    df$gender,NA)
df
#   id score gender
# 1  1    20   <NA>
# 2  2    30      F
# 3 NA    NA      M
# 4  4    50      F
# 5 NA    70      M
# 6  6    NA      F
```



#### 2-2. 극단치값이 포함되어 있는 경우

> - 가중치가 붙어 결과에 큰 영향을 끼친다
> - 극단치에 대한 기준을 우리가 설정해야한다
>   - 논리적으로 이성적인 범위를 설정
>   - 통계적인 방법으로 이상적인 범위를 설정