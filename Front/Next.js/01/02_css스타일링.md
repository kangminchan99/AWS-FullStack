# css 스타일

- 테일윈드 유틸리티 css 기본으로 사용하며 테일윈드 적용안되는 경우 css 모듈 사용

## 글로벌 스타일 추가

- 최상위 레이아웃 컴포넌트에 글로벌 css 추가

```js
// /app/layout.tsx
import '@/app/ui/global.css';

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="ko">
      <body>{children}</body>
    </html>
  );
}
```

- global.css에서 Unknown at rule @tailwind css 경고 끄기

- 설정>unknown검색>CSS>Lint: Unknown At Rules: ignore

## 테일윈드

- prettier-plugin-tailwindcss 패키지에 의해 권장순서에 따라 클래스명 자동 정렬

- vscode 익스텐션: Tailwind CSS IntelliSense 설치

- 커스텀 컬러 등록, 반응형 분기점 등록

- 테일윈드 기본값은 모바일 first md: 768이상, lg: 1024이상이며 대시보드 예제는 기본값으로 진행

```js
// /tailwind.config.ts
import type { Config } from 'tailwindcss';

const config: Config = {
  content: [
    './pages/**/*.{js,ts,jsx,tsx,mdx}',
    './components/**/*.{js,ts,jsx,tsx,mdx}',
    './app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    // screens: {
    //   // @media (max-width: 1200px) { ... }
    //   md: { max: '1200px' },
    //   // @media (max-width: 767px) { ... }
    //   sm: { max: '767px' },
    // },
    extend: {
      gridTemplateColumns: {
        '13': 'repeat(13, minmax(0, 1fr))',
      },
      colors: {
        blue: {
          400: '#2589FE',
          500: '#0070F3',
          600: '#2F6FEB',
        },
        gray: {
          400: '#999',
          500: '#666',
          600: '#292929',
        },
        'point-color1': '#ffce32',
        'point-color2': '#009223',
      },
    },
    keyframes: {
      shimmer: {
        '100%': {
          transform: 'translateX(100%)',
        },
      },
    },
  },
  plugins: [require('@tailwindcss/forms')],
};
export default config;
```

- 테일윈드 기본단위가 rem이므로 모바일 브라우저 접근성 설정에 의한 레이아웃 변경 방지

```css
/* /app/ui/global.css */
@tailwind base;
@tailwind components;
@tailwind utilities;

/* 테일윈드 기본단위가 rem이므로 모바일 브라우저 접근성 설정에 의한 레이아웃 변경 방지 */
html {
  font-size: 16px;
}

input[type='number'] {
  -moz-appearance: textfield;
  appearance: textfield;
}

input[type='number']::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

input[type='number']::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
```

- 임의의 값 사용시 [30px], [#0f0], p태그 위에 추가후 테스트

```js
// 메
<div className="h-0 w-0 border-b-[30px] border-l-[20px] border-r-[20px] border-b-[black] border-l-transparent border-r-transparent sm:border-b-[green] md:border-b-[red]" />
```

## css 모듈

```css
/* /app/ui/home.module.css */
.shape {
  height: 0;
  width: 0;
  border-bottom: 30px solid black;
  border-left: 20px solid transparent;
  border-right: 20px solid transparent;
}

@media (max-width: 1200px) {
  .shape {
    border-bottom-color: red;
  }
}

@media (max-width: 767px) {
  .shape {
    border-bottom-color: green;
  }
}
```

```js
import styles from '@/app/ui/home.module.css';

<div className={styles.shape} />
```

- 테일윈드와  css모듈 같이 사용시 템플릿문자열 사용

```js
<div className={`${styles.shape} h-0 w-0 border-b-[30px] border-l-[20px] border-r-[20px] border-b-[black] border-l-transparent border-r-transparent sm:border-b-[green] md:border-b-[red]`} />
```

## clsx 패키지로 조건부 스타일 작성

- status가 'pending'이면 회색, 'paid'면 녹색배경

```js
// /app/ui/invoices/status.tsx
import { CheckIcon, ClockIcon } from '@heroicons/react/24/outline';
import clsx from 'clsx';

export default function InvoiceStatus({ status }: { status: string }) {
  return (
    <span
      className={clsx(
        'inline-flex items-center rounded-full px-2 py-1 text-xs',
        {
          'bg-gray-100 text-gray-500': status === 'pending',
          'bg-green-500 text-white': status === 'paid',
        },
      )}
    >
      {status === 'pending' ? (
        <>
          Pending
          <ClockIcon className="ml-1 w-4 text-gray-500" />
        </>
      ) : null}
      {status === 'paid' ? (
        <>
          Paid
          <CheckIcon className="ml-1 w-4 text-white" />
        </>
      ) : null}
    </span>
  );
}
```
