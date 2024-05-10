# 객체state업데이트,use-immer

- 객체를 업데이트하는 경우 state의 객체를 직접 변경하면 안되며 새로운 객체를 생성하거나 기존 객체의 복사본을 사용해야함

- **state의 객체는 읽기 전용**으로 다뤄야함

- onPointerMove: 마우스와 모바일 터치이벤트 감지

- clientX, clientY: 브라우저 화면 기준의 좌표

```js
import { useState } from 'react';
import './App.css';

export default function MovingDot() {
  const [position, setPosition] = useState({
    x: 0,
    y: 0,
  });
  return (
    <div
      onPointerMove={(e) => {
        position.x = e.clientX;
        position.y = e.clientY;
      }}
      style={{
        position: 'relative',
        width: '100vw',
        height: '100vh',
      }}
    >
      <div
        style={{
          position: 'absolute',
          backgroundColor: 'red',
          borderRadius: '50%',
          transform: `translate(${position.x}px, ${position.y}px)`,
          left: -10,
          top: -10,
          width: 20,
          height: 20,
        }}
      />
    </div>
  );
}
```

- 리렌더링을 발생시키려면 새 객체를 생성하여 전달해야함

```js
import { useState } from 'react';
import './App.css';

export default function MovingDot() {
  const [position, setPosition] = useState({
    x: 0,
    y: 0,
  });
  return (
    <div
      onPointerMove={(e) => {
        setPosition({
          x: e.clientX,
          y: e.clientY,
        });
      }}
      style={{
        position: 'relative',
        width: '100vw',
        height: '100vh',
      }}
    >
      <div
        style={{
          position: 'absolute',
          backgroundColor: 'red',
          borderRadius: '50%',
          transform: `translate(${position.x}px, ${position.y}px)`,
          left: -10,
          top: -10,
          width: 20,
          height: 20,
        }}
      />
    </div>
  );
}
```

## 스프레드 연산자로 객체 복사후 일부 속성만 변경하기

```js
import { useState } from 'react';
import './App.css';

export default function Form() {
  const [person, setPerson] = useState({
    firstName: 'Barbara',
    lastName: 'Hepworth',
    email: 'bhepworth@sculpture.com',
  });

  function handleChangeFirstName(e) {
    setPerson({
      ...person,
      firstName: e.target.value,
    });
  }

  function handleChangeLastName(e) {
    setPerson({
      ...person,
      lastName: e.target.value,
    });
  }

  function handleChangeEmail(e) {
    setPerson({
      ...person,
      email: e.target.value,
    });
  }

  return (
    <>
      <div>
        <label>
          First name:
          <input value={person.firstName} onChange={handleChangeFirstName} />
        </label>
      </div>
      <div>
        <label>
          Last name:
          <input value={person.lastName} onChange={handleChangeLastName} />
        </label>
      </div>
      <div>
        <label>
          Email:
          <input value={person.email} onChange={handleChangeEmail} />
        </label>
      </div>
      <p>
        {person.firstName} {person.lastName} ({person.email})
      </p>
    </>
  );
}
```

## 여러 입력필드에 하나의 이벤트 핸들러 사용하기

- 계산된 속성명을 객체의 키로 사용

```js
import { useState } from 'react';

export default function Form() {
  const [person, setPerson] = useState({
    firstName: 'Barbara',
    lastName: 'Hepworth',
    email: 'bhepworth@sculpture.com'
  });

  function handleChange(e) {
    setPerson({
      ...person,
      [e.target.name]: e.target.value
    });
  }

  return (
    <>
      <label>
        First name:
        <input
          name="firstName"
          value={person.firstName}
          onChange={handleChange}
        />
      </label>
      <label>
        Last name:
        <input
          name="lastName"
          value={person.lastName}
          onChange={handleChange}
        />
      </label>
      <label>
        Email:
        <input
          name="email"
          value={person.email}
          onChange={handleChange}
        />
      </label>
      <p>
        {person.firstName}{' '}
        {person.lastName}{' '}
        ({person.email})
      </p>
    </>
  );
}
```

## 중첩 객체 업데이트하기

- 중첩된 내부 객체도 복사하여 업데이트

```js
setPerson({
  ...person, // 객체 복사
  artwork: { // artwork 교체
    ...person.artwork, // 중첩 객체 복사
    city: 'New Delhi' // 중첩 객체 속성 업데이트
  }
});
```

