// Footer.jsx
import { useContext } from 'react';
import { ThemeContext } from '../App';

export default function Footer() {
  const { isDarkMode } = useContext(ThemeContext);

  return (
    <footer className={`footer ${isDarkMode ? 'dark_theme' : 'light_theme'}`}>
      <h2>Footer</h2>
    </footer>
  );
}
