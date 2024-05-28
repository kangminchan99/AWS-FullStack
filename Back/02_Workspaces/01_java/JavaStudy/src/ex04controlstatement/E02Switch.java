package ex04controlstatement;

import java.util.Scanner;

public class E02Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input num");
        int iNum = scanner.nextInt();

        int remain = iNum % 3;
        switch (remain) {
            case 0:
                System.out.println("나머지는 0입니다");
                break;
            case 1:
                System.out.println("나머지는 1입니다");
                break;
            default:
                System.out.println("나머지는 2입니다");
        }
        long ln = 100;
//        switch (ln) {
//            case 100:
//                System.out.println("long타입 사용??");
//            default:
//                System.out.println("error");
//        }
//        switch (iNum % 3 == 0) {
//            System.out.println("논리식도 안되는군");
//        }
    }
}
