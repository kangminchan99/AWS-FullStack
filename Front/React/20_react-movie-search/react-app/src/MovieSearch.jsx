import { useRef } from 'react';
import styles from './MovieSearch.module.css';

export default function MovieSearch({ setTitle }) {
  const inputRef = useRef(null);

  function handleSearch() {
    setTitle(inputRef.current.value);
  }
  return (
    <div className={styles.movie_search}>
      <form onSubmit={(e) => e.preventDefault()}>
        <input
          type="text"
          ref={inputRef}
          placeholder="제목 검색"
          title="제목 검색"
        />
        <button type="submit" onClick={handleSearch}>
          search
        </button>
      </form>
    </div>
  );
}
