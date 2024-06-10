package ex12inheritance;


/*
다형성(Polymorphism)
: 하나의 인스턴스(객체)를 여러 타입의 참조변수를 통해 참조할 때 참조 변수의 타입에 따라 다양한 형태의
인스턴스를 이용할 수 있는 특성을 말한다.
- 부모 타입의 참조 변수로 자식 인스턴스를 참조
1. 이경우 부모 타입의 참조 변수는 부모로부터 상속받은 멤버 까지만 접근할 수 있다.
2. 자식에서 오버라이딩 한 메서드가 우선적으로 호출된다.
3. 자식에서 새롭게 확장한 멤버는 접근할 수 없다.
4. 이것을 이질화(Heterogeneous: 헤테로 지니어스)라고 표현한다.
- 동일한 타입의 참조변수로 인스턴스를 참조
1. 인스턴스 전체에 접근할 수 있다. 즉 클래스의 일반적인 규칙을 따른다.
2. 이것을 동질화(Homogeneous: 호모 지니어스)라고 표현한다.
 */
// 부모 클래스
class Parent {
    int parentMember; // 부모 클래스의 멤버 변수

    // 부모 클래스의 멤버 메서드
    void parentMethod() {
        System.out.println("parent Method()");
    }
}
// 자식 클래스
class Child extends Parent {
    // 자식에서 확장한 멤버 변수
    int childMember;

    // 자식 클래스에서 확장한 멤버 메서드
    void childMethod() {
        System.out.println("child Method()");
    }


    // 부모에서 정의한 메서드를 오버라이딩해서 재정의
    @Override
    void parentMethod() {
        System.out.println("자식에서 overriding한 메소드" + "parentMethod()");
    }

    // 메서드 명은 동일하지만 파라미터가 다르므로 오버로딩한 메서드임. 따라서
    // 자식에서 확장한 멤버 메서드가 된다.
    void parentMethod(int childMember) {
        this.childMember = childMember;
        System.out.println("오버로딩: 자식에서 확장한 메소드" + " parentMethod(int childMember)");
    }
}
public class E11Polymorphism {
    public static void main(String[] args) {
        System.out.println("자식으로 자식객체 참조 - 동질화");
        // 동질화: 참조변수와 인스턴스 타입이 동일
        Child child = new Child();
        // 동질화의 경우 인스턴스 전체 멤버에 접근할 수 있다.
        child.childMember = 10;
        child.parentMember = 100;
        child.childMethod();
        // 오버로딩 한 메서드(확장한 멤버)
        child.parentMethod(1000);
        // 오버라이딩 해서 재정의 한 메서드 (자식쪽의 메서드가 호출됨)
        child.parentMethod();

        System.out.println("부모로 자식객체 참조 - 이질화");
        /*
        이질화: 부모타입의 참조 변수로 자식 인스턴스를 참조하는 것을 말한다.
        이 경우 자식클래스에서 새롭게 정의한 멤버는 접근이 불가
        만약 접근해야 한다면 자식 타입으로 강제형변환(다운캐스팅)을 해야한다.
         */
        // 자식 객체를 부모 클래스의 참조변수로 참조
        Parent parent1 = child;
        // 부모 쪽 멤버 변수
        parent1.parentMember = 1;
        // 부모타입으로 자식 인스턴스에 접근할 수 없으므로 에러 발생
//        parent1.childMember = 1;

        // 오버라이딩 한 메서드이므로 자식쪽으로 호출된다. 그이유는 참조변수의 영향을 받지 않으므로
        // 부모쪽을 타고 자식 쪽으로 호출이 되는 것임.
        parent1.parentMethod();


        // 부모 참조 변수로 자식 인스턴스를 참조한 두번째 변수 생성
        Parent parent2 = new Child();

        // 다운 캐스팅을 통해서 자식 클래스의 멤버 변수를 참조
        // 부모의 참조변수로 접근하려면 아래와 같이 다운 캐스팅을 통해 강제 형 변환을 해야한다. 소괄호를
        // 이용하여 우선순위에 대한 부분을 처리해야 에러가 발생하지 않는다.
        ((Child) parent2).childMember = 1;
        ((Child) parent2).childMethod();
        ((Child) parent2).parentMethod();

        /*
        자식 타입으로 형변환 이후에 해당 참조 변수를 통해 자식 멤버에 접근한다. 위와 동일한 방식이다.
         */
        Child child2 = (Child) parent2;
        child2.childMember = 1;
        child2.childMethod();
        child2.parentMethod(1);

        System.out.println("클래스의 끝판왕 오브젝트");

        //Object 클래스는 Java의 모든 클래스의 최상위 클래스입니다.
        // 모든 클래스는 자동으로 Object 클래스를 상속받습니다.
        // 따라서 Java에서 모든 객체는 Object 클래스의 메서드를 사용할 수 있습니다.

        /*
        Java에서 생성한 모든 클래스는 Object 클래스를 상속한다.
        따라서 모든 인스턴스는 Object의 참조변수로 참조가 가능하다.
        또한 Object클래스에 정의된 모든 메서드를 별도의 처리없이 사용할 수 있고,
        필요하다면 오버라이딩도 할 수 있다.
         */
        Object object = new Child();
        ((Parent) object).parentMethod();


    }
}
