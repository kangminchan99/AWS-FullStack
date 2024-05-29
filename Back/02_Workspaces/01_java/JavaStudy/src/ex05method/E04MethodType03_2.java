package ex05method;

import java.util.Scanner;

public class E04MethodType03_2 {
    static void inputGugudan(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i ++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%2d*%2d=%3d ", i, j, i*j);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("start");
        int s = scanner.nextInt();
        System.out.println("end");
        int e = scanner.nextInt();
        inputGugudan(s, e);
    }
}
