# msw로 가짜데이터 모킹하기

## 프로젝트 초기화

```bash
npm create vite@latest ./
npm i
npm run dev
```

## msw(mock service worker)

- 백엔드 api 엔드포인트가 없을 경우 가짜데이터로 프론트에서 데이터를 이용한 작업을 하기위해 사용

- 백엔드 api 엔드포인트: 클라이언트(브라우저, 안드로이드, iOS)에서 DB 리소스에 CRUD 작업을 할때 필요한 URL

- service worker를 이용하여 모의 Api를 mocking

- service worker: 브라우저로 들어오는 네트워크 응답, 요청을 중간에서 가로채 제어하는 기능

## msw 패키지 설치

- -D는 --save-dev 약자로 개발의존성으로 패키지 설치, 개발시에만 사용되며 빌드에는 포함되지않음

```bash
npm i msw -D
```

## 브라우저에 msw 통합

- public 폴더에 `mockServiceWorker.js` worker 스크립트 복사

```bash
npx msw init public/ --save
```

- 복사후 스크립트 내용 표시되는지 확인

```url
http://localhost:5173/mockServiceWorker.js
```

## msw로 mock api 작성

- 가짜데이터 생성

```json
// src/mocks/dummy.json
[
  {
    "id": 1,
    "name": "lee",
    "country": "ko",
    "lang": "react"
  },
  {
    "id": 2,
    "name": "jay",
    "country": "eu",
    "lang": "vue"
  },
  {
    "id": 3,
    "name": "mark",
    "country": "us",
    "lang": "spring"
  }
]
```

## 네트워크 동작 작성

```js
// mocks/handlers.js
import { http, HttpResponse } from 'msw';
// 배열데이터 가져오기
import people from './dummy.json';

// 서버로 요청이 들어왔을때 실행될 http메서드(요청핸들러)
// http.get(): 서버 데이터 가져오기(Read)
// http.post(): 서버에 데이터 전송(Create)
export const handlers = [
  // '/people': 데이터 요청할 api 엔드포인트
  http.get('/people', async () => {
    await sleep(200);

    // 배열 데이터를 json으로 응답
    return HttpResponse.json(people);
  }),
  http.post('/people', async ({ request }) => {
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
```

## worker 설정

```js
// src/mocks/browser.js
import { setupWorker } from 'msw/browser';
import { handlers } from './handlers.js';

// 배열의 요청 핸들러 함수들을 전개연산자로 전달하여 실행
export const worker = setupWorker(...handlers);
```

## 조건부로 모킹 활성화

- 서비스워커 등록하고 활성화하기 위해 `worker.start()`호출하여 워커 시작

- 개발중에만 api 모킹 활성화

```js
// main.jsx
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';

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

enableMocking().then(() => {
  ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
      <App />
    </React.StrictMode>
  );
});
```

- 활성화후 개발자도구 콘솔에 Mocking enabled 뜨면 활성화 완료

## 가짜 데이터 가져오기

```js
// App.jsx
import { useEffect, useState, useRef } from 'react';
import reactLogo from './assets/react.svg';
import viteLogo from '/vite.svg';
import './App.css';

export default function App() {
  const [peopleData, setPeopleData] = useState([]);
  const idRef = useRef(3);

  // post로 데이터생성시 리스트의 key가 중복되면 안되므로
  // 렌더링간에 값이 유지되는 useRef사용
  idRef.current += 1;

  // 클린업함수 이용하여 데이터 한번만 가져오기
  // 리액트 개발중 strict mode로 인해 useEffect 스트레스 테스트가 진행되어
  // 두번 렌더링이 되며 클린업함수를 이용하여 한번만 데이터 가져오도록함
  let ignore = false;

  // 첫번째 렌더링후 이펙트실행 ignore = false
  // 두번째 렌더링후 이전이펙트의 클린업 실행 ignore = true
  // 이펙트 실행 ignore = true
  // 세번째 렌더링에서 지역변수 ignore값 유지되지않고 새로 초기화되어 false
  useEffect(() => {
    // console.log(ignore);
    // async function fetchData() {
    //   try {
    //     if (!ignore) {
    //       const response = await fetch('/people');
    //       const data = await response.json();
    //       setPeopleData(data);
    //     }
    //   } catch (error) {
    //     console.log(error);
    //   }
    // }

    // fetchData();

    async function createData() {
      try {
        if (!ignore) {
          const response = await fetch('/people', {
            method: 'POST',
            body: JSON.stringify({
              id: idRef.current,
              name: 'son',
              country: 'asia',
              lang: 'php',
            }),
          });
          const data = await response.json();
          setPeopleData(data);
        }
      } catch (error) {
        console.log(error);
      }
    }

    createData();

    return () => {
      ignore = true;
    };
  }, []);

  return (
    <div className="App">
      {/* 최초 로딩시 배열데이터가 없으므로 배열요소가 있을때 화면에 렌더링 */}
      {peopleData.length > 0 ? (
        peopleData.map((item) => (
          <div key={item.id}>
            <p>이름 : {item.name}</p>
            <p>나라 : {item.country}</p>
            <p>언어 : {item.lang}</p>
          </div>
        ))
      ) : (
        <p>...로딩중</p>
      )}
    </div>
  );
}
```
