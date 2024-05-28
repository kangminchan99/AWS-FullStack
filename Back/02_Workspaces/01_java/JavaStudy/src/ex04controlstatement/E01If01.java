package ex04controlstatement;

import java.io.IOException;

/*
if문의 조건문은 반드시 비교식 혹은 논리식이어야한다.
즉 결과값이 boolean타입으로 true/false를 반환해야한다.
실행할 문장이 하나이면 중괄호 생략이 가능하다.
 */
public class E01If01 {
    public static void main(String[] args) throws IOException {
        int num = 10;

//        if (num % 2) {
//            System.out.println("error");
//        }
//
//        if (num) {
//            System.out.println("error");
//        }
//
//        if (num % 2 == 0) {
//            System.out.println("%d even", num);
//        }
        if (num % 2 == 0 && num >= 10) {
            System.out.printf("%n%d even and num > 10\n", num);
        }

        if (true) {
            System.out.println("무조건 실행\n");
        }
        if (num % 2 != 0);
        {
            System.out.printf("%d oddㅁㄴㅇㅁㄴㅇㄴㅁㄴ", num);
        }

        if (num % 2 == 0) {
            System.out.println("even" + num);
        }

        if (num % 2 != 0) {
            System.out.println("odd" + num);
        }

        /*
        사용자가 입력한 문자가 숫자인지 판단하는 프로그램을 if문을 통해서 작성하시오.
        참조) system.in.read(): 사용하시오
         */

        System.out.println("문자를 입력");
        int asciiCode = System.in.read();
        System.out.println("입력한 문자:" + asciiCode);

        if (asciiCode >= 48 && asciiCode <= 57) {
            System.out.println("this is num");
        }else{
            System.out.println("not num");
        }
        // 메모리 저장 시 문자 0 과 9는 메모리에 저장 시 아스키 코드로 변환되므로 아래와 같은 조건으로도 확인할 수 있다.
        if (asciiCode >= '0' && asciiCode <= '9'){
            System.out.println("this is num [1]");
        } else {
            System.out.println("not num [1]");
        }
    }
}
