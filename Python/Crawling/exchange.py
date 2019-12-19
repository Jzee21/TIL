import requests
from bs4 import BeautifulSoup as bs

# url = "https://finance.naver.com/marketindex/"

# response = requests.get(url).text
# soup = bs(response, 'html.parser')
# result = soup.select_one('.value')    # class #
# print(f"미국USD 환율 : {result.text}")

res = requests.get("https://finance.naver.com/marketindex/").text
soup = bs(res, 'html.parser')
result = soup.select_one('.value')
print(f"미국USD 환율 : {result.text}")

# file save
# with : 스코프.    # heavy, high resorce.
with open('exchange_text.txt', 'w', encoding='utf-8') as f :
    f.write(f"현재 원/달러 환율 : {result.text}")
