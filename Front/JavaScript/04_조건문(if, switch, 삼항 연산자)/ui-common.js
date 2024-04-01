// prompt 함수로 나이를 입력받아 19살 이상이면 '성인'을 콘솔로 출력하고
// 19살 미만이면 '미성년자를' 콘솔에 출력하시오(if)

// let age = prompt('나이를 입력하세요');
// console.log(age);

// if (age >= 19) {
//   console.log('성인입니다');
// } else {
//   console.log('미성년자입니다');
// }

// 숫자를 prompt로 입력받고 짝,홀수를 판단하시오(if)
// let num = prompt('숫자를 입력하세요');

// if (num % 2 == 0) {
//   console.log('짝수');
// } else {
//   console.log('홀수');
// }

// 나이를 입력받아 10대(10살미만도포함), 20대, 30대이상으로 출력하시오(if)

// let num = prompt('나이를 입력하세요');
// if (num >= 30) {
//   console.log('30대');
// } else if (num > 20 && num < 30) {
//   console.log('20대');
// } else {
//   console.log('10대');
// }

// false판정되는 경우(false , 0, -0, '', undefined, null, NaN)
// let test = false;
// let test = 0;

// if (test) {
//   console.log('참');
// } else {
//   console.log('거짓');
// }

// 아이디가 맞으면 패스워드가 맞는지 판단하여 로그인시키기(중첩if, 아이디가 없으면 아이디없음 출력, 패스워드가 틀리면 패스워드 틀림 출력)
// let userId = 'minchan';
// let password = '1234';

// if (userId == 'minchan') {
//   console.log('id 있음');

//   if (password == '1234') {
//     console.log('login');
//   } else {
//     console.log('password error ');
//   }
// } else {
//   console.log('id 없음');
// }

// 일치 연산자: ===(자료형과 값이 같은지 비교), !==(자료형과 값이 다른지 비교)
// 자바 스크립트는 자동 형병환이 되므로 빈칸과 0을 같다고 판단
// 조건문 작성 시 무조건 일치 연산자 사용하여 값과 자료형을 모두 판단할 것
// if ('11' === 11) {
//   console.log('참');
// }

// 혈액형을 prompt로 입력받아 사람의 혈액형인지 판단하시오
// 혈액형이 A,B,AB,O이면 사람입니다 아니면 동물입니다 출력(논리연산자)

// 추가조건: 빈칸일경우 혈액형을 대문자로 입력하세요를 alert으로 띄우기

// let blood = prompt('혈액형을 입력하시오');
// // 앞 뒤 공백제거 trim()
// blood = blood.trim().toUpperCase();
// if (blood == '') {
//   alert('혈액형을 대문자로 입력하세요');
// } else if (blood === 'A' || blood === 'B' || blood === 'AB' || blood == 'O') {
//   console.log('사람');
// } else {
//   console.log('동물');
// }

// prompt로 점수를 입력받고 90이상이면 매우우수, 80이상이면 우수, 70이상이면 보통,
// 60이상이면 미흡, 60미만이면 매우미흡을 콘솔로 출력하시오
// let grade = prompt('성적 입력');

// if (grade >= 90) {
//   console.log('매우 우수');
// } else if (grade >= 80) {
//   console.log('우수');
// } else if (grade >= 70) {
//   console.log('보통');
// } else if (grade >= 60) {
//   console.log('미흡');
// } else {
//   console.log('매우 미흡');
// }

// switch조건문 값이 딱 떨어지는 경우 주로 사용

// prompt로 숫자를 입력받아 짝홀수를 판단하시오(switch 조건문 이용)
// 추가조건1: 빈문자일 경우 실행하지않기(if)
// 추가조건2: 일반문자일 경우 숫자를 입력하세요 출력하기(default)
// let num = prompt('input num');

// num1 = num.trim();

// if (num1 === '') {
// } else {
//   switch (num % 2) {
//     case 0:
//       console.log('even');
//       break;
//     case 1:
//       console.log('odd');
//       break;
//     default:
//       alert('숫자를 입력!');
//       break;
//   }
// }

// date객체를 이용하여 오늘의 요일을 콘솔에 출력하시오(switch)
// 객체 타입은 객체를 변경하지 않으므로 const상수로 선언
// Date 생성자 함수를 new 키워드로 호출하여 날짜 객체 인스턴스(복제본)생성
// const now = new Date();
// console.log(now.getDay());

// switch (now.getDay()) {
//   case 0:
//     console.log('일');
//     break;
//   case 1:
//     console.log('월');
//     break;
//   case 2:
//     console.log('화');
//     break;
//   case 3:
//     console.log('수');
//     break;
//   case 4:
//     console.log('목');
//     break;
//   case 5:
//     console.log('금');
//     break;
//   case 6:
//     console.log('토');
//     break;
//   default:
//     console.log('error');
//     break;
// }

// 삼항 연산자: 조건에 의해 실행될 문장이 두개일 경우 사용
// let num = 100;

// num % 2 ? console.log('odd') : console.log('even');

// num이 한자리 숫자면 '0'을 붙여 두자리로 만들기 (삼항연산자)
// let num = 9;

// let num2 = num < 10 ? '0' + num : num;

// console.log(num2);

// 오늘의 시간을 이용하여 6시이상 20시 미만이면 '낮입니다'
// 아니면 '밤입니다'를 출력하시오(삼항연산자)

const date = new Date();

date.getHours() >= 6 && date.getHours() < 20
  ? console.log('낮')
  : console.log('밤');
