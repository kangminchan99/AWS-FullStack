package ex02variable;

public class E05ConstantVar {
    public static void main(String[] args) {

        // 상수: 저장된 값이 변하지 않는 메모리의 한 종류로 선언할 때 앞 부분에 final을 붙여준다.
        //  - 상수는 한번만 초기화 되고, 이후에는 값을 변경할 수 없다.
        // 선언 시 전체를 대문자로 기술한다. 만약 연결할 단어가 있다면 가독성을 위해 '언더바'를 사용한다.
        // 주로 프로그램에서 코드의 가독성을 높여주는 역할을 한다.
        final double PI = 3.14; // 상수 선언과 동시에 초기화
        System.out.println("PI=" + PI);

//        PI = 3.141592; // 에러발생. 상수는 한번 초기화 되면 변경할 수 없다.

        final String NiCK_NAME;
//        System.out.println("we" + NiCK_NAME); // 에러 발생 초기화가 안된 상태에서는 사용할 수 없다.
        NiCK_NAME = "개발자"; // 하지만 초기화가 안된 상태 반드시 초기화 이후 사용해야한다.
        System.out.println("we" + NiCK_NAME);

        final int SCISSOR = 1;
        final int ROCK = 2;
        final int PARER = 3;

        int computer, user;

        computer = 1;
        user = 3;
        System.out.println("win com");


        computer = SCISSOR;
        user = PARER; // PARER와 같은 단어는 누가 보더라도 이해할 수 있으므로 가독성이 높은 명시적인 코드라 할 수 있다.
        System.out.println("com win");

    }
}
