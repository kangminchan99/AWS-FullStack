// 객체: 데이터를 속성명을 붙여 구조화
const car = {
  name: 'sonata',
  modelNum: 400,
  color: 'black',
  'navi model': '아이나비',
  company: {
    year: '2000',
    manufecture: 'kia',
  },
  // 메서드: 객체 안의 함수
  moveCar: function () {
    // 객체 메서드에서 this는 메서드가 선언된 객체를 가르킨다 그래서 sonata가 name에 들어감
    console.log(this.name + '가 움직입니다.');
  },
};

console.log(typeof car, car.modelNum, car['name'], car.color);
// 속성명에 띄어쓰기 있을 경우 대괄호 표기법으로 접근
console.log(car['navi model']);
console.log(car.company.manufecture);

car.moveCar();

// 객체 전용 반복문
for (const key in car) {
  // 객체 키 속성명 확인
  // console.log(key);
  console.log(car.key);
}

// 객체에 속성 존재 여부 확인
console.log('color' in car);

// 객체에 동적으로 속성 추가
car.speed = '300km';
console.log(car);

car.changeColor = function () {
  this.color = 'red';
};

car.changeColor();

// 객체 속성 제거
delete car.color;
console.log(car);

// ES6 객체 메서드 표기법
// ES6 메서드 표기법은 타입 스크립트에서 타입을 선언할 수 없으므로 사용하지 말 것
// 객체 메서드 선언 시 화살표 함수의 this는 해당 객체가 아니므로 사용금지
const user = {
  userId: 'dalhoya',
  // checkId() {
  //   console.log(this.userId);
  // },
  // checkId: () => {
  //   console.log(this.userId);
  // },
  checkId: function () {
    console.log(this.userId);
  },
};
user.checkId();
