# Reset vs Revert

## Reset

> 공개된 저장소(원격 저장소)에 push된 이력은 절대 reset 하지 않는다.

```bash
$ git reset {hash_code}
```

* `기본(--mixed)` : 이후 변경 사항을 WD에 유지시켜줌

* `--hard` : 이후 변경 사항이 모두 삭제됨.

  **주의**

* `--sotf` : 지금 작업하고 있는 내용(WD) 및 변경사항을 WD에 유지시켜줌.



## Revert

> 해당 커밋으로 되돌렸다는 이력(revert commit)을 남긴다.

```bash
$ git revert {hash_code}
```

* vim `->` 커밋 메세지 작성

```bash
$ git log --oneline
e087732 (HEAD -> master, feature) Edit a.txt on feature
087e6e7 Edit a.txt

$ git revert e087732
[master e9053b8] Revert "Edit a.txt on feature"
 1 file changed, 1 insertion(+), 2 deletions(-)

$ git log --oneline
e9053b8 (HEAD -> master) Revert "Edit a.txt on feature"
e087732 (feature) Edit a.txt on feature
087e6e7 Edit a.txt
```

