// /app/ui/fonts.ts
import { Montserrat, Lusitana } from 'next/font/google';
import localFont from 'next/font/local';

// 변수형 폰트는 굵기 지정 안함
export const montserrat = Montserrat({
  subsets: ['latin'],
  display: 'swap',
});

// 변수형이 아닌경우 weight 지정
export const lusitana = Lusitana({
  weight: ['400', '700'],
  subsets: ['latin'],
  display: 'swap',
});

// 로컬 폰트 경로를 잡아줘서 사용
export const pretendard = localFont({
  src: [
    { path: '../../public/fonts/Pretendard-Regular.woff', weight: '400' },
    { path: '../../public/fonts/Pretendard-Medium.woff', weight: '500' },
    { path: '../../public/fonts/Pretendard-Bold.woff', weight: '700' },
  ],
  display: 'swap',
});
