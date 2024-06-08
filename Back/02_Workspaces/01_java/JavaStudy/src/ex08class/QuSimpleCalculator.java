package ex08class;

class CalculatorEx {
    private double result;
    private int addCount;
    private int minCount;
    private int mulCount;
    private int divCount;

    public CalculatorEx() {
    }

    public void init() {
        result = 0;
        addCount = 0;
        minCount = 0;
        mulCount = 0;
        divCount = 0;
    }

    public double add(double a, double b) {
        result = a + b;
        addCount++;
        return result;
    }

    public double min(double a, double b) {
        result = a - b;
        minCount++;
        return result;
    }

    public double div(double a, double b) {
        if ( b == 0) {
            System.out.println("error");
            return 0;
        }
        result = a / b;
        divCount++;
        return result;
    }

    public double mul(double a, double b) {
        result = a * b;
        mulCount++;
        return result;
    }

    public void showOpCount(){
        System.out.println("덧셈횟수:" + addCount);
        System.out.println("뺄셈횟수:" + minCount);
        System.out.println("곱셈횟수:" + mulCount);
        System.out.println("나눗셈횟수:" + divCount);
    };

}


public class QuSimpleCalculator {
    public static void main(String[] args) {
        CalculatorEx cal = new CalculatorEx();
        cal.init();
        System.out.println("1 + 2 = " + cal.add(1 , 2));
        System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
        System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
        System.out.println("100 / 25 = " + cal.div(100 , 25));
        System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
        cal.showOpCount();

    }
}
