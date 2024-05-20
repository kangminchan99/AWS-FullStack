import styles from './MovieCard.module.css';

export default function MovieCard({ movie }) {
  return (
    <ul>
      <li className={styles.movie_card}>
        <p>{movie.Year}</p>
        <div className={styles.img_wrap}>
          <img
            src={
              movie.Poster !== 'N/A' ? movie.Poster : 'https://placehold.co/400'
            }
            alt={movie.Title}
          />
        </div>
        <div className={styles.txt_wrap}>
          <span>{movie.Type}</span>
          <strong>{movie.Title}</strong>
        </div>
      </li>
    </ul>
  );
}
