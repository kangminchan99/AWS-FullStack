# let, const, 자료형

## let, const

- 블럭스코프({ }, if블럭, for블럭, 함수블럭 등등)
- 블럭안에 선언한 변수는 해당 블럭에서만 사용가능한 지역변수
- let, const 생략시 전역변수 생성되므로 생략하지말것
- 변수선언후 아래쪽에서 사용하기
- let은 변할 수 있는 값에 사용
- const는 변하지않는 값에 사용(주로 객체)
- 변수이름은 카멜표기법(userId, st, mainNum)
- var은 함수스코프

## 자료형

- 기본자료형: Number, String, Boolean, undefined, null
- 복합자료형: Object(함수, 싱글턴객체, 생성자함수, 클래스, 내장객체)
- false판정되는값: '', 0, -0, false, NaN, undefined, null
- 같다 다르다 비교시 일치연산자 ===, !== 사용할것
