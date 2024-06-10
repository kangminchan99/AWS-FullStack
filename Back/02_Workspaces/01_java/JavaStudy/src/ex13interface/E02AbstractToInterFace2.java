package ex13interface;


/*
추상 클래스를 인터페이스로 변경하기
    abstract class => interface
    멤버 메서드인 경우 public abstract을 제거한다.
    멤버 변수인 경우 public static final을 제거한다
 */
interface IPersonalNumberStorage {
    // 정보를 저장하는 기능의 추상 메서드
    void addPersonalInfo(String juminNum, String name);
    // 저장된 정보를 검색하는 기능의 추상메서드
    String searchPersonalInfo(String juminNum);
}


/*
VO(Value Object): 값만 저장할 수 있는 객체라는 뜻으로 데이터 저장용 클래스를 만들 때 사용한다. DTO와 비슷한 의미로 사용된다.
 */
class PersonalInfoVO {
    // 이름과 주민번호를 멤버 변수로 선언
    private String name;
    private String juminNum;

    // 생성자
    public PersonalInfoVO(String name, String juminNum) {
        super();
        this.name = name;
        this.juminNum = juminNum;
    }

    // getter/setter 메서드 정의: private으로 정의된 멤버 변수를 설정하거나 값을 반환받기 위해 생성함.
    public String getName() {return name;}
    public String getJuminNum() {return juminNum;}

    public void setName(String name) {this.name = name;}
    public void setJuminNum(String juminNum) {this.juminNum = juminNum;}

}


/*
클래스가 클래스 상속할때 => extends
클래스가 인터페이스를 상속할때 => implements
매우 드물지만 인터페이스가 인터페이스를 상속할때 => extends
extends는 '상속'이라 표현하고, implements는 '구현'이라고 표현한다.
 */
class PersonalNumberStorageImpl implements IPersonalNumberStorage {
    /*
    멤버 변수: 2명이상의 정보를 저장해야 하므로 DTO 타입의 배열을 선언.
    또한 인덱스 카운트를 위한 변수 선언
     */
    PersonalInfoVO[] personalArr;
    int numOfPerIInfo;

    // 생성자 메서드
    public PersonalNumberStorageImpl(int arrSize) {
        // 배열 타입의 인스턴스 생성.
        personalArr = new PersonalInfoVO[arrSize];
        // 카운트용 변수는 0으로 초기화
        numOfPerIInfo = 0;
    }

    /*
    추상 메서드를 오버라이딩한 후 재정의한다.
    주민번호와 이름을 매개변수로 받은 후 DTO인스턴스를 배열에 추가한다.
     */
    @Override
    public void addPersonalInfo(String juminNum, String name) {
        personalArr[numOfPerIInfo] = new PersonalInfoVO(name, juminNum);
        numOfPerIInfo++;
    }

    @Override
    public String searchPersonalInfo(String juminNum) {
        // 배열에 저장된 인스턴스의 갯수만큼 반복
        for (int i = 0; i < numOfPerIInfo; i++) {
            // 매개변수로 전달된 주민번호를 통해 배열 검색
            if (juminNum.compareTo(personalArr[i].getJuminNum()) == 0) {
                // 일치하는 정보가 있는 경우 이름을 출력
                return personalArr[i].getName();
            }
        }
        // 일치하는 정보가 없는 경우 null 반환
        return null;
    }
}
public class E02AbstractToInterFace2 {
    public static void main(String[] args) {
        // 인스턴스 생성 10명의 정보 저장이 가능한 인스턴스 배열 생성
        PersonalNumberStorageImpl storage = new PersonalNumberStorageImpl(10);

        // 2명의 정보를 추가
        storage.addPersonalInfo("991231-123123", "minchan");
        storage.addPersonalInfo("991231-221321", "yeji");

        // 정보 검색
        System.out.println(storage.searchPersonalInfo("991231-123123"));
        System.out.println(storage.searchPersonalInfo("991231-221321"));
        // 일치하는 정보가 없어 null출력됨
        System.out.println(storage.searchPersonalInfo("000000-123213"));
    }
}
