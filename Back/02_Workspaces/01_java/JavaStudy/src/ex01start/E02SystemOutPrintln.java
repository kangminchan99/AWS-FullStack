package ex01start;

public class E02SystemOutPrintln {
    public static void main(String[] args) {

        int num1 = 100;

        System.out.println("num1= " + num1);
        System.out.print("num1=" + num1 + "\n");
//      printf - 특정 서식에 맞춰 출력한다. 또한 자체적인 줄바꿈이 기능이 없으므로 \n혹은 %n을 이용하여 줄바꿈한다.
//      변수를 출력하는 서식문자에는 %d, %f 등이 있다.
//      단 줄바꿈을 위한 %n은 printf에서만 사용할 수 있다.
        System.out.printf("num1=%d%n", num1);

        System.out.println(7);
        System.out.println(3.14);
//      print()문 에서의 +기호의 역할
//      1. 숫자 (정수 혹은 실수)끼리는 실제 덧셈연산을 함
//      2. 문자열, 숫자 등 서로 자료형이 다른 데이터끼리는 단순 연결하는 기능만 제공
        System.out.println(3 + 5);
        System.out.println(3.5 + 5.1);
        System.out.println("3+5=" + 8);
        System.out.println(3.15 + "는 실수입니다.");
        System.out.println("3+5" + "의 연산결과는 8입니다.");

        System.out.println("num1은" + num1 + "입니다.");
    }
}
