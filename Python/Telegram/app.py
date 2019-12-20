from flask import Flask, render_template, request
from decouple import config
import requests

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


# debug
if __name__ == "__main__":
    app.run(debug=True)