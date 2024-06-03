package ex08class;


/*
생성자(Constructor)
클래스를 인스턴스화 할 때 자동으로 호출되는 메서드
자동으로 호출되며 개발자가 임의로 호출할 수 없다.
반환값이 없다. 따라서 선언 시 void를 사용하면 안된다.
생성자 내부에서 또다른 생성자를 호출할 수 있다.
오버로딩이 가능하다.
 */
public class PersonConstructor {
    // 멤버 변수 선언
    String name;
    int age;
    String addr;

    /*
    개발자가 생성자를 직접 정의하지 않으면 아래와 같이 매개변수와 실행부가 없는 '디폴트 생성자'가 컴파일러에 의해 자동으로
    삽입된다.
    지금까지 인스턴스 생성 시 new 클래스명()과 같이 사용했던 문장이 바로 디폴트 생성자를 호출하는 것이었다.
     */
//    public PersonConstructor() {} // 디폴트 생성자


    // 생성자1: 매개변수가 없는 형태로 정의
    public PersonConstructor() {
        // 매개변수가 없으므로 항상 고정된 값으로만 초기화
        name = "생성자 없음";
        age = 1;
        addr = "없음";
        System.out.println("나는 기본 생성자 입니다.");
    }

    public PersonConstructor(String name) {
        // 해당 this는 멤버 변수와 매개변수를 구분하기 위한 용도로 사용된다.
        // 클래스 자신, 즉 멤버를 가리킨다. 따라서 좌측항은 멤버 변수 우측항은 매개변수가 된다.
        this.name = name;
        age = 1;
        addr = "null";
        System.out.println("나는 인자 생성자[1] 입니다.");
    }

    public PersonConstructor(String name, int age) {
        // this()는 생성자에서 다른 생성자를 호출할 때 사용한다.
        // 단, 생성자 내에서만 사용할 수 있고 일반 멤버 메서드에서는 사용할 수 없다.
        // 즉, 아래는 매개변수가 3개인 생성자를 호출하는 문장이다.
        this(name, age, "null"); // 아래에 있는 PersonConstructor()가 파리미터가 3개이므로 아래와 연결됨
        System.out.println("나는 인자 생성자[2] 입니다.");
    }


    public PersonConstructor(String _name, int age, String addr) {
        // 매개변수와 멤버 변수명이 다르면 this를 사용하지 않아도 된다.
        name = _name;
        // 둘의 이름이 같을경우는 this사용 권고
        this.age = age;
        this.addr = addr;
        System.out.println("나는 인자 생성자[3] 입니다.");
    }



//  멤버 메서드: 멤버 변수를 초기화할 목적으로 정의
    void initialize(String name, int age, String addr) {
        /*
        해당 코드는 생성자 내에서만 사용할 수 있다. 생성자는 인스턴스 생성시 딱 한번만 호출되고
        개발자가 임의로 호출할 수 없다. 하지만 멤버 메서드는 개발자가 원할때 언제든 호출이 가능하므로
        생성자와는 특성이 다르다.
        따라서 멤버 메서드에서는 생성자를 호출할 수 없다.
         */
//        this(name, age, "null"); // => 에러 발생
        // 멤버 변수 구분을 위한 this는 멤버 메서드에서도 사용할 수 있다.
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    void showPersonInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.addr);
    }
}
