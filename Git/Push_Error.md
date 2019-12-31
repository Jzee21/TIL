## Push Error

- 다른 로컬 저장소에서 진행한 작업을 또다른 로컬 저장소에서 이어나갈 경우

  `pull`을 진행하지 않고 진행한 다음 `push`를 진행할 때 아래의 에러가 발생할 수 있다.

- 이는 원격 저장소의 이력과 로컬 저장소의 이력이 다를 때 발생하는 에러이다.

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

  이 메세지를 보게 된다면,

  - 원격 저장소(Github)의 커밋 이력과 로컬 저장소에서 `git log`를 이용한 결과를 서로 비교하여

    다른 부분을 체크한다.

  - `pull`을 이용하여 변경 내용을 통합한 후 다시 `push`한다.

  ```bash
  $ git log --oneline
  d93c5a9 Update .....
  465d681 Edit.....
  8cf1b68 Add .....
  06da258 Edit.....
  e94b5c9 Add .....
  
  $ git pull origin master
  # merge
  $ git push origin master
  ```

 