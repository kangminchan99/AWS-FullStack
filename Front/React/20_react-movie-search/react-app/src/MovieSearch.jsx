import { useRef } from 'react';
import styles from './MovieSearch.module.css';

export default function MovieSearch({
  setTitle,
  setType,
  setChecked,
  setPage,
}) {
  const inputRef = useRef(null);

  function handleSearch() {
    if (inputRef.current.value.trim() != '') {
      setTitle(inputRef.current.value);
      setType('');
      setChecked(0);
      setPage(1);
    }
  }
  return (
    <div className={styles.movie_search}>
      <form onSubmit={(e) => e.preventDefault()}>
        <input
          type="search"
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
