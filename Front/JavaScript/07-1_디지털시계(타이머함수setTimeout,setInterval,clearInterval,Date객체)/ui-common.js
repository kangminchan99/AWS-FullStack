window.addEventListener('DOMContentLoaded', function () {
  const hourEl = document.querySelector('.section1 .hour');
  const minEl = document.querySelector('.section1 .min');
  const secEl = document.querySelector('.section1 .sec');
  const msecEl = document.querySelector('.section1 .msec');

  function clock() {
    // 닐짜 객체의 인스턴스(복제본) 생성
    const now = new Date();
    let hour = now.getHours();
    let min = now.getMinutes();
    let sec = now.getSeconds();
    // 밀리 세컨드 3자리를 앞 두자리만 사용
    let msec = Math.floor(now.getMilliseconds() / 10);
    // 텍스트로 넣어줌
    // hourEl.textContent = hour;
    // minEl.textContent = min;
    // secEl.textContent = sec;
    // msecEl.textContent = msec;

    // 숫자가 한자리면 두자리로 변경해주는 함수
    function digit(num) {
      // num이 10미만이면 '0'을 붙여 두자리로 만듬
      return num < 10 ? '0' + num : num;
    }

    // 텍스트로 넣어줌
    hourEl.textContent = digit(hour);
    minEl.textContent = digit(min);
    secEl.textContent = digit(sec);
    msecEl.textContent = digit(msec);
  }
  // 최초 시간 정보 보여주기
  clock();

  // 일정 시간마다 정보 갱신
  setInterval(clock, 1000);
});