```js
import { useState } from 'react';
import './App.css';

export default function Form() {
  const [person, setPerson] = useState({
    name: 'Niki de Saint Phalle',
    artwork: {
      title: 'Blue Nana',
      city: 'Hamburg',
      image: 'https://i.imgur.com/Sd1AgUOm.jpg',
    },
  });

  function handleNameChange(e) {
    setPerson({
      ...person,
      name: e.target.value,
    });
  }

  function handleTitleChange(e) {
    setPerson({
      ...person,
      artwork: {
        ...person.artwork,
        title: e.target.value,
      },
    });
  }

  function handleCityChange(e) {
    setPerson({
      ...person,
      artwork: {
        ...person.artwork,
        city: e.target.value,
      },
    });
  }

  function handleImageChange(e) {
    setPerson({
      ...person,
      artwork: {
        ...person.artwork,
        image: e.target.value,
      },
    });
  }

  return (
    <>
      <div>
        <label>
          Name:
          <input value={person.name} onChange={handleNameChange} />
        </label>
      </div>
      <div>
        <label>
          Title:
          <input value={person.artwork.title} onChange={handleTitleChange} />
        </label>
      </div>
      <div>
        <label>
          City:
          <input value={person.artwork.city} onChange={handleCityChange} />
        </label>
      </div>
      <div>
        <label>
          Image:
          <input value={person.artwork.image} onChange={handleImageChange} />
        </label>
      </div>
      <p>
        <i>{person.artwork.title}</i>
        {' by '}
        {person.name}
        <br />
        (located in {person.artwork.city})
      </p>
      <img src={person.artwork.image} alt={person.artwork.title} />
    </>
  );
}
```

## use-immer로 중첩 객체 간결하게 업데이트 하기

- 객체 불변성 유지하며 업데이트

- npm에서 use immer검색, npm i use-immer

- useState 대신 useImmer훅 사용

- 콜백함수의 draft매개변수에 객체가 전달되며 객체 속성 바로 변경 가능하며 불변성을 immer가 대신 관리해줌

```js
import { useImmer } from 'use-immer';

const [person, setPerson] = useImmer({
    name: 'Niki de Saint Phalle',
    artwork: {
      title: 'Blue Nana',
      city: 'Hamburg',
      image: 'https://i.imgur.com/Sd1AgUOm.jpg',
    },
  });

function handleChangeTitle(e) {
    setPerson((draft) => {
      draft.artwork.title = e.target.value;
    });
  });
```

```js
import { useImmer } from 'use-immer';
import './App.css';

export default function Form() {
  const [person, setPerson] = useImmer({
    name: 'Niki de Saint Phalle',
    artwork: {
      title: 'Blue Nana',
      city: 'Hamburg',
      image: 'https://i.imgur.com/Sd1AgUOm.jpg',
    },
  });

  function handleChangeName(e) {
    setPerson((draft) => {
      draft.name = e.target.value;
    });
  }

  function handleChangeTitle(e) {
    setPerson((draft) => {
      draft.artwork.title = e.target.value;
    });
  }

  function handleChangeCity(e) {
    setPerson((draft) => {
      draft.artwork.city = e.target.value;
    });
  }

  function handleChangeImage(e) {
    setPerson((draft) => {
      draft.artwork.image = e.target.value;
    });
  }

  return (
    <>
      <div>
        <label>
          Name:
          <input value={person.name} onChange={handleChangeName} />
        </label>
      </div>
      <div>
        <label>
          Title:
          <input value={person.artwork.title} onChange={handleChangeTitle} />
        </label>
      </div>
      <div>
        <label>
          City:
          <input value={person.artwork.city} onChange={handleChangeCity} />
        </label>
      </div>
      <div>
        <label>
          Image:
          <input value={person.artwork.image} onChange={handleChangeImage} />
        </label>
      </div>
      <p>
        <i>{person.artwork.title}</i>
        {' by '}
        {person.name}
        <br />
        (located in {person.artwork.city})
      </p>
      <img src={person.artwork.image} alt={person.artwork.title} />
    </>
  );
}
```

### 리액트의 모든 state는 불변성을 유지해야함

### 객체를 직접 변경하지말고 새로운 객체를 복사하여 리렌더링 발생시킴

### 객체 복사시 {...obj, 속성명: '새로운값'} 스프레드 연산자 사용

### 중첩 객체 업데이트시 use-immer사용
