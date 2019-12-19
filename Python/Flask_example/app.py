from flask import Flask, render_template, request
import datetime
import datetime as dt
import random
import time

# Flask server's name : app
app = Flask(__name__)

# @~ : cover codes
# now, management url
@app.route("/")
def hello() :
    return "hello world"

@app.route("/dday")
def dday() :
    today = datetime.datetime.now()
    final = datetime.datetime(2020, 6, 9)
    return f"now : {today} \nend : {final} \n-{(final-today).days} day"

@app.route("/isitchristmas")
def isitchristmas() :
    today = dt.datetime.now()
    # today = dt.datetime(2019, 12, 19)
    month = today.month
    day = today.day
    christmas = dt.datetime(today.year, 12, 25)
    if month == 12 and day == 25 :
        return "Yes"
    else :
        return "No. D{:+d}".format((-(christmas-today)).days)

@app.route("/movies")
def movies() :
    movies = ["Frozen 2", "클라우스", "나홀로집에", "어뱌웃타임", "러브 액츄얼리"]
    return render_template("movie.html", movies=movies)

@app.route("/greeting/<name>")
def greeting(name) :
    return f"안녕하세요! {name}님!"

@app.route("/cube/<int:num>")
def cube(num) :
    return str(num**3)

# 식사 메뉴 추천
# 1. random
# 2. DR_url : route("/lunch/1 2 3 4")
#       - list : ["", "", "", ""]
#       - <int:num> 숫자 만큼 뽑기
@app.route("/lunch/<int:num>")
def lunch(num) :
    lunchs = ["햄버거", "스테이크", "짜장면", "짬뽕", "샐러드", "에너지드링크", "냉면", "냉모밀",
                "분짜", "오므라이스", "짬뽕밥", "탕수육", "유산슬"]
    picks = []
    picks_str = ""
    if num > len(lunchs) :
        num = len(lunchs)
    
    picks = random.sample(lunchs, num)
    for pick in picks :
        picks_str += str(pick) + "\n"
    # for i in random.sample(lunchs, num) :   # random.sample(range(len(lunchs)), num)
    #     picks.append(lunchs[i])
    #     picks_str += str(lunchs[i]) + "\n"
    
    # return picks_str
    return render_template("lunch.html", lunchs=picks, items=len(lunchs), text = "Lunch List")

@app.route("/vonvon")
def vonvon() :
    return render_template("vonvon.html")

@app.route("/gotmademe")
def gotmademe() :
    name = request.args.get("name")
    if name == "" :
        name = "이름없는놈"
    first_list = ["잘생김", "이쁨", "못생김", "착하게생김", "참하게생김"]
    second_list = ["애교", "잘난척", "쑥쓰러움", "멍청함"]
    third_list = ["허세", "식욕", "찌질함", "돈복"]
    # time.sleep(3)
    first_pick = random.sample(first_list, 1)
    second_pick = random.sample(second_list, 1)
    third_pick = random.sample(third_list, 1)

    return render_template("gotmademe.html", name=name, first = first_pick[0], second=second_pick[0], third = third_pick[0] )

'''
def method (str, **args) :
    여러개의 인자 전달 가능

'''


if __name__ == "__main__":
    app.run(debug = True)