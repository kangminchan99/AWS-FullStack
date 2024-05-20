import { useContext } from 'react';
import { ThemeContext } from '../App';
import logo from '@/assets/images/react.svg';

export default function Header() {
  const { isDarkMode, toggleTheme } = useContext(ThemeContext);

  return (
    <header className={`header ${isDarkMode ? 'dark_theme' : 'light_theme'}`}>
      <h1>
        <img src={logo} alt="리액트" />
      </h1>
      <button type="button" className="btn" onClick={toggleTheme}>
        Toggle {isDarkMode ? 'Light' : 'Dark'} Theme
      </button>
    </header>
  );
}
