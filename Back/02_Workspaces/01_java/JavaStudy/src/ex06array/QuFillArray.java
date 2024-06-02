package ex06array;

import java.util.Arrays;
import java.util.Scanner;

public class QuFillArray {
    public static void main(String[] args) {
        int[] orderArr = new int[10];
        int[] oddEvenArr = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print(i +"번째 정수를 입력하세요:");
            orderArr[i - 1] = scanner.nextInt();
        }
        System.out.println("순서대로입력된결과");
        System.out.println(Arrays.toString(orderArr));

//      [2, 4, 5, 3, 2, 9, 7, 8, 5, 1]
        int oddIdx = 0;
        int evenIdx = orderArr.length - 1;
        for (int i = 0; i < orderArr.length; i++) {
            if (orderArr[i] % 2 != 0) {
                oddEvenArr[oddIdx] = orderArr[i];
                oddIdx++;
            } else {
                oddEvenArr[evenIdx] = orderArr[i];
                evenIdx--;
            }
        }
        System.out.println("홀수/짝수 구분입력결과");
        System.out.println(Arrays.toString(oddEvenArr));
    }
}
