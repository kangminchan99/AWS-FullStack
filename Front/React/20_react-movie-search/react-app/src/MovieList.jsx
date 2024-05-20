import MovieCard from './MovieCard';
import styles from './MovieList.module.css';

export default function MovieList({ movies }) {
  return (
    <div className={styles.movie_list}>
      {/* movies배열의 길이가 1이상인 경우 리스트 렌더링, movies가 undefined일 경우 length 실행하지 않게 */}
      {movies?.length > 0 ? (
        movies.map((movie) => <MovieCard key={movie.imdbID} movie={movie} />)
      ) : (
        <p>영화 데이터 없음</p>
      )}
    </div>
  );
}
