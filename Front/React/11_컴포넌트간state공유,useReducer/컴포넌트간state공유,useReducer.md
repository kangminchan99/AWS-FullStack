## 컴포넌트간state공유

- 부모 컴포넌트에 state를 두고 자식컴포넌트에 props 지정

```js
import { useState } from 'react';
import './App.css';

export default function Accordion() {
  const [activeIndex, setActiveIndex] = useState(0);

  return (
    <>
      <h2>Almaty, Kazakhstan</h2>
      <Panel
        title="About"
        isActive={activeIndex === 0}
        onShow={() => setActiveIndex(0)}
      >
        With a population of about 2 million, Almaty is Kazakhstan's largest
        city. From 1929 to 1997, it was its capital city.
      </Panel>
      <Panel
        title="Etymology"
        isActive={activeIndex === 1}
        onShow={() => setActiveIndex(1)}
      >
        The name comes from, the Kazakh word for "apple" and is often translated
        as "full of apples". In fact, the region surrounding Almaty is thought
        to be the ancestral home of the apple, and the wild Malus sieversii is
        considered a likely candidate for the ancestor of the modern domestic
        apple.
      </Panel>
    </>
  );
}

function Panel({ title, children, isActive, onShow }) {
  return (
    <section className="panel">
      <h3>{title}</h3>
      {isActive ? <p>{children}</p> : <button onClick={onShow}>Show</button>}
    </section>
  );
}
```

![](../images\2023-12-13-23-47-57-image.png)

## useReducer 이용한 카운터

- 하나의 상태와 관련된 여러동작을 처리할 때 사용

```js
import { useState, useReducer } from 'react';
import './App.css';

// 리듀서 함수의 리턴값이 state로 설정
const counterReducer = (state, action) => {
  switch (action.type) {
    case 'increment':
      return { count: state.count + 1 };
    case 'decrement':
      return { count: state.count - 1 };
    default:
      return state;
  }
};

export default function Counter() {
  // { count: 0 }이 state로 설정
  // counterReducer가 dispatch함수로 설정되며 리듀서에 타입을 보내는데 사용됨
  const [state, dispatch] = useReducer(counterReducer, { count: 0 });

  return (
    <div>
      <p>Count: {state.count}</p>
      <button onClick={() => dispatch({ type: 'increment' })}>증가</button>
      <button onClick={() => dispatch({ type: 'decrement' })}>감소</button>
    </div>
  );
}
```
