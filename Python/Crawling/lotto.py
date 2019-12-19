'''
import random

numbers = random.sample(range(1,46), 6)
numbers.sort()

# Add 12.19
url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=836"

print(numbers)


# Add 12. 19
# requests
import requests

response = requests.get("https://www.naver.com").text
print(response)
'''
# python init
import random
import json

import requests
from bs4 import BeautifulSoup as bs

numbers = random.sample(range(1,46), 6)
numbers.sort()

# Add 12.19
url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=836"

response = requests.get(url)
#print(response.text)

lotto = json.loads(response.text)
# print(lotto)
# print(lotto["drwtNo6"])

print()
winner = []
bnusNo = []
for i in range(1, 7) :
    winner.append(lotto.get(f"drwtNo{i}"))
    # winner.append(lotto["drwtNo" + str(i)])
bnusNo.append(lotto.get("bnusNo"))

print(winner)
print(bnusNo)

def pickLotto() :
    picked = sorted(random.sample(range(1, 46), 6))
    matched = len(set(winner) & set(picked))    # Same num check

    if matched == 6 :
        print("1등")
    elif matched == 5 :
        print("3등")
    elif matched == 4 :
        print("4등")
    elif matched == 3 :
        print("5등")
    else :
        print("꽝")

print(pickLotto)