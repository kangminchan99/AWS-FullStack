package ex07string;

/*
StringBuffer클래스
String클래스는 기존 문자열에 새로운 문자열을 추가하면 새롭게 생성된 메모리에 저장한다.
기존메모리가 소멸되고 새로운 메모리가 생성되는 낭비를 막기위해 문자열의 변경이 많은 경우에는
StringBuffer를 사용하는 것이 좋다. 기존의 메모리를 변경하고 부족한 경우 자동으로 확장한다.
 */
public class E03StringBuilderBuffer {
    public static void main(String[] args) {
        /*
        append(값): 문자열의 끝에 새로운 값을 연결한다.
        insert(idx, value): 지정한 인덱스에 값을 삽입한다.
         */

        // 인스턴스 생성
        StringBuffer strBuf = new StringBuffer("AB");
        strBuf.append(25); // 정수 연결
        strBuf.append("Y").append(true); // 문자열이나 boolean값 연결
        System.out.println(strBuf);

        System.out.println("===========");

        strBuf.insert(2, false); // 인덱스 2번째에 false삽입
        strBuf.insert(strBuf.length(), 'Z'); // 문자열의 길이를 통해서 마지막 부분에 'Z' 추가
        System.out.println(strBuf);

        System.out.println("===========");

        System.out.println("string과 stringbuffer의 참조값 비교");
        // 더블 쿼테이션으로 동일한 문자열을 생성하므로 동일한 주소값을 가짐
        String str1 = "Java&JSP";
        String str2 = "Java&JSP";
        if (str1 == str2) {
            System.out.println("address same");
        } else {
            System.out.println("address diff");
        }
        // String은 변경이 있는 경우 기존 메모리를 소멸한 후 새로운 메모리를 할당한다.
        str1 += "&Spring";
        if (str1 == str2) {
            System.out.println("address same");
        } else {
            System.out.println("address diff");
        }

        /*
        StringBuffer는 문자열을 저장하기 위해 기본 메모리를 16으로 할당한다.
        차후 저장공간이 부족하다면 자동으로 메모리를 확장한다.
         */
        StringBuffer buf = new StringBuffer();
        System.out.println(buf);
        System.out.println(buf.length()); // 메모리
        System.out.println(buf.capacity()); // 버퍼

        buf.append("learn java");
        System.out.println(buf);
        System.out.println(buf.length());
        System.out.println(buf.capacity());

        buf.append("learn springbuffer");
        System.out.println(buf);
        System.out.println(buf.length());
        System.out.println(buf.capacity());

    }
}
