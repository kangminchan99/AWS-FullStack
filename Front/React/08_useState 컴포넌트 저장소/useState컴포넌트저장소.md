# useState컴포넌트저장소

- 컴포넌트별 저장소를 state라 함

- 지역변수는 컴포넌트가 렌더링될때마다 초기화되므로 변경사항을 기억하지못함

- 지역변수가 변경되도 렌더링이 일어나지않음

- 컴포넌트가 업데이트되어 화면이 변경되려면 **렌더링 사이에 변경된 데이터를 저장하고 있어야하며 새로운 데이터로 렌더링되도록 해야함**

- useState의 리턴값인 state 변수는 렌더링간에 데이터를 유지해줌

- 두번째 리턴값인 state setter함수는 상태변수를 업데이트하여 컴포넌트 리렌더링을 유발

- use로 시작하는 함수를 훅이라하며 컴포넌트 상단에서만 사용가능

- index 상태변수는 오직  setIndex함수에 의해서만 변경가능

- **상태가 변경되면 리렌더링이 되어 화면이 변경되며 부모컴포넌트가 렌더링되면 자식컴포넌트도 렌더링됨**

```js
import { useState } from 'react';
import { sculptureList } from './data.js';
import './App.css';

export default function Gallery() {
  const [index, setIndex] = useState(0);

  function handleChangeIndex() {
    setIndex(index + 1);
  }

  let sculpture = sculptureList[index];

  return (
    <>
      <button type="button" onClick={handleChangeIndex}>
        Next
      </button>
      <h2>
        <i>{sculpture.name} </i>
        by {sculpture.artist}
      </h2>
      <div>
        ({index + 1} of {sculptureList.length})
      </div>
      <img src={sculpture.url} alt={sculpture.alt} />
      <p>{sculpture.description}</p>
    </>
  );
}
```

## 컴포넌트에 여러 state변수 지정

- 둘 중 하나를 보여줘야하면 삼항연산

- 한개를 보여주거나 안보여야 할 경우 && 단축평가

- 동일한 컴포넌트를 각각 렌더링하면 서로 독립적인 state변수를 가짐

```js
import { useState } from 'react';
import { sculptureList } from './data.js';
import './App.css';

export default function Gallery() {
  const [index, setIndex] = useState(0);
  const [showMore, setShowMore] = useState(false);

  function handleChangeIndex() {
    setIndex(index + 1);
  }

  function handleToggleDetails() {
    setShowMore(!showMore);
  }

  let sculpture = sculptureList[index];
  return (
    <>
      <button onClick={handleChangeIndex}>Next</button>
      <h2>
        <i>{sculpture.name} </i>
        by {sculpture.artist}
      </h2>
      <div>
        ({index + 1} of {sculptureList.length})
      </div>
      <button onClick={handleToggleDetails}>
        {showMore ? 'Hide' : 'Show'} details
      </button>
      {showMore && <p>{sculpture.description}</p>}
      <img src={sculpture.url} alt={sculpture.alt} />
    </>
  );
}
```

### 챌린지: 갤러리 완성하기

- 마지막에서 next 버튼 클릭시 13으로 안넘어가게

- prev버튼 추가하고 0으로 안넘어가게

### 챌린지: 폼 입력 불가 고치기

```js
export default function Form() {
  let firstName = '';
  let lastName = '';

  function handleFirstNameChange(e) {
    firstName = e.target.value;
  }

  function handleLastNameChange(e) {
    lastName = e.target.value;
  }

  function handleReset() {
    firstName = '';
    lastName = '';
  }

  return (
    <form onSubmit={e => e.preventDefault()}>
      <input
        placeholder="First name"
        value={firstName}
        onChange={handleFirstNameChange}
      />
      <input
        placeholder="Last name"
        value={lastName}
        onChange={handleLastNameChange}
      />
      <h1>Hi, {firstName} {lastName}</h1>
      <button onClick={handleReset}>Reset</button>
    </form>
  );
}
```

## 다음 렌더링 전에 동일한 state변수 여러번 업데이트하기

- 이벤트핸들러의 모든 setNumber(number + 1)가 호출된 뒤에 리렌더링이 되므로 리렌더링 전엔 setNumber(0 + 1)을 세 번 호출하며 항상 setNumber(1)이 됨

```js
import { useState } from 'react';

export default function Counter() {
  const [number, setNumber] = useState(0);

  return (
    <>
      <h1>{number}</h1>
      <button onClick={() => {
        setNumber(number + 1);
        setNumber(number + 1);
        setNumber(number + 1);
      }}>+3</button>
    </>
  )
}
```

- 상태 설정함수에 값 대신 state업데이터 함수 이용하여 이전 state의 값 전달

- setNumber((n) => n + 1);

```js
import { useState } from 'react';

export default function Counter() {
  const [number, setNumber] = useState(0);

  return (
    <>
      <h1>{number}</h1>
      <button onClick={() => {
        setNumber(n => n + 1);
        setNumber(n => n + 1);
        setNumber(n => n + 1);
      }}>+3</button>
    </>
  )
}
```
