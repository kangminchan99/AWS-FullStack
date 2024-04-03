// 콘솔에 1초마다 10까지 출력하시오(setInterval, clearInterval)

// let cnt = 0;

// const intervalId = setInterval(() => {
//   cnt++;
//   console.log(cnt);

//   if (cnt >= 10) {
//     clearInterval(intervalId);
//   }
// }, 1000);

// 화면에 5부터 0까지 카운트 보여주고 네이버로 이동하기
// window. 생략 가능 전역이라
// location.href = 'http://naver.com';

document.addEventListener('DOMContentLoaded', function () {
  function changeParam(num, className, url) {
    // let cnt = document.querySelector('.count').textContent;
    let cnt = parseInt(num);
    const count = document.querySelector(className);
    count.innerHTML = cnt;

    const intervalId = setInterval(() => {
      cnt--;
      count.innerHTML = cnt;

      if (cnt === 0) {
        clearInterval(intervalId);
        location.href = url;
      }
    }, 1000);
  }
  changeParam(10, '.count', 'http://naver.com');
});

// 함수로 리팩토링 시 위의 코드가 바뀔 수 있는거
// 카운트 초기값, 카운트 클래스 명, 이동할 주소
// 함수 호출 시 인자로 위의 값을 전달하여 실행되도록 개선
