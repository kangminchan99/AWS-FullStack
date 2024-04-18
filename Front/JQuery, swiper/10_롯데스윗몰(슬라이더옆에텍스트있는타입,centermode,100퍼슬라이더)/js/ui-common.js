$(function () {
  // 메인 신상
  let mainNew = new Swiper('.main_new .swiper', {
    // css로 크기지정시 auto
    slidesPerView: 'auto',
    spaceBetween: 30,
    scrollbar: {
      el: '.swiper-scrollbar',
    },
  });

  // 메인 인기상품
  let mainPopular = new Swiper('.main_popular .swiper', {
    slidesPerView: 'auto',
    spaceBetween: 50,
    // active슬라이드 가운데 배치
    centeredSlides: true,
    autoplay: {
      delay: 3000,
      disableOnInteraction: false,
    },
    scrollbar: {
      el: '.swiper-scrollbar',
    },
  });

  // 시작시 슬라이드 이동, slideTo(슬라이드 인덱스, 시간)
  // 시간이 0일때 자동재생안되는 버그있으므로 1
  mainPopular.slideTo(3, 1);
});
