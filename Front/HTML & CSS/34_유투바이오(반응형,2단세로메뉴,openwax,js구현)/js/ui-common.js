window.addEventListener('DOMContentLoaded', function () {
  const header = document.querySelector('#header');

  // header fixed
  window.addEventListener('scroll', function () {
    // 세로스크롤바 위치
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

  // 모바일메뉴
  // 이벤트핸들러 안에서 this는 이벤트가 연결된 요소를 의미
  document
    .querySelector('#header .open_btn')
    .addEventListener('click', function () {
      // body 스크롤바 안보이게, iOS 사파리는 안됨
      document.body.classList.toggle('on');
      header.classList.toggle('on');
      this.classList.toggle('on');
      document.querySelector('#header .m_gnb_wrap').classList.toggle('on');
    });

  // 모바일 아코디언 메뉴
  // 그룹요소는 querySelectorAll사용하며 배열로 리턴됨
  const mGnb = document.querySelectorAll('#header .m_gnb>li>a');

  // js 형제요소 선택
  function siblings(t) {
    // 타겟요소의 부모안의 모든 자식요소선택(.m_gnb>li들)
    const children = t.parentElement.children;
    const tempArr = [];

    // children은 html컬렉션 유사배열이므로 for문의 반복하여 임시배열로 만듬
    for (let i = 0; i < children.length; i++) {
      tempArr.push(children[i]);
    }

    // 임시배열안의 형제요소중 타겟요소와 같지않은 요소들로 새로운 배열 리턴
    return tempArr.filter((v) => {
      return v !== t;
    });
  }

  // a들을 배열로 선택후 반복문을 통해 이벤트 연결
  mGnb.forEach((v) => {
    v.addEventListener('click', function (e) {
      // a태그 기본이벤트(위로이동) 막기
      e.preventDefault();
      // a의 부모 li에 클래스 토글
      this.parentElement.classList.toggle('on');
      // a의 부모 li의 형제 li의 on 클래스 제거
      siblings(this.parentElement).forEach((v) => {
        v.classList.remove('on');
      });
    });
  });

  // 메인슬라이더 scroll down
  document
    .querySelector('.main_slider .scroll_down')
    .addEventListener('click', function (e) {
      e.preventDefault();

      // 클릭시 요소의 문서에서의 위치만큼 스크롤해야함
      let posY = document.querySelector('.main_business').offsetTop;

      window.scrollTo({
        top: posY,
        behavior: 'smooth',
      });
    });

  // aos 초기화
  AOS.init({
    duration: 1000,
    // 한번만 실행
    // once: true,
  });

  // 주식정보 숫자 카운팅
  function countNum(cnt, final, amount) {
    let isScroll = false;

    window.addEventListener('scroll', function () {
      // 요소가 페이지 상단까지 스크롤
      // let posY = document.querySelector('.main_info .info_left').offsetTop;

      // 요소가 창아래에서 위로 스크롤
      let posY =
        document.querySelector('.main_info .info_left').offsetTop -
        this.outerHeight;

      if (this.scrollY >= posY && isScroll === false) {
        const numEl = document.querySelector('.main_info .num strong');

        const interval = setInterval(() => {
          cnt += amount;
          numEl.textContent = cnt;

          // cnt가 최종숫자 - 증가량보다 크면 최종숫자를 넣어주고 타이머중지
          if (cnt >= final - amount) {
            numEl.textContent = final;
            clearInterval(interval);
          }
        }, 10);

        // isScroll을 true로 변경하여 다음 스크롤이벤트에서 실행되지않도록함
        isScroll = true;
      }
    });

    // js 이벤트 강제발생
    window.dispatchEvent(new Event('scroll'));
  }
  countNum(0, 4185, 17);
});
