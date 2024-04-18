$(function () {
  $('#header .gnb>li>a').on('mouseenter', function () {
    $('#header .inner_bottom').addClass('on');
  });
  $('#header').on('mouseleave', function () {
    $('#header .inner_bottom').removeClass('on');
  });

  $('#header .header_icon_wrap .menu_btn').on('click', function () {
    $('#header .inner_bottom').addClass('on');
  });
});
