import { useState } from 'react';
import './App.css';
import TodoCount from './TodoCount';
import TodoAdd from './TodoAdd';
import TodoList from './TodoList';

const init = [
  {
    id: 1,
    text: '리액트 공부하기',
    done: false,
  },
  {
    id: 2,
    text: '백엔드도 열심히 해야지',
    done: false,
  },
  {
    id: 3,
    text: '넷플릭스 시청',
    done: false,
  },
];

export default function App() {
  const [todos, setTodos] = useState(init);
  console.log(todos);

  return (
    <div className="app">
      <h1>Todo List</h1>
      <TodoCount todos={todos} />

      <TodoAdd todos={todos} setTodos={setTodos} />

      <TodoList todos={todos} setTodos={setTodos} />
    </div>
  );
}
