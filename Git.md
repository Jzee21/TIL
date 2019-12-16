수업 전 넉두리?

`객체`  주어와 동사다

`클래스`  사람이다

`인스턴스`  사람 누구누구다

---

# Git 기초

## 0. 준비 사항

+ [Git bash](https://gitforwindows.org/)
  + git을 활용하기 위한 CLI(Command Line Interface)를 제공한다
  + 추후 source tree, github desktop 등을 통해 GUI 환경에서도 활용 가능하다.



## 1. 로컬 저장소 활용하기

### 1. 저장소 초기화

```bash
$ git init
Initialized empty Git repository in C:/Users/student/Desktop/J.ze/Til/.git/
```

+ 저장소(repository)를 초기화 하게 되면, `.git`폴더가 해당 디렉토리에 생성된다.
+ bash ckddptjsms `(master)` 라고 표기된다.
  + 현재 브랜치가 master라는 것을 의미함.



### 2. add - staging area

> git으로 관리되는 파일들은 Working directory(작업환경), Staging Area, commit 단계를 거쳐 이력에 저장된다.

```bash
$ git add a.txt		# 파일명
$ git add images/	# 폴더명
$ git add .			# 현재 디렉토리의 모든 파일 및 폴더
```



+ add` 전 상태

```bash
student@M160221 MINGW64 ~/Desktop/J.ze/Til (master)
$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        Git.md
        Image/
        markdown.md

nothing added to commit but untracked files present (use "git add" to track)

```

+ add 후 상태

```bash
student@M160221 MINGW64 ~/Desktop/J.ze/Til (master)
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   Git.md
        new file:   "Image/\354\240\234\353\252\251 \354\227\206\354\235\214.png"
        new file:   markdown.md

```



### 3. commit

> commit은 코드의 이력을 남기는 과정이다.

```bash
$ git commit -m {커밋 메세지}

student@M160221 MINGW64 ~/Desktop/J.ze/Til (master)
$ git commit -m '마크다운 및 git 기초 정리'
[master (root-commit) d9cce4a] 마크다운 및 git 기초 정리
 3 files changed, 154 insertions(+)
 create mode 100644 Git.md
 create mode 100644 "Image/\354\240\234\353\252\251 \354\227\206\354\235\214.png"
 create mode 100644 markdown.md
```

+ 커밋 메세지는 항상 해당 이력에 대한 정보를 담을 수 있도록 작성하는 것이 좋다.
+ 일관적인 커밋 메세지를 작성하는 습관을 들이자.
+ 이력 확인을 위해서는 아래의 명령으를 활용한다.

```bash
$ git log
commit d9cce4a4f28560b3f2b43f544e72d02b83839db3 (HEAD -> master)
Author: Jzee21 <jzee21b@gmail.com>
Date:   Mon Dec 16 14:25:45 2019 +0900

    마크다운 및 git 기초 정리
```



**항상 status 명령어를 통해 git의 상태를 확인하자!**

**commit 이후에는 log 명령어를 통해 이력들을 확인하자!**



## 2. 원격 저장소 활용하기

