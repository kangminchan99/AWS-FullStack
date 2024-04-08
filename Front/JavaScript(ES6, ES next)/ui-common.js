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

  // 이벤트 전파: 하위 요소에서 바깥쪽으로 이벤트가 전파(버블링)
  document.querySelector('.box_wrap').addEventListener('click', function () {
    console.log('바깥쪽 요소 클릭 이벤트 발생');
  });

  document.querySelector('.box').addEventListener('click', function (event) {
    console.log('안쪽 요소 클릭 이벤트 발생');
    // 상위 이벤트 전파 막기
    // event.stopPropagation();
  });

  document.querySelector('.box a').addEventListener('click', function (event) {
    console.log('안쪽 a 요소 클릭 이벤트 발생');
    // a태그 기본이벤트 막기
    event.preventDefault();
    // // 상위 이벤트 전파 막기
    event.stopPropagation();
    // 동일 요소의 동일 이벤트 막기
    event.stopImmediatePropagation();
  });

  document.querySelector('.box a').addEventListener('click', function (event) {
    console.log('a영역 클릭이벤트2');
  });

  // 5번 클릭 후 이벤트 삭제하기
  let cnt = 0;
  const removeBtn = document.querySelector('.remove_btn');
  // 이벤트 삭제 시 함수명이 필요하므로 이벤트 핸들러를 기명함수로 생성 후 사용
  function handleClick() {
    cnt++;
    removeBtn.innerHTML = cnt;

    if (cnt === 5) {
      this.removeEventListener('click', handleClick);
    }
  }
  removeBtn.addEventListener('click', handleClick);
});
