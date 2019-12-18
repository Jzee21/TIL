# Python 101

## 1. 저장

### 1) 숫자

```python
a = 7
b = 3
```



### 2) string

```bash
# 1. 글자 합체
str = "git" + " " + "huuuuuuuuuuuuub"
print(str)

# 2. 글자 삽입
name = "한글이?"
age = 20
text = "Hi? My name is {}!! My age is {}!".format(name, age)
f_text = f"Hi? My name is {name}!! My age is {age}!"

# 3. 글자 자르기
text_name = text[:15]       # [start:end]
print(text_name)

text_name = text[15:]
print(text_name)

text_split = text.split()   # .split() return [list]
print(text_split)
```

```python
sample = ...
print(sample[0])
print(sample[-1])	# -index is possible
					# last of list
```



### 3) 참/거짓

```python
참 = True
거짓 = False

if 참 :			# True = 1
    print(참)
```



### 4) List, Dictionary

```python
# List
menus = ["신라면", "진라면", "너구리", "짜파게티"]	# Korea Fast Noodles
print(menus)	# ['신라면', '진라면', '너구리', '짜파게티']
print(menus[0])	# 신라면

# Dictionary
dict_nums = {
    "신라면" : "001",
    "진라면" : "005",
    "너구리" : "002",
    "짜파게티" : "003"
}

print(dict_nums)	# {'신라면': '001', '진라면': '005', '너구리': '002', '짜파게티': '003'} 
print(dict_nums["진라면"])		# 005
print(dict_nums.get("신라면"))	# 001
```




## 2. 조건

### 1) if, elif, else

```python
dust = 120

if dust > 150 :
    print("So Bad")
elif dust > 100 :
    print("Bad")
else:
    print("Good")
```

```python
if number%2 :	# 1 : True
    print("홀")
else:
    print("짝")
```

```python
if a>=90 and b>80 :	# use `and` insteadof '&&'
    print(True)
```





## 3. 반복

### 1) for

```python
menus = ["신라면", "진라면", "너구리", "짜파게티"]

for menu in menus :
    print(menu)
```



## 4. 기타

### 1) Index

```python
a = input()				# {init}
b = input("input >")	# input >{init}
print(a)
print(type(a))
```



### 2) sort, sorted

```python
prices = input()	# 입력 예시: 300000;20000;10000
prices = prices.split(";")	# split

boxes = []
for price in prices :           # string list -> int list
    boxes.append(int(price))

# sorted() : 원본 데이터 유지	origin data no changed
# Integer O, String x
print(sorted(prices))

# sort() : 원본 데이터 유지	origin data changed
boxes.sort() 
# reverse list
boxes.reverse()
```

