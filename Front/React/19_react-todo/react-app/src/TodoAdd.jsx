import { useRef, useState } from 'react';
import styles from './TodoAdd.module.css';

export default function TodoAdd({ todos, setTodos }) {
  const [txt, setTxt] = useState('');
  // 배열 데이터 길이로 초기값 설정
  const idRef = useRef(todos.length);

  function handleAdd() {
    // 추가버튼 클릭시만 1씩 증가
    idRef.current++;

    if (txt) {
      setTxt('');
      setTodos([
        ...todos,
        {
          id: idRef.current,
          text: txt,
          done: false,
        },
      ]);
    }
  }

  function handleEnter(e) {
    if (e.key === 'Enter') handleAdd();
  }

  return (
    <div className={styles.todo_add}>
      <input
        value={txt}
        onChange={(e) => setTxt(e.target.value)}
        onKeyUp={handleEnter}
        type="text"
        placeholder="할 일을 입력하세요"
        title="할 일을 입력하세요"
      />
      <button type="button" onClick={handleAdd}>
        Add
      </button>
    </div>
  );
}
