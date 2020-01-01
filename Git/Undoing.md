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

  





