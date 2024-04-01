## 게시판 공통클래스

- .board_list(게시판 리스트)
- .board_view(게시판 보기)
- .board_write(게시판 작성)
- .board_modify(게시판 수정)
- .fee_tbl(요금표 공통)

# html table

- table태그 아래`<caption>테이블에 대한 설명입력</caption>`넣고 블라인드처리
  
  ex. `<caption>영업보고서 테이블: 번호, 보고서명, 등록일</caption>`

- `<thead>`제목행, `<tbody>`는 생략가능하며 자동생성됨

- `<tr>`행에 제목셀은 `<th>`, 내용셀은 `<td>`

- table상단선은 table을 감싼 div에 주기(익스버그있음)

- 상단 제목셀 선택시 thead th로 선택자사용
  (th는 아래쪽 행에 들어갈 수도 있기때문)

- `<thead>`안에는 th만 사용가능, 제목셀이 테이블 왼쪽아래로 있을경우 `<thead>` 넣지않음

- 마지막 행의 하단 선처리시 `tr:last-child td` 사용

- th는 가로가운데정렬, bold이며 td는 왼쪽정렬이 기본값

- 칸에서 정렬은 text-align, vertical-align 사용

- 칸의 정렬을 다르게 할경우 td.td_left식으로 칸마다 클래스 걸어서 처리

- table 칸의 크기는 데이터(내용)에 따라 자동으로 늘어나며 원치않을경우
  `table {table-layout: fixed;}` 사용

- 칸의 가로길이는 각 칸에 클래스를 걸어 처리(.col01, .col02, .col03)

- th의 유효범위(scope)지정
  열에 대한 제목이면 `scope="col"`, 행에대한 제목이면 `scope="row"`

- 높이를 지정해도 데이터가 많으면 자동으로 늘어남

- 칸의 높이지정시 height 또는 padding사용하며 행의 높이가 모두 같을 경우 height 사용, 행 높이가 다를경우 padding사용

- 게시물링크 말줄임시 max-width로 글자길이만큼지정
