package ex02variable;

public class E06EscapeSequence {
    public static void main(String[] args) {

        System.out.println("4월엔 asdmlk");
        System.out.println("4월엔\t벚꽃"); // (\t) - tab(tab)기능으로 스페이스 4칸이 띄워진다.

        // 줄바꿈 기능 (\n)
        System.out.println("javaWorld welcome~~.\n");
        System.out.println("javaWorld\n welcome~~\n");

//        System.out.println("minc"han"maslkd");
        System.out.println("minc\"han\"maslkd"); // 문자열 자체를 표현하려면 \" ~ \" 사용


        int kor = 81, eng = 97, math = 21;


        // 같은 출력 문장이지만 println()을 사용하면 아래와 같이 문자열과 변수를 분리하여 작성해야하므로 조금 더 복잡하다.
        System.out.printf("kor:%d, eng:%d, math:%d%n", kor, eng, math);  // printf() : 문자열을 서식에 맞춰서 출력할 때 사용한다.
        System.out.println("\nkor:" + kor + "eng:" + eng + "math:" + math);  // 정수는 %d, 줄바꿈은 %n으로 표현한다.

        // 실수는 f를 사용한다. 또한 정수와 실수의 연산이므로 결과는 실수가 반환되어 double 타입의 변수에 대입해야한다.
        double avg = (kor+eng+math) / 3.0;

        // 자리수 지정하기 %4d: 정수 출력 시 4칸을 확보한 후 표현한다.
        // %6.2f : 실수 출력 시 전체 자리수는 6자리, 소수이하 2자리로 표현된다.
        // 또한 양수는 우측정렬, 음수는 좌측정렬
        System.out.printf("avg:%f%n", avg);
        System.out.printf("kor:%d, eng:%d, math:%d avg:%f %n", kor, eng, math, avg);
        System.out.printf("kor:%6d, eng:%6d, math:%6d avg:%7.4f %n", kor, eng, math, avg); // %6d (우측 정렬)
        System.out.printf("kor:%-6d, eng:%-6d, math:%-6d avg:%-7.2f %n", kor, eng, math, avg); // %-6d (좌측 정렬)
    }
}
