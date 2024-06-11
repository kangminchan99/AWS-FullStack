package ex15usefulclass;

import java.util.Scanner;

public class E01WrapperClass2 {
    public static void main(String[] args) {
        /*
        parseInt(): 숫자형식의 문자열을 정수로 변경한다.
        parseDouble(): 실수로 변경
         */
        String strNum = "1000";
        // 정수 + 문자열 => 101000
        System.out.println("10+strNum=" + (10+strNum));
        // 정수 + 정수 => 1010
        System.out.println("10+strNum을 숫자로 변경:" + (10 + Integer.parseInt(strNum)));
        // 위와 동일하게 문자열을 정수로 변경해준다.
        System.out.println("10+strNum을 숫자로 변경:" + (10 + Integer.valueOf(strNum)));


        /*
        문자열을 숫자로 변경할때는 반드시 숫자 형식만 기술해야한다.
        "원"은 숫자가 아니므로 예외가 발생한다.
         */
        String money = "120won";
//        System.out.println("120won:" + Integer.parseInt(money)); // => error

        /*
        실수 형태의 문자열을 숫자로 변경할때는 parseInt()를 사용할 수 없다.
        앞과 동일한 예외가 발생한다.
         */
        String floatString = "3.14";
//        System.out.println(Integer.parseInt(floatString)); => error
        System.out.println("float으로 변경" + Float.parseFloat(floatString));
        System.out.println("double로 변경" + Double.parseDouble(floatString));

        /*
        Character 클래스의 주요 메서드

        codePointAt(): 문자열에서 특정 index에 해당하는 문자의 아스키코드를 반환한다.
         */
        System.out.println("ABCD에서 3번째 인덱스 D의 아스키코드");
        System.out.println(Character.codePointAt("ABCD", 3));

        /*
        isDigit(): 인자로 전달된 문자가 숫자형식인지 판단한다.
         */
        System.out.println("isDigit()을 통한 숫자 판단");
        System.out.println(Character.isDigit('A') ? "숫자임" : "숫자가 아님");
        System.out.println(Character.isDigit(50) ? "숫자임" : "숫자가 아님");
        System.out.println(Character.isDigit('7') ? "숫자임" : "숫자가 아님");

        /*
        isLetter(): 문자인지 여부를 판단하는 메서드로 특수 기호나 숫자형일때는 false를 반환한다.
         */
        System.out.println("isLetter()메소드를 통한 문자판단");
        System.out.println(Character.isLetter('강'));
        System.out.println(Character.isLetter('A'));
        System.out.println(Character.isLetter('#'));
        System.out.println(Character.isLetter('9'));


        /*
        isWhitespace(): 공백 문자인지 판단하는 메서드. 공백문자일 때 true를 반환한다.
         */
        System.out.println("isWhitespace()메소드로 공백 문자 판단");
        System.out.println(Character.isWhitespace('A'));
        System.out.println(Character.isWhitespace(' '));


        /*
        isLowerCase() / isUpperCase(): 소문자 혹은 대문자인지 판단한다.
        만약 영문이 아닌 경우에는 무조건 false를 반환한다.
         */
        System.out.println("알파벳 대소문자 판단");
        System.out.println(Character.isLowerCase('A'));
        System.out.println(Character.isUpperCase('z'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isUpperCase('Z'));
        System.out.println(Character.isLowerCase('가'));


        /*
        시나리오] 주어진 문자열 안에 몇개의 공백문자(스페이스)가 있는지 판단하는 프로그램을 작성하시오.
            참고) toCharArray(): 문자열을 char형 배열로 반환해주는 String클래스에 정의된 메소드
         */
        String whiteString = "h e  l    l      o";
        char[] arr = whiteString.toCharArray();
        int cnt = 0;
        int cnt1 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                cnt += 1;
            }
        }

        // 향상된 for문
        for (char data: arr){
            // 공백 찾기
            if (Character.isWhitespace(data)){
                cnt1 += 1;
            }
        }
        System.out.println(cnt);
        System.out.println(cnt1);

    }
}
