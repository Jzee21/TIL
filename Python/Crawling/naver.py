'''
1. requests > naver.com > response
2. response > bs4
3. webbrowser

'''
import requests
import webbrowser
from bs4 import BeautifulSoup as bs

url = "https://www.naver.com"
response = requests.get(url).text

# print(response)     # naver main all code

doc = bs(response, 'html.parser')   # html 파일 로드
                                    # 이후 html 태그로 검색 가능

# 속성값 접근
# . > class
# # > id
result = doc.select_one('.ah_k')    # 실검 1위
result = doc.select('.ah_k')        # 실검 목록들

# webbrowser.open(url)
search_url = "https://search.naver.com/search.naver?query="

for i in range(5) :
    print(result[i].text)           # 실검 1~5위
    webbrowser.open(search_url + result[i].text)      # 1~5위 브라우저로 실행
