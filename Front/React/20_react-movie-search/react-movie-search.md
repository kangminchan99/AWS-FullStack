# react-movie-search-app

## 영화데이터 API 사용하기

- OMDB사이트 > API Key - FREE, 이메일, 이름, 사용목적 입력

- 이메일에서 **activate your key: 인증문자열 반드시 클릭하여 활성화**후 API키 포함된 주소 복사 붙이기

## 비동기 함수에서 데이터 fetch

```js
// App.jsx
import { useState, useEffect } from 'react';
import './App.css';

// API 엔드포인트 대문자 스네이크로 상수 선언
const API_URL = 'http://www.omdbapi.com/?i=tt3896198&apikey=16484246';

export default function App() {
  // 외부 시스템과 동기화이므로 useEffect
  useEffect(() => {
    // 비동기 함수 선언
    async function searchMovies(title) {
      // await 키워드로 프라미스객체 리턴시까지 기다림
      const response = await fetch(`${API_URL}&s=${title}`);
      // 자바스크립트 객체로 변환 기다림
      const data = await response.json();
      console.log(data.Search);
    }
    searchMovies('spiderman');
  }, []);

  return (
    <div className="pp">
      <h1>MovieLand</h1>
    </div>
  );
}
```

## mock data 세팅, state 설정, effect 의존성 설정 및 sort

- 콘솔에서 data.Search 배열중 객체 한개 복사후 mock data로 movie card 구성하기

```js
import { useState, useEffect } from 'react';
import MovieCard from './components/MovieCard.jsx';
import './App.css';

const API_URL = 'http://www.omdbapi.com/?i=tt3896198&apikey=16484246';

const movie = {
  Title: 'Italian Spiderman',
  Year: '2007',
  imdbID: 'tt2705436',
  Type: 'movie',
  // Poster: 'N/A',
  Poster:
    'https://m.media-amazon.com/images/M/MV5BZWQxMjcwNjItZjI0ZC00ZTc4LWIwMzItM2Q0YTZhNzI3NzdlXkEyXkFqcGdeQXVyMTA0MTM5NjI2._V1_SX300.jpg',
};

export default function App() {
  const [movies, setMovies] = useState([]);
  const [totalPage, setTotalPage] = useState(0);
  const [title, setTitle] = useState('bbc');
  const [type, setType] = useState('');
  const [page, setPage] = useState(1);

 useEffect(() => {
    async function searchMovie() {
      const response = await fetch(
        `${API_URL}&s=${title}&type=${type}&page=${page}`
      );
      const data = await response.json();
      setTotalPage(Math.ceil(data.totalResults / 10));

      const sortData = data.Search?.sort((a, b) => (a.Year > b.Year ? -1 : 1));
      setMovies(sortData);
    }
    searchMovie();
  }, [title, type, page]);

  return (
    <div className="App">
      <h1>MovieLand</h1>
    </div>
  );
}
```

## MovieCard 컴포넌트 구현

```js
// components/MovieCard.jsx
export default function MovieCard({ movie }) {
  return (
    <div className="movie_card">
      <p>{movie.Year}</p>
      <div className="img_wrap">
        <img
          src={
            movie.Poster !== 'N/A' ? movie.Poster : 'https://placehold.co/400'
          }
          alt={movie.Title}
        />
      </div>
      <div className="txt_wrap">
        <span>{movie.Type}</span>
        <strong>{movie.Title}</strong>
      </div>
    </div>
  );
}
```

## MovieSearch 컴포넌트 구현

```js
// components/MovieSearch.jsx
import { useRef } from 'react';

export default function MovieSearch({ setTitle, setType, setPage }) {
  const inputRef = useRef(null);

  function handleSearch() {
    setTitle(inputRef.current.value);
    setType('');
    setPage(1);
  }

  return (
    <div className="movie_search">
      <input
        type="text"
        ref={inputRef}
        placeholder="영화검색"
        title="영화검색"
      />
      <button type="button" onClick={handleSearch}>
        검색
      </button>
    </div>
  );
}
```

## MovieTab 컴포넌트 구현

```js
import { useState } from 'react';

export default function MovieTab({ setType }) {
  const types = ['All', 'Movie', 'Series', 'Episode'];
  // 탭메뉴 active 스테이트
  const [activeBtn, setActiveBtn] = useState(0);

  function handleChangeType(e, idx) {
    if (e.target.innerText !== 'All') {
      setType(e.target.innerText);
    } else {
      setType('');
    }

    // active 변경
    setActiveBtn(idx);
  }

  function handleActiveBtn(idx) {
    setActiveBtn(idx);
  }

  return (
    <div className="movie_tab">
      {types.map((item, i) => (
        <button
          type="button"
          // 이벤트객체와 map실행시 각각의 인덱스 전달
          onClick={(e) => handleChangeType(e, i)}
          key={item}
          className={activeBtn === i ? 'active' : ''}
        >
          {item}
        </button>
      ))}
    </div>
  );
}
```

