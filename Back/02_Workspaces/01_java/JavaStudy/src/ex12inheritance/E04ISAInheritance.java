package ex12inheritance;

/*
Is-A관계
: X is a Y => X는 Y의 일종이다로 표현가능한 관계
-노트북은 컴퓨터의 일종이다.
-휴대폰은 전화기의 일종이다.
이와같이 Is-A관계가 성립하는 객체를 상속으로 표현하기에 적합하다.
따라서 실제 업무에서도 유사한 기능의 클래스들을 묶어서 정의한다.
*/

// 컴퓨터: 기본적인 컴퓨팅 환경을 제공하여 입력된 내용을 계산
class Computer {
    // 멤버 변수: 컴퓨터의 소유주
    String owner;

    // 생성자
//    public Computer(){}

    /*
    private 접근 지정자로 선언된 멤버 메서드는 외부 클래스 혹은 상속받은 클래스에서 접근이 가능하므로, public으로 선언된
    메서드를 통해 간접적으로 호출해야한다.
     */
    public Computer(String name) {
        owner = name;
    }

    private void keyboardTouch() {
        System.out.println("키보드를 통해서 입력한");
    }
    private void calculate() {
        System.out.println("요청된 내용을 계산한다.");
    }
    /*
    private로 선언된 멤버 메서드를 외부에서 호출할 수 있도록
    public으로 지정하여 선언하였다.
    호출할 메서드의 순서까지 고려하여 "캡슐화"하고 있다.
     */
    public void calculateFunc() {
        keyboardTouch(); // 입력 후
        calculate(); // 계산을 수행한다.
    }
}

/*
컴퓨터를 상속한 노트북 컴퓨터
: 컴퓨터가 가진 기본 연산기능에 휴대성을 확장하여 정의한다.
노트북은 전원이 없어도 사용할 수 있어야 하므로 배터리를 추가하여 정의하였다.
 */
class NotebookComputer extends Computer {
    // 자식 클래스에 확장한 멤버 변수
    int battery;

    // 생성자
    public NotebookComputer(String name, int initCharge) {
        /*
        부모 클래스의 생성자를 호출하기 위해 사용하는 super()는 생략할 수 있지만,
        앞에 다른 문장이 먼저 기술되면 에러가 발생한다.
        또한 여기서는 부모 클래스에 디폴트 생성자가 없는 상태이므로 생략하는 즉시 에러가 발생한다.
         */
        super(name);
        battery = initCharge;
    }

    // 배터리 충전
    public void charging() {
        battery += 5;
    }

    // 휴대하면서 노트북을 사용하는것을 표현
    public void movigCal() {
        // 사용 전 배터리 잔량을 확인 후 사용 여부 판단
        if (battery < 1) {
            System.out.println("배터리 방전");
            return;
        }
        System.out.println("moving");

        /*
        아래 2개의 메서드는 private로 선언 되었으므로 상속을 받은 자식 클래스에서도 접근할 수 없어 에러가 발생한다.
        이 경우 public으로 선언된 메서드를 통해 호출해야한다.
         */
//        keyboardTouch();
//        calculate();
        calculateFunc();

        // 사용하면 배터리는 1씩 차감된다.
        battery -= 1;
    }
}

/*
테블릿 노트북: 컴퓨터의 기본 연산기능과, 휴대이용 그리고 전용펜으로 드로잉 할 수 있는 기능까지 추가된 컴퓨터
 */
class TabletNotebook extends NotebookComputer {
    String registPencil;
    public TabletNotebook(String name, int initCharge, String pen) {
        super(name, initCharge);
        registPencil = pen;
    }

    public void write(String penInfo) {
        if (battery < 1) {
            System.out.println("배터리 방전");
            /*
            메서드에서 아래와 같이 return을 만나게 되면 실행이 중지된다.
             */
            return;
        }

        // compareTo - 문자열 A와 B를 비교하여 0이 반환되면 동일한 문자열, 1이 반환되면 다른 문자열
        if (registPencil.compareTo(penInfo) != 0) {
            System.out.println("등록된 펜이 아님");
            return;
        }
        movigCal();
        System.out.println("스크린에 펜으로 그림 그린다");
        battery -= 1;
    }
}
public class E04ISAInheritance {

    public static void main(String[] args) {
        NotebookComputer notebookComputer = new NotebookComputer("minchan", 5);
        TabletNotebook tabletNotebook = new TabletNotebook("asmkl", 5, "ISE-1234");

        System.out.println("노트북 컴퓨터 사용");
        notebookComputer.movigCal();
        notebookComputer.movigCal();
        notebookComputer.movigCal();
        notebookComputer.movigCal();
        notebookComputer.movigCal();
        notebookComputer.movigCal();
        notebookComputer.movigCal();
        notebookComputer.movigCal();

        System.out.println("ISE-1234펜으로 테블릿 사용");
        tabletNotebook.write("ISE-1234");

        System.out.println("ISsE-1234펜으로 테블릿 사용");
        tabletNotebook.write("ISsE-1234");
    }
}
