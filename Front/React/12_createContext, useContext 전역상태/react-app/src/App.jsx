import './App.css';
import { useReducer, useState } from 'react';

function countReducer(state, action) {
  switch (action.type) {
    case 'increment':
      return { count: state.count + 1 };
    case 'decrement':
      return { count: state.count - 1 };

    default:
      return state;
  }
}

export default function Counter() {
  const [state, dispatch] = useReducer(countReducer, { count: 65 });

  return (
    <div>
      <p>Count: {String.fromCharCode(state.count)}</p>

      <button
        type="button"
        onClick={(event) => {
          if (state.count < 90) {
            dispatch({ type: 'increment' });
          } else {
            event.preventDefault();
          }
        }}
      >
        증가
      </button>
      <button
        type="button"
        onClick={(event) => {
          if (state.count > 65) {
            dispatch({ type: 'decrement' });
          } else {
            event.preventDefault();
          }
        }}
      >
        감소
      </button>
    </div>
  );
}
