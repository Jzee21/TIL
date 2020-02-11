여래개 View

(브라우저 종료 이전 / 브라우저에서 30분간 반응 X)



1. HttpSession 생성

   HttpSession session = request.getSession();

2. HttpSession 공유 정보 저장

   session.setAttribute("세션값이름", 객체)

3. HttpSession 저장 정보 추출

   ??? <- (형변환)session.setAttribute("세션값이름")

4. HttpSession 저장 정보 삭제

   session.removeAttribute("세션값이름")

5. HttpSession 소멸

   session.invalidate();

