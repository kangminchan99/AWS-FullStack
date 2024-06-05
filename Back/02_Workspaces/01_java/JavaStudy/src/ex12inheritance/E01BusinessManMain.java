package ex12inheritance;


/*
상속(Inheritance): 기존에 정의된 클래스에 메서드와 변수를 추가하여 새로운 클래스를 정의하는것
부모클래스를 자식 클래스가 상속할때는 extends 키워드를 사용한다.
 */

// 부모(상위) 클래스: 일반적인 사람을 추상화
class Man {
    // 멤버변수는 private이므로 클래스 내부에서만 접근할 수 있다.
    private String name;

    // 생성자: 오버로딩으로 2개를 정의
    public Man() {
        System.out.println("Man클래스의 디폴트 생성자 호출");
    }

    public Man(String name) {
        this.name = name;
        System.out.println("Man클래스 인자 생성자 호출됨");
    }

    /*
    멤버 메서드에서는 private멤버라도 동일 클래스 내부이므로 접근이 가능하다.
     */
    public void tellYourName() {
        System.out.println("내이름은" + name);
    }

}


// 자식(하위) 클래스: Man클래스를 상속받아 회사원을 추상화한다.
class BusinessMan extends Man {
    // 멤버 변수로 회사명, 직급 선언
    private String company;
    private String position;

    /*
    상속받은 자식클래스는 부모 클래스의 생성자를 호출하여 부모 인스턴스가 메모리에 먼저 생성되도록 해야한다. super()는 부모 클래스의
    생성자를 호출한다. 만약 super()를 기술하지 않으면 컴파일러에 의해 자동으로 삽입되어 디폴트 생성자가 호출된다.
     */
    public BusinessMan(String name, String company, String position){
        /*
        부모 클래스의 매개변수 1개인 생성자를 호출한다.
        남은 2개의 매개변수로 자식쪽 멤버변수를 초기화한다.
         */
        super(name);
        this.company = company;
        this.position = position;
        System.out.println("비즈니스 생성자 호출");
    }

    public void tellYourInfo() {
        // 자식클래스의 멤버이므로 접근할 수 있다.
        System.out.println("회사명은" + company);
        System.out.println("직급" + position);
        // 부모클래스의 멤버변수 name은 private로 선언 되었으므로 상속받은 자식 클래스에서는 접근할 수 없다.
        // private멤버는 무조건 클래스 내부에서만 접근할 수 있다.
//        System.out.println("이름" + name); -> 에러 발생

        /*
        부모 클래스에 public으로 선언된 메서드를 통해 간접적으로 접근하여 사용할 수 있다.
         */
        tellYourName();
    }
}

public class E01BusinessManMain extends Man{
    public static void main(String[] args) {
        /*
        자식클래스를 통해 2개의 인스턴스를 생성한다.
         */
        BusinessMan man1 = new BusinessMan("김천국", "naver", "팀장");
        BusinessMan man2 = new BusinessMan("김민국", "daum", "부장");


        // 회사 정보와 이름을 출력한다.
        man1.tellYourInfo();
        // 이름만 출력한다.
        man1.tellYourName();

        man2.tellYourInfo();
        man2.tellYourName();
    }
}
