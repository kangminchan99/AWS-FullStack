# css로 삼각형

```css
:after {
  content:'';
  position:absolute;
  left:0;
  top:0;
  border:8px solid transparent;
  border-top-color:red;
}
```

# video태그

- mp4 포멧 사용(모든브라우저 대응)
- autoplay="autoplay" 이나 속성과 값이 같을경우 속성명만 사용가능
- 자동재생사용시 muted(음소거) 필수
- 아이폰 저전력모드일경우 자동재생불가
- 구글, ios video 정책문서 참고
- 용량 클경우 트래픽 문제 발생할수있음(20M 이하 권장)
- ios playsinline 속성사용해야 자동재생됨
- 여러 포맷 연결할경우 `<source src="video/파일명.webm">`
  사용하지만 mp4가 모든브라우저 지원하므로 `<source>` 불필요
  ex. `<video src="video/파일명.mp4" autoplay muted loop playsinline>`

## full레이아웃 비디오

- video를 감싼 부모의 높이를 100vh로 창높이로 지정
- object-fit:cover 부모 너비, 높이중 큰쪽에 맞추고 넘친부분은 가려짐

```css
video {
  width:100%;
  height:100%;
  object-fit:cover;
}
```

## 가변레이아웃(모바일, 반응형)일 경우

- video태그를 감싸는 요소의 높이를 padding-top:%로 잡아준후 비디오를 엡솔로 띄우고 가로, 세로 100%
- padding-top:%는 부모의 가로길이를 기준으로함
  ex. 16:9는 `padding-top:56.25%` 4:3은 `padding-top:75%`
- 영상비율이 일반적이지 않을 경우 크롬으로 보면서 조절

# css캐싱방지

- 사이트에 최초 접속시 html, css, js, images, 폰트등의 자원이 캐시폴더에 다운로드된후 보여짐

- 두번째 접속시는 캐시폴더에 있는 파일을 읽으므로 좀더 빠르게 화면이 로딩

- 우리가 작성하는 css파일, 직접작성하는 js파일에 캐싱방지를 위해 타임스탬프코드 사용
  
  ```html
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
  <link rel="stylesheet" href="css/common.css?v=<?php echo time(); ?>">
  ```

- 파일명뒤에 파라미터를 붙이고 1970년 1월 1일부터 현재까지의 시간(밀리세컨)을 문자열로 반환

- 브라우저는 파일연결경로가 다르면 다운로드받음
