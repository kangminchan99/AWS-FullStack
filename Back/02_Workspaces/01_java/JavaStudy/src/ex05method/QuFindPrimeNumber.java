package ex05method;

public class QuFindPrimeNumber {
    public static void main(String[] args) {
        isPrimeNumber(100);
    }

    static void isPrimeNumber(int prime) {
        int result = 0;
        for (int i = 2; i <= prime; i++){
            int check = 0;
            if ( prime % i == 0) {
                result += 1;
            }
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    check += 1;
                }
            }
            if (check == 1) {
                System.out.println(i);
            }
        }
        System.out.println(result == 1 ? "True" : "False");
    }
}
