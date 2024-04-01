// 복합 자료형: 배열, 싱글턴 객체, 함수, 생성자 함수, 정규 표현식 객체, 내장 객체

// // 일반적으로 배열은 동일 자료형을 나열하여 생성
const fruit = ['apple', 'lemon', 'grape', 'banana'];
// console.log(fruit, typeof fruit, fruit.length);

// // 배열 오른쪽에 요소 추가
// fruit.push('manggo');
// console.log(fruit);

// // 배열 요소 제거하고 리턴
// let last = fruit.pop();

// console.log(fruit, last);

// while 반복문으로 과일배열요소를 출력하시오

let i = 0;
while (i < fruit.length) {
  console.log(fruit[i]);
  i++;
}
