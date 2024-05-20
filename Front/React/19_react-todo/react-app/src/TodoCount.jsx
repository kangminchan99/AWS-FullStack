import styles from './TodoCount.module.css';

export default function TodoCount({ todos }) {
  // todos배열요소중 todo.done이 true인 요소로 새로운 배열 리턴후 갯수 구하기
  const done = todos.filter((todo) => todo.done).length;

  return (
    <div className={styles.todo_count}>
      완료: {done} / 할 일: {todos.length}
    </div>
  );
}
