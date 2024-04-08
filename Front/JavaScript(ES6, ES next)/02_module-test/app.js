// default export를 {}없이 먼저 받고 named export는 객체 구조 분해로 받음
// 경로에 현재 폴더 기호(./) 생략 불가
// default export는 이름 변경이 가능하나 그냥 쓰자..(Header())
import NavBar, { sum as sum2, pi as pi2 } from './utils/math.js';

NavBar();
console.log(`2pi = ${sum2(pi2, pi2)}`);
