# useEffect가필요하지않은경우

## prop, state에 따라 state 업데이트하기

```js
function Form() {
  const [firstName, setFirstName] = useState('Taylor');
  const [lastName, setLastName] = useState('Swift');

  // 🔴 피하세요: 중복된 state 및 불필요한 Effect
  const [fullName, setFullName] = useState('');
  useEffect(() => {
    setFullName(firstName + ' ' + lastName);
  }, [firstName, lastName]);
  // ...
}
```

- **기존 prop이나 state에서 계산될 경우** state에 넣지 않고 **렌더링 중에 계산되게 함**

```js
function Form() {
  const [firstName, setFirstName] = useState('Taylor');
  const [lastName, setLastName] = useState('Swift');

  // ✅ 좋습니다: 렌더링 중에 계산됨
  const fullName = firstName + ' ' + lastName;
  // ...
}
```

## 비용이 많이 드는 계산 캐싱하기

- props로 받은 `todos`를 `filter` prop에 따라 필터링하여 `visibleTodos`를 계산합니다. 결과를 state에 저장하고 Effect에서 업데이트하고 싶을 수 있습니다.

```js
function TodoList({ todos, filter }) {
  const [newTodo, setNewTodo] = useState('');

  // 🔴 피하세요: 중복된 state 및 불필요한 효과
  const [visibleTodos, setVisibleTodos] = useState([]);
  useEffect(() => {
    setVisibleTodos(getFilteredTodos(todos, filter));
  }, [todos, filter]);

  // ...
}
```

- 렌더링중에 필터함수를 재실행하는 것이 좋음

```js
function TodoList({ todos, filter }) {
  const [newTodo, setNewTodo] = useState('');
  // ✅ getFilteredTodos()가 느리지 않다면 괜찮습니다.
  const visibleTodos = getFilteredTodos(todos, filter);
  // ...
}
```

- 필터함수의 연산이 느린경우(1ms이상) useMemo훅으로 감싸서 캐시(메모이제이션) 가능

- todos, filter prop이 변경될 때만 필터함수 실행

```js
import { useMemo, useState } from 'react';

function TodoList({ todos, filter }) {
  const [newTodo, setNewTodo] = useState('');
  const visibleTodos = useMemo(() => {
    // ✅ todos 또는 filter가 변경되지 않는 한 다시 실행되지 않습니다.
    return getFilteredTodos(todos, filter);
  }, [todos, filter]);
  // ...
}
```

## 비용이 많이 드는 계산 useMemo로 캐싱하기

- console.time()으로 계산시 1ms이상이면 계산비용이 많이 드는것이므로 useMemo로 캐싱해줌

```js
import './App.css';
import { useState, useMemo } from 'react';

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

  // console.time('시간계산');
  useMemo(() => {
    timeConsuming();
  }, [count]);
  // console.timeEnd('시간계산');

  return (
    <>
      {count}
      <button type="button" onClick={handleCount}>
        클릭
      </button>
      <div>
        <button type="button" onClick={handleShowMsg}>
          메세지 {showMsg ? '숨기기' : '보기'}
        </button>
        {showMsg && <p>안녕하세요</p>}
      </div>
    </>
  );
}
```

## 이벤트 발생에 의한 로직은 이벤트 핸들러로 처리

```js
function Form() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');

  // ✅ 좋습니다: 컴포넌트가 표시되었으므로 이 로직이 실행되어야 합니다.
  useEffect(() => {
    post('/analytics/event', { eventName: 'visit_form' });
  }, []);

  // 🔴 피하세요: Effect 내부의 이벤트별 로직
  const [jsonToSubmit, setJsonToSubmit] = useState(null);
  useEffect(() => {
    if (jsonToSubmit !== null) {
      post('/api/register', jsonToSubmit);
    }
  }, [jsonToSubmit]);

  function handleSubmit(e) {
    e.preventDefault();
    setJsonToSubmit({ firstName, lastName });
  }
  // ...
}
```

```js
function Form() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');

  // ✅ 좋습니다: 컴포넌트가 표시되었으므로 이 로직이 실행됩니다.
  useEffect(() => {
    post('/analytics/event', { eventName: 'visit_form' });
  }, []);

  function handleSubmit(e) {
    e.preventDefault();
    // ✅ 좋습니다: 이벤트별 로직은 이벤트 핸들러에 있습니다.
    post('/api/register', { firstName, lastName });
  }
  // ...
}
```

## 애플리케이션 초기화 로직은 루트컴포넌트 위에 작성

```js
if (typeof window !== 'undefined') { // 브라우저에서 실행 중인지 확인합니다.
   // ✅ 앱 로드당 한 번만 실행
  checkAuthToken();
  loadDataFromLocalStorage();
}

function App() {
  // ...
}
```

## 데이터 가져오기시 부모에서 가져와 자식에게 내려줌

```js
function Parent() {
  const data = useSomeAPI();
  // ...
  // ✅ 좋습니다: 자식에서 데이터를 전달
  return <Child data={data} />;
}

function Child({ data }) {
  // ...
}
```

## 데이터 가져오기시 클린업함수 작성

- 오랜된 응답을 무시하기위해 무시변수 추가하여 렌더링시 이전요청이 일어나지않도록 해줌

```js
function SearchResults({ query }) {
  const [results, setResults] = useState([]);
  const [page, setPage] = useState(1);

  let ignore = false;

  useEffect(() => {
    if (!ignore) {
      fetchResults(query, page).then(json => {
        setResults(json);
      });
    }
    return () => {
      ignore = true;
    };
  }, [query, page]);

  function handleNextPageClick() {
    setPage(page + 1);
  }
  // ...
}
```
