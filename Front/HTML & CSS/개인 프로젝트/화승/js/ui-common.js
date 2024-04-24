$(function () {
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
  });

  $('#header .m_gnb_wrap .close_btn').on('click', function () {
    $('#header .m_gnb_wrap').toggleClass('on');
  });

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
});
