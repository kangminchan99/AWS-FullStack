package ex03operator;

public class E05ShortCircuitEvaluation {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0;
        boolean result;

        // SCE(Short-Circute Evaluation) - 하나의 조건 검사만으로 결과를 알 수 있는 경우 Java 컴파일러는 뒤의 조건을 검사하지 않고
        // 건너뛰게 된다. 이 경우 변수의 값이 변경되는 코드가 있다면 실행되지 않으므로 주의해야한다.
        result = (num1 += 10) < 0 && (num2 += 10) > 0; // 논리 And의 경우 둘 중 하나만 false이면 무조건 false이므로 첫번째 조건이
        // false이면 두번째 조건은 검사하지 않는다.
        System.out.println(result);
        System.out.println("num1" + num1 + "num2=" + num2);

        result = (num1 += 10) > 0 || (num2+=10)>0; // 논리 or의 경우 둘 중 하나만 true이면 무조건 true를 반환하므로 첫번째 조건이 true이면
        // 두번째 조건은 검사하지 않는다.
        System.out.println(result);
        System.out.println("num1" + num1 + "num2=" + num2); // 그래서 num2는 여기서도 0으로 증가되지 않음
    }
}
