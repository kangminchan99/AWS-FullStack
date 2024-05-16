# useRef로DOM조작

- 리액트는 렌더링 결과에 맞춰 DOM 변경을 자동으로 처리

- 특정요소에 포커스를 보내거나 스크롤위치를 옮기거나 할 경우 DOM을 직접 조작하려 할 때 useRef사용

- 이벤트핸들러, 브라우저 API 사용가능

```js
import { useRef } from 'react';

// ref객체 생성
const myRef = useRef(null);

// jsx태그에 ref속성으로 전달
<div ref={myRef}>
```

## 버튼 클릭시 입력필드로 포커스 이동하기

```js
// App.jsx
import './App.css';
import { useRef } from 'react';

export default function Form() {
  const inputRef = useRef(null);

  function handleClick() {
    inputRef.current.focus();
  }

  return (
    <>
      <input type="text" ref={inputRef} />
      <button type="button" onClick={handleClick}>
        Focus the input
      </button>
    </>
  );
}
```

## 다른 컴포넌트로 ref전달하여 DOM접근

- 컴포넌트에 ref 연결불가하며 forwardRef로 컴포넌트 생성후 ref 전달

```js
// App.jsx
import './App.css';
import { forwardRef, useRef } from 'react';

// ref를 받기위해 forwardRef로 컴포넌트 생성
const MyInput = forwardRef(function({test}, ref) {
  return <input type="text" ref={ref} />;
});

export default function Form() {
  const inputRef = useRef(null);

  function handleClick() {
    inputRef.current.focus();
  }

  return (
    <>
      {/* 다른컴포넌트로 ref전달 */}
      <MyInput test={100} ref={inputRef} />
      <button onClick={handleClick}>Focus the input</button>
    </>
  );
}
```

### **React가 관리하는 DOM 노드를 직접 바꾸려 하면 안됨**

### 빈 요소에서 엘리먼트를 추가하거나 삭제하는 것은 안전

### 챌린지: 비디오 재생 멈춤

- video dom의  play(), pause() 호출

- ref추가후 작동 구현

```js
import { useState, useRef } from 'react';

export default function VideoPlayer() {
  const [isPlaying, setIsPlaying] = useState(false);

  function handleClick() {
    const nextIsPlaying = !isPlaying;
    setIsPlaying(nextIsPlaying);
  }

  return (
    <>
      <button onClick={handleClick}>
        {isPlaying ? 'Pause' : 'Play'}
      </button>
      <video width="250">
        <source
          src="https://interactive-examples.mdn.mozilla.net/media/cc0-videos/flower.mp4"
          type="video/mp4"
        />
      </video>
    </>
  )
}
```
