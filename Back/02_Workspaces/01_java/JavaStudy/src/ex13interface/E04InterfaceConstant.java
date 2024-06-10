package ex13interface;


import java.util.Scanner;


/*
인터페이스에 변수를 정의하면 무조건 상수가 되므로
주로 "인터페이스형 상수"라고 표현한다. 주로 프로그램에서의
설정값이나 명시적인 코드를 위해 사용된다.
 */

/*
해당 인터페이스의 접근 지정자는 default이므로 해당 패키지를 벗어나면 사용할 수 없게 된다.
프로젝트 전체에서 사용하고 싶다면 별도의 파일로 생성하여 public으로 만들어야 한다.
 */
//interface Game {
//    int SCISSORS = 1, ROCK = 2, PAPER = 3;
//}

public class E04InterfaceConstant {

    public static void main(String[] args) {
        System.out.println("가위(1), 바위(2), 보(3)");
        System.out.print("선택하세요");

        Scanner scanner = new Scanner(System.in);
        int sel = scanner.nextInt();

        /*
        가위 바위 보를 1,2,3으로 설정했지만 설정값이 많은 경우 모두 기억하기 힘들 수 있으므로 명시적인 단어를 통한
        상수를 사용하면 코드의 가독성이 높아진다.
         */
        switch (sel) {
            case Game.SCISSORS:
                System.out.println("SCISSORS");
                break;
            case Game.PAPER:
                System.out.println("PAPER");
                break;
            case Game.ROCK:
                System.out.println("ROCK");
                break;
            default:
                System.out.println("error");
        }
    }
}
