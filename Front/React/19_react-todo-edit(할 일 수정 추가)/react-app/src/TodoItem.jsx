import Checkbox from './components/Checkbox';
import styles from './TodoItem.module.css';
import Modal from 'react-modal';
import { useState } from 'react';

Modal.setAppElement('#root');

export default function TodoItem({ todo, todos, setTodos }) {
  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [inputValue, setInputValue] = useState(todo.text);
  // 배열데이터 업데이트
  // todo로 각각 넘어온 id와 배열전체요소의 id를 비교하여 같은경우 배열요소 업데이트
  function handleDone() {
    const nextTodos = todos.map((t) => {
      if (t.id === todo.id) {
        return {
          ...todo,
          done: !todo.done,
        };
      } else {
        return t;
      }
    });
    setTodos(nextTodos);
  }

  function handleRemove() {
    setTodos(todos.filter((t) => t.id !== todo.id));
  }

  function handleEdit() {
    const editTodos = todos.map((t) => {
      if (t.id === todo.id) {
        alert('변경이 성공적으로 반영되었습니다!!!');
        return {
          ...t,
          text: inputValue,
        };
      } else {
        return t;
      }
    });

    setTodos(editTodos);
    setModalIsOpen(false);
  }

  function handleKeyEnter(event) {
    if (event.key === 'Enter') {
      handleEdit();
    }
  }

  return (
    <li className={`${styles.todo_item} ${todo.done ? styles.checked : ''}`}>
      <Checkbox onChange={handleDone}>{todo.text}</Checkbox>
      <button className={styles.edit_btn} onClick={() => setModalIsOpen(true)}>
        Edit{' '}
      </button>
      <Modal
        className={styles.modal_wrap}
        isOpen={modalIsOpen}
        onRequestClose={() => setModalIsOpen(false)}
        style={{
          content: {
            width: 'fit-content', // 요소의 내용 크기에 맞게 모달의 너비 조정
            height: 'fit-content', // 요소의 내용 크기에 맞게 모달의 높이 조정
            margin: ' auto', // 모달을 수평으로 가운데 정렬
          },
        }}
      >
        <div
          style={{
            display: 'flex',
            gap: '0 20px',
          }}
        >
          <input
            autoFocus
            type="text"
            onKeyUp={handleKeyEnter}
            placeholder={inputValue}
            value={inputValue}
            onChange={(event) => setInputValue(event.target.value)}
            title={inputValue}
          />
          <button
            style={{
              padding: '10px',
              background: 'black',
              color: 'white',
            }}
            type="button"
            onClick={handleEdit}
          >
            Change
          </button>

          <button
            style={{
              padding: '10px',
              color: 'var(--point-color1)',
              border: '1px solid var(--point-color1)',
            }}
            type="button"
            onClick={() => setModalIsOpen(false)}
          >
            Close
          </button>
        </div>
      </Modal>
      <button
        onClick={handleRemove}
        className={styles.remove_btn}
        type="button"
      >
        remove
      </button>
    </li>
  );
}
