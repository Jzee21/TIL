# Git status & undoing

# 1. commit

> * 파일 생성 후 commit
>
> ```bash
> (master) $ touch a.txt
> 
> (master) $ git commit
> On branch master
> 
> Initial commit
> 
> Untracked files:
>         a.txt
> # commit 할 파일이 없지만,	 # -> Staging area가 비어있음
> # untracked file이 있다   # -> git commit 이력에 담기지 않은 파일이 있다
> nothing added to commit but untracked files present
> ```
>
> * a.txt 삭제 후
>
> ```bash
> # WD x, Staging area x
> (master) $ git commit
> On branch master
> 
> Initial commit
> # 어떠한 변경 사항도 없음.
> nothing to commit
> ```
>
> 
>
> ㅇ
>
> ㅇ
>
> ㅇ
>
> ㅇ
>
> 