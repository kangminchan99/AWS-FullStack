// var로 선언한 변수는 호이스팅에 의해 선언부가 먼저 읽혀짐
console.log(mainNum, num2, _this, $el);

// 변수 선언 (변수명: 카멜 표기법) 시 대입연산자를 사용하여 오른쪽 값에 넣어줌
var mainNum = 100;
var num2 = 200;
// 키워드를 변수명으로 활용할 경우 _사용
var _this = this;
// $를 붙여 제이쿼리객체임을 명시할 때 사용
var $el = 'str';

// var 변수는 함수 스코프(범위)를 가짐
function fn() {
  var local = 'region var';
  // 함수 스코프므로 local값이 덮어씌워진다.
  if (true) {
    var local = 'region var3';
  }
  console.log(local);
}

fn();

function fn2() {
  var local = 'region var2';
  console.log(local);
}

fn2();

// var은 함수 스코프이므로 함수가 아닌 경우 모두 전역 변수가 되는 문제가 있음.
for (var i = 0; i < 5; i++) {
  console.log(i);
}
console.log(window.i);

// 변수명이 같아도 에러를 띄워주지 않음
var test = 500;
var test = 600;
console.log(test);

// var은 여러가지 문제점이 있으므로 변수 선언 시 let, const 사용할 것
// let, const는 {}안에 선언하면 지역변수이며 블럭 스코프임
{
  let num = 100;
  console.log(num, 'let 선언');

  // const 상수형 변수 이므로 재할당(변경) 불가
  const userId = 'ossam';
  userId = '바뀌지 않아용';
  console.log(userId);
}

for (let j = 0; j < 10; j++) {
  console.log(j);
}
