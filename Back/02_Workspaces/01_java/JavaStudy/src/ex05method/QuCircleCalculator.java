package ex05method;

public class QuCircleCalculator {
    public static void main(String[] args) {
        circleRound(5.5);
        circleArea(5.5);
    }
    static void circleArea(double radius) {
        System.out.println("넓이공식:" + (3.14 * radius * radius));
    }

    static void circleRound(double radius) {
        System.out.println("둘레공식:" + (2 * 3.14 * radius));
    }
}
