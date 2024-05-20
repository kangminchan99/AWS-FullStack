import './App.css';
import { useEffect, useState } from 'react';
import MovieSearch from './MovieSearch';
import MovieTab from './MovieTab';
import MovieList from './MovieList';

const API_URL = 'http://www.omdbapi.com/?i=tt3896198&apikey=aabeaee8';

export default function App() {
  const [movies, setMovies] = useState([]);
  const [title, setTitle] = useState('bbc');
  const [type, setType] = useState('');

  useEffect(() => {
    async function searchMovies() {
      const response = await fetch(`${API_URL}&s=${title}&type=${type}`);
      const data = await response.json();

      // 년도 기준 내림차순 정렬
      // ? - Search배열이 undefined, null일 경우 sort실행하지 않게 함
      const sortData = data.Search?.sort((a, b) => (a.Year > b.Year ? -1 : 1));
      setMovies(sortData);
    }
    searchMovies();
  }, [title, type]);

  return (
    <div className="app">
      <h1>MovieLand</h1>
      <MovieSearch setTitle={setTitle}></MovieSearch>
      <MovieTab setType={setType}></MovieTab>
      <MovieList movies={movies} />
    </div>
  );
}
