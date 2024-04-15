$(function () {
  $('.gnb')
    .on('mouseenter', function () {
      $('#header').addClass('on');
    })
    .on('mouseleave', function () {
      $('#header').removeClass('on');
    });

  // 메인슬라이더
  let mainSlider = new Swiper('.main_slider .swiper', {
    loop: true,
    // 슬라이드 이동 속도
    speed: 1000,
    // 마우스드래그, 모바일 swipe 끄기
    allowTouchMove: false,
    autoplay: {
      delay: 4000,
      // 슬라이더 내부 인터렉션발생시 자동재생 안멈추게
      disableOnInteraction: false,
    },
    pagination: {
      // 페이지네이션 클릭으로 이동
      clickable: true,
      el: '.swiper-pagination',
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });

  // 자동재생 토글
  $('.main_slider .autoplay_btn').on('click', function () {
    $(this).toggleClass('on');

    if ($(this).hasClass('on')) {
      // swiper10버전에선 autoplay속성명 사용해야함
      mainSlider.autoplay.stop();
    } else {
      mainSlider.autoplay.start();
    }
  });

  // 서브웨이메뉴
  $('.main_menu .menu_tab li').on('click', function (e) {
    // a기본이벤트 막기
    e.preventDefault();
    $(this).addClass('active').siblings().removeClass('active');

    // 그룹요소중 클릭한 요소의 순서값
    let idx = $(this).index();

    // 클릭된 요소의 순서값과 일치(eq(idx))하는 B그룹요소 선택
    $('.main_menu .menu_slider')
      .eq(idx)
      .addClass('active')
      .siblings()
      .removeClass('active');
  });

  // 메인슬라이더
  let menuSlider = new Swiper('.menu_slider .swiper', {
    slidesPerView: 4,
    spaceBetween: 30,
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });
});
