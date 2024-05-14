# useRef로값참조

- 컴포넌트가 정보를 기억하지만 렌더링은 되지않아야 할 경우 사용

- useRef는 {current:값} 객체를 반환, 값을 읽거나 수정가능

- **stete 변수가 변경되면 리렌더링이 되지만 ref는 렌더링 되지않음**

## 스톱워치 만들기

- 인터벌id를 함수 두곳에서 사용해야하므로 ref로 인터벌id 저장후

- 함수 두군데서 사용, 일반변수는 렌더링마다 초기화되므로 사용불가

- state 상태변수는 리렌더링을 발생시키므로 사용불가

```js
// App.jsx
import './App.css';
import { useState, useRef } from 'react';

export default function Stopwatch() {
  const [startTime, setStartTime] = useState(null);
  const [now, setNow] = useState(null);
  const intervalRef = useRef(null);

  function handleStart() {
    // Date.now(): 1970년 1월 1일부터 현재까지의 밀리초
    setStartTime(Date.now());
    setNow(Date.now());

    clearInterval(intervalRef.current);

    // 인터벌id를 함수 두곳에서 사용해야하므로 ref로 인터벌id 저장후
    // 함수 두군데서 사용, 일반변수는 렌더링마다 초기화되므로 사용불가
    intervalRef.current = setInterval(() => {
      setNow(Date.now());
    }, 10);
  }

  function handleStop() {
    clearInterval(intervalRef.current);
  }

  let secondsPassed = 0;
  if (startTime != null && now != null) {
    secondsPassed = (now - startTime) / 1000;
  }

  return (
    <>
      <h1>Time passed: {secondsPassed.toFixed(3)}</h1>
      <button onClick={handleStart}>Start</button>
      <button onClick={handleStop}>Stop</button>
    </>
  );
}
```

## ref는 값이 변경되도 리렌더링이 일어나지않는다

```js
import './App.css';
import { useRef } from 'react';

export default function Counter() {
  let countRef = useRef(0);

  function handleClick() {
    // 이것은 컴포넌트의 리렌더를 일으키지 않습니다!
    countRef.current = countRef.current + 1;
    // ref값이 변경되지만 리렌더가 되지않으므로 화면에 표시되지않음
    console.log(countRef.current);
  }

  return (
    <button onClick={handleClick}>You clicked {countRef.current} times</button>
  );
}
```

## ref 사용하는 경우

- 인터벌 id 저장

- DOM 요소 저장 및 조작
