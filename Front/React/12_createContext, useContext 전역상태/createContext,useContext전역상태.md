# createContext,useContext전역상태

## Context로 다크모드 구현하기

- context로 컴포넌트 트리안의 전역 데이터 공유 가능(테마, 현재 로그인 유저 정보)

- 상위컴포넌트에서 하위컴포넌트로 prop을 전달하려면 중간의 모든 컴포넌트를 거쳐야하므로(prop drilling) 자손 컴포넌트로 데이터를 바로 보내야 할 경우 사용

```js
// App.jsx
import './App.css';
import { useState, createContext, useEffect } from 'react';
import Header from './Header.jsx';
import Footer from './Footer.jsx';

// 전역 컨텍스트 생성, 객체를 값으로 전달하므로 초기값은 null
export const ThemeContext = createContext(null);

export default function App() {
  const [isDarkMode, setIsDarkMode] = useState(false);

  const toggleTheme = () => {
    setIsDarkMode(!isDarkMode);
  };

  // body는 dom이므로 컴포넌트함수 외부 시스템이며
  // 렌더링이 완료된후 동작되도록 useEffect사용
  useEffect(() => {
    document.body.classList.toggle('dark_theme');
  }, [isDarkMode]);

  return (
    <div className="app">
      {/* value prop으로 상위컴포넌트 데이터를 하위 컴포넌트로 전달 */}
      <ThemeContext.Provider value={{ isDarkMode, toggleTheme }}>
        <Header />
        <Footer />
      </ThemeContext.Provider>
    </div>
  );
}
```

```js
// Header.jsx
import { useContext } from 'react';
import { ThemeContext } from './App.jsx';

export default function Header() {
  // ThemeContext에는 provider에서 전달된 객체가 있으므로
  // 구조분해로 받아 provider의 상태 변수 변경
  const { isDarkMode, toggleTheme } = useContext(ThemeContext);

  return (
    <header className={`header ${isDarkMode ? 'dark_theme' : 'light_theme'}`}>
      <h2>Header</h2>
      <button type="button" onClick={toggleTheme}>
        Toggle {isDarkMode ? 'Light' : 'Dark'} Theme
      </button>
    </header>
  );
}
```

```js
// Footer.jsx
import { useContext } from 'react';
import { ThemeContext } from './App.jsx';

export default function Footer() {
  const { isDarkMode } = useContext(ThemeContext);

  return (
    <footer className={`footer ${isDarkMode ? 'dark_theme' : 'light_theme'}`}>
      <h2>Footer</h2>
    </footer>
  );
}
```

```css
.dark_theme {
  background-color: #333;
  color: #fff;
}

.light_theme {
  background-color: #fff;
  color: #333;
}

.header.dark_theme button {
  color: #fff;
  background: #000;
}
```
