# 원격 저장소 활용하기 (부제 - 집에서 복습하기)

## 준비사항

* 멀티캠퍼스 컴퓨터에 git 저장소

```bash
$ git init
$ touch a.txt	# new file 'a.txt'
$ git add .
$ git commit -m 'init'
```



* 집 컴퓨터에 git 저장소

```bash
$ git clone {url}
```



* github 원격 저장소

## 시나리오

> 작업을 완료한 이후에는 항상 push,
>
> 작업을 시작하기 전에는 항상 pull !!!
>
> > (문제가 발생했을 경우 해결 방법도 추가될 예정)

1. 멀캠 도착

   ```bash
   
   ```

2. 멀캠 작업

   ```bash
   # 임의의 파일 수정/생성 등
   $ git add .
   $ git commit -m 'msg'
   ```

3. 멀캠 퇴근

   ```bash
   $ git push origin master
   ```

4. 집 도착

   ```bash
   $git pull origin master
   ```

5. 집 작업

   ```bash
   # 임의의 파일 수정/생성 등
   $ git add .
   $ git commit -m 'msg'
   ```

6. 집 나가기

   ```bash
   $ git push origin master
   ```





> `#` 강제 에러 만들어버리깃!

## 충돌상황

만약, 원격저상소의 이력과 로컬 저장소의 이력이 다른 경우에는 아래의 에러가 발생한다.

```bash
$ git push origin master
To https://github.com/Jzee21/Database.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://github.com/Jzee21/Database.git'
# 원격 저장소의 작업내용(work - commit)과 로컬 내용이 다르다.
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
# 원격 저장소의 변경사항(changes)을 통합하고 다시 Push하라
# 통합 예) git pull...
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```

**이 메세지를 보게 된다면, 로컬에서 `git log`, `원격저장소(github)`의 `커밋 이력`들을 확인하고 다른 부분을 체크하자.

```bash
$ git pull origin master
```

통합 후,

```bash
$ git push origin master
```



















> ## 마크다운 기반 블로그
>
> 정적 탬플릿 생성기 :  md->html/css 바꿔주기



> ## Jekyll
>
> 꽤 오래되고 레퍼런스가 많음
>
> 카카오 기술블로그 기반



> ## Gatsby
>
> 최신 프레임워크. github octoverse 기준으로 2019년 가장 많이 성장한 오픈소스 프로젝트 Top 10.
>
> 최근 웹 트렌드 기술(react, graphql)이 반영되어 있음.

