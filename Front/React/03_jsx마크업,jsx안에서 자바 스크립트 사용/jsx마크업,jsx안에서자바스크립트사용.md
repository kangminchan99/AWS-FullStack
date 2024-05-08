# jsx마크업,jsx안에서 자바스크립트 사용

- 컴포넌트에서 렌더링 로직과 마크업을 한번에 표현하여 return

- 하나의 부모 태그로 감싸야하며 부모태그를 쓰지않을 경우 <> </> 프레그먼트 사용

- jsx내부에서 여러 객체를 하나의 배열로 감싸서 return하는 것과 같음

- self closing 태그도 `<br />` `<img />` 형태로 닫아야함

- 태그 속성명은 카멜케이스이며 예약어인 경우 className, htmlFor 사용

## html을 jsx로 변환하여 TodoList컴포넌트 만들기

```html
<h2>Hedy Lamarr's Todos</h2>
<img src="https://i.imgur.com/yXOvdOSs.jpg" alt="" class="photo">
<ul>
  <li>새로운 신호등 발명</li>
  <li>영화 장면 리허설</li>
  <li>스펙트럼 기술 개선</li>
</ul>
<div class="checkbox_wrap">
  <input id="check1" type="checkbox">
  <label for="check1">체크박스</label>
</div>
```

```js
import './App.css';

export default function TodoList() {
  return (
    <>
      <h2>Hedy Lamarr's Todos</h2>
      <img src="https://i.imgur.com/yXOvdOSs.jpg" alt="" className="photo" />
      <ul>
        <li>새로운 신호등 발명</li>
        <li>영화 장면 리허설</li>
        <li>스펙트럼 기술 개선</li>
      </ul>
      <div className="checkbox_wrap">
        <input id="check1" type="checkbox" />
        <label htmlFor="check1">체크박스</label>
      </div>
    </>
  );
}
```

## jsx에서 자바스크립트 사용

- 동적인 값은 {}로 전달

- src와 alt 동적으로 지정

```js
import './App.css';

export default function Avatar() {
  const avatar = 'https://i.imgur.com/7vQD0fPs.jpg';
  const description = 'Gregorio Y. Zara';

  return <img className="avatar" src={avatar} alt={description} />;
}
```

- 태그 내부에 전달할때도 {}

```js
import './App.css';

export default function TodoList() {
  const name = '오쌤';

  return <h2>{name}'s To Do List</h2>;
}
```

- 함수호출

- new Intl.DateTimeFormat: 날짜 및 시간을 현지화된 형식으로 표시해주는 표준 API

```js
import './App.css';

function formatDate(date) {
  return new Intl.DateTimeFormat('ko-KR', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    hour12: false,
    weekday: 'long',
  }).format(date);
}

export default function TodoList() {
  return <h1>To Do List for {formatDate(new Date())}</h1>;
}
```

- 객체 전달시 {{}} 이중 중괄호 사용
- css속성명의 -는 자바스크립트 연산자이므로 카멜케이스여야함

```js
import './App.css';

export default function TodoList() {
  return (
    <ul
      style={{
        backgroundColor: 'black',
        color: 'pink',
      }}
    >
      <li>화상전화 개선</li>
      <li>항공학 강의 준비</li>
      <li>알코올 연료 엔진 작업</li>
    </ul>
  );
}
```

- 객체 사용하여 값 전달하기

```js
import './App.css';

const pet = {
  name: '코코',
  theme: {
    backgroundColor: '#ffc107',
    color: '#000',
  },
};

export default function TodoList() {
  return (
    <div style={pet.theme}>
      <h2>{pet.name}'s Todos</h2>
      <img
        className="avatar"
        src="http://ossamuiux.com/react-img/dog.jpg"
        alt=""
      />
      <ul>
        <li>밥먹기</li>
        <li>산책하기</li>
        <li>까불기</li>
      </ul>
    </div>
  );
}
```

### 챌린지: 실수 고치기

- Objects are not valid as a React child 오류

