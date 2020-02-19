# Linux File System

---

## + 주요 경로

```
/						filesystem root
/root					root 계정 디렉토리
/home/user_account/		해당 계정 디렉토리
/etc/...				설정파일 디렉토리
/usr/...				모든 계정 사용 가능 디렉토리
```

## 파일 속성

```
[root@localhost ~]# ls -l
합계 8
-rw-------. 1 root root 1420  2월 18  2020 anaconda-ks.cfg
-rw-r--r--. 1 root root 1471  2월 18 11:08 initial-setup-ks.cfg
drwxr-xr-x. 2 root root    6  2월 18 11:10 공개
drwxr-xr-x. 2 root root    6  2월 18 11:10 다운로드
drwxr-xr-x. 2 root root    6  2월 18 11:10 문서
drwxr-xr-x. 2 root root    6  2월 18 11:10 바탕화면
drwxr-xr-x. 2 root root    6  2월 18 11:10 비디오
drwxr-xr-x. 2 root root    6  2월 18 11:10 사진
drwxr-xr-x. 2 root root    6  2월 18 11:10 서식
drwxr-xr-x. 2 root root    6  2월 18 11:10 음악

----------------------------------------------
d / rwx / r-x / r-x		|	- - -
1	2	  3		4		|	4 2 1  + => 7(max)
----------------------------------------------

1. d	- or d	: file or directory

2. rwx	- root 계정
		- r:read, w:write, x:execute

3. r-x	- root 그룹 계정


4. r-x	- 다른 사용자 그룹
```