# css 모듈

## css 지정방식 3가지

### styled-components

- css in js방식이며 컴포넌트 내부에서 사용

- css가 복잡할 경우 컴포넌트 내부 가독성이 떨어짐

- 패키지 설치해야 하므로 빌드시 번들크기 증가

- jsx내 태그가 변수명으로 변경되므로 태그 구조를 코드상에서 확인하기 어려움

```js
import styled from 'styled-components';

// Create a Title component that'll render an <h1> tag with some styles
const Title = styled.h1`
  font-size: 1.5rem;
  text-align: center;
  color: #333;
`;

// Create a Wrapper component that'll render a <section> tag with some styles
const Wrapper = styled.section`
  padding: 4em;
  background: papayawhip;
`;

// Use Title and Wrapper like any other React component – except they're styled!
render(
  <Wrapper>
    <Title>
      Hello World!
    </Title>
  </Wrapper>
);
```

### 테일윈드 유틸리티 css

- 미리정의된 스타일을 정해진 클래스명으로 지정하는 방식(부트스트랩과 유사)

- 테일윈드 방식을 익혀야하므로 러닝커브 존재

- 테일윈드만으로 안되는 경우 있으므로 다른방식 같이 사용해야함

- class명이 점점 길어질 경우 가독성 현격히 떨어짐

- 클래스명을 따로 생각하지않아도 되는 부분이 장점

- 토이프로젝트나 css가 매우 간단할 경우 사용하는것이 좋으며 css가 익숙하지않으면 사용하지않는것이 바람직

```js
<div class="p-6 max-w-sm mx-auto bg-white rounded-xl shadow-md flex items-center space-x-4">
      <div class="flex-shrink-0">
        <img class="h-12 w-12" src={logo} alt="ChitChat Logo" />
      </div>
      <div>
        <div class="text-xl font-medium text-black">ChitChat</div>
        <p class="text-gray-500">You have a new message!</p>
      </div>
    </div>
```

### css 모듈

- 리액트, next.js에서 공식적으로 지원
- 컴포넌트별 클래스명이 같아도 고유해시가 붙기때문에 중복되지않음
- 패키지 설치하지않음
- css가 복잡하더라도 파일이 따로 있으므로 가독성 향상
- 컴포넌트의 jsx가 깔끔
- 컴포넌트별 css 파일을 만드는 부분이 단점이나 관심사 분리 원칙을 지킨 것이므로 괜찮음

![KakaoTalk_20231217_160508533.png](E:\03_종로더조은수업\00_클라우드(AWS)%20환경에서%20개발하는%20풀스택(프론트엔드,백엔드)%20자바(JAVA)웹,앱(더조은종로,418,202210)_원본\09_리액트(미완)\18_css모듈\KakaoTalk_20231217_160508533.png)

```css
// components/StatusBar.module.css
.wrap {
  padding: 20px 0px;
  border-bottom: 1px solid #ddd;
}
```

```js
// components/StatusBar.jsx
import { useOnlineStatus } from '../hooks/useOnlineStatus';
import styles from './StatusBar.module.css';

export default function StatusBar() {
  const isOnline = useOnlineStatus();

  return (
    <div className={styles.wrap}>
      <p className={styles.txt}>{isOnline ? '✅ 온라인' : '❌ 연결 안 됨'}</p>
    </div>
  );
}
```

```css
// components/SaveButton.module.css
.wrap {
  padding: 20px 1px;
  display: flex;
  align-items: center;
  gap: 0 20px;
}

.save_btn {
  padding: 0 10px;
  border: 1px solid #333;
  border-radius: 4px;
  display: inline-flex;
  height: 40px;
  align-items: center;
  font-size: 1.5rem;
}

/* .save_btn.active {
  color: var(--primary-color);
  border-color: var(--primary-color);
} */
```

```js
// components/SaveButton.jsx
import { useOnlineStatus } from '../hooks/useOnlineStatus';
import styles from './SaveButton.module.css';

export default function SaveButton() {
  const isOnline = useOnlineStatus();

  function handleSaveClick() {
    console.log('✅ 진행사항 저장됨');
  }

  return (
    <div className={styles.wrap}>
      <button
        className={`${styles.save_btn} ${styles.active}`}
        type="button"
        disabled={!isOnline}
        onClick={handleSaveClick}
      >
        {isOnline ? '진행사항 저장' : '재연결 중...'}
      </button>
      <p>진행사항이 저장중입니다.</p>
    </div>
  );
}
```

```js
// App.jsx
import styles from './App.module.css';
import SaveButton from './components/SaveButton.jsx';
import StatusBar from './components/StatusBar.jsx';

export default function App() {
  return (
    <div className={styles.app}>
      <StatusBar />
      <SaveButton />
    </div>
  );
}
```

```js
// hooks/useOnlineStatus.js
import { useState, useEffect } from 'react';

export function useOnlineStatus() {
  // 온라인상태 추적하여 화면내용 변경해야하므로 state사용
  const [isOnline, setIsOnline] = useState(true);

  // 브라우저 API이므로 외부시스템과 동기화위해 effect사용
  useEffect(() => {
    function handleOnline() {
      setIsOnline(true);
    }

    function handleOffline() {
      setIsOnline(false);
    }

    window.addEventListener('online', handleOnline);
    window.addEventListener('offline', handleOffline);

    // 컴포넌트가 사라질경우(언마운트) 이벤트리스너가 필요없으므로 클린업에서 이벤트리스너 삭제
    return () => {
      window.removeEventListener('online', handleOnline);
      window.removeEventListener('offline', handleOffline);
    };
    // 종속성에 빈 배열로 한번만 실행
  }, []);

  // 다른컴포넌트에서 읽을 수 있도록 리턴
  return isOnline;
}
```
