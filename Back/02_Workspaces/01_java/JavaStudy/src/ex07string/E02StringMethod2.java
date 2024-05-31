package ex07string;

public class E02StringMethod2 {
    public static void main(String[] args) {

        String str1 = "Welcome To JAVA";
        String str2 = "자바야 놀자!";

        /*
        codePointAt() - 문자열의 특정 인덱스의 문자를 찾은 후 아스키 코드 혹은 유니코드를 반환
         */
        System.out.println(" codePointAt() 아스크 코드");
        System.out.println(str1.codePointAt(0));
        System.out.println(str2.codePointAt(2));

        /*
        end - startWith() - 특정 문자열로 끝나거나 시작하면 true 반환
         */
        System.out.println("end - startWith()");
        System.out.println("www.naver.com".endsWith("com"));
        System.out.println("naver.com".startsWith("http"));

        /*
        format() - 출력 형식을 지정하여 문자열로 반환할 때 사용 printf()와 사용법은 동일하고, 주로 웹 애플리케이션 제작에 사용된다.
         */
        System.out.println("format()");
        System.out.printf("kor%d,eng%d, math%d\n", 49, 66, 80);

        // 차후 웹 애플리케이션 제작에서 이와 같이 처리하여 웹 브라우저에 출력한다.
        String formatStr = String.format("kor%d,eng%d, math%d\n", 49, 66, 80);
        System.out.println(formatStr);

        /*
        indexOf() - 문자열에서 특정 문자열의 시작 인덱스를 반환한다. 만약 존재하지 않으면 -1을 반환한다. 인덱스는 항상 0부터 시작하므로
        -1은 해당 문자열이 없다는 의미가 된다.
         */
        String email1 = "naver@daum.net";
        System.out.println(str1.indexOf("AVA"));
        System.out.println(str1.indexOf("j"));
        // @가 없으면 이메일 형식이 아니므로 diff 반환
        System.out.println((email1.indexOf("@") != -1) ? "이메일 형식 맞음" : "이메일 형식 아님" );
    }
}
