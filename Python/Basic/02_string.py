# 02_string.py
'''
string 조작하기

    1. 글자 합체

    2. 글자 삽입(수술)

    3. 글자 자르기

'''

# 1. 글자 합체
hphk = "Happy" + " " +  "hacking"

print(hphk)

# 2. 글자 삽입
name = "한글이?"
age = 20

text = "Hi? My name is {}!! My age is {}!".format(name, age)
print(text)

f_text = f"Hi? My name is {name}!! My age is {age}!"
print(f_text)

# 3. 글자 자르기
text_name = text[:15]       # [start:end]
print(text_name)

text_name = text[15:]
print(text_name)

text_split = text.split()   # .split() return [list]
print(text_split)
