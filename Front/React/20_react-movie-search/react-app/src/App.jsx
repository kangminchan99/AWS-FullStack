import { useMemo } from 'react';
import './App.css';
import { useState } from 'react';

// 임의의 복잡한 계산
function timeConsuming() {
  let result = 0;

  for (let i = 0; i < 1000000; i++) {
    result += Math.sqrt(i);
  }
  console.log('계산완료');
  return result;
}

export default function App() {
  const [count, setCount] = useState(0);
  const [showMsg, setShowMsg] = useState(false);

  function handleCount() {
    setCount(count + 1);
  }

  function handleShowMsg() {
    setShowMsg(!showMsg);
  }

  console.time('time check');
  useMemo(() => {
    timeConsuming();
  }, []);

  console.timeEnd('time check');

  return (
    <>
      {count}
      <button type="btn" onClick={handleCount}>
        click
      </button>
      <div>
        <button type="btn" onClick={handleShowMsg}>
          message {showMsg ? 'hidden' : 'show'}
        </button>
        {showMsg && <p>hihihihi</p>}
      </div>
    </>
  );
}
