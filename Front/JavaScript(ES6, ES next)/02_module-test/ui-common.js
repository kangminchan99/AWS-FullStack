// let, const
// 블럭 스코프이며 선언전에 사용 불가, const 상수이므로 재할당 불가
function fn1() {
  let x;

  {
    const x = 'sneaky';

    // 상수는 재할당 불가
    // x = 'foo'
  }
  console.log(x);
}

fn1();

// // var i 는 전역변수
// for (var i = 0; i < 3; i++) {
//   console.log(i);
// }

// for 블럭에 선언된 let i는 지역변수이므로 밖에서 참조 불가
for (let i = 0; i < 3; i++) {
  console.log(i);
}

// console.log(i);

let greeting = '안녕';

if (true) {
  let greeting = 'hi';
  console.log(greeting);
}

// 화살표 함수
// 함수의 인자로 전달되는 콜백함수(익명 함수)에 사용
// 이벤트 핸들러, 객체 메서드애선 사용 금지
// 화살표 함수의 this는 부모함수의 this와 일치
const evens = [2, 4, 6, 8, 10];

// const odds = evens.map((v) => {
//   return v + 1;
// });

// 매개 변수가 하나면 ()생략가능 실행문이 한줄일 때 {return} 생략 가능
const odds = evens.map((v) => v + 1);
const nums = evens.map((v, i) => v + i);
// 객체 리턴 시 ()로 묶어야함
const pairs = evens.map((v) => ({ even: v, odd: v + 1 }));

console.log(odds, 'odds');
console.log(nums, 'nums');
console.log(pairs, 'pairs');

// nums배열 요소를 5로 나눈 나머지가 0인 요소만 새로운 배열로 만들기
const divNum = nums.filter((v) => v % 5 === 0);

console.log(divNum, 'divNum');

// ES6 객체 메서드는 원래 문법 사용할 것
const bob = {
  name: 'bob',
  // 타입 스크립트에서 유형 선언 안되는 문제 있음
  // printName() {},
  printName: function () {
    console.log(this.name);
  },
};
// 일반 함수의 this는 윈도우
// 객체 메서드의 this는 해당 객체
// 이벤트 핸들러의 this는 이벤트 연결 대상
// 화살표 함수의 this는 바깥쪽 부모 함수의 this와 일치
bob.printName();

// 템플릿 문자열
// var txt = "문자열에 '홀따옴표' 넣기";
let txt = `문자열에 '홀따옴표' 넣기`;
console.log(txt);

let animal = 'Tiger';
let age = 13;
// +와 ""사용하는 것보다 ``(백틱)하고 ${}사용이 훨씬 편함
console.log(
  `우리 고양이 이름은  ${animal.toLowerCase()}  이고 나이는  ${
    age * 10
  }  살 입니다.`
);

// 줄바꿈 가능
let txt2 = `고양이
개
호랑이`;
console.log(txt2);

// 문자열, 배열 추가 메서드
let txt3 = '사과는 맛있어';
let subTxt = '사과';

// 찾을 문자열이 있으면 true
console.log(txt3.includes(subTxt));

// 반복
console.log('best'.repeat(3));

const pet = ['고양이', '개', '앵무새'];

// 조건에 맞는 배열 요소 리턴
let findPet = pet.find((v) => v === '고양이');
console.log(findPet);

let findPetIdx = pet.findIndex((v) => v === '고양이');
console.log(findPetIdx);

console.clear();
// 구조분해
const arr = [11, 22, 33, 44];
// let [a, b, c, d] = arr;

// 건너 뛸 요소에서 , ,
let [a, , , d] = arr;
console.log(a, d);

// 객체 구조 분해
const luke = {
  job: 'jedi',
  father: 'anakin',
};

// let { job, father } = luke;

// 기존 변수명과 동일한 경우 이름 변경 가능
let { job: hobby, father: family } = luke;
console.log(hobby, family);

// 객체 리터럴
let fruit = '사과';
let modelNum = 'N002930';

const obj = {
  // 변수명과 값을 속성으로 사용
  fruit,
  // 계산된 속성: 변수값을 키로 사용
  [modelNum]: 100,
};

console.log(obj);

// default 매개면수, 나머지 매개변수, 스프레드 연산자
function fn2(x, y = 12) {
  return x + y;
}
console.log(fn2(3));

// 나머지 매개변수로 가변인자함수 생성
// rest는 일반 배열이므로 forEach, for of 사용 가능
function fn3(txt, ...rest) {
  let sum = 0;

  rest.forEach((v) => (sum += v));

  // for of 반복문은 break, continue 사용가능
  // for (v of rest) {
  //   if (v === 30) break;
  //   sum += v;
  // }

  return sum;
}
console.log(fn3('sum:', 10, 20, 30, 40));

function fn4(x, y, z) {
  return x + y + z;
}
const arr2 = [1, 2, 30];

// 배열요소를 전개하여 매개변수로 전달
console.log(fn4(...arr2));

// 배열 복사
const newArr2 = [...arr2];
newArr2.push(4);
console.log(newArr2, arr2);
