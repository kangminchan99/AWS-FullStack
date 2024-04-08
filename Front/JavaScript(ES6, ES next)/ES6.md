# ES6

**let, const
화살표함수
템플릿 문자열
문자열, 배열 추가 메서드
구조분해
향상된 객체 리터럴
기본(default), 나머지(rest) 매개변수, 스프레드 연산자
forEach, for in, for of 반복문
모듈
프라미스객체**

## let, const

- var은 함수스코프, var 생략가능(전연변수 양산), 중복선언허용, 변수호이스팅에 의해 선언전에 참조가능등의 문제점이 있음

- let, const는 블럭스코프

- let, const 생략불가

- 동일 블럭에서 중복선언불가

- 선언전에 참조불가

- const는 재할당 불가, 배열, 함수표현식등의 변경되지 말아야 할 값(주로 객체)에 사용

- let은 변수명만 선언가능, const는 값을 할당해야함

- 블럭: { }를 말하며 if블럭, for블럭, 함수블럭, { } 자체는 모두 블럭

```js
function fn1() {
{
  // 선언전에 참조불가
  console.log(x);
  let x;
  {
    // 블럭이 다르므로 x로 선언가능
    const x = "sneaky";
    // const는 상수이므로 재할당 불가
    x = "foo";
  }
  // 동일블럭에서 같은 변수명 선언 불가
  let x = "inner";
}
}

// var는 전연변수이므로 for문 밖에서 참조가능
for (var i = 0; i < 3; i++) {
 console.log(i);
}
console.log(i);

// let은 for블럭의 지역변수이므로 밖에서 참조불가
for (let i = 0; i < 3; i++) {
 console.log(i);
}
console.log(i);

// if블럭의 greeting은 서로 다른 스코프(범위)를 가지므로 다른 변수
let greeting = "안녕하세요";

if (true) {
 let greeting = "하이";
 console.log(greeting); // "하이"
}
console.log(greeting); // "안녕하세요"
```

## 화살표함수

- 화살표함수 this는 부모함수의 this와 일치하며 함수안의 익명함수, 함수의 인자로 전달되는 콜백함수에 사용

```javascript
// 매개변수 한개면 괄호 생략가능
// 매개변수 없거나 두개이상은 괄호
// 실행문 한줄이면 { return } 생략가능
// 표현식에서 객체 리턴시 ()로 묶어야함(함수블럭아님을 알려주기위해)
const evens = [2, 4, 6, 8, 10];
const odds = evens.map(v => v + 1);
const nums = evens.map((v, i) => v + i);
const pairs = evens.map(v => ({even: v, odd: v + 1}));

// nums배열 요소를 5로 나눈 나머지가 0인 요소만 새로운 배열로 만들기
let fives = [];

nums.forEach(v => {
  if (v % 5 === 0) fives.push(v);
});

const fives = nums.filter((v) => v % 5 === 0);

// 화살표함수 this는 함수가 만들어질때 결정됨
// 화살표함수 this는 부모함수의 this와 일치
// 일반함수 this는 window
// 객체의 메서드는 화살표함수 사용금지(메서드의 this가 달라지므로)
const bob = {
  name: "Bob",
  printName() {
    const fn = () => {
      console.log(this.name);
    };
    /* const fn = function () {
      console.log(this.name);
    }; */
  }
}
```

## 템플릿 문자열

- \`(백틱) 사용, 템플릿 리터럴안에서 ${변수}로 변수값 참조

```js
var txt = '문자열에 \'홑따옴표\' 포함된 경우 이스케이프 문자 사용';
let txt = `문자열에 '홑따옴표' 포함되어도 이스케이프 필요없음`;


let animalName = 'Tiger';
let age = 13;

console.log(`우리 고양이 이름은 ${name}이고 나이는 ${age}살 이다`);

// \n없이 줄바꿈가능
let txt2 = `고양이
 개
 호랑이`;

// 표현식 가능
let today = new Date();
let txt3 = `오늘 날짜와 시간은 ${today.toLocaleString()}`;
```

## 문자열, 배열 추가 메서드

```js
let txt4 = '사과는 맛있어';
let subTxt = '사과'; 
// 문자열에 찾을 문자열이 있으면 true
console.log(txt4.includes(subTxt)); // true 
// 문자열 반복
'best'.repeat(3); // 'bestbestbest' 
const pet = ['고양이', '개', '앵무새']; 
// 제공된 테스트함수에 맞는 첫번째 요소 리턴
pet.find(x => x === '고양이');
// 제공된 테스트함수에 맞는 요소의 인덱스 리턴
pet.findIndex(x => x === '고양이');
```

## 구조분해

- 배열, 객체에서 값을 추출하여 새로운 변수에 할당하여 사용

```js
var arr = [1, 2, 3, 4];
var a = arr[0];
var b = arr[1];
var c = arr[2];
var d = arr[3];

// 배열 구조분해하여 각 변수에 할당
const arr2 = [1,2,3,4];
let [a, b, c, d] = arr2;

// 건너띌 요소에서 ,(쉼표)로 필요한 요소만 할당 가능
let [a, , c] = arr2;

// 객체 구조분해시 객체 키를 변수명으로 사용
const luke = { job: 'jedi', father: 'anakin' };
let {job, father} = luke;

console.log(job); // 'jedi'
console.log(father); // 'anakin'

// 객체 키와 다른 이름의 변수에 할당
const luke = { job: 'jedi', father: 'anakin' };
let {job:hobby, father:family} = luke;
```

## 향상된 객체 리터럴

```js
let fruit = '사과';
let modelNum = 'N001345';

