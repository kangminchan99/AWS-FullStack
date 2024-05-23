# zustand 전역상태관리

- Context API와 달리 불필요한 리렌더링 제어가 쉬움

- 하나의 스토어구조를 활용하여 상태를 정의하고 사용하는 단순한 방식

```bash
npm i zustand
```

## 곰 숫자 증가시키고  제거하기

- 전역스토어 생성

```js
// stores/store.js
// create함수 임포트
import { create } from 'zustand';

// 상태객체 리턴하는 useStore훅 생성
const useStore = create((set) => ({
  // 전역상태
  bears: 0,
  // 전역상태 조작 메서드
  increasePopulation: function () {
    // set함수의 인자로 상태객체 조작함수 사용
    set((state) => ({ bears: state.bears + 1 }));
  },
  removeAllBears: function () {
    // set함수 인자로 새로운 상태객체 사용
    set({ bears: 0 });
  },
}));

export default useStore;
```

- 전역스토어 사용

```js
// App.jsx
import useStore from '@/stores/store.js';

export default function App() {
  const { bears, increasePopulation, removeAllBears } = useStore();

  return (
    <>
      <div>
        <h1>{bears} around here ...</h1>
        <button type="button" onClick={increasePopulation}>
          one up
        </button>
        <button type="button" onClick={removeAllBears}>
          remove all
        </button>
      </div>
    </>
  );
}
```

## 1씩 증가, 3씩 증가하는 전역스토어 추가하기

```js
// stores/numberBaseStore.js
import { create } from 'zustand';

const useNumberBaseStore = create((set) => ({
  numberA: 0, // 전역 상태
  numberB: 0, // 전역 상태
  // numberA 증가 메서드
  increaseNumberA: function () {
    set((state) => ({
      numberA: state.numberA + 1,
    }));
  },
  // numberB를 3씩 증가
  increaseNumberB: function (num) {
    set((state) => ({
      numberB: state.numberB + num,
    }));
  },
}));

export default useNumberBaseStore;
```

```js
// App.jsx
import useStore from './stores/store.js';
import useNumberBaseStore from './stores/numberBaseStore.js';

export default function App() {
  const { bears, increasePopulation, removeAllBears } = useStore();
  const { numberA, numberB, increaseNumberA, increaseNumberB } =
    useNumberBaseStore();

  return (
    <>
      <div>
        <h1>{bears} around here ...</h1>
        <button type="button" onClick={increasePopulation}>
          one up
        </button>
        <button type="button" onClick={removeAllBears}>
          remove all
        </button>
      </div>
      <div>
        <p>numberA: {numberA}</p>
        <button onClick={increaseNumberA}>A증가</button>
        <p>numberB: {numberB}</p>
        <button onClick={() => increaseNumberB(3)}>B증가</button>
      </div>
    </>
  );
}
```
