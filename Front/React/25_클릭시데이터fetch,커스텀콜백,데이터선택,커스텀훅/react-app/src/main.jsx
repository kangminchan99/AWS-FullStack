import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';
import { BrowserRouter } from 'react-router-dom';
import {
  QueryCache,
  QueryClient,
  QueryClientProvider,
} from '@tanstack/react-query';

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

// 전역커스텀함수: 데이터가 들어온 뒤에 실행됨
// const queryClient = new QueryClient({
//   queryCache: new QueryCache({
//     onSuccess: (data) => console.log(data),
//     onError: (error) => console.error(`Something went wrong: ${error.message}`),
//   }),
// });

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
