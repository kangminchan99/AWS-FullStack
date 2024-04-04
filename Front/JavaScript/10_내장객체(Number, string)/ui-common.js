// Number객체 생성 시 new키워드 사용하지 말 것(불필요한 정보가 생성되므로)
// let num = new Number(123);
// console.log(num);

let num = 123.3456;
// 소수점 두자리
num = num.toFixed(2);
console.log(num);

// String 객체
let str = 'hi';
console.log(str.length);

// prompt메서드로 비밀번호를 입력받고 8글자미만이면
// 8글자 이상 입력하라는 alert을 띄우고 아니면 비밀번호 길이를 띄워줌

// let password = prompt('숫자를 입력');

// if (password.length < 8) {
//   alert('더 길게 입력하쇼');
// } else {
//   alert(password.length);
// }

let str2 = '문자열입니다';
// 문자열 위치 charAt
console.log(str2.charAt(0));

let str3 = str2.concat('  연결된 문자');
console.log(str3);

let str4 = str3.indexOf('문자');
console.log(str4);

// 찾는 문자가 있는지 판단
if (str3.indexOf('abc') === -1) {
  console.log('찾는 문자가 없음');
} else {
  console.log('찾는 문자가 있음');
}

// 변경될 문자에서 첫번째로 일치하는걸 바꿔줌
let change = str3.replace('문자', 'ㅋㅋ');
console.log(change);

// 문자열 잘라낸거 보여줌
console.log(str3.slice(3, 5));
