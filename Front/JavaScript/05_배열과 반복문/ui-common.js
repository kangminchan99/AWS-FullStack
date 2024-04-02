// 복합 자료형: 배열, 싱글턴 객체, 함수, 생성자 함수, 정규 표현식 객체, 내장 객체

// // 일반적으로 배열은 동일 자료형을 나열하여 생성
// const fruit = ['apple', 'lemon', 'grape', 'banana'];
// console.log(fruit, typeof fruit, fruit.length);

// // 배열 오른쪽에 요소 추가
// fruit.push('manggo');
// console.log(fruit);

// // 배열 요소 제거하고 리턴
// let last = fruit.pop();

// console.log(fruit, last);

// while 반복문으로 과일배열요소를 출력하시오

// let i = 0;
// while (i < fruit.length) {
//   console.log(fruit[i]);
//   i++;
// }

// for 반복문(횟수 중심): 초기값 조건 증감
// for (let i = 0; i < fruit.length; i++) {
//   console.log(fruit[i]);
// }

// for문으로 i를 10부터 1까지 출력하가
// for (let i = 10; i > 1; i--) {
//   console.log(i);
// }

// for문으로 i를 20부터 30까지 출력하가
// for (let i = 20; i < 31; i++) {
//   console.log(i);
// }

// for문으로 i를 5씩증가 (i += 5 복합 대입 연산자)
// for (let i = 5; i < 21; i += 5) {
//   console.log(i);
// }

// i증가하며 6번 반복하다가 i가 2면 반복문 빠져나오기(break)
// i번째 출력을 문자로 보여주기

// let str = '';

// // \n 줄 바꿈
// for (let i = 0; i < 6; i++) {
//   if (i === 2) continue;
//   str += i + '번 째 출력\n';
//   console.log(str);
// }

// 배열 전용 반복문
const numArr = [10, 20, 30];

// 배열 요소에 5를 곱하여 배열 요소 변경
// forEach: 배열 전용 반복문 (v - value, i - index)
// 콜백 함수를 인자로 전달
// numArr.forEach(function (v, i) {
//   // console.log(v, i);
//   numArr[i] *= 5;
// });

// console.log(numArr);

// ES6에서는 콜백함수를 화살표 함수를 사용하는 것이 좋음
// 화살표 함수는 {}와 return 생략가능
// numArr.forEach((v, i) => (numArr[i] *= 5));
// console.log(numArr);

// 강의실번호 배열요소에 '호'를 연결하여 배열요소를 변경하시오(forEach)
// 처음배열: classNumber = ['701', '702', '703'];
// 결과 : classNumber = ['701호','702호','703호']
// const classNumber = ['701', '702', '703'];

// const classNumber = ['701', '702', '703'];

// // 함수 선언 시 매개변수(지역변수)는 이름 변경 가능, 주로 약자 사용
// classNumber.forEach((v, i) => (classNumber[i] += '호'));

// console.log(classNumber);

const movieArr = ['타짜', '아저씨', '어벤져스', '이모', '고모', '숙모'];

// 특정 인덱스부터 배열 요소 추가
// movieArr.splice(1, 0, '슈퍼맨');

//  특정 인덱스 부터 배열 요소 삭제
// movieArr.splice(0, 2);

// 특정 인덱스부터 배열 요소 삭제
// movieArr.splice(0, 3, '할머니');

// 배열요소가 '아저씨'일 경우 할머니로 바꾸기
// 배열 요소의 길이와 위치는 바뀔 수 있음
// 아저씨가 있는 위치를 찾아서 변경

// # 1
// movieArr.forEach((v, i) => {
//   if (v === '아저씨') {
//     //
//     movieArr.splice(i, 1, '할머니');
//   }
// });

// # 2
// for (i = 0; i < movieArr.length; i++) {
//   if (movieArr[i] === '아저씨') {
//     movieArr[i] = '할머니';
//   }
// }

// console.log(movieArr);

// 배열요소의 값이 포도일 경우를 제외하고 '는 맛있어' 문자열 연결하기(for문, continue)
// for문은 continue break가능, forEach는 continue break불가

const fruit2 = ['사과', '딸기', '포도', '키위'];

for (let i = 0; i < fruit2.length; i++) {
  if (fruit2[i] === '포도') {
    continue;
  } else {
    fruit2[i] += '맛있어';
  }
}

console.log(fruit2);