const obj = {
  // 변수명과 값을 속성으로 바로 사용
  fruit,
  // 변수값을 키로 사용
  [modelNum]: 100,
};
```

## 기본(default), 나머지(rest) 매개변수, 스프레드 연산자

```javascript
function fn2(x, y = 12) {
  // y 매개변수에 인자가 전달되지않으면 기본값 할당
  return x + y;
}
console.log(fn2(3)) // 15

// 나머지 매개변수사용시 배열에 나머지 인자들이 들어감
function fn3(txt, ...rest) {
  let sum = 0;

  for (v of rest) {
    sum += v;
  }
  return txt + sum;
}
console.log(fn3('합계: ', 10, 20, 30, 40, 100, 500));

function fn4(x, y, z) {
  return x + y + z;
}

const arr3 = [1,2,3];

// 배열 요소 각각을 전개하여 전달
console.log(fn4(...arr3)) // 6

// 배열 복사
const newArr3 = [...arr3];
```

## forEach, for in, for of 반복문

- for of 반복문은 반복 가능한 객체(배열, 문자열, Map, Set)에 대해 키값을 반복순회,
  (break, continue, return 사용가능)

```js
const arr4 = ['사과', '배', '딸기'];

// forEach 메서드는 배열요소에 대해 반복작업 실행(break, continue, return 사용불가)
arr4.forEach((v, i) => console.log(v));

const user = {
  name:'Smith',
  age: 30,
  country: 'Korea',
};

// 객체 키, 키값 확인하기
for (const key in user) {
  console.log(key, user[key]);
}

// for of 반복문은 반복 가능한 객체(배열, 문자열, Map, Set)에 대해 키값을 반복순회,
// break, continue, return 사용가능
for (const value of arr4) {
  console.log(value);

  if(value === '사과') {
    break;
  }
}
```

## 모듈

- 기능별 파일(모듈)로 분리하여 작업후 import하여 사용(유지보수에 용이)

```html
// index.html
<body>
  <script type="module" src="app.js"></script>
</body>
```

```js
// npm init -y, package.json에 "type": "module" 추가하여 es 모듈 활성화
{
  "name": "module-test",
  "version": "1.0.0",
  "type": "module",
  "description": "",
  "main": "app.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC"
}

// utils/math.js
export function sum(x, y) {
  return x + y;
}

export const pi = 3.141593;

export default function Header () {
  console.log('기본 함수 내보내기');
}

// app.js
// default는 {} 없이 앞에서 먼저 받고 나머지는 객체 구조분해로 받음
// default는 이름변경가능, 나머지는 as로 변경가
import Header, {sum, pi} from "utils/math";

Header();
alert(`2π = ${sum(pi, pi)}`);
```

## Promise 객체

- 데이터 가져오기 등 비동기 동작(데이터 가져오기가 완료되면 실행되야 하는 동작)에 사용

- 비동기 동작을 순차적으로 실행해주며 에러발생시 예외처리 가능

- 자바스크립트 인포: https://ko.javascript.info/promise-basics

### 프라미스의 콜백함수에 의한 상태 변화

- 비동기 호출이 성공하면 resolve() 호출, 실패하면 reject() 호출

- resolve(value)가 호출되면 result에 value가 들어가고 reject(error)가 호출되면 result에 error가 들어감
  
  ![![[Pasted image 20231126222128.png]]](C:\markdown\Pasted%20image%2020231126222040.png)
  
  ```js
  function promise1(param) {
    return new Promise((resolve, reject) => {
      if (param) {
        resolve('완료');
      } else {
        reject(new Error('에러 발생!'));
      }
    });
  }
  
  //프로미스 실행
  promise1(true)
    .then((result) => console.log(result))
    .catch((err) => console.log(err.message));
  ```

### 프라미스 체이닝

- resolve() 호출이후 then의 핸들러(콜백함수)가 호출되고 return값은 그다음 then 핸들러에 전달
- promise.then의 리턴이 프라미스이므로 .then으로 체이닝하여 순차적으로 실행가능

```js
new Promise((resolve, reject) => {
  setTimeout(() => resolve(1), 1000);
})
  .then((result) => {
    alert(result);
    return result * 2;
  })
  .then((result) => {
    alert(result);
    return result * 2;
  })
  .then((result) => {
    alert(result);
    return result * 2;
  });
```

### fetch메서드와 프라미스 체이닝

- 가짜 API 테스트: https://jsonplaceholder.typicode.com/guide/

```javascript
// fetch메서드는 백엔드 API 엔드포인트(url)를 이용하여 비동기로 데이터 가져올때 사용
// fetch호출시 프라미스 리턴
const tit = document.querySelector('.tit');
const txt = document.querySelector('.txt');

fetch('https://jsonplaceholder.typicode.com/posts/1')
  .then((response) => response.json())
  .then((json) => {
    const post = json;
    console.log(post);

    tit.innerHTML = post.title;
    txt.innerHTML = post.body;
  });
```

### async, await

```js
// async가 붙은 함수는 반드시 프라미스를 반환
async function fn5 () {
  return 1;
}

fn5().then(alert); // 1

async function fn6() {
  const promise = new Promise((resolve, reject) => {
    setTimeout(() => resolve("완료!"), 1000)
  });
  // await은 async함수 안에서만 사용가능
  // 다음 코드 실행하지않고 프라미스 이행완료시까지 기다림
  let result = await promise;

  alert(result); // "완료!"
}

fn6();

// fetch메서드 async, await사용
async function getFekeData () {
  const response = await fetch('https://jsonplaceholder.typicode.com/posts/1');
  // 자바스크립트 객체로 변환
  const post = await response.json();
  console.log(post);
}
getFekeData();
```
