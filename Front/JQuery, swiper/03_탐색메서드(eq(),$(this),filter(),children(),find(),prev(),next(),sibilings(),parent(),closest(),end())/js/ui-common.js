$(function () {
  $('.gnb>li').on('click', function () {
    // this는 js DOM이므로 제이쿼리 메서드 사용 불가
    // js DOM을 제이쿼리 객체로 변환
    console.log($(this));

    // 이벤트 발생 대상
    // $(this).css('background', gray);
    // 자식요소, 제이쿼리객체를 리턴하므로 메서드 체인이 가능
    // $(this).children().css('background', 'gray');
    // 하위요소선택
    // $(this).find('>a').css('background', 'gray');

    // 이전 형제 선택
    // $(this).prev().css('background', 'gray');

    // 이전 형제 모두 선택
    // $(this).prevAll().css('background', 'gray');

    // 다음형제
    // $(this).next().css('background', 'gray');

    // 다음 형제 모두
    // $(this).nextAll().css('background', 'gray');

    // 자신을 제외한 형제요소 선택
    // $(this).siblings().css('background', 'gray');

    // 부모 선택
    // $(this).parent().css('background', 'gray');

    // 조상 선택
    // $(this).closest('#header .inner').css('background', 'gray');

    // 기존 선택된 요소에서 재선택하기
    // $('.gnb>li')
    //   .css('background', 'gray')
    //   .filter(':nth-child(1)')
    //   .css('border', '2px solid red');

    // end(): 여러 요소를 연속으로 선택 후 이전 선택된 요소로 돌아갈 때 사용d
    $(this)
      .css('background', 'gray')
      .find('>a')
      .text('hihihihi')
      .end()
      .css('border', '10px solid pink');
  });
});
