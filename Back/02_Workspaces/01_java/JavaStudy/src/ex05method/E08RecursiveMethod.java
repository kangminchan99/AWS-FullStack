package ex05method;

public class E08RecursiveMethod {

    static int factorial(int number) {
        int result;
        if (number == 1){
            // 매개변수의 값이 1인경우 1을 반환하고 더이상 재귀 호출 X
            result = 1;
        } else{
            // 1이 아닌 경우에는 자신의 메서드를 재귀호출
            result = number * factorial(number - 1);
        }
        System.out.println("계산과정" + number +", result" +result);
        return result;

    }
    public static void main(String[] args) {
        System.out.println("factorial");
        System.out.println("4fac" +  factorial(4));
        System.out.println("10fac" + factorial(10));
    }
}
