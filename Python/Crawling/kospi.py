import requests
import webbrowser
from bs4 import BeautifulSoup as bs

url = "https://finance.naver.com/"
url_sise = "https://finance.naver.com/sise/"

response = requests.get(url).text
soup = bs(response, 'html.parser')
result = soup.select_one('.num')
print(f"Kospi : {result.text}")

response_sise = requests.get(url_sise).text
soup_sise = bs(response_sise, 'html.parser')        
result_sise = soup_sise.select_one('#KOSPI_now')    # class #
print(f"Kospi : {result_sise.text}")
