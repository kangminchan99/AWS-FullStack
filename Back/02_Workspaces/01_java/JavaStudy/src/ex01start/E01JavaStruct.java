// 자바 파일의 구조
// 1.패키지 선언부: 현재 작성중인 자바 파일의 저장위치를 결정한다.
// 2.임포트 선언부: 프로그램에서 상용하는 클래스를 가져와서 사용할때 기술한다.
// 3.클래스 선언부: 프로그램의 주 내용을 입력한다.
package ex01start;

import java.text.SimpleDateFormat;
import java.util.Date;

public class E01JavaStruct {
    public static void main(String[] args) {

//      대문자로 시작하면 클래스임 (Date, SimpleDateFormat)
//      시스템에서 현재 시각을 가져온다
        Date toDayofDate = new Date();
        System.out.println("today date:" + toDayofDate);

//      한국에서 주로 사용하는 날짜 형식인 년 월 일 시 분 초로 변경하여 출력
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDayString = simple.format(toDayofDate);
        System.out.println("trans date" + toDayString);
    }
}
