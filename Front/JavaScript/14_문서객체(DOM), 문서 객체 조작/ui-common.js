window.addEventListener('DOMContentLoaded', function () {
  const tit = document.createElement('h1');
  tit.textContent = '문서 객체 동적으로 생성';
  tit.setAttribute('class', 'tit');

  // #wrap 안쪽 기존 요소 앞에 추가
  document.querySelector('#wrap').prepend(tit);
  console.log(tit);
});
