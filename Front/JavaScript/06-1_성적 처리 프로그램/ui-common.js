// 윈도우객체를 통해 이벤트 연결 DOM(html)이 로딩되면 이벤트 핸들러 함수가 실행됨
// 이벤트 핸들러 함수는 화살표 함수 대신 익명함수 사용
// 화살표 함수 사용 시 this가 가르키는 대상이 달라지므로
window.addEventListener('DOMContentLoaded', function () {
  // getScore() ()는 호출연산자이고 이름 그대로 함수를 호출(실행)하는 역할 즉 실행 후 결과 가 나오고.
  // getScore이라고 쓰면 함수 그자체를 말한다 즉 함수가 들어가야 하는 위치에서는 ()를 빼고 넣는다.
  function getScore() {
    // id 요소 선택(탐색 속도가 좀 더 빠름),
    let kor = parseInt(document.getElementById('score1').value);
    let eng = parseInt(document.getElementById('score2').value);
    let mat = parseInt(document.getElementById('score3').value);
    let msg = '국어 점수:';
    let msg1 = '영어 점수:';
    let msg2 = '수학 점수:';
    let avg = '평균 점수(반올림):';
    let success = '합격 여부:';

    msg += kor;
    msg1 += eng;
    msg2 += mat;
    sumAvg = Math.round((kor + eng + mat) / 3).toFixed(2);
    avg += sumAvg;

    if (sumAvg >= 60) {
      success += '합격';
    } else {
      success += '실패';
    }

    // 입력값이 문자나 빈값일 경우 경고창 반환
    if (isNaN(kor) || isNaN(eng) || isNaN(mat)) {
      alert('fail type');
    } else {
      document.querySelector('.main_score .message').innerHTML =
        msg + '<br>' + msg1 + '<br>' + msg2 + '<br>' + avg + '<br>' + success;
    }
  }
  // querySelector는 클래스에 사용
  // 함수명을 이벤트 핸들러로 전달하여 실행
  document
    .querySelector('.main_score .result_btn')
    .addEventListener('click', getScore);
});
