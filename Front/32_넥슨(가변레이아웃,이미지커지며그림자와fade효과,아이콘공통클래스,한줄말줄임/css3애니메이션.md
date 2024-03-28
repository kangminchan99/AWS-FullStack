# 단일애니메이션(transition, transform)

## transition

- :hover시 한번만 동작할 경우

- transition:all 또는 개별속성명 1s [지연시간] [ease]

- ease: 처음과 끝이 느리고 중간이 빠름, 주로사용

- ease-in(가속): 처음은 느리고 끝에서 빨라짐
  ex. 우주선이 밖으로 나갈때

- ease-out(감속): 처음은 빠르고 끝에서 느려짐
  ex. 화면밖에서 안으로 들어올때

- ease-in-out: ease와 같지만 중간속도가 ease보다 부드러움
  ex. 반복애니메이션에 사용

- steps(5)
  ex. 타이핑 애니메이션에 사용

- cubic-bezier(1,0,0,1) /* easeInOutExpo*/
  ex. 특수한 움직임(스프링, 다이나믹한움직임)이 필요한 경우 사용, 크롬개발자모드로 커스텀, https://easings.co/ 이용

- linear(등속도): 속도변화가 없이 일정함
* 데스크탑은 고정크기이므로 all사용해도되지만 모바일, 반응형은 all 사용시 크기도 애니메이션이 되버리므로 레이아웃에는 개별속성명 사용이 좋음

* :hover를 움직이는 요소에 걸지말것

* transition은 처음에 미리 걸어야하며 :hover에 걸경우 :hover에서만 애니메이션이됨

* 처음 transition과 :hover의 transition을 다르게 세팅가능

## transform

- 이동,크기,회전,기울이기로 변화를 줌

- position:relative처럼 원래위치는 막히면서 제자리에서 뜨게됨

- rotateZ(-90deg) 회전, 음수는 반시계방향, 여러번회전은 각도를 많이주면됨

- rotateY는 플립효과(카드플립효과)

- translate(x, y) % 사용시 자신의 크기가 기준이며 음수가능

- translateX(100px), translateY(100px) 가로나 세로 한방향일 경우 사용

- transform-origin으로 transform기준점 변경가능, px, %, left, top 사용하여 변경

- scale(1.5)로 가로,세로 크기를 배수로 변경

- skewX(45deg) 기울이기

- css 애니메이션은 GPU가속방식을 사용하므로 성능이 우수함

- **positon:fixed요소의 바깥 요소에 transform사용시 fixed요소의 기준이 transform사용한 요소로 변경되므로 fixed 바깥요소에 transform사용불가(크롬버그이므로 향후 수정될 수 있음)**

# 복합애니메이션(@keyframes, animation)

- 여러번에 걸쳐서 동작, 자동시작 애니메이션일 경우
- @keyframes 함수명 {
  50% { transform:translateX(500px); }
  }
- 키프레임 함수명은 어떤동작인지를 나타내는 이름을 카멜표기법으로 하며 중복은 안됨
  ex. moveBox, changeColor, fadeCover, moveBox02
- %는 애니메이션시간에 대한 백분율, 애니메이션시간이 1초인 경우 50%는 0.5초임
- 0%, 100%는 적지않을경우 최초상태

**animation: name duration delay timing-function iteration-count direction fill-mode;**
**animation-fill-mode: forwards 키프레임함수의 100%에서 멈추게 할때 사용, 없을경우 처음위치로 되돌아감**
animation-play-state:pause 일시정지
