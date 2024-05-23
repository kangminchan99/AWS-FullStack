# id로특정항목가져오기,동적라우팅

## 동적라우팅으로 상세페이지 만들기

- `<Route path="/react-query/:userId" element={} />` path에 변수지정

```js
// App.jsx
import { Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import ReactQuery from './pages/ReactQuery';
import ReactQueryDetails from './pages/ReactQueryDetails';
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';
import './App.css';

export default function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="/react-query" element={<ReactQuery />} />
          <Route path="/react-query/:userId" element={<ReactQueryDetails />} />
        </Route>
      </Routes>
      <ReactQueryDevtools initialIsOpen={false} />
    </>
  );
}
```

- 상세페이지 라우트

```js
// pages/ReactQueryDetails.jsx
import { useParams } from 'react-router-dom';
import { useUserId } from '@/hooks/useUserId';

export default function ReactQueryDetails() {
  // url에서 파라메터 가져오기
  const { userId } = useParams();
  // userId로 데이터 요청
  const { isLoading, isError, error, data } = useUserId(userId);
  console.log(data, '===');

  if (isLoading) return <>Loading...</>;

  if (isError) return <>{error.message}</>;

  return (
    <>
      {data && (
        <div>
          {/* data배열 첫번째 요소의 객체사용 */}
          <p>ID : {data[0].id}</p>
          <p>NAME : {data[0].name}</p>
          <p>COTUNTRY : {data[0].country}</p>
        </div>
      )}
    </>
  );
}
```

- 커스텀훅 추가

```js
// hooks/useUserId.js
import { useQuery } from '@tanstack/react-query';

export function useUserId(userId) {
  return useQuery({
    // 쿼리키와 동적라우팅에 사용된 변수를 배열로 지정
    queryKey: ['userId', userId],
    queryFn: () => fetch(`/people/${userId}`).then((res) => res.json()),
  });
}
```

- mock 서버 응답핸들러 추가

```js
// mocks/handlers.js
import { http, HttpResponse } from 'msw';
// 배열데이터 가져오기
import people from './dummy.json';

// 서버로 요청이 들어왔을때 실행될 http메서드(응답핸들러)
// http.get(): 서버 데이터 가져오기(Read)
// http.post(): 서버에 데이터 전송(Create)
export const handlers = [
  // '/people': 데이터 요청할 api 엔드포인트
  http.get('/people', async () => {
    await sleep(200);

    return HttpResponse.json(people);
  }),
  http.get('/people/:id', async ({ params }) => {
    await sleep(200);
    // url파라메터 구조분해
    const { id } = params;
    // 배열 데이터를 json으로 응답
    return HttpResponse.json(
      // id 파라메터가 문자이므로 숫자로 변환후 배열요소중 id와 동일한 요소찾기
      people.filter((person) => person.id === parseInt(id))
    );
  }),
  http.post('http://localhost:5173/people', async ({ request }) => {
    await sleep(200);
    // 요청객체중 요청 body로 넘어온 내용을 js 객체로 변환
    const item = await request.json();
    // 배열에 데이터 추가
    people.push(item);

    return HttpResponse.json(people);
  }),
];

// 데이터 전송시 시간이 걸리므로 지연시간 걸어 서버환경과 비슷하게 동작하게 하는 함수
async function sleep(timeout) {
  return new Promise((resolve) => {
    setTimeout(resolve, timeout);
  });
}
서
```

- 서브페이지 링크컴포넌트 추가

```js
// pages/ReactQuery.jsx
import { useUserName } from '@/hooks/useUserName';
import { Link } from 'react-router-dom';

export default function ReactQuery() {
  const { isLoading, isFetching, data, isError, error } = useUserName();

  if (isLoading) return <>Loading...</>;

  if (isError) return <>{error.message}</>;

  return (
    <div className="react_query">
      <h2>React Query page</h2>
      <ul className="list">
        {data?.map((user) => (
          <li key={user.id}>
            <Link to={`/react-query/${user.id}`}>{user.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}
```

- useUserName 커스텀훅

```js
// pages/useUserName.js
import { useQuery } from '@tanstack/react-query';

export function useUserName() {
  return useQuery({
    queryKey: ['userName'],
    queryFn: () => fetch('/people').then((res) => res.json()),
  });
}
```

## 병렬쿼리

- 하나의 컴포넌트에서 데이터 여러개 가져오기

- 라우트 추가

```js
// App.jsx
import { Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import ReactQuery from './pages/ReactQuery';
import ReactQueryDetails from './pages/ReactQueryDetails';
import ParallelQuery from './pages/ParallelQuery';
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';
import './App.css';

export default function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="/react-query" element={<ReactQuery />} />
          <Route path="/react-query/:userId" element={<ReactQueryDetails />} />
          <Route path="/parallel-query" element={<ParallelQuery />} />
        </Route>
      </Routes>
      <ReactQueryDevtools initialIsOpen={false} />
    </>
  );
}
```

- 헤더에 링크 추가

```js
// Header.jsx
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
        <li>
          <Link to="/parallel-query">Parallel Query</Link>
        </li>
      </ul>
    </nav>
  );
}
```

- 병렬쿼리 페이지 추가

```js
import { useQuery } from '@tanstack/react-query';

export default function ParallelQuery() {
  const { isLoading, data, isError, error } = useQuery({
    queryKey: ['getUser'],
    queryFn: () => fetch('/people').then((res) => res.json()),
  });

  // 변수명이 동일하므로 별칭으로 구조분해
  const {
    isLoading: productLoading,
    data: productData,
    isError: productIsError,
    error: productError,
  } = useQuery({
    queryKey: ['getProduct'],
    queryFn: () => fetch('/product').then((res) => res.json()),
  });

  if (isLoading) return <>Loading...</>;

  if (isError) return <>{error.message}</>;

  return (
    <div className="parallel_query">
      <h2>Parallel Query page</h2>
      <ul>
        {data?.map((user) => (
          <li key={user.id}>
            {user.name} {user.country} {user.lang}
          </li>
        ))}
      </ul>
      <ul>
        {productData?.map((product미) => (
          <li key={product.id}>
            {product.name} {product.price}
          </li>
        ))}
      </ul>
    </div>
  );
}
```

- product 임시 데이터 추가

```json
// mocks/product.json
[
  {
    "id": 1,
    "name": "watch",
 답   "price": 100
  },
  {
    "id": 2,
    "name": "tv",
    "price": "200"
  },
  {
    "id": 3,
    "name": "pc",
    "price": "350"
  }
]
```

- 응답핸들러 추가

```js
import product from './product.json';

http.get('/product', async () => {
    await sleep(200);

    return HttpResponse.json(product);
  }),
```
