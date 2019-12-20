from flask import Flask, render_template, request
from decouple import config
import requests
import random

app = Flask(__name__)

token = config('TELEGRAM_BOT_TOKEN')
chat_id = config('CHAT_ID')

app_url = f"https://api.telegram.org/bot{token}"

# root
@app.route('/')
def hello() :
    return "Hi?"

@app.route('/write')
def write() :
    # HTML
    return render_template("write.HTML")

@app.route('/send')
def send() :
    message = request.args.get("message")
    msg_url = app_url + f"/sendMessage?chat_id={chat_id}&text={message}!"
    # send message to Telegram from get
    requests.get(msg_url)

    return "Message Send Success이야"

# Ready for Webhook
@app.route(f"/{token}", methods=['POST'])
def telegram() :
    response = request.get_json()
    resp_id = response['message']['from']['id']
    resp_msg = response['message']['text']
    print(f"[message]\nfrom id : {resp_id}\nmessage : {resp_msg}")

    # return get message
    return_msg = resp_msg

    # if msg = lotto / 로또, return_msg = lotto numbers
    # or return_msg = resp_msg
    if resp_msg == "lotto" or resp_msg == "Lotto" or resp_msg == "로또" :
        picked = sorted(random.sample(range(1, 46), 6))
        return_msg = ""
        for pick in picked :
            return_msg += f"{pick} "

    msg_url = app_url + f"/sendMessage?chat_id={resp_id}&text={return_msg}"
    requests.get(msg_url)
    
    # return body, status_code
    return '', 200


# debug
if __name__ == "__main__":
    app.run(debug=True)