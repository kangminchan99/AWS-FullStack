import { useState } from 'react';
import './App.css';

export default function Counter() {
  const [number, setNumber] = useState(0);

  return (
    <>
      <h1>{number}</h1>
      <button
        onClick={() => {
          setNumber((prev) => prev + 1);
          setNumber((prev) => prev + 1);
          setNumber((prev) => prev + 1);
        }}
      >
        +3
      </button>
    </>
  );
}
