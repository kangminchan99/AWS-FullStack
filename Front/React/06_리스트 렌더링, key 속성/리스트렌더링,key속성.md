# 리스트렌더링,key속성

- 배열 데이터는 map메서드로 렌더링

- 리스트가 정렬, 이동, 삭제등으로 변경되더라도 리액트가 알 수 있도록 고유 key 제공해야함

```js
// App.jsx
import './App.css';

const people = [
  'Creola Katherine Johnson: 수학자',
  'Mario José Molina-Pasquel Henríquez: 화학자',
  'Mohammad Abdus Salam: 물리학자',
  'Percy Lavon Julian: 화학자',
  'Subrahmanyan Chandrasekhar: 천체 물리학자',
];

export default function List() {
  const listItems = people.map((person) => <li key={person}>{person}</li>);

  return <ul>{listItems}</ul>;
}
```

## 배열의 객체 필터링하기

- 익명함수로 화살표 함수 사용시 한줄일 경우 {return} 생략가능

- 리스트의 key로 사용하기위해 데이터에 id가 포함되야함

```js
// data.js
export const people = [
  {
    id: 0,
    name: 'Creola Katherine Johnson',
    profession: '수학자',
    accomplishment: '우주 비행 계산',
    imageId: 'MK3eW3A',
  },
  {
    id: 1,
    name: 'Mario José Molina-Pasquel Henríquez',
    profession: '화학자',
    accomplishment: '북극 오존홀 발견',
    imageId: 'mynHUSa',
  },
  {
    id: 2,
    name: 'Mohammad Abdus Salam',
    profession: '물리학자',
    accomplishment: '전자기 이론',
    imageId: 'bE7W1ji',
  },
  {
    id: 3,
    name: 'Percy Lavon Julian',
    profession: '화학자',
    accomplishment: '선구적인 코르티손 약물',
    imageId: 'IOjWm71',
  },
  {
    id: 4,
    name: 'Subrahmanyan Chandrasekhar',
    profession: '천체 물리학자',
    accomplishment: '백색 왜성의 질량 계산',
    imageId: 'lrWQx8l',
  },
];
```

```js
// utils.js
export function getImageUrl(person, size = 's') {
  return `https://i.imgur.com/${person.imageId}${size}.jpg`;
}
```

```js
// App.jsx
import { people } from './data.js';
import { getImageUrl } from './utils.js';
import './App.css';

export default function List() {
  const chemists = people.filter((person) => person.profession === '화학자');

  return (
    <ul className="list">
      {chemists.map((person) => (
        <li key={person.id}>
          <img className="avatar" src={getImageUrl(person)} />
          <p>
            <b>{person.name}: </b>
            {person.profession}
            <b> 업적: </b>
            {person.accomplishment}
          </p>
        </li>
      ))}
    </ul>
  );
}
```

<img title="" src="../images/2023-12-10-23-06-28-image.png" alt="" data-align="inline">

## 각 항목이 하나가 아닌 리스트일 경우

```js
import './App.css';
import { people } from './data.js';
import { Fragment } from 'react';

export default function List() {
  return (
    <div className="list">
      {people.map((person) => (
        <Fragment key={person.id}>
          <h2>{person.name}</h2>
          <p>{person.profession}</p>
        </Fragment>
      ))}
    </div>
  );
}
```

## key 규칙

- 데이터베이스에서 가져오는 경우 고유 데이터베이스 ID사용

- 메모앱등의 로컬 생성 데이터는 데이터 생성시 uuid 패키지 사용하여 고유 식별자 생성

- key는 형제 간에 고유해야하며 변경되면 안됨

- 배열 인덱스는 key로 사용 불가, key는 prop으로 전달되지않으므로 별도 prop으로 전달

### 챌린지: 리스트를 둘로 나누기

- 화학자와 다른 과학자 두 개의 리스트를 차례로 보여주기

```js
// App.jsx
import { people } from './data.js';
import { getImageUrl } from './utils.js';
import './App.css';

export default function List() {
  const chemists = people.filter((person) => person.profession === '화학자');
  const everyoneElse = people.filter(
    (person) => person.profession !== '화학자'
  );

  return (
    <section>
      <h2>과학자</h2>
      <h3>화학자</h3>
      <ul className="list">
        {chemists.map((person) => (
          <li key={person.id}>
            <img className="avatar" src={getImageUrl(person)} />
            <p>
              <b>{person.name}: </b>
              {person.profession}
              <b> 업적: </b>
              {person.accomplishment}
            </p>
          </li>
        ))}
      </ul>
      <h3>다른 과학자</h3>
      <ul className="list">
        {everyoneElse.map((person) => (
          <li key={person.id}>
            <img className="avatar" src={getImageUrl(person)} />
            <p>
              <b>{person.name}: </b>
              {person.profession}
              <b> 업적: </b>
              {person.accomplishment}
            </p>
          </li>
        ))}
      </ul>
    </section>
  );
}
```
