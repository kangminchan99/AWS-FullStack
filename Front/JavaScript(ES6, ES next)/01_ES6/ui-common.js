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

console.clear();

// Promise객체: 데이터 fetch성공, 실패 여부에 따라 로직을 처리하게 해주는 객체
// 비동기 로직(데이터 가져오기)이 성공하면 resolve()실행되어 then안쪽 함수가 실행
// 실패하면 reject() 반환되어 catch안쪽 함수가 실행됨
function promise(param) {
  return new Promise((resolve, reject) => {
    if (param) {
      resolve('fetched');
    } else {
      reject(new Error('error occur'));
    }
  });
}

promise(false)
  .then((result) => console.log(result))
  .catch((e) => console.log(e.message));

// 프라미스 체이닝: promise.then의 리턴값이 프라미스 객체이므로 .then으로 연결하여 순차 실행 가능
// 데이터를 가져온 후 .then으로 순차적으로 코드를 실행할 수 있음
// new Promise((resolve, reject) => {
//   setTimeout(() => resolve(1), 1000);
// })
//   .then((result) => {
//     alert(result);
//     return result * 2;
//   })
//   .then((result) => {
//     alert(result);
//     return result * 2;
//   })
//   .then((result) => {
//     alert(result);
//     return result * 2;
//   });

// fetch메서드로 데이터 가져와서 화면에 보여주기
// window.addEventListener('DOMContentLoaded', function () {
//   const tit = document.querySelector('.tit');
//   const txt = document.querySelector('.txt');

//   // 데이터를 get방식으로 가져오기
//   fetch('https://jsonplaceholder.typicode.com/posts/1')
//     .then((response) =>
//       // json객체로 변환
//       response.json()
//     )
//     .then((result) => {
//       tit.innerHTML = result.title;
//       txt.innerHTML = result.body;
//     });
// });

// async, await 키워드로 비동기 로직을 동기적(순차적)으로 실행하기
async function fn5() {
  const promise = new Promise((resolve, reject) => {
    setTimeout(() => resolve('완료'), 1000);
  });
  // async키워드는 async 함수 안에서 사용가능, 프라미스 완료 시 까지 기다림
  let result = await promise;
  alert(result);
}

fn5();

// fetch메서드에서 async, await 사용하기

window.addEventListener('DOMContentLoaded', function () {
  const tit = document.querySelector('.tit');
  const txt = document.querySelector('.txt');

  async function getData() {
    const response = await fetch(
      'https://jsonplaceholder.typicode.com/posts/1'
    );
    const post = await response.json();

    tit.innerHTML = post.title;
    txt.innerHTML = post.body;
  }

  getData();
});
