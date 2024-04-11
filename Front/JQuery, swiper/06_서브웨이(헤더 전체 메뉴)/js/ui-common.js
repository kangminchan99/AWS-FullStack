// DOMContentLoaded는(js) window또는 document에 사용가능
// window.addEventListener('DOMContentLoaded', function(){

// })
//  == (같은거)

// $(document).ready(function(){

// })

// == (같은거)
// ready의 축약형
$(function () {
  // // 클릭 시 마다 텍스트 변경하기
  // let toggleTxt = true;
  // // .btn에 클릭 이벤트 걸고 콘솔로 확인
  // $('#header .btn').on('click', function () {
  //   // console.log('click');

  //   // toggleClass: on, off 번갈아가며 작동함
  //   $(this).toggleClass('on');

  //   if (toggleTxt) {
  //     $(this).text('btn2');
  //     toggleTxt = false;
  //   } else {
  //     $(this).text('btn');
  //     toggleTxt = true;
  //   }
  // });

  // 요소에 클래스가 동적으로 걸리는 경우 hasClass()로 조건처리가능
  $('#header .btn').on('click', function () {
    $(this).toggleClass('on');
    console.log($(this).hasClass('on'));

    if ($(this).hasClass('on')) {
      $(this).text('btn2');
    } else {
      $(this).text('btn');
    }
  });

  // $('.gnb>li').on('mouseenter', function () {
  //   // 높이를 늘려줌
  //   $(this).find('.depth2').stop().slideDown();
  // });

  // $('.gnb>li').on('mouseleave', function () {
  //   $(this).find('.depth2').stop().slideUp();
  // });

  // 스크롤 시 탑버튼이 서서히 보이게(fade in)
  $(window).on('scroll', function () {
    if ($(this).scrollTop() >= 100) {
      $('#footer .top_btn').fadeIn(800, function () {
        $(this).css('background', 'red');
      });
    } else {
      $('#footer .top_btn').fadeOut(800);
    }
  });

  // 언어메뉴 코글
  $('#header .lang_btn').on('click', function () {
    // $(this).next().show();
    $(this).next().toggle();
  });

  $('#header .move_btn').on('click', function () {
    $(this).animate({ 'margin-left': 100 }, 1000, 'easeOutBounce');
  });
});
