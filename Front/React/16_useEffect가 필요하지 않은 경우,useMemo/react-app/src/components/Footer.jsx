import { useContext } from 'react';
import { ThemeContext } from '../App';

export default function Footer() {
  const { isDarkMode, toggleTheme } = useContext(ThemeContext);

  return (
    <footer className={`footer ${isDarkMode ? 'dark_theme' : 'light_theme'}`}>
      ⓒ NAVER Corp.
    </footer>
  );
}
