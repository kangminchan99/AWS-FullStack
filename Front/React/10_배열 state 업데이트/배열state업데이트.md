# 배열state업데이트,use-immer

- 배열을 업데이트할 경우 새 배열 또는 기존 배열을 복사하여 업데이트

- push, pop, splice로 배열을 직접변경하면 안됨

- **concat, [...arr], map, filter, slice**로 새 배열 반환하여 업데이트

- immer사용시 모두 사용 가능

## 배열에 항목 추가

```js
import { useState } from 'react';
import './App.css';

export default function List() {
  const [name, setName] = useState('');
  const [artists, setArtists] = useState([]);
  const [nextId, setNextId] = useState(0);

  return (
    <>
      <h2>영감을 주는 조각가:</h2>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <button
        type="button"
        onClick={() => {
          setName('');
          setNextId(nextId + 1);
          // push, unshift 기능과 동일
          // setArtists([...artists, { id: nextId, name: name }]);
          setArtists([{ id: nextId, name: name }, ...artists]);
        }}
      >
        Add
      </button>
      <ul>
        {artists.map((artist) => (
          <li key={artist.id}>{artist.name}</li>
        ))}
      </ul>
    </>
  );
}
```

## 배열에서 항목 제거

- filter메서드 사용, 원본배열을 변경하지않음

- 배열요소의 id가 다른 요소를 filter하여 새로운 배열로 리턴

```js
import { useState } from 'react';
import './App.css';

const initialArtists = [
  { id: 0, name: 'Marta Colvin Andrade' },
  { id: 1, name: 'Lamidi Olonade Fakeye' },
  { id: 2, name: 'Louise Nevelson' },
];

export default function List() {
  const [artists, setArtists] = useState(initialArtists);

  return (
    <>
      <h1>영감을 주는 조각가:</h1>
      <ul>
        {artists.map((artist) => (
          <li key={artist.id}>
            {artist.name}{' '}
            <button
              type="button"
              onClick={() => {
                setArtists(artists.filter((a) => a.id !== artist.id));
              }}
            >
              Delete
            </button>
          </li>
        ))}
      </ul>
    </>
  );
}
```

## 배열 변환

- map() 으로 새로운 배열 생성하여 변환 처리

```js
import { useState } from 'react';
import './App.css';

const initialShapes = [
  { id: 0, type: 'circle', x: 50, y: 100 },
  { id: 1, type: 'square', x: 150, y: 100 },
  { id: 2, type: 'circle', x: 250, y: 100 },
];

export default function ShapeEditor() {
  const [shapes, setShapes] = useState(initialShapes);

  function handleClick() {
    const nextShapes = shapes.map((shape) => {
      if (shape.type === 'square') {
        // 변경시키지 않고 반환합니다.
        return shape;
      } else {
        // 50px 아래로 이동한 새로운 원을 반환합니다.
        return {
          ...shape,
          y: shape.y + 50,
        };
      }
    });
    // 새로운 배열로 리렌더링합니다.
    setShapes(nextShapes);
  }

  return (
    <>
      <button onClick={handleClick}>원만 아래로 이동</button>
      {shapes.map((shape) => (
        <div
          key={shape.id}
          style={{
            background: 'purple',
            position: 'absolute',
            left: shape.x,
            top: shape.y,
            borderRadius: shape.type === 'circle' ? '50%' : '',
            width: 20,
            height: 20,
          }}
        />
      ))}
    </>
  );
}
```

## 배열 내부 항목 교체

- map() 으로 인덱스 확인후 원래 항목 반환 또는 다른 항목 반환

- 0부터 1씩 증가하는 3개의 카운터 만들기

```js
import { useState } from 'react';
import './App.css';

export default function CounterList() {
  const [counters, setCounters] = useState([0, 0, 0]);

  function handleIncrement(index) {
    const nextCounters = counters.map((counter, i) => {
      if (i === index) {
        // 클릭된 counter를 증가시킵니다.
        return counter + 1;
      } else {
        // 변경되지 않은 나머지를 반환합니다.
        return counter;
      }
    });
    setCounters(nextCounters);
  }

  return (
    <ul>
      {counters.map((counter, i) => (
        <li key={i}>
          {counter}{' '}
          <button
            type="button"
            onClick={() => {
              handleIncrement(i);
            }}
          >
            +1
          </button>
        </li>
      ))}
    </ul>
  );
}
```

## 배열 reverse

- **원본배열에 직접 사용하면 안되며 배열 복사한 뒤 변경**

```js
import { useState } from 'react';
import './App.css';

const initialList = [
  { id: 0, title: 'Big Bellies' },
  { id: 1, title: 'Lunar Landscape' },
  { id: 2, title: 'Terracotta Army' },
];

export default function List() {
  const [list, setList] = useState(initialList);

  function handleClick() {
    const nextList = [...list];
    nextList.reverse();
    setList(nextList);
  }

  return (
    <>
      <button onClick={handleClick}>Reverse</button>
      <ul>
        {list.map((item) => (
          <li key={item.id}>{item.title}</li>
        ))}
      </ul>
    </>
  );
}
```

### 배열을 복사하더라도 배열 내부 객체를 직접 변경하면 안됨

- 복사된 배열 내부 객체는 원본 배열과 동일

```js
const nextList = [...list];
nextList[0].seen = true; // 문제: list[0]을 변경시킵니다.
setList(nextList);
```

- map() 사용하여 원본 변경없이 업데이트

```js
setMyList(myList.map(artwork => {
  if (artwork.id === artworkId) {
    // 변경된 새 객체를 만들어 반환합니다.
    return { ...artwork, seen: nextSeen };
  } else {
    // 변경시키지 않고 반환합니다.
    return artwork;
  }
}));
```

### 챌린지: 장바구니 항목 업데이트하기

- ”+” 버튼을 누르면 해당 숫자가 증가하도록 `handleIncrease`를 완성하세요

```js
import { useState } from 'react';

const initialProducts = [{
  id: 0,
  name: 'Baklava',
  count: 1,
}, {
  id: 1,
  name: 'Cheese',
  count: 5,
}, {
  id: 2,
  name: 'Spaghetti',
  count: 2,
}];

export default function ShoppingCart() {
  const [
    products,
    setProducts
  ] = useState(initialProducts)

  function handleIncreaseClick(productId) {

  }

  return (
    <ul>
      {products.map(product => (
        <li key={product.id}>
          {product.name}
          {' '}
          (<b>{product.count}</b>)
          <button onClick={() => {
            handleIncreaseClick(product.id);
          }}>
            +
          </button>
        </li>
      ))}
    </ul>
  );
}
```

```js
import { useState } from 'react';

const initialProducts = [{
  id: 0,
  name: 'Baklava',
  count: 1,
}, {
  id: 1,
  name: 'Cheese',
  count: 5,
}, {
  id: 2,
  name: 'Spaghetti',
  count: 2,
}];

export default function ShoppingCart() {
  const [
    products,
    setProducts
  ] = useState(initialProducts)

  function handleIncreaseClick(productId) {
    setProducts(products.map(product => {
      if (product.id === productId) {
        return {
          ...product,
          count: product.count + 1
        };
      } else {
        return product;
      }
    }))
  }

  return (
    <ul>
      {products.map(product => (
        <li key={product.id}>
          {product.name}
          {' '}
          (<b>{product.count}</b>)
          <button onClick={() => {
            handleIncreaseClick(product.id);
          }}>
            +
          </button>
        </li>
      ))}
    </ul>
  );
}
```
