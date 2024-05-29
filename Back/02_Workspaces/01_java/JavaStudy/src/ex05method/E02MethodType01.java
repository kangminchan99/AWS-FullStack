package ex05method;

/*
Method(메서드, 함수)
: 객체지향 프로그래밍에서 행동 혹은 동작을 의미한다.
즉 어떤 하나의 업무를 처리하기 위한 모듈(부속품)이라 정의할 수 있다.
메서드는 반드시 class 내부에 정의해야한다.
메서드 내부에 또 다른 메서드를 정의할 수 없다. 에러 발생됨
반환값이 없다면 void를 반드시 명시해야한다.
메서드명은 변수명과 동일한 규칙으로 작성한다.
 */

// 자바에서의 naming rule
// 클래스명 - GoodMorning (파스칼 케이스): 첫글자가 대문자면 파스칼케이스, 소문자면 카멜 케이스임
// 메서드 혹은 변수명 - goodMorning (카멜 케이스)
// 상수명 - GOOD_MORNING - (스네이크 케이스)
// 패키지명 - good.morning - 전체 소문자로 작성 연결 단어는 . 으로 구분

// 메서드 형태1] 매개변수도 없고, 반환값도 없는 메서드
// 둘 다 없는 형태의 메서드로 주로 메뉴를 출력하거나 하는 단순 출력 기능 정도로 사용한다.
public class E02MethodType01 {
    static void menuPrint() {
        System.out.println("menu");
        System.out.println("1. open, 2. continue, 3.exit");
        System.out.println("=============");
    }
    static void returnError() {
        int returnValue = 8;
        System.out.println("return문 이전");

//        return;

        // 리턴문이 중간에 있으려면 조건부로 기술해야함
        if (returnValue % 2 == 0) {
            System.out.println(returnValue);
            // 함수 종료
            return;
        }

        System.out.println(returnValue);
        System.out.println("[return문 이후]");

    }

    public static void main(String[] args) {
        menuPrint();
        returnError();
    }

}
