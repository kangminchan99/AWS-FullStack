# 컴포넌트에 props전달

- 부모컴포넌트에서 props를 통해 자식 컴포넌트로 정보전달

- 부모에서 props 객체전달하고 자식 컴포넌트에서 구조분해할당하여 같은 이름으로 받음

- props는 변경불가하며 상호작용이 필요한 경우 state 사용

- 컴포넌트 렌더링시 마다 새로운 props를 받음

```js
// App.jsx
import { getImageUrl } from './utils.js';

function Avatar({ person, size }) {
  return (
    <img
      className="avatar"
      src={getImageUrl(person)}
      alt={person.name}
      width={size}
      height={size}
    />
  );
}

export default function Profile() {
  return (
    <div>
      <Avatar
        size={100}
        person={{
          name: 'Katsuko Saruhashi',
          imageId: 'YfeOqp2',
        }}
      />
      <Avatar
        size={80}
        person={{
          name: 'Aklilu Lemma',
          imageId: 'OKS67lh',
        }}
      />
      <Avatar
        size={50}
        person={{
          name: 'Lin Lanying',
          imageId: '1bX5QH6',
        }}
      />
    </div>
  );
}
```

```js
// utils.js
export function getImageUrl(person, size = 's') {
  return `https://i.imgur.com/${person.imageId}${size}.jpg`;
}
```

- props 사용하여 부모와 자식 컴포넌트를 독립적으로 사용가능

- props객체는 함수실행시 전달되는 인자와 동일

```js
// App.jsx
// 아바타 컴포넌트에서 props 사용방식 변경
function Avatar({ person, size }) {
  return (
    <>
      <div>
        <img
          className="avatar"
          src={getImageUrl(person)}
          alt={person.name}
          width={size}
          height={size}
        />
      </div>
      <strong>{person.name}</strong>
    </>
  );
}
```

## prop 기본값 지정

- prop이 없거나 undefined일 경우 기본값 사용

```js
// App.jsx
function Avatar({ person, size = 150 }) {
  return (
    <>
      <div>
        <img
          className="avatar"
          src={getImageUrl(person)}
          alt={person.name}
          width={size}
          height={size}
        />
      </div>
      <strong>{person.name}</strong>
    </>
  );
}
```

## 스프레드 문법으로 props전달

- 부모의 모든 props를 자식 컴포넌트에 전달할 경우 props객체로 받고 자식컴포넌트에 스프레드 문법으로 전달

```js
// utils.js
export function getImageUrl(person, size = 's') {
  return `https://i.imgur.com/${person.imageId}${size}.jpg`;
}
```

```js
// Avatar.jsx
import { getImageUrl } from './utils.js';

export default function Avatar({ person, size, border }) {
  return (
    <>
      <div style={{ border: border }}>
        <img className="avatar" src={getImageUrl(person, size)} alt={person.name} />
      </div>
      <strong>{person.name}</strong>
    </>
  );
}
```

```js
// Profile.jsx
import Avatar from './Avatar.jsx';

export default function Profile(props) {
  return (
    <div className="card">
      {/* <Avatar person={person} size={size} border={border} /> */}
      {/* 부모가 전달받은 모든 prop을 자식컴포넌트로 그대로 전달할 경우 */}
      <Avatar {...props} />
    </div>
  );
}
```

```js
// App.jsx
import './App.css';
import Profile from './Profile.jsx';

export default function App() {
  return (
    <div className="app">
      <Profile
        person={{
          name: 'Katsuko Saruhashi',
          imageId: 'YfeOqp2',
        }}
        size={'b'}
        border={'5px solid red'}
      />
    </div>
  );
}
```

## 자식을 jsx로 전달

- 자식 컴포넌트를 다른 자식 컴포넌트로 전달하는 방식

- 컴포넌트를 감싸 시각적으로 표현할 경우 사용하며 내용은 다르지만 디자인이 동일한 경우 사용

- children prop 사용

```js
// Avatar.jsx
import { getImageUrl } from './utils.js';

export default function Avatar({ person, size = 150 }) {
  return (
    <>
      <img
        className="avatar"
        src={getImageUrl(person)}
        alt={person.name}
        width={size}
        height={size}
      />
    </>
  );
}
```

```js
import Avatar from './Avatar.jsx';
import './App.css';

function Card({ children }) {
  return <div className="card">{children}</div>;
}

export default function Profile() {
  return (
    <div className="profile">
      <Card>
        <Avatar
          size={100}
          person={{
            name: 'Katsuko Saruhashi',
            imageId: 'YfeOqp2',
          }}
        />
        {/* <p>글자가 들어가면?</p> */}
      </Card>
    </div>
  );
}
```

![](../images\2023-12-10-19-44-41-image.png)

### 챌린지: 컴포넌트 추출하기

- 두가지 프로필을 Profile컴포넌트로 추출하여 Gallery컴포넌트의 자식컴포넌트로 표현하기

```js
import { getImageUrl } from './utils.js';

