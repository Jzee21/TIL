# CSS

> **종속형 시트** 또는 **캐스케이딩 스타일 시트(Casvcading Style Sheets, CSS)**는
>
> 마크업 언어가 실제로 표시되는 방법을 기술하는 언어이다.



## CSS 요소

> CSS 문서는 어떤 태그들에게 스타일 효과를 주는 언어로서 **선택자**와 **속성**으로 이루어져있다.
>
> CSS는 **선택자를 먼저 쓰고 중괄호 `{}` 안에 속성과 값**을 적는 방식으로 이루어져 있다.



## CSS

```css
@charset "UTF-8";
/* @import url("../subCss/basic.css") */

선택자 {
    속성1: 값1;
    속성2: 값2;
}

/* Tag 선택자 */
body {
    background-color: skyblue;
}

/* id 선택자 */
div#idName {
    
}

/* class 선택자 */
div.className {
    
}

.className ul li {
    
}
```

- `@import`를 통해 **외부의 다른 CSS 파일** 을 가져와 적용시킬 수 있다.
- 선택자를 먼저 쓰고 중괄호 {} 안에 속성과 값이 위치한다.



### 선택자

CSS의 선택자는 3가지로 이루어져 있다.

- 태그 선택자
- id 선택자
- class 선택자



### 우선순위

CSS는 HTML의 태그에 스타일 효과를 주는 언어로서

HTML 파일 내부에서 또는 별도의 CSS 파일에서 등 어떤 태그에 속성이 중복되어 설정될 수 있다.

CSS는 어떤 속성이 우선되어 적용되는지 미리 명시하고 있다.



1. `HTML` 에서 `style`을 직접 지정한 속성
2. `#id`로 지정한 속성
3. `.클래스`, `:추상클래스`로 지정한 속성
4. `태그이름`으로 지정한 속성
5. 상위 객체에 의해 상속된 속성 (CSS file에서 `@import`로 가져오는 외부 `CSS File`)



> id > class > tag

 

## Reference Site

- [[W3Schools CSS Reference]](https://www.w3schools.com/cssref/default.asp)
- [[ofcourse CSS Course]](https://ofcourse.kr/css-course/CSS-%EC%9E%85%EB%AC%B8)
- [[TunaHG's TIL]](https://github.com/TunaHG/TIL/blob/master/Web/CSS.md)

