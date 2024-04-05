// 정규표현식 - 폼요소의 유효성검증시 주로 사용, /정규식/옵션(flag)
function isMobile() {
  return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(
    navigator.userAgent
  );
}

// dom이 로딩되면 콜백함수 실행
window.addEventListener('DOMContentLoaded', function () {
  if (isMobile()) {
    document.querySelector('.txt').innerHTML = '모바일 브라우저';
  } else {
    document.querySelector('.txt').innerHTML = 'PC 브라우저';
  }

  console.log('dom로딩 완료');

  // 이미지가 로딩된 후 제어해야할 경우
  window.addEventListener('load', function () {
    console.log('이미지등의 리소스 로딩 완료');
  });

  // resize이벤트는 창크기 조절 시 발생하며 처음엔 실행되지 않으므로 함수를 이용하여 처음에도 실행되도록 함
  function checkWidth() {
    console.log(this.outerWidth, 'width');
  }
  checkWidth();
  window.addEventListener('resize', checkWidth);

  function checkScroll() {
    console.log(this.scrollY);
  }

  checkScroll();
  window.addEventListener('scroll', checkScroll);
});
