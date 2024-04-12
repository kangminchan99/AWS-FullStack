$(function () {
  const header = $('#header');

  $(window).on('scroll', function () {
    // 세로스크롤바 위치
    let st = $(window).scrollTop();

    if (st > 0) {
      header.addClass('fixed');
    } else {
      header.removeClass('fixed');
    }
  });

  // 언어메뉴
  $('#header .lang_btn').on('click', function () {
    $('#header .lang_wrap').toggleClass('on');
  });

  // 모바일메뉴
  // 이벤트핸들러 안에서 this는 이벤트가 연결된 요소를 의미
  $('#header .open_btn').on('click', function () {
    // body 스크롤바 안보이게, iOS 사파리는 안됨
    $('body').toggleClass('on');
    header.toggleClass('on');
    $(this).toggleClass('on');
    $('#header .m_gnb_wrap').toggleClass('on');
  });

  // 모바일 아코디언 메뉴
  $('#header .m_gnb>li>a').on('click', function () {
    $(this).parent().toggleClass('on');
    $(this).parent().siblings().removeClass('on');
  });

  // 메인슬라이더 scroll down

  $('.main_slider .scroll_down').on('click', function (event) {
    event.preventDefault();

    // 클릭시 요소의 문서에서의 위치만큼 스크롤해야함
    let posY = $('.main_business').offset().top;

    // jquery 스크롤 애니메이션
    $('html, body').animate({ scrollTop: posY });
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

    $(window)
      .on('scroll', function () {
        // 요소가 페이지 상단까지 스크롤
        // let posY = document.querySelector('.main_info .info_left').offsetTop;

        // 요소가 창아래에서 위로 스크롤
        let posY =
          $('.main_info .info_left').offset().top - $(this).outerHeight();

        if ($(this).scrollTop() >= posY && isScroll === false) {
          const numEl = $('.main_info .num strong');

          const interval = setInterval(() => {
            cnt += amount;
            numEl.text(cnt);

            // cnt가 최종숫자 - 증가량보다 크면 최종숫자를 넣어주고 타이머중지
            if (cnt >= final - amount) {
              numEl.text(final);
              clearInterval(interval);
            }
          }, 10);

          // isScroll을 true로 변경하여 다음 스크롤이벤트에서 실행되지않도록함
          isScroll = true;
        }
      })
      .trigger('scroll');
  }
  countNum(0, 4185, 17);

  $('#footer .family_btn').on('click', function () {
    // document.querySelector('#footer .family_wrap').classList.toggle('on');
    $(this).parent().toggleClass('on');
  });

  // 푸터 탑 버튼
  $('#footer .top_btn').on('click', function (event) {
    event.preventDefault();

    $('html, body').animate({ scrollTop: 0 });
  });
});
