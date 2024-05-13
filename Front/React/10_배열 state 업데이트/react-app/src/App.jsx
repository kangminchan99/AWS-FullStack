import { useState } from 'react';
import './App.css';

export default function CounterList() {
  const [counters, setCounters] = useState([0, 0, 0]);

  function incrementCount(index) {
    const nextCounters = counters.map((counter, i) => {
      if (i === index) {
        return counter + 1;
      } else {
        return counter;
      }
    });
    setCounters(nextCounters);
  }

  return (
    <ul>
      {counters.map((counter, i) => (
        <li key={i}>
          {counter}
          <button type="btn" onClick={() => incrementCount(i)}>
            +1
          </button>
        </li>
      ))}
    </ul>
  );
}
