package ex18lambda;

import java.util.function.Consumer;

public class Ex06Define3Consumer {
    public static void main(String[] args) {
        /*
        Consumer<T>
        : 소비자라는 뜻을 가지고 있다. 매개변수는 있으나 반환값은 없는
        accept() 추상 메서드가 정의되어있다.
        즉 매개변수를 소비하는 형태라 보면되고, 리턴값이 없으므로 단순한
        출력결과만 보여준다.

        interface Consumer<T> {
            void accept(T t);
        }
         */
        // accept()를 기반으로 람다식을 정의한다.
        Consumer<String> c1 = (String s) -> {
            System.out.println(s + " is singer");
        };
        // 매개변수로 전달한 문자열을 출력한다.
        c1.accept("iu");

        /*
        매개변수의 타입을 생략한 형태의 람다식을 정의한다.
        Consumer<String>으로 정의했으므로 매개변수 타입이 String임을 유추할 수 있으므로
        생략 가능하다.
         */
        Consumer<String> c2 = t -> System.out.println(t + " is fruit");

        c2.accept("apple");
    }
}
