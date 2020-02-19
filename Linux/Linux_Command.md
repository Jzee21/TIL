# Linux Command

---

## + 필수 명령어

```terminal
* <fimename>	-> <f>
* <directory>	-> <d>

cd				-- 디렉토리 이동
ls				-- 디렉토리 내부 파일 정보 확인
dir				-- 디렉토리 내부 확인(간단)

pwd				-- 현재 경로 확인

cat <f>			-- 파일 내용 출력 (입력x)
gedit <f>		-- 파일 내용 출력 (입력o)

touch <f>		-- 파일 생성 또는 실행(최종 수정 시간 변경)

cp <f1> <f2>	-- file1을 file2란 이름으로 복사
cp -r <d> <d>	-- 디렉토리 복사

mv <f> <d>		-- file을 해당 디렉토리로 이동
				   <d> 뒤에 <f>를 주면 변경된 파일명으로 이동

rm <f>			-- file 삭제
rm -i <f>		-- 삭제 여부 확인
rm -f <f>		-- 확인 없이 삭제
rm -r <d>		-- 디렉토리 삭제
rm -rf <d>		-- 하위 디렉토리까지 삭제(확인 없이!)**

----------------------------------------------------------
ls -a		-- 숨김파일 포함
   -l		-- 파일 권한 포함
   /<directory>		-- 해당 경로 내부 파일 정보

cat <f1> <f2>			-- file 1, 2 합쳐서 조회
cat <f1> <f2> > <f3>	-- file 1, 2 합쳐서 file3에 덮어쓰기
cat <f1> <f2> >> <f3>	-- file 1, 2 합쳐서 file3에 이어쓰기

history -c	-- history 기록 삭제
----------------------------------------------------------
shutdown -P now			-- P : poweroff		-- now : time
						-- r : reboot
						-- c : (shutdown cancel)
		 -r	+10			-- 10분 후 재부팅
halt -P
init 0					-- 0 : 0~6	run level
						-- 1 : rescue
						-- 3 : multi user mode (text)
						-- 5 : multi user mode (graphic)
						-- 6 : reboot

```


