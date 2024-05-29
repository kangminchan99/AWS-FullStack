package ex05method;

import java.util.Scanner;


// 매개변수도 있고 반환값도 있는 형식으로 4가지 형식중에 가장 많이 사용된다.

public class E05MethodType04_1 {
    public static void main(String[] args) {
        int sumOfAge = getTotalAge(3);
        System.out.println(sumOfAge);
    }

    static int getTotalAge(int personCnt) {
        Scanner scanner = new Scanner(System.in);
        int sumAge = 0;   // 나이의 합을 저장

        for (int i = 1; i <= personCnt; i ++) {
            System.out.println(i + "번째 사람의 나이");
            int age = scanner.nextInt(); // 입력 받은 나이는 변수에 누적해서 더해준다.
            sumAge += age;
        }
        return  sumAge;
    }
}
