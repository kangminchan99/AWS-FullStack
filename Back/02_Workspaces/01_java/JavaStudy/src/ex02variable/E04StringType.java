package ex02variable;

public class E04StringType {
    public static void main(String[] args) {

        // String 클래스: 참조형 변수로써 기본 자료형이 아닌 클래스로 문자열을 저장하고, 조작하는 기능을 가지고 있다. 자바에서는 문자열을 표현할 때 "으로
        // 감싸주면 되고, 연결 시에는 + 기호를 사용한다.
        int number;
        number = 99;

        // 클래스를 통해 생성한 참조형 변수와 기본 자료형 사이에서는 형변환이 불가능하다.
        // 서로 사용하는 메모리 공간이 다르기 때문이다.
        // 기본 자료형: stack(스택) 영역을 사용한다.
        // 참조형(클래스)변수: heap(힙)영역을 사용한다.
//        int stringNumber1 = (int)"100"; // 에러 발생
//        String stringNumber2 = (String) 100; // 에러 발생

        // String + int => 단순 연결되서 출력된다.
        String strNumber = "100";
        System.out.println(strNumber + number);

        // String은 클래스이므로 new를 사용해서 변수를 생성할 수 있다.
        String newString = new String("new use");
        System.out.println(newString);

        // String변수는 주로 더블 쿼테이션을 통해 생성한다.
        String stringBasic = "class";
        String plusString = "기본 자료형 처럼 사용";
        System.out.println(stringBasic + " " + plusString);

        int kor = 100, eng = 99, math = 98;

        System.out.println("result" + kor + eng + math); // 총점이라는 문자 뒤에 + 연산만 사용하여 출력하면 문자열로 붙어서 나온다.
        System.out.println("result" + (kor + eng + math)); // 괄호가 있는 경우에는 ()안에 있는 값이 더해지고 문자열로 붙어서 나온다.
    }
}
