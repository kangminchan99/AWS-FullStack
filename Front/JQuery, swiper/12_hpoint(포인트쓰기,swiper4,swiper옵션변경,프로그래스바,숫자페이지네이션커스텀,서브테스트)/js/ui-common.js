$(function () {
  function changeSwiperOpt() {
    // 요소 존재 여부 판단하여 없으면 함수 실행을 종료한다.
    if (!$('.main_use').length) return;

    // swiper인스턴스가 들어갈 변수
    let mainUse = null;
    let check = true;
    $(window)
      .on('resize', function () {
        let w = $(this).outerWidth();

        if (w >= 768) {
          check = false;
          // swiper인스턴스가 있으면 이전 swiper 인스턴스 삭제하고 스타일 제거
          if (mainUse) mainUse.destroy(true, true);

          mainUse = new Swiper('.main_use .swiper-container', {
            slidesPerView: 3,
            spaceBetween: 24,
            allowTouchMove: false,
            pagination: {
              el: '.swiper-pagination',
            },
          });
        } else {
          if (mainUse) mainUse.destroy(true, true);

          // swiper 10에서 centeredSlides, loop일 경우 슬라이드가 채워지지않는 현상이 나타나므로
          // 슬라이드 갯수를 *2 또는 *3으로 복사해야함
          mainUse = new Swiper('.main_use .swiper-container', {
            slidesPerView: 'auto',
            spaceBetween: 10,
            centeredSlides: true,
            loop: true,
            autoplay: {
              delay: 3000,
              disableOnInteraction: false,
            },
            pagination: {
              el: '.swiper-pagination',
              type: 'progressbar',
            },
          });

          // 슬라이드 복사갯수만큼 나머지연산자 사용
          mainUse.on('slideChange', function () {
            let current = mainUse.realIndex + 1;
            $('.main_use .current').text(current);
          });

          // 복사한 슬라이드를 제외한 원본 슬라이드 갯수
          let total = $(
            '.main_use .swiper-slide:not(.swiper-slide-duplicate )'
          ).length;
          $('.main_use .total').text(total);

          if (check === false) {
            mainUse.autoplay.stop();
            check = true;
          }
          // 자동 재생 토글
          $('.main_use .autoplay_btn').on('click', function () {
            $(this).toggleClass('on');

            if (check) {
              mainUse.autoplay.stop();
              check = false;
            } else {
              mainUse.autoplay.start();
              check = true;
            }
          });
        }

        if (!check) {
          mainUse.autoplay.stop();
        }
      })
      .trigger('resize');
  }
  changeSwiperOpt();
});
