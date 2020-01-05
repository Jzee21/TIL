# Github Pages

> `Github`에서 제공하는 호스팅 서비스
>
> `.github.io` 라는 url로 접근 가능한 [`Github Pages`](https://pages.github.com/)는 개인 페이지(블로그)를 무료로 생성할 수 있다.
>
> 주로 개인 블로그, 특히 개발 블로그 용으로 인기가 높다.

 

### 1. 새 저장소(repository) 만들기

Github에 새 저장소(repository)를 만든다. 

이때 저장소의 이름은 자신의 username 뒤에 `.github.io`를 붙여준다.

이렇게 해야 `username.github.io`의 도메인으로 접속 가능한 페이지가 된다.

> 프로젝트 별로 페이지를 만들 수 있으며, 이미 존재하는 프로젝트에 페이지를 만드는 것도 가능하다.
>
> 다만 이렇게 만든 페이지는 `username.github.io/project_name`의 url로 접속하게 된다.

 

### 2. Template 가져오기

다양한 방법이 있겠지만 여기서는 기존에 만들어진 Template들 중에서

[[Start Bootstrap](https://startbootstrap.com/)] site의 `Resume`을 사용하였다. (Free Download)

> 해당 Template는 반응형으로 제작되었다

 

### 3. Template 수정하기

1. `startbootstrap-resume-gh-pages.zip` 파일을 다운받았다면 이를 압축 해제하고

   해당 폴더의 모든 내용을 `username.github.io` 저장소로 `git init` 한다.

   이때, [LF_CRLF Error](./Whitespace_Error.md)가 발생할 수 있다.

    

2. `index.html` 파일을 수정한다.

   1. 탭 타이틀 바꾸기

      ```html
      <!-- Line 11 -->
      <title>Jzee's Portfolio</title>
      ```

      > 위 내용을 설정하면 탭의 내용이 변경된다.
      >
      > ![image-20200105180537640](C:\Jzee\TIL\Image\github_io_title.png)

       

   2. 이름 바꾸기 1

      ```html
      <!-- Line 30 -->
      <span class="d-block d-lg-none">Jaeyoung Sim</span>
      ```

      > ![github_io_title2](C:\Jzee\TIL\Image\github_io_title2.png)
      >
      > 창의 넓이에 따라 자동적으로 형태가 바뀌는 반응형 Template.
      >
      > Line 30의 내용을 바꾸면 노란 박스의 내용이 변한다.

       

   3. 이름 바꾸기 2

      ```html
      <!-- Line 66~68 -->
      <h1 class="mb-0">Jaeyoung
      	<span class="text-primary">Sim</span>
      </h1>
      ```

      > Line 66과 Line 67의 내용을 바꾸면 빨간 박스의 내용이 각각 변한다.

       

   4. Profile 사진 변경

      ```
      startbootstrap-resume-gh-pages\img\profile.jpg
      ```

      > 위 경로의 파일을 본인이 원하는 사진으로 변경한다.

       

   5. 주소 변경

      ```html
      <!-- Line 70 -->
      <a href="mailto:jzee21b@gmail.com">jzee21b@gmail.com</a>
      <!-- Line 77 -->
      <a href="https://github.com/Jzee21">
      ```

      > Line 70 에서는 빨간 박스 아래 갈색 메일 주소와 링크를 설정할 수 있다
      >
      > Line 77 에서는 하단의 Github 마크에 본인의 Github 링크를 설정할 수 있다.

       

   6. Programming Languages 설정

      ```html
      <!-- Line 184 -->
      <li class="list-inline-item">			<!-- 1 -->
      	<i class="fab fa-css3-alt"></i>		<!-- 2 -->
      </li>
      ```

      > Line 184 부터는 Programming Languages 들을 아이콘으로 추가할 수 있다.
      >
      > 주석 2번 부분에 원하는 아이콘으로 변경이 가능하다.
      >
      > 변경 가능한 아이콘의 목록은 [Font Awesome](https://fontawesome.com/)의 [Icons](https://fontawesome.com/icons?d=gallery)에서 확인 가능하다.

       

   7. 색상 변경

      ```html
      startbootstrap-resume-gh-pages\css\resume.css
      ```

      > 위 경로의 파일을 수정하여 색상 태그를 수정할 수 있다.

      ```css
      /* Line 162~176 */
      .bg-primary {
        background-color: #BD5D38 !important;
      }
      
      .text-primary {
        color: #BD5D38 !important;
      }
      
      a {
        color: #BD5D38;
      }
      
      a:hover, a:focus, a:active {
        color: #824027;
      }
      ```

      > 위의 color 값들을 HEX 값으로 설정한다.

       

      ```html
      <!-- index.html -->
      <!-- Line 22 -->
      <!-- Custom styles for this template -->
        <link href="css/resume.css" rel="stylesheet">
      ```

      > `index.html` 파일의 Line 22 에서 `resume.min.css` 값을 `resume.css`로 변경한다.

       

3. 모든 내용은 `add`, `commit` 한다.

   변경된 내용의 적용에는 지연이 있을 수 있다.

 

 

## Markdown 기반 블로그

> 정적 탬플릿 생성기 : md ->  html/css로 바꿔준다.

 

### Jekyll

> - Github 에서는 Markdown 포맷을 지원하기 위해 [Jekyll(한국어)](https://jekyllrb-ko.github.io/)이라는 Static Site Generator를 사용한다.
>
> - 이는 HTML 작성을 신경쓰지 않고, 일단 텍스트 등으로 작성하면 알아서 HTML/CSS로 바꿔준다.
> - Github 에서는 Jekyll을 지원하며, 빌트인 테마를 골라 간편하게 사용할 수 있다.
> - 국내에서는 카카오의 기술블로그 등이 이를 사용한다.

 

### Gatsby

> - 최신 프레임워크
> - Github octoverse 기준, 2019년 가장 많이 성장한 오픈소스 프로젝트 Top 10에 선정됬다.
> - 최신 웹 트렌드 기술(react, graphql)들이 반영되어 있다.

