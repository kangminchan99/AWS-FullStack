package ex16exception;

import java.io.IOException;

public class Ex01ExceptionBasic1 {
    public static void main(String[] args) {
        /*
        syntax에러(구문에러)
        : 실행 자체가 되지 않는 코드로 오류를 수정해야만 정상적으로 실행된다.
        즉 코드에 문법 적인 오류가 발생되었음을 의미한다.
         */

//        Int number = 10; -> int를 Int로 표기
//        if(true);
//        {}
//        else{} -> if문이 세미콜론으로 종료되어 의미없는 else문이 됨

        int number = 10;
        if(true){
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        /*
        외부자원을 사용할 때 발생하는 예외
        처리방법1] 예외가 발생한 지점을 try~catch문으로 직접 감싸서 처리한다
        if-else와 다른점은 try는 exception throw 발생 경우 그 즉시 try 블럭 스코프를 벗어나지만
        if-else는 그 구문만 벗어나기 때문에 에러가 발생한 객체의 수명이 유지가 되고 try~catch는 객체의 수명이 종료가 된다.

        처리방법2] "예외 던지기"를 수행한다.
        main 메서드에 throws를 IOException을 기술하면 해당 메서드 내에서 발생되는
        예외를 프로그램 외부로 던지기 할 수 있다.
        여기서 던지기의 의미는 예외를 처리하지않고 무시하겠다는 뜻이다.
         */
        System.out.println("문자하나를 입력하세요");
        try {
            int iChar = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
