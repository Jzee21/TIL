# Git status

## 1. commit

1. Working Directory 는 있으나 Staging Area는 비어있는 상황

   ```bash
   $ touch a.txt
   
   $ git commit
   On branch master
   
   Initial commit
   
   Untracked files:
           a.txt
   
   nothing added to commit but untracked files present
   ```

   - `nothing added to commit` 
     - commit 할 것이 없다	: Staging Area가 비어있다.
   - `untracked files present'
     - untracked file이 있다	: `git commit` 이력이 담기지 않은 파일은 있다.

    

2. Working Directory 와 Staging Area 둘 다 비어있는 상황.

   ```bash
   $ git commit
   On branch master
   
   Initial commit
   
   nothing to commit
   ```

   - 어떠한 변경 사항도 없다.



### status

1. 새로운 파일 생성 후 status

   ```bash
   (master) $ touch a.txt
   (master) $ git status
   On branch master
   
   No commits yet
   # commit 이력에 담긴 적 없는 파일
   Untracked files:
   # 커밋 될 목록(staging area)에 추가하려면, git add <file>
     (use "git add <file>..." to include in what will be committed)
           a.txt
   
   nothing added to commit but untracked files present (use "git add" to track)
   ```

   

2. a.txt Add 후

   ```bash
   (master) $ git add a.txt
   
   (master) $ git status
   On branch master
   
   No commits yet
   # 커밋 될 변경사항들
   Changes to be committed:
     (use "git rm --cached <file>..." to unstage)
           new file:   a.txt
   ```

   





### commit 메세지 작성하기

> #### 부제 - vim 활용 기초

	$ git commit
	# Please enter the commit message for your changes. Lines starting
	# with '#' will be ignored, and an empty message aborts the commit.
	#
	# On branch master
	#
	# Initial commit
	#
	# Changes to be committed:
	#       new file:   a.txt
	#

* 편집(입력)모드 : `i`
  * 문서 편집 기능
* 명령 모드 : `esc`
  * `dd` - 해당 줄 삭제
  * `:wq` - 저장 및 종료
    * `w` : write
    * `q` :quit
  * `:q!` : 강제종료
    * `!` : 강제

```bash
$ git commit -m 'commit message'
```

* 커밋 메세지는 항상 해당 작업 이력을 나타낼 수 있도록 작성한다.
* 일관적인 포맷으로 작성하도록 노력한다.



### log

> git commit은 해시 값(hash value)에 의해서 구분된다.
>
> git에서는 SHA-1 해시 알고리즘을 사용하여 표현한다.

```bash
$ git log
commit 4c5b24d58346fca6b60b05b09352e4bb688c85b0 (HEAD -> master)
Author: Jzee21 <jzee21b@gmail.com>
Date:   Wed Dec 18 09:42:48 2019 +0900

    Add a.txt

    * a.txt 내용 추가
```

```bash
$ git log --oneline
4c5b24d (HEAD -> master) Add a.txt
$ git log -1
$ git log --oneline --graph
$ git log -1 --oneline
```



