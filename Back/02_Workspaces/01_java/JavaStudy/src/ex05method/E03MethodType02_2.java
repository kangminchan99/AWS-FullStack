package ex05method;

import java.util.Scanner;

public class E03MethodType02_2 {

    // 반환 타입이 String이므로 문자열의 결과를 반환한다.
    static String getHakjum() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("kor");
        int kor = scanner.nextInt(); // 정수형으로 입력 받는다.
        System.out.println("eng");
        int eng = scanner.nextInt();
        System.out.println("math");
        int math = scanner.nextInt();
        // 평균값을 구한다.
        double avg = (kor + eng + math) / 3.0;
        String hakjum = "";
        int result = (int)avg / 10;
        // 평균값을 통해 학점을 판단한다.
        switch (result) {
            case 10: case 9:
                hakjum = "A";break;
            case 8:
                hakjum = "B"; break;
            case 7:
                hakjum = "C"; break;
            case 6:
                hakjum = "D"; break;
            default:
                hakjum = "F";
        }
        return hakjum;
    }
    public static void main(String[] args) {
        System.out.println("your score" + getHakjum());
        String h = getHakjum();
        System.out.printf("your score %s", h);

    }


}
