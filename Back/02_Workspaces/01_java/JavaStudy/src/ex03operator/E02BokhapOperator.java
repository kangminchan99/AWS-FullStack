package ex03operator;

public class E02BokhapOperator {
    public static void main(String[] args) {
        // 복합 대입 연산자
        double e = 3.1;
        e += 2.1;
        e *= 2;
        e += e;
        System.out.println(e);

        int n = 5;
//        n = n * 2.7;
        n = (int)(n * 2.7);
        n *= 2.7;
        System.out.println(n);
    }
}
