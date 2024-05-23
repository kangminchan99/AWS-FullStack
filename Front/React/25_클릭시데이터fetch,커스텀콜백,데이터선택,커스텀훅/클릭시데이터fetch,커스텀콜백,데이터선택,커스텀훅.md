# 클릭시데이터fetch,커스텀콜백,데이터선택,커스텀훅

## 클릭시 데이터 fetch

- enabled: true(기본값), 컴포넌트가 마운트되면 데이터 가져오기 끄고 refetch함수 사용

```js
const { isLoading, isFetching, data, isError, error, refetch } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
    enabled: false,
 });

return (
    <div className="react_query">
      <h2>React Query page</h2>
      <button type="button" onClick={refetch}>
        데이터 가져오기
      </button>
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
```

## 전역커스텀콜백함수

- v5에서 useQuery의 onSuccess, onError 콜백은 없어졌으며 useMutation에선 그대로 사용가능
- 쿼리완료후 실행할 전역커스텀콜백함수 정의

```js
// main.jsx
import {
  QueryCache,
  QueryClient,
  QueryClientProvider,
} from '@tanstack/react-query';


// 쿼리클라이언트 인스턴스 생성
const queryClient = new QueryClient({
  queryCache: new QueryCache({
    onSuccess: (data) => console.log(data),
    onError: (error) => console.error(`Something went wrong: ${error.message}`),
  }),
});
```

## 사용할 데이터 선택하기

```js
const { isLoading, isFetching, data, isError, error, refetch } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
    enabled: false,
    select: (data) => {
      const userName = data?.map((user) => user.name);
      return userName;
    },
  });


return (
    <div className="react_query">
      <h2>React Query page</h2>
      <button type="button" onClick={refetch}>
        데이터 가져오기
      </button>
      <ul className="list">
        {/* 옵셔널체이닝: 오류로 인해 data배열이 없을 경우 에러 방지 */}
        {data?.map((name) => (
          <li key={name}>이름: {name}</li>
        ))}
      </ul>
      <button type="button" onClick={handleCreateUser}>
        user 추가
      </button>
    </div>
  );
```

- 조건에 맞는 데이터만 선택(filter)

```js
const { isLoading, isFetching, data, isError, error, refetch } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
    enabled: false,
    // 사용자 언어가 react인 사용자 이만 선택하기
    select: (data) => {
      const userName = data
        ?.filter((user) => user.lang === 'react')
        .map((user) => user.name);
      return userName;
    },
  });
```

## 커스텀훅으로 재사용

- 동일데이터를 여러 컴포넌트에서 사용할 경우

- 훅함수는 use로 시작하여 네이밍

```js
// hooks/useUserName.js
import { useQuery } from '@tanstack/react-query';

export function useUserName() {
  return useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
    select: (data) => {
      const userName = data?.map((user) => user.name);
      return userName;
    },
  });
}
```

```js
// ReactQuery.jsx
import { useUserName } from '@/hooks/useUserName';

const { isLoading, isFetching, data, isError, error } = useUserName();
```
