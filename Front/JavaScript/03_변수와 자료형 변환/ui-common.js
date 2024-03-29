// 기본 자료형: Number, String, boolean, undefined, null, Nan

// 데이터 자료형
// Number
let num1 = 999;
console.log(num1, typeof num1);

// String(문자열)
let str = 'hi';
console.log(str, typeof str);

// boolean(true, false)
let bool1 = true;
console.log(bool1, typeof bool1);

// undefined 변수에 값을 할당하지 않음
let userId;
console.log(userId);

// null - undefined와는 다른 느낌 나중에 객체타입을 변수에 저장할 때 사용
let el = null;
console.log(el, typeof el);

// 문자형 변수 초기화 시 빈칸 사용
let msg = 'fan';
// 재할당
// msg변수 공간에 msg의 값인 'hi'에 다른 문자를 연결하여 재할당
msg += ' yeji';
console.log(msg);

// Nan - 문자와 숫자가 곱해질 수 없으므로 연산 오류
console.log('hi' * 100);

let num2 = 99;
num2 *= 100;

console.log(num2);

// 나머지 연산자 %
console.log(101 % 2);

// 증감 연산자(1씩 증감)
let cnt = 0;
// cnt++;
// cnt++;
console.log(cnt++);
console.log(cnt++);

// 윈도우 전역객체는 생략가능
prompt('put number');
