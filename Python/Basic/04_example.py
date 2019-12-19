msg = "happy hacking!"

for i in range(5) :
    print(msg)

# List
menus = ["신라면", "진라면", "너구리", "짜파게티"]
print(menus)
print(menus[0])

print()
for i in menus :
    print(i)

# 전화번호부 저장하기
phone_nums = ["02-6574-3412", "02-6543-8431", "031-351-8646"]

# Dictionary
dict_nums = {
    "신라면" : "001",
    "진라면" : "005",
    "너구리" : "002",
    "짜파게티" : "003"
}

print()
print(dict_nums)
print(dict_nums)
print(dict_nums["진라면"])
print(dict_nums.get("신라면"))

