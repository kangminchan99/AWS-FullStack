package ex18lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex06Define4Function {
    public static void main(String[] args) {
        /*
        Function<T, E>
        : 매개변수와 반환값을 둘 다 가지고 있는 apply() 추상 메서드가
        정의되어있다. 개발자가 가장 많이 사용하는 함수형 인터페이스이다.

        interface Function<T, E> {
            E apply(T t);
        }
         */

        /*
        매개변수는 String, 반환값은 Integer 타입으로 람다식 정의.
        문자열의 길이를 반환한다.
         */
        Function<String, Integer> func = (String s) -> s.length();

        System.out.println("lambda 문자열 길이 = " + func.apply("lambda"));
        // Human 인스턴스 생성
        Human p1 = new Human("케이윌", "man", 80);
        Human p2 = new Human("에일리", "girl", 77);
        Human p3 = new Human("임재범", "man", 97);
        Human p4 = new Human("아이유", "girl", 99);
        // List에 저장한다. 단 참조만 할 수 있는 형태이다.
        List<Human> list = Arrays.asList(p1, p2, p3, p4);

        /*
        Human 인스턴스를 받은 후 점수(Score)를 반환하는 람다식 정의
         */
        Function<Human, Integer> getFunc = (Human h) -> h.getScore();

        int score = getFunc.apply(p1);
        System.out.println("p1 score" + score);

        /*
        foreach문을 통해 컬렉션 전체를 반복하여 점수를 출력한다.
         */
        System.out.println("score");
        for(Human h : list) {
            System.out.println(h.getName() + " score " + getFunc.apply(h));
        }
    }
}
