# Commit Undoing

### 1. commit undoing

1. 커밋 메세지 수정

   ```bash
   $ git commit --amend
   [master 62f] Add b.txt + amend modify
    Date: Wed Dec 18 10:15:17 2019 +0900
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 b.txt
   ```

* 바로 직전에 `commit`한 내용만을 변경한다. 그 외의 `commit messate`도 수정할 수는 있으나 수정하지 않는 것이 좋다.

* `vim` 이 실행되며, `vim`에서 `commit message`를 수정하면 된다.

* `commit message`를 수정하는 경우 해시 값이 변경되므로 다른 이력으로 관리가 된다.

  **따라서, 공개된 저장소(원격 저장소)에 이미 push된 경우 절대 수정해서는 안된다.**



2. 특정 파일 추가하기

   > c.txt 파일을 같이 `commit` 하려고 하였으나, add를 하지 않고 `commit`한 경우

   ```bash
   $ git add c.txt
   $ git commit --amend
   [master 1b9] Add b.txt + amend modify + Add c.txt
 Date: Wed Dec 18 10:15:17 2019 +0900
    2 files changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 b.txt
    create mode 100644 c.txt
   
   $ git status
   On branch master
   nothing to commit, working tree clean
   ```
   
   - `commit --amend`가 `commit`을 실시한 시점으로 이동하여 `commit`을 다시 진행하기 때문에
   
     add 되어있는 파일을 다시 `commit`할 수 있다.
   
      

### 2. Staging Area

1. Commit 이력이 있는 파일을 수정하는 경우

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

   - `Changes not staged ...` : 변경 사항이 `Working Directory`에 있지만, `Staging Area`에 없다.
   - `(use "git add <file>...` : `Staging Area`로 보내기 위해 ~를 실행하라
   - `(use "git restore <file>...` : `Staging Area`에서 제외하고자 한다면 ~를 실행하라.

     

2. add 취소하기

   ```bash
   $ git restore --staged a.txt
   $ git status
   On branch master
   Changes not staged for commit:
     (use "git add <file>..." to update what will be committed)
     (use "git restore <file>..." to discard changes in working directory)
           modified:   a.txt
   
   no changes added to commit (use "git add" and/or "git commit -a")
   ```

   - `$ git restore --staged <file>` : unstage	(19' F/W 추가 명령어)

   - 구버전의 `git`에서는 아래의 명령어를 사용해야 한다.

     > `$ git reset HEAD <file>`

    

### 3.  Working Directory 변화 삭제하기

1. Working Directory 변경내용 삭제

   > git에서는 모든 commit 시점으로 되돌릴 수는 있다.
   >
   > 다만, Working Directory를 삭제하는 것은 되돌릴 수가 없다.

   ```bash
   $ git status
   On branch master
   Changes not staged for commit:
     (use "git add/rm <file>..." to update what will be committed)
     (use "git restore <file>..." to discard changes in working directory)
           deleted:    a.txt
           deleted:    b.txt
           deleted:    c.txt
   
   no changes added to commit (use "git add" and/or "git commit -a")
   
   $ git restore .
   $ git status
   On branch master
   nothing to commit, working tree clean
   ```

   - `$ git restore <file>`

   - 구버전의 `git`에서는 아래의 명령어를 사용해야 한다.

     > `$ git checkout --<file>`

    

 