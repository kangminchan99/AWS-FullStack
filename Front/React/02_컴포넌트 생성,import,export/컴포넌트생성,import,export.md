# 컴포넌트생성,import,export

- 컴포넌트: 재사용 가능한 UI요소, 마크업으로 뿌릴 수 있는 자바스크립트 함수이므로 재사용이 아니더라도 기능별 컴포넌트(함수)로 생성하여 유지보수가 쉽도록 해줌 

- 컴포넌트 이름은 일반함수와 구별위해 파스칼표기법, jsx마크업을 반환하는 함수

- return 뒤에 jsx로 마크업, 한줄 아닐 경우 ()로 묶어야함

- jsx는 self closing 태그 `<img />` 형식

```js
// App.jsx
function Profile() {
  return <img src="https://i.imgur.com/MK3eW3Am.jpg" alt="Katherine Johnson" />;
}
```

```js
return (
  <div>
    <img src="https://i.imgur.com/MK3eW3As.jpg" alt="Katherine Johnson" />
  </div>
);
```

## 컴포넌트 사용

- 다른곳에서 사용하지않고 서로 밀접하게 관련된 경우 같은 파일안에 컴포넌트 생성

- Gallery는 부모컴포넌트, Profile은 자식컴포넌트

- 컴포넌트 안에서 다른 컴포넌트 정의 불가, 최상위 레벨(파일)에 정의

```js
function Profile() {
  return <img src="https://i.imgur.com/MK3eW3Am.jpg" alt="Katherine Johnson" />;
}

export default function Gallery() {
  return (
    <section>
      <h2>놀라운 과학자들</h2>
      <Profile />
      <Profile />
      <Profile />
    </section>
  );
}
```

### 챌린지: Hello컴포넌트 만들고 프로필 아래 추가하기

- jsx마크업은 부모 태그 하나에 포함되야하며 필요없을 경우 <></> 프레그먼트 사용

```js
function Hello() {
  return (
    <>
      <h2>리액트</h2>
      <p>리액트를 배워보자</p>
    </>
  );
}
```

## 컴포넌트 import, export

- 재사용하려면 컴포넌트가 파일로 분리되 있어야함

- 파일 = 모듈이며 es모듈로 파일간 접근가능

- Gallery.jsx 파일 생성

- 함수컴포넌트 default로 export하면 import시 이름 변경가능

```js
// Gallery.jsx
function Profile() {
  return <img src="https://i.imgur.com/MK3eW3Am.jpg" alt="Katherine Johnson" />;
}

export default function Gallery() {
  return (
    <section>
      <h2>놀라운 과학자들</h2>
      <Profile />
      <Profile />
      <Profile />
    </section>
  );
```

- 상대경로(./ 생략불가)로 컴포넌트 import, 확장자는 생략가능하지만 명시하는게 좋음

```js
import './App.css';
import Gallery from './Gallery.jsx';

export default function App() {
  return <Gallery />;
}
```

## Default와 Named Export

- 한 파일에는 하나의 export default만 존재해야하며 부모함수컴포넌트는 export default하여 import시 {}없이 가져오며 이름변경가능

- named export는 최상위(파일) 레벨에서만 가능하며 import시 { 변수명, 함수명 as 함수명2}로 가져오며 as로 이름변경가능

- 일반적으로 한파일에서 하나의 컴포넌트를 export default하며 여러 컴포넌트일 경우 named export사용

## 한 파일에서 여러 컴포넌트 export

```js
// Gallery.jsx
export function Profile() {
  return <img src="https://i.imgur.com/MK3eW3Am.jpg" alt="Katherine Johnson" />;
}

export default function Gallery() {
  return (
    <section>
      <h2>놀라운 과학자들</h2>
      <Profile />
      <Profile />
      <Profile />
    </section>
  );
}
```

```js
import './App.css';
import Gallery, { Profile } from './Gallery.jsx';

export default function App() {
  return (
    <>
      <Gallery />
      <Profile />
    </>
  );
}
```

### 챌린지: Profile.jsx와 Gallery.jsx 컴포넌트로 각각 분리하여 App.jsx에서 모두 사용하기

```js
// Profile.jsx
export default function Profile() {
  return <img src="https://i.imgur.com/MK3eW3Am.jpg" alt="Katherine Johnson" />;
}
```

```js
// Gallery.jsx
import Profile from './Profile.jsx';

export default function Gallery() {
  return (
    <section>
      <h2>놀라운 과학자들</h2>
      <Profile />
      <Profile />
      <Profile />
    </section>
  );
}
```

```js
// App.jsx
import './App.css';
import Gallery from './Gallery.jsx';
import Profile from './Profile.jsx';

export default function App() {
  return (
    <>
      <Gallery />
      <Profile />
    </>
  );
}
```
