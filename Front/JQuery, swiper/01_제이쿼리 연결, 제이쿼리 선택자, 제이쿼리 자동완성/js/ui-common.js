// ready가 js DOMContentLoaded 이벤트므로 사용 x
// ready 축약형으로 사용
$(function () {
  $('#header').css('border', '10px solid red');
  // 요소 선택 시 유사 배열 형태로 선택됨
  console.log($('.gnb > li').length);

  $('#header .logo').css('border', '3px solid pink');

  $('.gnb>li:nth-child(2)').css('border', '3px solid black');
});
