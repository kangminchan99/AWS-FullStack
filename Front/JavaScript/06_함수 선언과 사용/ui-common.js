// 함수 호출하여 실행 - 함수 선언식은 호이스팅 가능 선언 위차 관계 X
fn1();

// 함수 선언
// 모든 함수는 내부로직 아래에 return이 기본 제공됨
function fn1() {
  console.log('함수 선언식');
}

// 함수 표현식은 호이스팅이 없으므로 선언하기전에 실행 불가
// fn2();
// const fn2 = function () {
//   console.log('함수 표현식');
// };

// 매개변수,파라미터(전달된 인자를 받아주는 지역변수), 리턴값(함수 내부의 결과를 밖으로 보냄)
function sum(a, b) {
  return a + b;
}

// 함수 실행 시 전달되는 값을 인자(argument)
let result = sum(10, 20);
console.log(result);

// 가변 인자 함수: arguments 유사 배열에 인자가 모두 들어있음
// return걸면 함수 종료됨
function calc() {
  let sum = 0;
  console.log(arguments);
  for (let i = 0; i < arguments.length; i++) {
    sum += arguments[i];
  }
  return sum;
}
let result2 = calc(5, 20, 30, 40);
console.log(result2);

// 함수 스코프(유효 범위): 함수는 포함관계
// 스코프 내부에서 밖으로만 접근이 가능
function outerFn() {
  console.log('outfn');

  // 함수 내부에서만 사용하는 기능은 내부함수로 선언
  function innerFn() {
    console.log('innerFn');
  }
  innerFn();
}

outerFn();

// 콜백함수: 함수 실행 시 인자로 전달되는 함수
function fn3(callback) {
  console.log('fn3');
  callback();
}

// function callbackFn() {
//   console.log('콜백함수 실행');
// }

// fn3 펑션안에 있는 내용이 먼저 실행된 다음에 콜백함수 실행
fn3(() => console.log('콜백함수 실행'));

// 재귀함수 (함수 내부에서 자신을 다시 호출하는 함수)

function factorial(num) {
  if (num === 1) return 1;
  return num * factorial(num - 1);
}

let result3 = factorial(5);
console.log(result3);

// 즉시 실행 함수 (IEFF): 익명 함수를 감아서 실행하는 형태
(function () {
  console.log('즉시 실행 함수 IEFF');
})();
