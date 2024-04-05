window.addEventListener('DOMContentLoaded', function () {
  // 고전 이벤트: 이벤트 삭제 등 추가기능이 없으므로 사용 금지
  // document.querySelector('.test_btn').onclick = function () {
  //   console.log('click');
  // };

  // 마우스 이벤트
  document
    .querySelector('.test_btn')
    .addEventListener('mouseenter', function () {
      this.innerHTML = '마우스 올라감';
    });

  document
    .querySelector('.test_btn')
    .addEventListener('mouseleave', function () {
      this.innerHTML = '마우스 떠남';
    });
});
