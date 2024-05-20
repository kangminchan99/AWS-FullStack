import { useState } from 'react';
import styles from './MovieTab.module.css';

export default function MovieTab({ setType }) {
  const types = ['All', 'Movie', 'Series', 'Episode'];
  const [checked, setChecked] = useState(0);

  function handleClick(idx, event) {
    // type에 all이 없음
    if (event.target.textContent != 'All') {
      setType(event.target.textContent);
    } else {
      setType('');
    }
    setChecked(idx);
  }

  return (
    <div className={styles.movie_tab}>
      {types.map((type, i) => (
        <button
          key={type}
          type="button"
          className={checked === i ? styles.active : ''}
          onClick={(event) => handleClick(i, event)}
        >
          {type}
        </button>
      ))}
    </div>
  );
}
