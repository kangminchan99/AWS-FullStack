package ex05method;

import java.util.Scanner;

public class E04MethodType03_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("start num");
        int s = scanner.nextInt();
        System.out.println("end num");
        int e = scanner.nextInt();
        // 반환값이 없는 메서드이므로 단독적으로 호출한다. 앞에서 입력받은 2개의 정수를 인수로 전달한다.
        myWantSum(s, e);
    }

    // 메인 메서드에서 호출 시 전달한 2개의 인수를 파라미터를 통해 순서대로 받는다. 파라미터는 해당 메서드에서 즉시
    // 사용할 수 있는 지역 변수가 된다.
    // 커스터 마이징함 숫자를 입력받아서
    static void myWantSum(int startNum, int endNum) {
        int sum = 0;
        int change = 0;
        if (startNum > endNum) {
            change = endNum;
            endNum = startNum;
            startNum = change;
        }
        for (int i = startNum; i <= endNum; i++) {
            sum += i;
        }
        // 결과는 반환하지 않고 즉시 출력한다.
        System.out.printf("%d~%dinfo:%d",startNum, endNum, sum);
    }
}
