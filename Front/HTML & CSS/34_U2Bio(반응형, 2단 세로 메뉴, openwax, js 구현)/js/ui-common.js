window.addEventListener('DOMContentLoaded', function () {
  const header = document.querySelector('#header');
  // header fix
  window.addEventListener('scroll', function () {
    // 세로 스크롤바의 위치값
    let _scrollY = window.scrollY;

    if (_scrollY > 0) {
      header.classList.add('fixed');
    } else {
      header.classList.remove('fixed');
    }
  });
  // 언어메뉴
  document
    .querySelector('#header .lang_btn')
    .addEventListener('click', function () {
      document.querySelector('#header .lang_wrap').classList.toggle('on');
    });

  // 화살표 함수의 this는 함수 생성 시점에서 바깥 부모 함수의 this와 일치함
  // document.querySelector('#header .lang_btn').addEventListener('click', () => {
  //   console.log(this);
  //   this.classList.toggle('on');
  // });

  // 모바일 메뉴
  // 이벤트 핸들러 안에서 this는 이벤트가 연결된 요소를 의미
  document
    .querySelector('#header .open_btn')
    .addEventListener('click', function () {
      this.classList.toggle('on');
    });
});
