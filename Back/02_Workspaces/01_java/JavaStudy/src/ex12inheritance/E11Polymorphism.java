package ex12inheritance;

class Parent {
    int parentMember; // 부모 클래스의 멤버 변수

    // 부모 클래스의 멤버 메서드
    void parentMethod() {
        System.out.println("parent Method()");
    }
}

class Child extends Parent {
    int childMember; // 자식 클래스의 멤버 변수

    // 자식 클래스의 멤버 메서드
    void childMethod() {
        System.out.println("child Method()");
    }


    // 부모클래스를 오버라이딩
    @Override
    void parentMethod() {
        System.out.println("자식에서 overriding한 메소드" + "parentMethod()");
    }

    // 부모클래스의 메서드 오버로딩
    void parentMethod(int childMember) {
        this.childMember = childMember;
        System.out.println("오버로딩: 자식에서 확장한 메소드" + " parentMethod(int childMember)");
    }
}
public class E11Polymorphism {
    public static void main(String[] args) {
        System.out.println("자식으로 자식객체 참조 - 동질화");
        Child child = new Child();
        child.childMember = 10;
        child.parentMember = 100;
        child.childMethod();
        child.parentMethod(1000);
        child.parentMethod();


        System.out.println("부모로 자식객체 참조 - 이질화");
        // 자식 객체를 부모 클래스의 참조변수로 참조
        Parent parent1 = child;
        parent1.parentMember = 1;
//        parent1.childMember = 1;
        parent1.parentMethod();

        Parent parent2 = new Child();
        // 다운 캐스팅을 통해서 자식 클래스의 멤버 변수를 참조
        ((Child) parent2).childMember = 1;
        ((Child) parent2).childMethod();
        ((Child) parent2).parentMethod();

        Child child2 = (Child) parent2;
        child2.childMember = 1;
        child2.childMethod();
        child2.parentMethod(1);

        System.out.println("클래스의 끝판왕 오브젝트");

        //Object 클래스는 Java의 모든 클래스의 최상위 클래스입니다.
        // 모든 클래스는 자동으로 Object 클래스를 상속받습니다.
        // 따라서 Java에서 모든 객체는 Object 클래스의 메서드를 사용할 수 있습니다.
        Object object = new Child();
        ((Parent) object).parentMethod();


    }
}
