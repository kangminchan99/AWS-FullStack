# this, this바인딩

- 전역(함수밖)에서 this는 window

- 함수안에서 this는 window

- 객체 메서드안에서 this는 메서드가 선언된 객체

- 이벤트 핸들러안에서 this는 이벤트가 걸린 요소

## 객체 메서드의 내부함수에서 this바인딩

```js
var obj = {
  num: 200,
  showNum: function () {
    console.log(this);

    // 메서드에서의 this를 변수에 대입하여 내부함수에서 사용(this바인딩)
    let _this = this;

    function inner() {
      console.log(_this.num);
      console.log(this);
    }
    inner();
  },
};
obj.showNum();
```

## 함수의 this를 객체로 바인딩

```js
const student = {
  studentName: ['홍길동', '슈퍼걸'],
};

// 이미 만들어져있는 객체안의 정보에 접근하기
function showName(n1, n2) {
  console.log(n1, n2);
  console.log(this.studentName[1]);
}

// 함수호출시 call(연결할객체명, 인자1, 인자2)로 연결
showName.call(student, 100, 200);

// 함수호출시 apply(연결할객체명, [])
// showName.apply(student, ['사과', '배']);

// showName.bind(student)();
```
