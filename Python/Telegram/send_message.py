import requests
from decouple import config

# token = "734322713:AAEyR0Rys8zBhx7BesYSmP2TGWTKdHeZkzI"
token = config("TELEGRAM_BOT_TOKEN")
chat_id = config("CHAT_ID")
app_url = f"https://api.telegram.org/bot{token}"
# msg_url = app_url + f"/sendMessage?chat_id={}"

update_utl = app_url + "/getUpdates"

response = requests.get(update_utl).json()
# print(response)

# chat_id = response["result"][0]["message"]["chat"]["id"]
print(chat_id)

text = "Lunch Time soon! Pang Ha~"
message_url = app_url + f"/sendMessage?chat_id={chat_id}&text={text}!"

requests.get(message_url)