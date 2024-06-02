package ex07string;

import java.util.Scanner;

public class QuValidateId {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디를 입력하세요:");

        String inputId = scanner.nextLine();

        boolean valid = idValidate(inputId);
        System.out.println(valid ? "사용 가능" : "사용 불가");

    }

    static boolean idValidate(String inputId) {
        if (inputId.length() < 8 || inputId.length() > 12) {
            return false;
        }

        for (int i = 0; i < inputId.length(); i++) {
            char idChar = inputId.charAt(i);
            if (!((idChar >= 'a' && idChar <= 'z')|| (idChar >= 'A' && idChar <= 'Z') || (idChar >= '0' && idChar <= '9'))) {
                return false;
            }
        }
        return true;
    }
}
