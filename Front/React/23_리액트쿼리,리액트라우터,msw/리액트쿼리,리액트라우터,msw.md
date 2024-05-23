# 리액트쿼리,리액트라우터,msw

- 관련 패키지 설치

```bash
npm i @tanstack/react-query react-router-dom
```

## 라우팅 설정

```js
// main.jsx
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';
import { BrowserRouter } from 'react-router-dom';
// 리액트쿼리 클라이언트 클래스, provider 가져오기
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';

async function enableMocking() {
  // 환경변수로 개발중일때만 서비스워커 활성화
  if (process.env.NODE_ENV !== 'development') {
    return;
  }

  const { worker } = await import('./mocks/browser.js');

  // 서비스워커가 동작하여 요청을 가로챌 준비가 되면 완료된 프라미스를 반환
  return worker.start({
    onUnhandledRequest: 'bypass',
  });
}

// 쿼리클라이언트 인스턴스 생성
const queryClient = new QueryClient();

enableMocking().then(() => {
  ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
      <QueryClientProvider client={queryClient}>    
        <BrowserRouter>
        <App />
      </BrowserRouter>
      </QueryClientProvider>
    </React.StrictMode>
  );
});
```

```js
// App.jsx
import { Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import ReactQuery from './pages/ReactQuery';
import './App.css';

export default function App() {
  return (
    <>
      <Routes>
        {/* 루트 공통 레이아웃 */}
        <Route path="/" element={<Layout />}>
          {/* 인덱스 라우트 */}
          <Route index element={<Home />} />
          <Route path="/react-query" element={<ReactQuery />} />
        </Route>
      </Routes>
    </>
  );
}
```

- 공통 레이아웃

```js
// components/Layout.jsx
// 자식 라우트 컴포넌트
import { Outlet } from 'react-router-dom';
import Header from './Header';

export default function Layout() {
  return (
    <div className="wrap">
      <Header />
      <main className="container">
        <Outlet />
      </main>
    </div>
  );
}
```

```js
// components/Header.jsx
// 라우터 링크 컴포넌트
import { Link } from 'react-router-dom';

export default function Header() {
  return (
    <nav className="gnb_wrap">
      <ul className="gnb">
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/react-query">React Query</Link>
        </li>
      </ul>
    </nav>
  );
}
```

- 페이지 컴포넌트

```js
// pages/Home.jsx
export default function Home() {
  return (
    <div>
      <h2>home page</h2>
    </div>
  );
}
```

```js
// pages/ReactQuery.jsx
export default function ReactQuery() {
  return (
    <div>
      <h2>React Query page</h2>
    </div>
  );
}
```

```css
// App.css
.wrap {
  padding: 30px;
}

.gnb {
  display: flex;
}
.gnb > li + li {
  padding-left: 30px;
}
.gnb > li > a {
  display: block;
  line-height: 40px;
  font-size: 18px;
}

.container h2 {
  font-size: 40px;
}

.react_query .list {
  margin-top: 20px;
}
.react_query .list li {
  margin-bottom: 10px;
}
```

## 리액트쿼리로 데이터 가져오기(GET요청)

```js
import { useQuery} from '@tanstack/react-query';

export default function ReactQuery() {
  // useQuery사용시 useEffect 사용하지않아도 되며 로딩, 에러 상태 관리용 변수 제공
  // queryKey: 요청마다 구분되는 유니크키, 응답데이터 캐시에 사용(로컬에서 데이터 재사용)
  // isError: 불린, 에러 핸들링
  // error: 에러 객체
  // 데이터 가져오기(GET, read)
  const { isLoading, data, isError, error } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
  });
  // 변수를 객체키로 사용시 변수명이 키, 변수값을 키값으로 사용
  // isLoading: 데이터가 없고 데이터가져오기시 true, 처음 데이터 로딩시만 true
  // isFetching: 데이터 요청시 true, 요청완료후 false
  console.log({ isLoading, isFetching });

  if (isLoading) return <>Loading...</>;

  if (isError) return <>{error.message}</>;

  return (
    <div className="react_query">
      <h2>React Query page</h2>
      <ul className="list">
        {/* 옵셔널체이닝: 오류로 인해 data배열이 없을 경우 에러 방지 */}
        {data?.map((person) => (
          <li key={person.id}>
            이름: {person.name} / 국가: {person.country} / 개발언어:{' '}
            {person.lang}
          </li>
        ))}
      </ul>
    </div>
  );
}
```

## 리액트쿼리로 데이터 생성(POST요청)

```js
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';

export default function ReactQuery() {
  // main.js에서 생성한 queryClient 컨텍스트 가져오기
  const queryClient = useQueryClient();

  // useQuery사용시 useEffect 사용하지않아도 되며 로딩, 에러 상태 관리용 변수 제공
  // queryKey: 요청마다 구분되는 유니크키, 응답데이터 캐시에 사용(로컬에서 데이터 재사용)
  // isError: 불린, 에러 핸들링
  // error: 에러 객체
  // 데이터 가져오기(GET, read)
  const { isLoading, data, isError, error } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
  });
  // 변수를 객체키로 사용시 변수명이 키, 변수값을 키값으로 사용
  // isLoading: 데이터가 없고 데이터가져오기시 true, 처음 데이터 로딩시만 true
  // isFetching: 데이터 요청시 true, 요청완료후 false
  console.log({ isLoading, isFetching });

  // 서버에 데이터 생성(POST, create)
  // mutate함수를 통해 user객체를 post요청으로 서버로 보냄
  // 요청헤더: 요청 컨텐츠 유형을 서버에 알려줌
  // 요청본문: user객체를 json형식으로 변환
  const { mutate } = useMutation({
    mutationFn: (user) =>
      fetch('/people', {
        method: 'POST',
        body: JSON.stringify(user),
      }),
    onSuccess: () => {
      // userInfo키의 데이터 초기화후 서버의 데이터 다시 가져옴
      queryClient.invalidateQueries({ queryKey: ['userInfo'] });
    },
  });

  if (isLoading) return <>Loading...</>;

  if (isError) return <>{error.message}</>;

  // Date.now() 1970년 1월 1일부터 현재까지의 밀리초
  function handleCreateUser() {
    const user = {
      id: Date.now(),
      name: 'son',
      country: 'asia',
      lang: 'php',
    };
    mutate(user);
  }

  return (
    <div className="react_query">
      <h2>React Query page</h2>
      <ul className="list">
        {/* 옵셔널체이닝: 오류로 인해 data배열이 없을 경우 에러 방지 */}
        {data?.map((person) => (
          <li key={person.id}>
            이름: {person.name} / 국가: {person.country} / 개발언어:{' '}
            {person.lang}
          </li>
        ))}
      </ul>
      <button type="button" onClick={handleCreateUser}>
        user 추가
      </button>
    </div>
  );
}
```

## ReactQueryDevtools 설치

```bash
$ npm i @tanstack/react-query-devtools

// nextjs13 app 라우터 사용시 개발 종속성으로 설치해야함
$ npm i @tanstack/react-query-devtools -D
```

```js
// App.js
import { Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import ReactQuery from './pages/ReactQuery';
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';
import './App.css';

export default function App() {
  return (
    <>
      <Routes>
        {/* 루트 공통 레이아웃 */}
        <Route path="/" element={<Layout />}>
          {/* 인덱스 라우트 */}
          <Route index element={<Home />} />
          <Route path="/react-query" element={<ReactQuery />} />
        </Route>
      </Routes>
      <ReactQueryDevtools initialIsOpen={false} />
    </>
  );
}
```
