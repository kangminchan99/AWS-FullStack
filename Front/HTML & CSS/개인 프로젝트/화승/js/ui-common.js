$(function () {
  // 헤더 색깔 변경
  window.addEventListener('scroll', function () {
    const header = document.querySelector('#header');
    let posY = document.querySelector('#container .main_slider').offsetHeight;

    // 스크롤 위치가 특정 클래스의 높이보다 크면 헤더의 색상 변경
    if (window.scrollY > posY) {
      header.classList.add('fixed');
    } else {
      header.classList.remove('fixed');
    }
  });

  //
  $('#header .gnb>li>a').on('mouseenter', function () {
    $('#header .inner_bottom').addClass('on');

    $('#header').addClass('on');
  });

  $('#header').on('mouseleave', function () {
    $('#header .inner_bottom').removeClass('on');
    $('#header').removeClass('on');
  });

  $('#header .header_icon_wrap .menu_btn').on('click', function () {
    $('#header .inner_bottom').addClass('on');
    $('#header .m_gnb_wrap').toggleClass('on');
    $('#header').addClass('on');
  });

  $('#header .m_gnb_wrap .close_btn').on('click', function () {
    $('#header .m_gnb_wrap').toggleClass('on');
  });

  // lang_BTN 동작
  $('#header .lang_btn').on('click', function () {
    $('#header .lang_box').toggleClass('on');
  });
  // lang_BTN 동작

  $('#footer .family_btn').on('click', function (event) {
    event.preventDefault();
    $('#footer .family_wrap').toggleClass('on');
  });

  $('#footer .lang_btn').on('click', function (event) {
    event.preventDefault();
    $('#footer .family_wrap').toggleClass('on');
  });

  // 모바일 아코디언 메뉴
  // 그룹 요소는 jQuery를 사용하여 선택
  $('#header .m_gnb > li > a').on('click', function (e) {
    e.preventDefault(); // a 태그의 기본 이벤트 차단

    // 현재 클릭된 a 태그의 부모인 li 요소
    var $li = $(this).parent();

    // 현재 클릭된 li 요소에 'on' 클래스 토글
    $li.toggleClass('on');

    // 현재 클릭된 li 요소의 형제 요소에서 'on' 클래스 제거
    $li.siblings().removeClass('on');
  });

  // aos 초기화
  AOS.init({
    duration: 500,
    // 한번만 실행
    // once: true,
  });

  // 활성화된 li를 제외한 나머지 li 항목들의 스타일 조절 함수
  function adjustOtherItems() {
    const activeIndex = $('.horizontal_slider > li').index(
      $('.horizontal_slider > li.on')
    );

    $('.horizontal_slider > li').each(function (index, li) {
      if (index !== activeIndex) {
        $(li).addClass('default'); // 활성화된 li를 제외한 나머지 li에 default 클래스 추가
      } else {
        $(li).removeClass('default'); // 활성화된 li에는 default 클래스 제거
      }
    });
  }

  $('.horizontal_slider > li')
    .on('mouseenter', function () {
      if (window.innerWidth >= 768) {
        $(this).addClass('on');
        adjustOtherItems(); // 다른 li의 스타일 조절 함수 호출
      }
    })
    .on('mouseleave', function () {
      $(this).removeClass('on');
      $('.horizontal_slider > li').removeClass('default'); // 모든 li에서 default 클래스 제
    });

  // 지속가능 경영
  let mainManage = new Swiper('.main_manage .swiper', {
    slidesPerView: 'auto',
    spaceBetween: 50,
    loop: true,
    centeredSlides: true,
    // autoplay: {
    //   delay: 3000,
    //   disableOnInteraction: false,
    // },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
      bulletClass: 'swiper-pagination-bullet',
      bulletActiveClass: 'swiper-pagination-bullet-active',
    },
    breakpoints: {
      // // 테블릿
      // 768: {
      //   slidesPerView: 2,
      //   spaceBetween: 30,
      // },
      // // 데스크탑
      // 1201: {
      //   slidesPerView: 3,
      //   spaceBetween: 40,
      // },
    },
  });
});
