$(function () {
  let faviconIdx = 1;
  // 한번만 선택후 사용, 타이머함수에서 선택하면 매시간 요소를 계속 탐색하므로
  const faviconEl = $('#favicon');

  setInterval(() => {
    // faviconIdx++;

    // if (faviconIdx === 8) {
    //   faviconIdx = 1;
    // }
    faviconIdx = faviconIdx === 7 ? 1 : faviconIdx + 1;
    faviconEl.attr('href', `images/favicon/favicon_logo_0${faviconIdx}.ico`);
  }, 100);

  // live슬라이더
  let mainLive = new Swiper('.main_live .swiper', {
    // 모바일
    slidesPerView: 'auto',
    spaceBetween: 20,
    pagination: {
      el: '.swiper-pagination',
    },
    breakpoints: {
      // 테블릿
      768: {
        slidesPerView: 2,
        spaceBetween: 30,
      },
      // 데스크탑
      1201: {
        slidesPerView: 3,
        spaceBetween: 40,
      },
    },
  });
});