- 객체를 자식요소로 직접 사용한 경우 발생하며 객체의 속성을 사용해야함

```js
import './App.css';

const pet = {
  name: '코코',
  theme: {
    backgroundColor: '#ffc107',
    color: '#000',
  },
};

export default function TodoList() {
  return (
    <div style={pet.theme}>
      <h2>{pet}'s Todos</h2>
      <img
        className="avatar"
        src="http://ossamuiux.com/react-img/dog.jpg"
        alt=""
      />
      <ul>
        <li>밥먹기</li>
        <li>산책하기</li>
        <li>까불기</li>
      </ul>
    </div>
  );
}
```

### 챌린지: 이미지 url을 pet 객체로 추출하기

```js
import './App.css';

const pet = {
  name: '코코',
  imageUrl: 'http://ossamuiux.com/react-img/dog.jpg',
  theme: {
    backgroundColor: '#ffc107',
    color: '#000',
  },
};

export default function TodoList() {
  return (
    <div style={pet.theme}>
      <h2>{pet.name}'s Todos</h2>
      <img className="avatar" src={pet.imageUrl} alt="" />
      <ul>
        <li>밥먹기</li>
        <li>산책하기</li>
        <li>까불기</li>
      </ul>
    </div>
  );
}
```

### 챌린지: jsx 중괄호 안에 표현식 작성하기

- 아래 객체에서 전체 이미지 URL은 기본 URL, `imageId`, `imageSize` 및 파일 확장자 네 부분으로 나누어져 있으며 img의 src 지정방식에 문제가 있다
- 이미지 연결되면 imageSize:'b'로 변경해보기

```js
const baseUrl = 'https://i.imgur.com/';
const person = {
  name: 'Gregorio Y. Zara',
  imageId: '7vQD0fP',
  imageSize: 's',
  theme: {
    backgroundColor: 'black',
    color: 'pink'
  }
};

export default function TodoList() {
  return (
    <div style={person.theme}>
      <h1>{person.name}'s Todos</h1>
      <img
        className="avatar"
        src="{baseUrl}{person.imageId}{person.imageSize}.jpg"
        alt={person.name}
      />
      <ul>
        <li>화상전화 개선</li>
        <li>항공학 강의 준비</li>
        <li>알코올 연료 엔진 작업</li>
      </ul>
    </div>
  );
}
```

```js
// App.jsx
import './App.css';

const baseUrl = 'https://i.imgur.com/';
const person = {
  name: 'Gregorio Y. Zara',
  imageId: '7vQD0fP',
  imageSize: 's',
  theme: {
    backgroundColor: 'black',
    color: 'pink',
  },
};

export default function TodoList() {
  return (
    <div style={person.theme}>
      <h1>{person.name}'s Todos</h1>
      <img
        className="avatar"
        // src={baseUrl + person.imageId + person.imageSize + '.jpg'}
        src={`${baseUrl}${person.imageId}${person.imageSize}.jpg`}
        alt={person.name}
      />
      <ul>
        <li>화상전화 개선</li>
        <li>항공학 강의 준비</li>
        <li>알코올 연료 엔진 작업</li>
      </ul>
    </div>
  );
}
```

## utils.js에 getImageUrl 함수로 분리하기

```js
// utils.js
export function getImageUrl(person) {
  return `https://i.imgur.com/${person.imageId}${person.imageSize}.jpg`;
}
```

```js
// App.jsx
import './App.css';
import { getImageUrl } from './utils.js';

const person = {
  name: 'Gregorio Y. Zara',
  imageId: '7vQD0fP',
  imageSize: 's',
  theme: {
    backgroundColor: 'black',
    color: 'pink',
  },
};

export default function TodoList() {
  return (
    <div style={person.theme}>
      <h2>{person.name}'s Todos</h2>
      <img className="avatar" src={getImageUrl(person)} alt={person.name} />
      <ul>
        <li>화상전화 개선</li>
        <li>항공학 강의 준비</li>
        <li>알코올 연료 엔진 작업</li>
      </ul>
    </div>
  );
}
```
