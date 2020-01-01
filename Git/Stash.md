# Stash

> 변경사항을 임시로 저장 해놓는 공간
>
> 마지막 commit 시점으로 되돌려준다.
>
> Commit을 진행하기 전의 애매한 코드들을 Stash 공간에 넣어두고 merge를 진행한 후,
>
> 진행하고 있던 Stash 공간의 코드를 다시 가져와서 작업을 계속 진행한다.

## Problem

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

 

## Command

1. stash 저장

   ```bash
   $ git stash
   Saved working directory and index state WIP on master: 087e6e7 Edit a.txt
   ```

2. stash 목록

   ```bash
   $ git stash list
   stash@{0}: WIP on master: 087e6e7 Edit a.txt
   ```

3. stash 불러오기

   ```bash
   $ git stash pop		# 불러오기 + 목록에서 삭제
   $ git stash apply	# 불러오기
   $ git stash drop	# 목록에서 삭제
   ```

    

## Solution

```bash
$ git stash		# 임시 저장 공간
Saved working directory and index state WIP on master: 087 Edit a.txt

$ git merge feature		# 병합
Updating 087..e12
Fast-forward
 a.txt | 3 ++-
 1 file changed, 2 insertions(+), 1 deletion(-)

$ git stash pop			# 임시 공간에서 불러오기
Auto-merging a.txt
CONFLICT (content): Merge conflict in a.txt
The stash entry is kept in case you need it again.
# 충돌 발생, 해결 후 작업 이어가기...
```

- `git stash` : 작업중이던 내용을 임시공간에 저장
- `git stash pop` : 작업중이던 내용을 불러와서 계속 작업

```bash
aaaaaaaa
<<<<<<< Updated upstream
수정수정
=======
마스터마스터
>>>>>>> Stashed changes
```

