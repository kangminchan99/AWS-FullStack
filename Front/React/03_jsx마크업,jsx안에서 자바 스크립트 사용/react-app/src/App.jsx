import './App.css';

// export default function Avatar() {
//   // 함수 호출 시 함수 내부에서 지역변수가 새로 만들어지므로
//   // 컴포넌트 함수 내부 변수는 대부분 const(상수)임
//   const avatar = 'https://i.imgur.com/7vQD0fPs.jpg';
//   const desc = 'Gregorio Y. Zara';
//   return <img className="avatar" src={avatar} alt={desc} />;
// }

// export default function TodoList() {
//   const name = 'min_chan';
//   return <h2>{name}&apos;s ToDo List</h2>;
// }

// function formatDate(date) {
//   return new Intl.DateTimeFormat('ko-KR', {
//     year: 'numeric',
//     month: '2-digit',
//     day: '2-digit',
//     hour: '2-digit',
//     minute: '2-digit',
//     hour12: false,
//     weekday: 'long',
//   }).format(date);
// }

// export default function TodoList() {
//   return <h1>To Do List for {formatDate(new Date())}</h1>;
// }

// export default function TodoList() {
//   return (
//     <ul
//       style={{
//         backgroundColor: 'black',
//         color: 'pink',
//       }}
//     >
//       <li>화상 전화 개선</li>
//       <li>항공학 강의 준비</li>
//       <li>알코올 연료 엔진 작업</li>
//     </ul>
//   );
// }

// 한번만 사용하는 데이터는 컴포넌트의 바깥쪽 영역에 배치하여 사용
// 컴포넌트가 렌더링되면 컴포넌트 함수 안쪽 코드가 재실행되므로
// const pet = {
//   name: '장군이',
//   theme: {
//     backgroundColor: '#ffc107',
//     color: '#000',
//   },
//   imgUrl: 'http://ossamuiux.com/react-img/dog.jpg',
// };

// export default function TodoList() {
//   return (
//     <div style={pet.theme}>
//       <h2>{pet.name}&apos;s Todos</h2>
//       <img className="avatar" src={pet.imgUrl} alt="" />
//       <ul>
//         <li>밥먹기</li>
//         <li>산책하기</li>
//         <li>까불기</li>
//       </ul>
//     </div>
//   );
// }

// const baseUrl = 'https://i.imgur.com/';

import { getImageUrl } from './utils';

const person = {
  name: 'Gregorio Y. Zara',
  imageId: '7vQD0fP',
  imageSize: 'b',
  theme: {
    backgroundColor: 'black',
    color: 'pink',
  },
};

export default function TodoList() {
  return (
    <div style={person.theme}>
      <h1>{person.name}&apos;s Todos</h1>
      <img
        className="avatar"
        // src={`${baseUrl}${person.imageId}${person.imageSize}.jpg`}
        src={getImageUrl(person)}
        alt={person.name}
      />
      <ul>
        <li>화상전화 개선</li>
        <li>항공학 강의 준비</li>
        <li>알코올 연료 엔진 작업</li>
      </ul>
    </div>
  );
}
