import styles from './MovieTab.module.css';

export default function MovieTab({ setType, checked, setChecked }) {
  const types = ['All', 'Movie', 'Series', 'Episode'];

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
    <div>
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
    </div>
  );
}
