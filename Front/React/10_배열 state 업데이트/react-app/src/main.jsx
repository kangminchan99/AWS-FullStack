import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';

ReactDOM.createRoot(document.getElementById('root')).render(
  // StrictMode에선 개발자 모드에서 2번 렌더링
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
