# 브라우저객체(BOM)

- window(최상위객체)

- document(dom), history(이동한 페이지 정보), location(주소표시줄 정보), navigator(브라우저제조사 정보)

- 이미지등의 리소스가 로딩되면 발생
  
  ```js
  window.addEventListener('load', function() {
    console.log(이미지 리소스 로딩);
  });
  ```

## 클릭시 새창띄우기

```html
// a는 클릭하면 페이지 상단으로 이동하는 기본이벤트가 있으므로 기본이벤트를 막아야함
// 인라인으로 기본이벤트 막
<a href="javascript:void(0)" onclick="openWin();">새창팝업 열기</a>
<script>
  function openWin() {
    // 듀얼모니터중 메인모니터가 아닌경우 left값 작동안함
    window.open('popup.html','_blank','toolbar=0,scrollbars=0,resizable=0,left=100,top=100,width=400,height=500');
  }
</script>
```

## 뒤로가기(history)

```html
<a href="javascript:void(0)" onclick="history.go(-1);">뒤로가기</a>
```

## 다른사이트로 강제이동(location)

```js
location.href = 'http://naver.com'
```

## 모바일 브라우저 판단(userAgent)

```js
// 정규표현식 - 폼요소의 유효성검증시 주로 사용, /정규식/옵션(flag)
function isMobile() {
  return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(
    navigator.userAgent
  );
}

if(isMobile()) {
  document.querySelector('.txt').innerHTML = '모바일브라우저';
  console.log('모바일브라우저');
} else {
  document.querySelector('.txt').innerHTML = 'PC브라우저';
  console.log('PC브라우저');
}
```

## a태그 기본이벤트 막기

- 인라인으로 사용시
  
  `<a href="javascript:void(0)">기본이벤트막기</a>`

- js파일에서 요소선택후 기본이벤트 막기(이벤트객체사용)
  
  `e.preventDefault();`
