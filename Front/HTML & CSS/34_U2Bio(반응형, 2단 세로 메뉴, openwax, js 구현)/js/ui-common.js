// 처음 들어왔을 때 스크롤 위치를 계산한다.
window.addEventListener('DOMContentLoaded', function () {
  const header = document.querySelector('#header');
  // header fix
  window.addEventListener('scroll', function () {
    // 세로 스크롤바의 위치값
    let _scrollY = window.scrollY;

    if (_scrollY > 0) {
      header.classList.add('fixed');
    } else {
      header.classList.remove('fixed');
    }
  });
  // 언어메뉴
  document
    .querySelector('#header .lang_btn')
    .addEventListener('click', function () {
      document.querySelector('#header .lang_wrap').classList.toggle('on');
    });

  // 화살표 함수의 this는 함수 생성 시점에서 바깥 부모 함수의 this와 일치함
  // document.querySelector('#header .lang_btn').addEventListener('click', () => {
  //   console.log(this);
  //   this.classList.toggle('on');
  // });

  // 모바일 메뉴
  // 이벤트 핸들러 안에서 this는 이벤트가 연결된 요소를 의미
  document
    .querySelector('#header .open_btn')
    .addEventListener('click', function () {
      // body 스크롤바 안보이게 ios 사파리는 안됨
      document.body.classList.toggle('on');
      this.classList.toggle('on');
      document.querySelector('#header .m_gnb_wrap').classList.toggle('on');
      header.classList.toggle('on');
    });

  // 모바일 아코디언 메뉴
  // 그룹 요소는 querySelectorAll사용하며 배열로 리턴됨
  const mGnb = document.querySelectorAll('#header .m_gnb>li>a');

  // js 형제요소 선택
  function siblings(t) {
    // t가 파라미터로 들어오면 그거에 대한 부모요소의 자식요소선택(.m_gnb>li)
    const children = t.parentElement.children;
    const tempArr = [];

    // children이 html컬렉션 유사배열이므로 for문으로 반복하여 임시 배열에 넣어준다.
    for (let i = 0; i < children.length; i++) {
      tempArr.push(children[i]);
    }

    // 임시 배열안의 형제 요소중 타겟요소와 같지 않은 요소들로 새로운 배열 리턴
    return tempArr.filter((v) => {
      return v !== t;
    });
  }

  console.log(siblings(document.querySelector('#header .m_gnb>li')));

  // 버튼 클릭 마다 다른거 연결
  // 반복문 내에서 배열이나 리스트 값을 변경하거나 추가할 수 없다. + 비동기임
  // a들을 배열로 선택 후 반복문을 통해 이벤트 연결
  mGnb.forEach((v) => {
    v.addEventListener('click', function (e) {
      e.preventDefault();
      // parentElement사용 시 this의 부모로 바뀐다
      // console.log(this.parentElement);
      // a의 부모 li에 클래스 토글
      this.parentElement.classList.toggle('on');
      // a의 부모 li의 형제 li의 on 클래스 제거
      siblings(this.parentElement).forEach((v) => {
        v.classList.remove('on');
      });
    });
  });

  // 클릭 시 요소의 문서에서의 위치만큼 스크롤 해야함
  document
    .querySelector('.main_slider .scroll_down')
    .addEventListener('click', function (event) {
      // 메인 슬라이더 스크롤 다운 막기 preventDefault
      event.preventDefault();
      console.log(document.querySelector('.main_business').offsetTop);
    });
});
