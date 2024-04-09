$(function () {
  // 선택자가 동일한 경우 메서드 체인 가능
  // 요소의 높이를 조작하는 경우 css max-height 사용해야 부드럽게 처리가 되므로 그거 사용하자
  $('.gnb>li')
    .on('mouseenter', function () {
      $(this).find('.depth2').stop().slideDown();
    })
    .on('mouseleave', function () {
      $(this).find('.depth2').stop().slideUp();
    });

  // 5번 클릭 후 이벤트 삭제하기 (off)
  let cnt = 0;

  $('#header .btn').on('click', function () {
    cnt++;
    $(this).text(cnt);

    if (cnt === 5) {
      $('header .btn').off('click');
    }
  });

  // 스크롤 이벤트는 처음에 실행되지 않으므로 .trigger로 처음 한번 실행해야 함
  $(window)
    .on('scroll', function () {
      let st = $(this).scrollTop();
      // console.log(st);
    })
    .trigger('scroll');

  // $(window).outerWidth() : 스크롤 바 포함한 가로길이
  // $(window)).outerWidth() : 스크롤 바 제외한 가로 길이
  $(window)
    .on('resize', function () {
      let winW = $(this).outerWidth();
      // let winW = $(this).innerWidth();
      // console.log(winW);
    })
    .trigger('resize');

  // outerWidth() : 선, 패딩을 포함한 크기 (일반적으로 사용)
  // innerWidth() : 선을 제외한 크기
  // width: 선, 패딩을 제외한 크기
  console.log($('#header .btn').width());
});
