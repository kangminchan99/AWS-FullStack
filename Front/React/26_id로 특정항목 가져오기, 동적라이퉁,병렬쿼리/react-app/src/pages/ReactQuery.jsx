import { useUserName } from '../hooks/useUserName';
import { Link } from 'react-router-dom';

export default function ReactQuery() {
  const { isLoading, isFetching, data, isError, error } = useUserName();

  return (
    <div className="react_query">
      <h2>리액트 쿼리 페이지</h2>
      {/* <button type="button" onClick={refetch}>
        데이터 가져오기
      </button> */}

      <ul className="list">
        {data?.map((user) => (
          <li key={user.id}>
            <Link to={`/react-query/${user.id}`}>{user.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}
