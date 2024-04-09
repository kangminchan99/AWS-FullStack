$(function () {
  // $('.gnb>li:eq(0)').css({
  //   border: '2px solid red',
  //   'font-size': '30px',
  // });

  // 홀수번째 요소 선택
  // $('.gnb>li:even').css({
  //   border: '2px solid red',
  //   'font-size': '30px',
  // });

  // 첫번째 제외한 나머지 li선택
  // $('.gnb>li:gt(0)').css({
  //   border: '2px solid red',
  //   'font-size': '30px',
  // });

  // $('.gnb>li:lt(3)').css('border', '5px solid red');

  // eq메서드 사용하여 n번째 요소 선택
  let idx = 2;

  // $('.gnb>li:eq(' + idx + ')').css('border', '5px solid pink');
  $('.gnb>li').eq(idx).css('border', '5px solid pink');
});
