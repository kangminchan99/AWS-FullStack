package ex14innerclass;

/*
내부 클래스(Inner class)
: 클래스 내부에 정의된 클래스로 static 멤버가 없는 클래스를 말한다.
- 외부 클래스의 모든 멤버(정적 혹은 인스턴스형)를 사용할 수 있다.
- 정적 멤버를 가질 수 없다. 단 상수는 가질 수 있다.
- 컴파일 시 외부 클래스명$내부클래스명.class 파일이 생성된다.
- 이벤트 기반의 프로그래밍에서 많이 사용된다.
 */

// 외부클래스 정의
class Unit {
    // 멤버 변수
    private String name;
    private int healthPoint;

    // 인스턴스형 멤버 변수: new를 통해 인스턴스를 생성해야한다.
    Marine marine;
    Medic medic;

    public Unit(String name, int healthPoint){
        this.name = name;
        this.healthPoint = healthPoint;
        // 인스턴스형 멤버 변수 및 초기화
        marine = new Marine();
        // Medic 인스턴스 생성은 주석으로 처리하고 외부에서 처리한다.
//        medic = new Medic();
    }

    // 멤버 변수의 정보를 문자열로 반환
    public String infoStr() {
        return "유닛정보[이름:" + name +" 체력:" + healthPoint + "]";
    }

    // 내부 클래스 (내부 멤버 클래스) 정의
    class Marine {
        // 내부 클래스도 일반 클래스와 동일하게 멤버를 정의할 수 있다.
        int attackPower;
        /*
        내부 클래스에서는 외부 클래스의 모든 멤버에 접근할 수 있다.
        외부 클래스가 더 넓은 지역이기 때문이다.
         */
        public void attack(){
            System.out.println(infoStr() + "\n 마린이 공격");
        }
    }

    class Medic {
        int healthPower;
        public void heal() {
            System.out.println(infoStr() + "\n 메딕이 치료");
        }
    }
}


public class E01InnerClassMain {
    public static void main(String[] args) {
        // 외부 클래스의 인스턴스를 먼저 생성한다.
        Unit unit = new Unit("커멘드 센터", 1000);
        System.out.println(unit.infoStr());

        /*
        외부 클래스가 아닌 다른 클래스에서는 내부 멤버 클래스가 보이지 않으므로 직접 인스턴스를 생성할 수 없다.
         */
//        Marine m = new Unit.Marine(); => 에러 발생

        /*
        외부 클래스의 인스턴스를 먼저 생성한 후 내부 클래스의 인스턴스를 생성해야한다.
        Marine은 Unit클래스의 생성자에서 이미 인스턴스 생성이 되었으므로 아래와 같이 사용할 수 있다.
         */
        Unit.Marine marine = new Unit("marine", 50).marine;
        marine.attack();

        /*
        Medic의 경우 Unit의 생성자에서 인스턴스 생성이 되지 않았으므로
        아래와 같이 new를 통해 생성해야한다. 이때에도 Unit인스턴스를 통해 생성해야하므로 new를 두 번 사용한다.
         */
        Unit.Medic medic = new Unit("medic", 30).new Medic();
        medic.heal();
    }
}
