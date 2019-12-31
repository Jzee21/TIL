---

# Git 기초

## 0. 준비 사항

+ [Git bash](https://gitforwindows.org/)
  + Git을 활용하기 위한 `CLI(Command Line Interface)`를 제공한다
  + Source tree, Github Desktop 등을 통해 `GUI 환경`에서도 활용 가능하다.
  
+ 사전 지식

  1. 로컬 저장소와 원격 저장소

     - 저장소에는 파일과 디렉토리를 관리하고 이들의 변경 이록을 기록할 수 있다.

     - 저장소는 주로 컴퓨터의  `로컬 저장소`와 서버 등 네트워크상의 `원격 저장소`로 나뉘며,

       기본적으로는 로컬 저장소에서 작업을 수행하고 그 결과를 원격 저장소에 저장한다.

  2. 커밋과 푸시

     > Git에서 가장 중요한 개념

     - **커밋(commit) : 파일을 추가하거나 변경 내용을 저장소에 저장하는 작업**
     - **푸시(push) : 파일을 추가하거나 변경한 내용을 원격 저장소에 업로드하는 작업**

  3. 브랜치(branch)

     - 브랜치는 흐음을 분기하여 기록하는 것을 말한다.

       분기한 하나의 지점은 다른 지점의 영향을 받지 않기 때문에 

       같은 저장소에서 별도의 개발을 진행할 수 있다.

 

 

## 1. 로컬 저장소 활용하기

### 1. 저장소 초기화

```bash
$ git init
Initialized empty Git repository in C:/Users/student/Desktop/J.ze/Til/.git/
# or
$ git clone {clone url}		# 하단 원격 저장소 참고
```

+ 저장소(repository)를 초기화 하게 되면, `.git`폴더가 해당 디렉토리에 생성된다.
+ bash 창에서는 `(master)` 라고 표기된다. 
  + 현재 브랜치가 master라는 것을 의미함.

 

### 2. add - Staging Srea

> git으로 관리되는 파일들은 
>
> Working directory(작업환경), Staging Area, commit 단계를 거쳐 이력에 저장된다.

```bash
$ git add a.txt		# 파일명
$ git add images/	# 폴더명
$ git add .			# 현재 디렉토리의 모든 파일 및 폴더
```

 

+ add 전 상태

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
$ git add .
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
$ git commit -m {Commit Message}

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

- `git log --oneline`을 사용하면 commit이 각각 한줄로 표시된다.

 

> **항상 status 명령어를 통해 git의 상태를 확인하자!**
>
> **commit 이후에는 log 명령어를 통해 이력들을 확인하자!**

 

 

## 2. 원격 저장소 활용하기

> 원격 저장소(remote repository)를 제공하는 서비스는 다양하게 존재한다.
>
> 로컬 저장소에서 실행된 add, commit 의 이력을 원격 저장소에 저장하여 활용할 수 있다.
>
> 여기서는 github를 기준으로 설명한다.

 

### 0. 준비하기

+ Github에서 저장소(repository) 생성

 

### 1. 원격 저장소 설정

```bash
$ git remote add origin {github url}
						https://github.com/Jzee21/TIL.git
```

+ 원격 저장소(remote repository)을 origin 이라는 이름으로 추가(add)하는 명령어이다.
+ {github url} 부분에는 원격 저장소의 url을 작성한다.
+ 원격 저장소 목록을 보기 위해서는 아래의 명령어를 활용한다.

```bash
$ git remote -v
origin  https://github.com/Jzee21/TIL.git (fetch)
origin  https://github.com/Jzee21/TIL.git (push)
```

 

### 2. push

```bash
$ git push origin master
```

+ 설정된 원격 저장소(origin)으로 push!

> 폴더의 내용을 수정 및 삭제, 생성 등을 하게 된다면, `add, commit 명령어`를 통해서 이력을 저장하고`push 명령어`를 통해 업로드 한다.

 

### 3. clone

```bash
$ git clone {clone url}
```

- 원격 저장소에 업로드 된 내용을 가져올 때 사용한다.
- `{clone url}`은 Github의 Repository 에서 `Clone or download`을 클릭하여 링크를 복사할 수 있다.
- `clone` 명령어는 `init` 명령어와 같이 `Git 저장소`를 생성하여 원격저장소의 내용을 저장하기 때문에 `init` 명령을 실행할 필요가 없다.

 

### 4. pull

```bash
$ git pull origin master
```

- 원격 저장소와 로컬 저장소를 동기화 할 때 사용된다.
- branch에서 더욱 자세하게 설명한다.

 

 ### 주의사항

> Github 사이트의 Repository(원격 저장소)에서 직접적으로 수정을 할 경우 
>
> 로컬 저장소에서 push할 때 에러가 발생할 수 있다.
>
> 따라서, 모든 변경은 로컬 저장소의 `git bash`에서 진행하도록 하자.

 

 

 ## Reference link

- [Git](https://git-scm.com/book/ko/v2)

+ [Git Commit Tip](https://meetup.toast.com/posts/106)

+ [Gitignore](https://www.gitignore.io/)

  > Git으로 관리하지 않을 파일 목록(.gitignore)을 만들어주는 사이트
  >
  > .gitignore 파일에 등록된 파일 또는 경로는 필터링되어 Git 에 업로드되지 않는다.

- https://tagilog.tistory.com/377
- https://rogerdudler.github.io/git-guide/index.ko.html

 