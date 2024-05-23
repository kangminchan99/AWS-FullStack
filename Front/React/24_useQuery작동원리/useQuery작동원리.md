# useQuery 작동원리

- 각 요청에 대한 데이터를 쿼리키로 구분하여 캐시에 저장

- 다른 라우트로 갔다 돌아올 경우 캐시에 있던 데이터를 로딩없이 바로 보여줌

- stableTime = 0(기본값), 데이터가 항상 stable(오래된) 상태로 간주되며 백그라운드에서 데이터를 계속 가져오지만 캐시에 저장된 데이터와 동일한 경우 캐시 데이터를 사용하고 새로운 데이터일 경우 캐시 데이터 업데이트

```js
const { isLoading, isFetching, data, isError, error, refetch } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
  });
  // 변수를 객체키로 사용시 변수명이 키, 변수값을 키값으로 사용
  // isLoading: 데이터가 없고 데이터가져오기시 true, 처음 데이터 로딩시만 true
  // isFetching: 데이터 요청시 true, 요청완료후 false
  console.log({ isLoading, isFetching });
```

## gcTime 변경해보기

- gcTime: 300000(기본값 5분), 가비지컬렉터 시간이며 다른 라우터로 이동했거나 데이터를 사용하는 컴포넌트가 언마운트된 후 5분이 지나면 캐시데이터 삭제시켜 메모리 최적화

```js
const { isLoading, data, isError, error } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
    gcTime: 5000,
  });
  // 변수를 객체키로 사용시 변수명이 키, 변수값을 키값으로 사용
  // isLoading: 데이터가 없고 데이터가져오기시 true, 처음 데이터 로딩시만 true
  // isFetching: 데이터 요청시 true, 요청완료후 false
  console.log({ isLoading, isFetching });
```

- 브라우저 새로고침버튼에서 마우스 우클릭후 캐시 비우기 및 강력 새로고침

- home 라우터로 이동하면 5초뒤에 userInfo 캐시 삭제됨

## stableTime 변경해보기

- stableTime:0(기본값), 지정된 시간후 데이터가 fresh(최신) -> stable(오래된) 상태로 변경

```js
const { isLoading, data, isError, error } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
    staleTime: 6000,
  });
  // 변수를 객체키로 사용시 변수명이 키, 변수값을 키값으로 사용
  // isLoading: 데이터가 없고 데이터가져오기시 true, 처음 데이터 로딩시만 true
  // isFetching: 데이터 요청시 true, 요청완료후 false
  console.log({ isLoading, isFetching });
```

- 캐시 데이터 상태변경 순서: inactive(홈화면) > fetching(리액트쿼리 라우트) > fresh > stable

- gcTime은 기본값으로 사용하며 변경이 자주 일어나지않는 데이터일 경우 stableTime 조정

## 컴포넌트가 화면에 마운트될때, 윈도우가 활성화됐을때 데이터 refetching

## Polling: 강제로 데이터 가져오기

- 실시간 주식 데이터처럼 특정시간마다 데이터 가져와야 할 경우

- 백그라운드에서 주기적으로 데이터 가져오기

```js
const { isLoading, isFetching, data, isError, error } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
    refetchInterval: 2000,
    refetchIntervalInBackground: true,
  });
  // 변수를 객체키로 사용시 변수명이 키, 변수값을 키값으로 사용
  // isLoading: 데이터가 없고 데이터가져오기시 true, 처음 데이터 로딩시만 true
  // isFetching: 데이터 요청시 true, 요청완료후 false
  console.log({ isLoading, isFetching });
```
