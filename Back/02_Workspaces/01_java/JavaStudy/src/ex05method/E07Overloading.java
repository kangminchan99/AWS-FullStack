package ex05method;


/*
메서드 오버로딩(method overloading)
: 동일한 이름의 메서드(함수)를 2개이상 정의하는 것을 말한다.
- 매개변수의 갯수가 다르거나 자료형이 다를 때 성립한다.
- 반환 타입만 다른 것은 허용되지 않는다. (파라미터는 같은데 반환타입이 void와 int인 경우)
- 컴파일러는 메서드 호출 시 전달되는 인수를 통해 호출할 메서드를 구분한다.
 */
public class E07Overloading {

    // 남성일 경우 파라미터가 2개
    static void person(int juminNum, int milNum) {
        System.out.println("군필자");
        System.out.println("주민" + juminNum);
        System.out.println("군번" + milNum);
    }

    // 여성일 경우 파라미터 1개
    static void person(int juminNum) {
        System.out.println("미필자 or woman");
        System.out.println("주민" + juminNum);
    }

    // 에러발생 반환타입만 다른 경우이므로 컴퓨터가 어떤걸 호출할지 애매하니까 에러가 발생한다.
//   static int person(int juminNum) {
//        System.out.println("미필자 or woman");
//        System.out.println("주민" + juminNum);
//        return 1;
//
//    }


    public static void main(String[] args) {
        person(123123,923493094); // 인자의 개수로 호출할 메서드의 이름이 같이도 구분이 가능하다.
        System.out.println("========");
        person(912309);


        // jdk안에서 오버로딩을 처리해줘서 타입이 달라도 에러가 발생하지 않는다.
        // print가 대표적인 오버로딩으로 정의된 메서드이다
        System.out.println(10);
        System.out.println(3.14);
        System.out.println("a");
        System.out.println(true);
    }
}