export default function Gallery() {
  return (
    <div>
      <h1>Notable Scientists</h1>
      <section className="profile">
        <h2>Maria Skłodowska-Curie</h2>
        <img
          className="avatar"
          src={getImageUrl('szV5sdG')}
          alt="Maria Skłodowska-Curie"
          width={70}
          height={70}
        />
        <ul>
          <li>
            <b>Profession: </b> 
            physicist and chemist
          </li>
          <li>
            <b>Awards: 4 </b> 
            (Nobel Prize in Physics, Nobel Prize in Chemistry, Davy Medal, Matteucci Medal)
          </li>
          <li>
            <b>Discovered: </b>
            polonium (chemical element)
          </li>
        </ul>
      </section>
      <section className="profile">
        <h2>Katsuko Saruhashi</h2>
        <img
          className="avatar"
          src={getImageUrl('YfeOqp2')}
          alt="Katsuko Saruhashi"
          width={70}
          height={70}
        />
        <ul>
          <li>
            <b>Profession: </b> 
            geochemist
          </li>
          <li>
            <b>Awards: 2 </b> 
            (Miyake Prize for geochemistry, Tanaka Prize)
          </li>
          <li>
            <b>Discovered: </b>
            a method for measuring carbon dioxide in seawater
          </li>
        </ul>
      </section>
    </div>
  );
}
```

![](../images\2023-12-10-20-03-40-image.png)

```js
// App.jsx
import { getImageUrl } from './utils.js';
import './App.css';

function Profile({
  imageId,
  name,
  profession,
  awards,
  discovery,
  imageSize = 70,
}) {
  return (
    <section className="profile">
      <h2>{name}</h2>
      <img
        className="avatar"
        src={getImageUrl(imageId)}
        alt={name}
        width={imageSize}
        height={imageSize}
      />
      <ul>
        <li>
          <b>Profession:</b> {profession}
        </li>
        <li>
          <b>Awards: {awards.length} </b>({awards.join(', ')})
        </li>
        <li>
          <b>Discovered: </b>
          {discovery}
        </li>
      </ul>
    </section>
  );
}

export default function Gallery() {
  return (
    <div>
      <h1>Notable Scientists</h1>
      <Profile
        imageId="szV5sdG"
        name="Maria Skłodowska-Curie"
        profession="physicist and chemist"
        discovery="polonium (chemical element)"
        awards={[
          'Nobel Prize in Physics',
          'Nobel Prize in Chemistry',
          'Davy Medal',
          'Matteucci Medal',
        ]}
      />
      <Profile
        imageId="YfeOqp2"
        name="Katsuko Saruhashi"
        profession="geochemist"
        discovery="a method for measuring carbon dioxide in seawater"
        awards={['Miyake Prize for geochemistry', 'Tanaka Prize']}
      />
    </div>
  );
}
```

```js
// utils.js
export function getImageUrl(imageId, size = 's') {
  return `https://i.imgur.com/${imageId}${size}.jpg`;
}
```

### 챌린지: children prop으로 서로 다른 내용 전달하기

- card 컴포넌트 추출하고 children으로 서로 다른 jsx 전달하기

```js
// App.jsx
import './App.css';

export default function Profile() {
  return (
    <div className="profile">
      <div className="card">
        <h3>Photo</h3>
        <img
          className="avatar"
          src="https://i.imgur.com/OKS67lhm.jpg"
          alt="Aklilu Lemma"
          width={70}
          height={70}
        />
      </div>
      <div className="card">
        <h3>About</h3>
        <p>
          Aklilu Lemma was a distinguished Ethiopian scientist who discovered a
          natural treatment to schistosomiasis.
        </p>
      </div>
    </div>
  );
}
```

![](../images\2023-12-10-20-37-37-image.png)

```js
// App.jsx
import './App.css';

function Card({ children }) {
  return <div className="card">{children}</div>;
}

export default function Profile() {
  return (
    <div className="profile">
      <Card>
        <h3>Photo</h3>
        <img
          className="avatar"
          src="https://i.imgur.com/OKS67lhm.jpg"
          alt="Aklilu Lemma"
          width={70}
          height={70}
        />
      </Card>
      <Card>
        <h3>About</h3>
        <p>
          Aklilu Lemma was a distinguished Ethiopian scientist who discovered a
          natural treatment to schistosomiasis.
        </p>
      </Card>
    </div>
  );
}
```
