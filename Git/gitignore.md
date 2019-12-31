# .gitignore 란?

> Git이 관리하는 저장소 내에서 관리하지 않을 파일 또는 폴더를 설정하는 File이다.
>
> 따라서 Git을 통한 프로젝트 시작 시에는 반드시 만들도록 하자.



## 활용법

`.gitignore` 파일을 생성 후 git으로 관리하지 않을 파일의 목록을 작성한다.

```bash
# : comments

# no .xlsx files
*.xlsx

# but do track a.xlsx, even ignoring .xlsx files
!a.xlsx

# only ignore the test file in the current directory, not subdir/test
/test

# ignore all files in the build/ dicectory
build/

# ignore docu/note.txt, but not docu/test/note.txt
docu/*.txt

# ignore all .pdf files in the docu/ directory
docu/**/*.pdf
```

> 보통 `.gitignore`에 등록되는 파일은 IDE(eclipse) 설정과 관련된 내용 혹은 프로그래밍 언어별 임시 파일, 윈도우 등 OS 관련 파일을 등록한다. (프로젝트 소스코드와 무관)



[gitignore.io](https://www.gitignore.io/) 에서는 환경에 따라 `.gitignore`를 자동으로 생성해준다.

 