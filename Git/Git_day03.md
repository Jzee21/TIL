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

   





### +) commit 메세지 작성하기

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

