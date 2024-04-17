$(function () {
  let mainSlider = new Swiper('.main_slider .swiper', {
    loop: true,
    speed: 2000,
    effect: 'fade',
    autoplay: {
      delay: 3000,
      disableOnInteraction: false,
    },
    pagination: {
      el: '.swiper-pagination',
      // 숫자타입
      type: 'fraction',
      formatFractionCurrent: function (number) {
        return number < 10 ? '0' + number : number;
      },
      formatFractionTotal: function (number) {
        return number < 10 ? '0' + number : number;
      },
      renderFraction: function (currentClass, totalClass) {
        return (
          // prettier-ignore
          '<span class="' + currentClass + '"></span><span class="' + totalClass + '"></span>'
        );
      },
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });

  // 메인슬라이더 자동재생 토글
  let autoplay = true;

  $('.main_slider .autoplay_btn').on('click', function () {
    if (autoplay) {
      $(this).find('span').text('PLAY');
      $(this).find('i').attr('class', 'ri-play-fill');
      mainSlider.autoplay.stop();
    } else {
      $(this).find('span').text('STOP');
      $(this).find('i').attr('class', 'ri-pause-fill');
      mainSlider.autoplay.start();
    }
    autoplay = !autoplay;
  });
});
