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
