package ex16exception;

import java.util.Scanner;

public class Ex02PreDefineException2 {
    public static void main(String[] args) {
        System.out.println("NumberFormatException");
        Scanner scanner = new Scanner(System.in);
        try {
            /*

             */
            System.out.println("나이 입력해");
            String strAge = scanner.nextLine();
            int ageAfter10 = Integer.parseInt(strAge) + 10;
            System.out.println("당신 10년 후 나이" + ageAfter10);
        } catch (NumberFormatException e) {
            System.out.println("나이는 숫자만");
            System.out.println("message" + e.getMessage());
            e.printStackTrace();
        }
    }
}

