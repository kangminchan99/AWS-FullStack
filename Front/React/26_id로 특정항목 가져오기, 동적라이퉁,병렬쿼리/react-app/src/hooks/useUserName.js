import { useQuery } from '@tanstack/react-query';

export function useUserName() {
  return useQuery({
    queryKey: ['userInfo'],
    queryFn: () => fetch('/people').then((res) => res.json()),

    // enabled: false,
  });
}
