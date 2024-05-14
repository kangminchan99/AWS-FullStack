import { useContext } from 'react';
import { ThemeContext } from '../App';

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
