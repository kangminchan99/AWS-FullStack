import { useState } from 'react';
import { Todo } from './lib/types';
import Button from './components/Button';
import { getValue, printArray } from './lib/utils';

const init: Todo = [
  {
    id: 1,
    text: 'react',
    done: false,
  },
  {
    id: 2,
    text: 'flutter',
    done: false,
  },
  {
    id: 3,
    text: 'js',
    done: false,
  },
];

export default function App() {
  const [toggle, setToggle] = useState(true);
  const [todos, setTodos] = useState(init);
  const [firstName, setFirstName] = useState('minchan');

  function handleToggle() {
    setToggle(!toggle);
  }

  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    setFirstName(event.target.value);
  }

  function handleClick(event: React.MouseEvent<HTMLButtonElement>) {
    // 타입 단언: ts가 타입을 찾지 못할 경우 타입을 알려준다.
    const btn = event.target as HTMLElement;
    console.log(btn.textContent);
  }
  printArray<number>([20, 10, 30]);

  const car = {
    color: 'red',
    speed: 300,
    price: 200000000990,
  };

  console.log(getValue(car, 'price'));
  return (
    <div>
      <Button onClick={handleToggle}>{toggle ? 'show' : 'hide'}</Button>
      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>{todo.text}</li>
        ))}
      </ul>
      <input type="text" value={firstName} onChange={handleChange} />
      <p>{firstName}</p>
      <button type="button" onClick={handleClick}>
        click
      </button>
    </div>
  );
}
