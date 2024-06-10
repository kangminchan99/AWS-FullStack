package ex13interface;


/*
프로젝트 전체에서 기준 역할을 하는 추상 클래스.
해당 클래스에는 추상 메서드를 포함하고 있으므로 하위에서 상속받으면 반드시 추상메서드를
오버라이딩 해야한다.
 */
abstract class PersonalNumberStorageAbs {
    // 정보를 저장하는 기능의 추상 메서드
    public abstract void addPersonalInfo(String juminNum, String name);
    // 저장된 정보를 검색하는 기능의 추상메서드
    public abstract String searchPersonalInfo(String juminNum);
}

/*
DTO(Data Transfer Object): 데이터를 저장하고 전송하기 위한 용도의 객체를 말한다.
VO(Value Object)로 표현하기도 한다. 해당 프로그램에서는 이름과 주민번호를 저장하는 용도로 사용된다.
 */
class PersonalInfoDTO {
    // 이름과 주민번호를 멤버 변수로 선언
    private String name;
    private String juminNum;

    // 생성자
    public PersonalInfoDTO(String name, String juminNum) {
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

// 추상 클래스를 상속하여 정보 저장과 검색 기능을 구현한 클래스
class PersonalNumberStorageExt extends PersonalNumberStorageAbs {
    /*
    멤버 변수: 2명이상의 정보를 저장해야 하므로 DTO 타입의 배열을 선언.
    또한 인덱스 카운트를 위한 변수 선언
     */
    PersonalInfoDTO[] personalArr;
    int numOfPerIInfo;

    // 생성자 메서드
    public PersonalNumberStorageExt(int arrSize) {
        // 배열 타입의 인스턴스 생성.
        personalArr = new PersonalInfoDTO[arrSize];
        // 카운트용 변수는 0으로 초기화
        numOfPerIInfo = 0;
    }

    /*
    추상 메서드를 오버라이딩한 후 재정의한다.
    주민번호와 이름을 매개변수로 받은 후 DTO인스턴스를 배열에 추가한다.
     */
    @Override
    public void addPersonalInfo(String juminNum, String name) {
        personalArr[numOfPerIInfo] = new PersonalInfoDTO(name, juminNum);
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
public class E02AbstractToInterFace1 {
    public static void main(String[] args) {
        // 인스턴스 생성 10명의 정보 저장이 가능한 인스턴스 배열 생성
        PersonalNumberStorageExt storageExt = new PersonalNumberStorageExt(10);

        // 2명의 정보를 추가
        storageExt.addPersonalInfo("991231-123123", "minchan");
        storageExt.addPersonalInfo("991231-221321", "yeji");

        // 정보 검색
        System.out.println(storageExt.searchPersonalInfo("991231-123123"));
        System.out.println(storageExt.searchPersonalInfo("991231-221321"));
        // 일치하는 정보가 없어 null출력됨
        System.out.println(storageExt.searchPersonalInfo("000000-123213"));
    }
}
