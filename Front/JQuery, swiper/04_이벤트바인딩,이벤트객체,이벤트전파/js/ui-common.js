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
  console.log($('#header .btn').outerWidth());
  console.log($('#header .btn').innerWidth());
  console.log($('#header .btn').width());

  // 키보드 이벤트(keydown: 키를 입력한 순간, keyup: 키를 누르고 뗐을 때, 주로 사용)
  // 제이쿼리 메서드는 get, set 기능을 가지고 있음
  $('#header .search').on('keyup', function (event) {
    // setter(): 값을 변경해준다.
    // $(this).val('안녕하세요');

    // getter(): 값을 가져온다.
    console.log($(this).val());

    // enter key 확인
    console.log(event.key);
    if (event.key === 'Enter') {
      console.log('push enter');
    }
  });

  // 포커스 서치 텍스트 필드로 강제 이동
  $('header .search').trigger('focus');

  $(document).on('mousemove', function (event) {
    // clientXY = (뷰포트)브라우저 화면 상에서의 마우스 위치값을 나타내 준다
    // console.log(event.clientX, event.clientY);

    // html문서에서의 좌표값
    console.log(event.pageX, event.pageY);
  });
});
