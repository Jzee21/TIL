# Git status & undoing

## 1. commit

* 새로운 파일 생성 후 commit

  ```bash
  (master) $ touch a.txt
  
  (master) $ git commit
  On branch master
  
  Initial commit
  
  Untracked files:
          a.txt
  # commit 할 파일이 없지만,	 # -> Staging area가 비어있음
  # untracked file이 있다   # -> git commit 이력에 담기지 않은 파일이 있다
  nothing added to commit but untracked files present
  ```

  

* a.txt 삭제 후

  ```bash
  # WD x, Staging area x
  (master) $ git commit
  On branch master
  
  Initial commit
  # 어떠한 변경 사항도 없음.
  nothing to commit
  ```



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



### commit undoing

1. 커밋 메세지 수정

   ```bash
   $ git commit --amend
   ```

* 커밋이 `vim` 창에서 수정이 된다.

* 커밋 메세지를 수정하는 경우 해시 값이 변경되므로, 다른 이력으로 관리가 된다.

  **따라서, 공개된 저장소(원격 저장소)에 이미 push된 경우 절대 수정해서는 안된다.**



2. 특정 파일 추가하기

   * 상황) c.txt 파일을 같이 커밋 하려고 하였으나, add를 하지 않고 커밋해버렸다.

   ```bash
   $ git add c.txt
   $ git commit --amend
   ```

   

### Staging area

### 1. 커밋 이력이 있는 파일을 수정하는 경우

```bash
$ git status
On branch master
# 변경 사항인데(WD o) stagint area x
Changes not staged for commit:
# git add로 staging area로 보낼 수 있다
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt

no changes added to commit (use "git add" and/or "git commit -a")
```



```bash
$ git add a.txt
$ git status
On branch master
Changes to be committed:
# unstage 하기 위해서(stagint area에서 제외하기 위해서)
  (use "git restore --staged <file>..." to unstage)
        modified:   a.txt
```



### add 취소하기

```bash
$ git restore --staged <file>	## 19 F/W 신상 명령어
```

* 구버전의 git에서는 아래의 명령어를 사용해야 한다.

  ```bash
  $ git reset HEAD <file>		## 재고정리? 명령어
  ```

  

## WD 변화 삭제하기

> git에서는 모든 commit 시점으로 되돌릴 수는 있다.
>
> 다만, WD 삭제하는 것은 되돌릴 수가 없다.

```bash
$ git restore <file>
```

* 구버전 git

  ```bash
  $ git checkout --<file>
  ```

  