## App 컴포넌트 연결

```js
import { useState, useEffect } from 'react';
import MovieSearch from './components/MovieSearch.jsx';
import MovieTab from './components/MovieTab.jsx';
import MovieCard from './components/MovieCard.jsx';
import './App.css';

const API_URL = 'https://www.omdbapi.com/?i=tt3896198&apikey=16484246';

export default function App() {
  const [movies, setMovies] = useState([]);
  const [totalPage, setTotalPage] = useState(0);
  const [title, setTitle] = useState('bbc');
  const [type, setType] = useState('');
  const [page, setPage] = useState(1);

  useEffect(() => {
    async function searchMovie() {
      const response = await fetch(
        `${API_URL}&s=${title}&type=${type}&page=${page}`
      );
      const data = await response.json();
      setTotalPage(Math.ceil(data.totalResults / 10));

      const sortData = data.Search?.sort((a, b) => (a.Year > b.Year ? -1 : 1));
      setMovies(sortData);
    }
    searchMovie();
  }, [title, type, page]);

  return (
    <div className="app">
      <MovieSearch setTitle={setTitle} setType={setType} setPage={setPage} />
      <MovieTab setType={setType} />
      <div className="movie">
        {movies?.length > 0 ? (
          movies.map((movie) => <MovieCard movie={movie} key={movie.imdbID} />)
        ) : (
          <p>영화데이터 없음</p>
        )}
      </div>
    </div>
  );
}
```

## Pagination 구현

- 전체페이지를 페이지 리미트 만큼 잘라서 배열로 리턴해주는 함수 이용

```js
// utils.js
export function sliceArrayByLimit(totalPage, limit) {
  const totalPageArray = Array(totalPage)
    .fill()
    .map((_, i) => i);
  return Array(Math.ceil(totalPage / limit))
    .fill()
    .map(() => totalPageArray.splice(0, limit));
}
```

```js
// components/Pagination.jsx
import { useState, useEffect } from 'react';
import { sliceArrayByLimit } from '../utils.js';

export default function Pagination({ totalPage, limit, page, setPage }) {
  const [currentPageArray, setCurrentPageArray] = useState([]);
  const [totalPageArray, setTotalPageArray] = useState([]);

  useEffect(() => {
    if (page % limit === 1) {
      setCurrentPageArray(totalPageArray[Math.floor(page / limit)]);
    } else if (page % limit === 0) {
      setCurrentPageArray(totalPageArray[Math.floor(page / limit) - 1]);
    }
  }, [page]);

  useEffect(() => {
    const slicedPageArray = sliceArrayByLimit(totalPage, limit);
    setTotalPageArray(slicedPageArray);
    setCurrentPageArray(slicedPageArray[0]);
  }, [totalPage]);

  return (
    <div className="pagination">
      {page !== 1 && (
        <button type="button" onClick={() => setPage(page - 1)}>
          이전
        </button>
      )}
      {currentPageArray?.map((v) => (
        <button
          className={`num_btn ${page === v + 1 && 'active'}`}
          key={v}
          type="button"
          onClick={() => setPage(v + 1)}
        >
          {v + 1}
        </button>
      ))}
      {page !== totalPage && (
        <button type="button" onClick={() => setPage(page + 1)}>
          다음
        </button>
      )}
    </div>
  );
}
```

## App 컴포넌트 Pagination 연결

```js
// App.jsx
import { useState, useEffect } from 'react';
import MovieSearch from './components/MovieSearch.jsx';
import MovieTab from './components/MovieTab.jsx';
import MovieCard from './components/MovieCard.jsx';
import Pagination from './components/Pagination.jsx';
import './App.css';

const API_URL = 'https://www.omdbapi.com/?i=tt3896198&apikey=16484246';

export default function App() {
  const [movies, setMovies] = useState([]);
  const [totalPage, setTotalPage] = useState(0);
  const [title, setTitle] = useState('bbc');
  const [type, setType] = useState('');
  const [page, setPage] = useState(1);

  useEffect(() => {
    async function searchMovie() {
      const response = await fetch(
        `${API_URL}&s=${title}&type=${type}&page=${page}`
      );
      const data = await response.json();
      setTotalPage(Math.ceil(data.totalResults / 10));

      const sortData = data.Search?.sort((a, b) => (a.Year > b.Year ? -1 : 1));
      setMovies(sortData);
    }
    searchMovie();
  }, [title, type, page]);

  return (
    <div className="app">
      <MovieSearch setTitle={setTitle} setType={setType} setPage={setPage} />
      <MovieTab setType={setType} />
      <div className="movie">
        {movies?.length > 0 ? (
          movies.map((movie) => <MovieCard movie={movie} key={movie.imdbID} />)
        ) : (
          <p>영화데이터 없음</p>
        )}
      </div>
      {!isNaN(totalPage) && (
        <Pagination
          totalPage={totalPage}
          limit={5}
          page={page}
          setPage={setPage}
        />
      )}
    </div>
  );
}
```
