package ex12inheritance;

public class E07RideAndLoad2 {
    public static void main(String[] args) {
        System.out.println("child형 참조변수로 child객체 참조");
        DeChild deChild = new DeChild("minchan", 26, "12학번");

        deChild.exercise();
        deChild.sleep();
        deChild.printParent();

        deChild.study();
        deChild.walk();
        deChild.walk(25);

        DeChild.staticMethod();

        System.out.println("parent형 참조변수로 child객체 참조");
        DeParent deParent = new DeChild("yeji", 22, "16학번");

        deParent.exercise();
        deParent.sleep();
        deParent.printParent();

//        deParent.study();
        deParent.walk();
//        deParent.walk(20);

//      일반적으로 static 메서드는 클래스 이름으로 호출
        DeParent.staticMethod();

    }

}
