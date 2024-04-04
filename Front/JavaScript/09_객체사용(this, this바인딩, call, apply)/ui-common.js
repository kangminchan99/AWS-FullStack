// 객체 메서드에서 this는 메서드가 선언된 객체를 가리킴
// 일반 함수의 this는 window를 가리킴
const obj = {
  num: 200,
  showNum: function () {
    console.log(this);

    // this바인딩: 메서드의 this를 변수에 대입하여 바인딩
    let _this = this;

    function inner() {
      console.log(this);
      console.log(_this);
    }
    inner();
  },
};
obj.showNum();

// this바인딩: 함수의 this를 다른 객체를 가르키도록 함(call, apply, bind)
const student = {
  studentName: ['yeji', 'yuna'],
};

function showname() {
  // console.log(x, y);
  console.log(this.studentName[0], '===showname');
}

// student객체와 연결하여 this 바인딩 후 인자값 파라미터로 넘기기
// showname.call(student, 100, 200);

// 배열안의 요소 각각이 파라미터로 전달됨 인자값이 배열일 때 사용
// showname.apply(student, [100, 200]);

// this가 가리키는 대상은 함수를 호출할 때 동적으로 결정됨
// bind메서드 만으로 함수 호출이 되지 않으므로 ()를 붙여서 함수 호출을 해야함
showname.bind(student)();
