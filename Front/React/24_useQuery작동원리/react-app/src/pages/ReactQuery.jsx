import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';

export default function ReactQuery() {
  // main.jsx에서 생성한 queryClient컨텍스트 가져오기
  const queryClient = useQueryClient();

  const { isLoading, data, isError, error } = useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),
    // gcTime: 5000,
    staleTime: 6000,
    refetchInterval: 2000,
    refetchIntervalInBackground: true,
  });

  const { mutate } = useMutation({
    mutationFn: (user) =>
      fetch('/people', {
        method: 'POST',
        body: JSON.stringify(user),
      }),
    onSuccess: () => {
      // userInfo키의 데이터 초기화후 서버의 데이터 다시 가져옴
      queryClient.invalidateQueries({ queryKey: ['userInfo'] });
    },
  });

  if (isLoading) return <>Loading...</>;

  if (isError) return <>{error.message}</>;

  function handleCreateUser() {
    const user = {
      id: Date.now(),
      name: 'son',
      country: 'asia',
      lang: 'php',
    };
    mutate(user);
  }

  return (
    <div className="react_query">
      <h2>리액트 쿼리 페이지</h2>
      <ul className="list">
        {data?.map((person) => (
          <li key={person.id}>
            이름: {person.name} / 국가: {person.country} / 개발언어:{' '}
            {person.lang}
          </li>
        ))}
      </ul>
      <button type="button" onClick={handleCreateUser}>
        user 추가
      </button>
    </div>
  );
}
