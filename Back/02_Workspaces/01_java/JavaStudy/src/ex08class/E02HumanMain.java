package ex08class;

public class E02HumanMain {
    public static void main(String[] args) {


        /*
        클래스를 통해 인스턴스를 생성한다. 참조변수는 스택영역에 인스턴스는 힙 영역에 생성된다.
         */
        Human human = new Human();

        /*
        2. 인스턴스 초기화: 참조변수를 통해 .(dot)으로 접근할 수 있다. 여기서 멤버변수의 초기값을 할당한다.
         */
        human.name = "minchan";
        human.age = 28;
        human.energy = 4;


        /*
        멤버 메서드를 호출한다. 이를 통해 동작 실행
         */
        human.showState();
        human.eating();
        human.walking();
        human.thinking();
        human.showState();


        for(int i = 1; i <= 20; i++) {
            human.walking();
        }
        human.showState();

        for(int i = 1; i <= 20; i++) {
            human.eating();
        }
        human.showState();
    }
}
