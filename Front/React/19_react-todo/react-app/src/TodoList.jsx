import TodoItem from './TodoItem';

export default function TodoList({ todos, setTodos }) {
  return (
    <ul>
      {todos.map((todo) => (
        <TodoItem todo={todo} todos={todos} setTodos={setTodos} key={todo.id} />
      ))}
    </ul>
  );
}
