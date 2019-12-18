# Stash

> 변경사항을 임시로 저장 해놓는 공간
>
> 마지막 커밋 시점으로 되돌려준다.

```
1. feature branch에서 a.txt 변경 후 커밋
2. master branch에서 a.txt 수정 (no add, commit)
3. merge
```

```bash
(master)
$ git merge feature
error: Your local changes to the following files would be overwritten by merge:
        a.txt
Please commit your changes or stash them before you merge.
Aborting
Updating 087e6e7..e087732
```



## 명령어

stash 저장

```bash
(master)
$ git stash
Saved working directory and index state WIP on master: 087e6e7 Edit a.txt
```

stash 목록

```bash
(master)
$ git stash list
stash@{0}: WIP on master: 087e6e7 Edit a.txt
```

stash 불러오기

```bash
$ git stash pop		# 불러오기 + 목록에서 삭제
# $ git stash apply	# 불러오기
# $ git stash drop	# 목록에서 삭제
```





## 해결

```bash
$ git stash		# 임시 저장 공간
$ git merge feature		# 병합
$ git stash pop			# 임시 공간에서 불러오기
Auto-merging a.txt
CONFLICT (content): Merge conflict in a.txt
The stash entry is kept in case you need it again.
# 충돌 발생, 해결 후 작업 이어가기...
```

```
aaaaaaaa
<<<<<<< Updated upstream
퓨처퓨처
=======
마스터마스터
>>>>>>> Stashed changes
```

