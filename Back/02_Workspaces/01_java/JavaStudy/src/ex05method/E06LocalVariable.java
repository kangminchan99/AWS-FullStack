package ex05method;


// 지역변수
// 변수는 사용범위를 가지고 있고, 해당 지역에서만 사용할 수 있다.
// 해당 지역을 벗어나면 즉시 메모리에서 소멸된다.
// 기본 자료형은 스택이라는 메모리를 사용한다.
// 스택은 입구가 하나만 있는 컵과 같은 형태이며, 선입후출의 특성을 가진다.
// 또한 스택은 cpu가 메모리의 생성 및 소멸을 주관한다.
public class E06LocalVariable {
    public static void main(String[] args) {
        boolean scope = true;
//
//        int num = 9; // 메인 지역에 num 선언 시 if문 안에서는 같은 이름의 변수 선운 불가.

        // if문과 else문은 서로 다른 지역이므로 동일한 이름의 변수를 선언할 수 있다.
        if(scope) {
            int num = 1;
            num++;
            System.out.println("if문 첫번째 지역" + num);
        }
        else {
            int num = 5;
            System.out.println("첫번째 if문의 else지역" + num);
        }
        /*
        if문의 블럭에서 선언된 변수 num은 해당 블럭을 벗어나는 순간 메모리에서 소멸되므로 아래에서 num을 새롭게 선언할 수 있다.
         */
        int num = 100;
        System.out.println("main method 지역" + num);

        simpleFunc();
        System.out.println("main method end");
    }

    // 메인 지역에서 선언한 변수 num은 메모리에 아직 상주하고 있지만 해당 메서드는
    // 크기가 동일한 다른 지역에 정의되었으므로 같은 이름의 변수를 선언할 수 있다.
    // 앞의 main메서드의 if~else문의 블럭도 같은 개념으로 변수를 선언한 것이다.
    static void simpleFunc() {
        int num = 1000;
        System.out.println("simple메소드 지역" + num) ;
    }
}
