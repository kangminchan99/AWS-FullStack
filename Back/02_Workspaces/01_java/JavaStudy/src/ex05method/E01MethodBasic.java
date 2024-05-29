package ex05method;

import java.util.Scanner;

/*
메서드(함수)의 규칙
자바에서 메인 메서드는 public static void 로 선언한다.
static으로 선언된 메서드는 스태틱으로 선언된 메서드만 호출할 수 있다.
메서드 호출 후 반환값은 호출한 위치로 반환된다. 이때 메서드는 메모리에서 소멸된다.
반환값이 없는 void형 메서드도 실행이 완료되면 호출한 위치로 실행의 흐름이 돌아온다.
 */

public class E01MethodBasic {

    // 메서드1: 반환값O, 파라미터O
    //  2개의 인트형 파라미터를 받아 그 합을 리턴
    public static int simpleFunc(int a, int b) {
        int sum = a + b;
        return sum;
    }

    // 메서드2: 반환값 x why? void로 선언해서
    // 전달 받은 값 없이 그냥 함수 이름으로 호출시켜서 스캐너에 담긴 정보를 namePrint로 넘겨준다.
    public static void menuPrint() {
        System.out.println("whats u r name");
        Scanner scanner = new Scanner(System.in);
        // nextLine()은 문자열을 입력받을 때 사용하는 메서드
        String name = scanner.nextLine();
        namePrint(name);
    }

    // 파라미터 있음 문자열을 인수로 전달받아 단순히 출력만 진행한다.
    public static void namePrint(String n) {
        System.out.println("my name is " + n );
    }

    // 메인 메서드는 자바에서 출발점 역할을 한다.
    // 즉 직접 호출하지 않아도 자동으로 호출되어 프로그램이 실행된다.
    public static void main(String[] args) {
        // 메서드 호출 시 함수의 원형을 그대로 기술한다. 매개변수의 갯수가 다르거나 타입이 틀리면 에러가 발생한다.

        int result = simpleFunc(1,2); // 리턴값이 있으면 변수에 대입
        System.out.println(result);
        System.out.println(simpleFunc(10,20));

        menuPrint(); // void면 단독 사용

        // 메인 메서드의 종료는 해당 프로그램의 종료로 이어진다.
    }
}
