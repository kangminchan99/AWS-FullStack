package ex02variable;

public class E07TypeCasting {
    public static void main(String[] args) {
        // 자동 형 변환: 작은 자료형의 데이터를 큰 자료형에 대입할 때 자동으로 형 변환이 일어난다.
        byte b1 = 65;
        short s1;
        // byte가 short보다 작은 자료형이므로 자동형변환되어 대입된다.
        s1 = b1;
        System.out.printf("b1은 %d, s1 = %d%n", b1 , s1);

        // 아래 코드는 자동형변환이 아니다. cpu는 int보다 작은 자료형을 연산할때는 Int로 간주하여 진행하고 결과도 int로 반환
        // int에 최적화된 cpu의 특성
        int num1 = b1 + s1;
        System.out.println("num1 ="+ num1);

//        char ch1 = b1; // char(문자타입)에 byte(정수타입)을 바로 대입 불가, 특성이 다르므로 강제 형변환 후 대입
        char ch2 = (char) b1;
        System.out.println("b1 = " + b1 + ", ch2 =" + ch2);

        // 명시적 형변환: 큰상자의 자료를 작은 상자의 자료형에 할당해야할 때 사용, 단, 자료의 손실이 있을 수 있으므로 필요한 경우에만 사용
        short s2 = 100;
        byte b2 = (byte) s2;
        System.out.printf("데이터미손실:b2=%d, s2=%d\n", b2, s2);


        // 소수점 아래부분이 버려지므로 데이터 손실이 있는 경우이다.
        // 흔히 원 단위 절삭과 같은 경우에 사용한다.
        int num3;
        double dl = 3.14;
        num3 = (int) dl;
        System.out.printf("데이터손실:num3=%d, dl=%.2f %n",  num3, dl); // %.2f - 소수 이하 2자리까지만 표현

        /*
        문자는 메모리에 저장 시 아스키 코드로 저장되므로 int와의 연산을 진행한 후
        문자로 표현하고 싶다면 char형으로 강제형변환 하면 된다.
         */
        char ch3 = 'A', ch4;
        int num4 = 2;
//        ch4 = ch3 + num4;
        // A + 2 => C가 할당됨
        ch4 = (char)(ch3 + num4);
        System.out.println("ch4=" + ch4);

    }
}
