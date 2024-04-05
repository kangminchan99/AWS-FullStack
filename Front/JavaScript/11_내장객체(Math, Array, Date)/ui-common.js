const fruit = ['사과', '배', '딸기'];

const fruit2 = ['포도', '망고'];

// concat - 배열 연결
console.log(fruit.concat(fruit2));

// 배열을 문자로 변경, 구분자로 빈칸 사용 시 문자열이 이어짐
console.log(fruit.join(''));

// 배열 시작(왼쪽)에 요소 추가, 삭제 (첫 요소 삭제, 추가)
console.log(fruit.shift(), fruit);
console.log(fruit.unshift('수박'), fruit);

// 배열의 순서 거꾸로
console.log(fruit.reverse());

// 배열 일부 잘라내기 - 1,3 인덱스 1번부터 2까지 나온다.
// 원본 배열 변경 x
const numArr = [20, 20, 30, 50, 60, 90, 70];
console.log(numArr.slice(1, 3));

// // 오름차순 정렬
// const numArr2 = numArr.sort((a, b) => {
//   return a - b;
// });

// console.log(numArr2);

// 내림차순 정렬
const numArr2 = numArr.sort((a, b) => {
  return b - a;
});

console.log(numArr2);

const str = ['가', '다', '나', '차', '사'];

console.log(str.sort());

// 문자 내림차순
console.log(str.sort().reverse());

const now = new Date();
console.log(now);
// 현재 지역에 맞는 날짜 형식으로 변환
console.log(now.toLocaleString());
// 현재 지역에 맞는 시간만 반환
console.log(now.toLocaleTimeString());

let num = 10.69;

// 소수 버리고 정수변환
console.log(Math.floor(num));

// 반올림
console.log(Math.round(num));

// 올림
console.log(Math.ceil(num));

// 랜덤 수 만들기 (0 - 1미만의 랜덤한 소수)
console.log(Math.random());

// 0 - 9까지의 랜덤수 만들기

// for (let i = 0; i < 10; i++) {
//   console.log(Math.floor(Math.random() * 10));
// }

// 0 - 10까지의 랜덤수 만들기(11개 숫자)
// for (let i = 0; i < 11; i++) {
//   console.log(Math.floor(Math.random() * 11));
// }

// 11 - 50까지 랜덤수 만들기(40개의 수)
// for (let i = 0; i < 40; i++) {
//   console.log(Math.floor(Math.random() * 40 + 11));
// }

// 랜덤 정수 공식
// Math.floor(Math.random * 만들 정수 갯수 + 초기값)

// 100 - 110까지 랜덤수 만들기(11개)
for (let i = 0; i < 11; i++) {
  console.log(Math.floor(Math.random() * 11 + 100));
}
