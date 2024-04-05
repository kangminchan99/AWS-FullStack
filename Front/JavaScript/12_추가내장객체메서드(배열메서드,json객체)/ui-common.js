// 복합(참조)자료형: 함수, 싱글턴 객체, 배열, 정규 표현식 객체, 생성자함수, 내장 객체
const fruit = ['사과', '배', '딸기'];
const numArr = [
  [1, 2, 3, 4, 5],
  [10, 20, 30, 40, 50],
];
console.log(typeof fruit, fruit.length, numArr[1][4]);

// numArr의 50요소에 접근하기
let idx = numArr[1].indexOf(50);
console.log(idx, '======');

// 배열요소 '딸기'앞에 바나나를 추가하시오(딸기요소의 위치는 모름)
let searchIdx = fruit.indexOf('딸기');

// 1번째 매개변수 - searchIdx 인덱스 번 째에 위치
// 2번째 매개변수가 0이면 요소를 삭제하지않고 3번째 매개변수를 1번째 -1 매개변수에 추가
console.log(fruit.splice(searchIdx, 0, '바나나'));
console.log(fruit);

// 과일배열에 '는 맛있어'를 모두 추가하시오(forEach)
fruit.forEach((v, i) => {
  fruit[i] += '맛있어';
});

console.log(fruit);

const numArr1 = [100, 200, 300];

// numArr에 *5를 하여 새로운 배열로 만들기 (map)
const newArr = numArr1.map((v) => {
  return v * 5;
});
console.log(newArr);

// 원본배열중 200이상인 요소만 새로운 배열로 만들기(filter)
const newArr1 = numArr1.filter((v) => {
  // 조건식에 맞는값들만 리턴됨
  return v >= 200;
});

console.log(newArr1);

// 모든 배열 요소가 특정 조건을 만족하는지 확인(every)
const result = numArr1.every((v) => {
  return v >= 200;
});
console.log(result);

// 원본 배열의 왼쪽 요소부터 오른쪽으로 연산해줌(누산, reduce)
let sum = numArr1.reduce((prev, current) => {
  return prev + current;
});
console.log(sum);

console.clear();
// JSON 객체 문자열: 프론트와 백엔드의 객체 표기법이 다르므로 데이터를 주고받을 때 사용
const car = {
  name: 'car1',
  model: 400,
  color: 'black',
};

console.log(car);

// JSON 문자열로 변경
const carJSON = JSON.stringify(car);
console.log(carJSON);

// ``문자열은 줄바꿈이 안되지만 ``(ES6 백틱문자) 사용시 줄바꿈 가능 모두 큰따옴표로 작성
const studentJSON = `{
  "grade": 90,
  "studentName": "minchan",
  "pass": true
}`;

// js객체로 변경
const student = JSON.parse(studentJSON);
console.log(student);

let str = '    h i!   ';
console.log(str);

str = str.trim();
console.log(str);
