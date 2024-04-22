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

  $('#footer .family_btn').on('click', function (event) {
    event.preventDefault();
    $('#footer .family_wrap').toggleClass('on');
  });

  $('#footer .lang_btn').on('click', function (event) {
    event.preventDefault();
    $('#footer .family_wrap').toggleClass('on');
  });
});
