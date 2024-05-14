import './App.css';
import { useState, createContext, useEffect } from 'react';
import Header from './components/Header';
import Footer from './components/Footer';

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
