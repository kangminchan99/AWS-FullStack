# js 요소 탐색

- 이벤트가 연결된 자신: 이벤트핸들러 안에서 this
- 부모: this.parentElement
- 자식: this.children
- 자신안쪽선택: this.querySelector('하위요소')
- 다음형제: this.nextElementSibling
- 이전형제: this.previousElementSibling
- 형제요소모두: js에 없으므로 siblings함수 사용
- 조상요소: this.closest('#header')

```js
// js 형제선택 함수
  function siblings(t) {
    const children = t.parentElement.children;
    const tempArr = [];

    // children이 HTML 컬렉션 유사배열이므로 forEach사용불가
    // 일반 for문으로 유사배열 길이만큼 반복하여 임시배열에 넣어줌
    for (let i = 0; i < children.length; i++) {
      tempArr.push(children[i]);
    }

    // 임시배열의 요소들과 함수실행시 전달된 요소가 다른 요소만 배열로 리턴
    return tempArr.filter((v) => {
      return v !== t;
    });
  }
```
