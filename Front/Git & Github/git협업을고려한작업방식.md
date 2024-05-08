# git작업방식요약

- 깃헙 레포지토리 생성후 이슈템플릿 추가

- 깃헙 > settings > general > pull prequests
  Automatically delete head branches 체크, pr승인후 main브랜치에 머지되면 브랜치 자동삭제

- 깃헙 > settings > branches > branch protection rule(브랜치보호규칙적용) 
  Require a pull request before merging, main에 머지하기전 PR 필요
  Require approvals, PR 승인 필요

---

- git init(nextjs는 git 초기화되어있으므로 패스), 작업폴더에 로컬저장소 생성

- git remote add origin 원격저장소주소, 원격저장소 연결

- git pull origin main, 원격에 변경사항이 있으므로 원격저장소 기본브랜치 내용 가져와 로컬저장소에 동기화

- refusing to merge unrelated histories 뜨면
  
  ```bash
  git pull --allow-unrelated-histories origin main
  ```
  
  원인: 로컬에 git초기화후 원격저장소에 이슈템플릿 추가로 커밋이력 생기면 로컬에 커밋이력이 없으므로 발생함
  
  [git push/pull 할때 fatal: refusing to merge unrelated histories 문제 해결](https://www.lesstif.com/gitbook/git-push-pull-fatal-refusing-to-merge-unrelated-histories-86311254.html)

- git switch -c feature/main-ui, 새로운 작업시 기능관련 브랜치 생성/이동후 작업

## 작업완료후 커밋시작시

- 깃헙에 이슈템플릿으로 이슈추가
- git add . 작업완료후 변경사항 스테이징
- git commit 로컬저장소에 이슈번호붙여서 커밋
- git push -u origin feature/main-ui, -u는 upstream 원격저장소에 첫 push하면 깃헙에 pr버튼 나옴
- 첫 push이후부터 git push만 입력하면 해당 브랜치에 push
- 깃헙에 PR버튼클릭후 내용에 resolve: #이슈번호 넣으면 머지된후 해당이슈 자동으로 close됨, 자신의 PR은 승인을 못하므로 하단 체크후 강제 머지
- 로컬에서 git switch main으로 이동후 git merge feature/main-ui하여 기능브랜치의 내용을 main에 병합
- git branch -d 브랜치명, 작업완료된 브랜치 삭제

## PR버튼 활성화 안되는 경우

- 동일브랜치에서 커밋할 경우 깃헙에서 PR버튼 활성화 안되며 수동으로 merge해야함

- 깃헛 > Pull requests > New pull request > 하단 브랜치명 클릭 > create pull request

- 브랜치명이 다를 경우 PR버튼이 활성화됨

## 로컬에서 브랜치 먼저 만들경우

- git init

- git add .

- git commit 첫 커밋하면 main브랜치 생성

- git remote add origin 원격주소

- git push -u origin main하면 원격과 커밋이력이 다르다는 에러뜸

- git pull --allow-unrelated-histories origin main 관련없는 커밋이력 가져오기 허용
