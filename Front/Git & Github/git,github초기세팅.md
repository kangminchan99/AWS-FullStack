# git, github 초기세팅

## git 초기세팅

- 깃설치 https://git-scm.com/download/win 64bit버전 설치
- use visual studio code as git's default editor 깃 기본에디터 변경
- **기본 브랜치명 main으로 변경(깃헙 기본 브랜치가 main이므로)**
- git -v, git-test 폴더생성후 터미널에서 git 설치확인
- **git config --global core.autocrlf true**, 윈도우와 맥의 줄바꿈문자열이 달라 나오는 LF -> CRLF 경고 방지
- git config --global core.safecrlf false, LF -> CRLF 경고 계속 뜨는경우(편집기때문)
- git config --global init.defaultBranch main, git 기본브랜치 master인 경우 main으로 변경
- **github 회원가입**

### 사용자이름, 이메일 설정/확인

- git config --global user.email "[dalhoya@naver.com](mailto:dalhoya@naver.com)"

- git config --global user.name "ossamuiux"

- git config --global user.email

- git config --global user.name

### 커밋템플릿작성 및 연결

- ni ~/.gitmessage.txt, c:\Users\윈도우사용자계정에 파일생성후 vscode로 열고 커밋샘플메세지 복붙

```textile
################
# 타입: 제목 #이슈번호 형식으로 제목을 아래 공백줄에 작성
# 제목은 50자 이내 / 변경사항이 "무엇"인지 명확히 작성 / 끝에 마침표 금지
# 예) feat: 로그인 UI 적용 #이슈번호, feat: nextjs14 프로젝트 시작 #이슈번호, feat: 메인 UI 적용 #이슈번호

# 바로 아래 공백은 지우지 마세요 (제목과 본문의 분리를 위함)

################
# 본문(구체적인 내용)을 아랫줄에 작성
# 여러 줄의 메시지를 작성할 땐 "-"로 구분 (한 줄은 72자 이내)

################
# feat: 새로운 기능 추가
# fix: 버그 수정
# docs: 문서 수정
# test: 테스트 코드 추가
# refact: 코드 리팩토링
# style: 코드 의미에 영향을 주지 않는 변경사항
# chore: 빌드 부분 혹은 패키지 매니저 수정사항
################
```

- git config --global commit.template ~/.gitmessage.txt 커밋템플릿연결

---

## github 초기세팅

- 프로젝트명 기반으로 원격레포지토리(보관소) 만들기: github > 홈 > new
  
  ex. git-test, nextjs14-car-showcase, react-todo, react-movie-search

### 이슈 템플릿 설정

- 깃헙 > settings > Features - Issues, Set up templates 이슈템플릿 설정

- Add template - Custom template - Preview and edit

- Template name: 이슈 템플릿, About: 작업이슈 만들때 사용

- Template content: #개요 ##요구사항

- Propose changes - commit 메세지: update issue templates

- commit하면 .github/ISSUE_TEMPLATE 폴더 생성

- 이슈 생성시 Assignees(관련 팀원), Labels(이슈종류), Projects 를 설정

### PR(풀리퀘스트) 깃헙 세팅

- 동일 레포지토리에서 다른 팀원과 협업시 push후 PR을 통해 기본브랜치에 머지하고 다른 팀원들이 작업전 pull 하여 변경된 사항을 가져오게함

- 깃헙 > settings > general > pull prequests
  Automatically delete head branches 체크, pr승인후 main브랜치에 머지되면 브랜치 자동삭제

- 깃헙 > settings > branches > branch protection rule(브랜치보호규칙적용) 
  Require a pull request before merging, main에 머지하기전 PR 필요
  Require approvals, PR 승인 필요

---

## git graph, vscode 익스텐션

- vscode 하단 왼쪽 상태바 git graph 클릭하여 커밋 히스토리보기
- 커밋히스토리 마우스오른쪽으로 깃명령 사용가능
- git graph설치후 깃인식 안되면 소스컨트롤탭에서 manege버튼 클릭후 커밋

---

## git 기본 명령어

- git add . 또는 파일명, 스테이지에 추가

- git remote add origin 원격저장소주소, 원격저장소 연결

- git reset HEAD^, 최근 커밋 되돌리기, 스테이징 취소

- git restore --staged . 또는 파일명, 스테이징 취소

- git status 작업디렉토리 변경내용, 수정사항 확인

- git diff 변경코드확인

- git branch 브랜치명, 브랜치만들기

- git branch -d 브랜치명, 머지된 브랜치 삭제

- git branch -D 브랜치명, 머지안된 브랜치 강제삭제

- git switch 브랜치명, 브랜치이동

- git switch -c feature/main-ui 브랜치만들고 이동

- git branch 로컬브랜치확인

- git branch -a 로컬, 원격브랜치확인

- 로컬브랜치삭제: git switch main로 이동후 git branch -d 브랜치명

- 원격브랜치삭제: git push origin -d feature/main-ui

- git revert HEAD(해당브랜치 마지막 커밋) 원격에 올린 잘못된 커밋을 이력남기고 되돌리기

- git config --list 깃 설정 확인

## 기타

- 터미널에서 프롬프트로 나가기 ctrl + c

- vscode 터미널에서 프롬프트로 나가기 안될경우(터미널에 내용이 다 안보일경우 가끔나타남) q
