import './App.css';
import { useEffect, useState } from 'react';
import MovieSearch from './MovieSearch';
import MovieTab from './MovieTab';
import MovieList from './MovieList';
import Pagination from './components/Pagination';

const API_URL = 'http://www.omdbapi.com/?i=tt3896198&apikey=aabeaee8';

export default function App() {
  const [movies, setMovies] = useState([]);
  const [title, setTitle] = useState('bbc');
  const [type, setType] = useState('');
  const [checked, setChecked] = useState(0);
  const [page, setPage] = useState(1);
  const [totalPage, setTotalPage] = useState(0);

  useEffect(() => {
    async function searchMovies() {
      // 서버에 요청한 응답 데이터
      const response = await fetch(
        `${API_URL}&s=${title}&type=${type}&page=${page}`
      );
      // 서버에서 받아온 json을 js로 변환
      const data = await response.json();

      // 년도 기준 내림차순 정렬
      // ? - Search배열이 undefined, null일 경우 sort실행하지 않게 함
      const sortData = data.Search?.sort((a, b) => (a.Year > b.Year ? -1 : 1));
      setMovies(sortData);
      setTotalPage(Math.ceil(data.totalResults / 10));
    }
    searchMovies();
  }, [title, type, page]);

  return (
    <div className="app">
      <h1>MovieLand</h1>
      <MovieSearch
        setTitle={setTitle}
        setType={setType}
        setChecked={setChecked}
        setPage={setPage}
      ></MovieSearch>
      <MovieTab
        setType={setType}
        checked={checked}
        setChecked={setChecked}
      ></MovieTab>
      <MovieList movies={movies} />
      {/* movies 배열이 있는 경우만 실행 */}
      {movies && (
        <Pagination
          page={page}
          setPage={setPage}
          totalPage={totalPage}
          limit={5}
        ></Pagination>
      )}
    </div>
  );
}
