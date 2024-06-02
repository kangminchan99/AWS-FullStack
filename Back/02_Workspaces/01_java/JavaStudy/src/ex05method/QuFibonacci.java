package ex05method;

public class QuFibonacci {
    public static void main(String[] args) {
        fibonacciProgression(10);
    }

    static void  fibonacciProgression(int num) {
        int first = 0, second = 1;
        System.out.println(first);
        System.out.println(second);
        for (int i = 2; i < num; i++) {
            int next = first + second;
            first = second;
            second = next;
            System.out.println(second);
        }
    }
}
