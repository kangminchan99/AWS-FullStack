$(function () {
  let mainProduct = new Swiper('.main_product .swiper', {
    slidesPerView: 3,
    spaceBetween: 8,
    grid: {
      rows: 2,
    },
    breakpoints: {
      // when window width is >= 640px
      768: {
        slidesPerView: 6,
        spaceBetween: 18,
        grid: {
          rows: 1,
        },
      },
    },
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });

  // 모바일에서 swiper의 높이 가변처리
  $(window)
    .on('resize', function () {
      if ($(this).outerWidth() <= 767) {
        let h = $('.main_product .swiper-slide').outerHeight() * 2 + 110;
        $('.main_product .swiper').outerHeight(h);
      } else {
        $('.main_product .swiper').outerHeight('auto');
      }
    })
    .trigger('resize');
});
