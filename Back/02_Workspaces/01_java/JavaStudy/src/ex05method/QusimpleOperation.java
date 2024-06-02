package ex05method;

public class QusimpleOperation {
    public static void main(String[] args) {
        arithmetic(100, 77);
    }

    static void arithmetic(int num1, int num2) {
        System.out.println("덧셈결과 ->" + (num1 + num2));
        System.out.println("뺄셈결과 ->" + (num1 - num2));
        System.out.println("곱셈결과 ->" + (num1 * num2));
        System.out.println("나눗셈 몫 ->" + (num1 / num2));
        System.out.println("나눗셈 나머지 ->" + (num1 % num2));

    }
}
