package ex02variable;

public class E03CharBooleanType {
    public static void main(String[] args) {

        // char형: 하나의 문자를 저장할 수 있는 자료형으로 값을 저장할 때 ''사용
        // String: ""사용 시 문자열로 인식하르모 String으로 선언
        char ch1 = '가';
//        char chStr = '가나다라';  // 문자열 이므로 char로 선언할 수 없다.
        String chStr = "가나다라";
        System.out.println("ch1=" + ch1);
        System.out.println("chstr=" + chStr);

        // 아스키코드: 1byte로 표현할 수 있는 문자로 영문, 숫자를 십진수로 정의한 것을 말한다. ex) A => 65, a => 97로 표현된다.
        // 유니코드: 1byte로 표현할 수 없는 문자로 영문과 숫자를 제외한 모든 문자(한글, 한자 등)를 2byte로 표현한다. 보통 숫자가
        // 크기 때문에 16진수로 표현한다.
        char ch2 = 'A'; // 메모리에 65라는 값으로 저장됨.
        int num1 = 2; // 정수형 변수를 선언 및 초기화한다.
        int num2 = ch2 + num1; // 문자 + 정수 => 아스키코드로 저장되므로 연산이 가능하다.
        // 정수로 출력하면 67이 된다.
        System.out.println("num2=" + num2);
        // 문자로 출력하면 C가 된다.
        System.out.println("(char)num2=" + (char)num2);

        // (char)(char + int => int) => char형으로 강제 형 변환
        char ch3 = (char)(ch2+num1);

        System.out.println("ch3(문자출력)=>" + ch3);
        System.out.println("ch3=(아스키코드 출력)" + (int)ch3);

        // 싱글 쿼테이션으로 감쌌으므로 문자1(아스키코드49가) 할당된다.
        char ch4 = '1';
        // 연산결과는 50이므로 이에 해당하는 문자는 '2'가 된다.
        char ch4_1 = '1' + 1; // 49 + 1 = 50 = '2'
        // 문자 '2'와 정수 50이 출력된다.
        System.out.println("ch4=" + ch4 +", ch4_1 =" + ch4_1 + ", ch4_1 = " + (int)ch4_1);


        boolean bn1 = true;
        boolean bn2 = false;
        System.out.println("bn1="+ bn1 + ", bn2=" + bn2);

        boolean bn3 = bn1 && bn2;
        System.out.println("bn3(and)="+bn3);
        bn3 = bn1 || bn2;
        System.out.println("bn3(or)="+bn3);

        // 문자 '가'는 유니코드 44032로 표현되므로 true를 반환한다.
        bn3 = '가' > 30000;
        System.out.println("bn3=" + bn3);

    }
}
