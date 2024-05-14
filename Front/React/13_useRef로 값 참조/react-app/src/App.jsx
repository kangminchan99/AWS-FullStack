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
