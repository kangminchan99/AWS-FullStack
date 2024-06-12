package ex15usefulclass;

/*
equals() 메소드
- 자바에서 인스턴스의 내용 비교를 위해 비교 연산자(==)를 사용하는 것은
단순히 참조값에 대한 비교를 하는것이므로, 실제 내용에 대한 비교가 이루어지지 않는다.
- 인스턴스간의 내용 비교를 위해서는 equals()를 각 클래스에 맞게 오버라이딩 하여 사용해야한다.
- String과 같은 기본 클래스는 별도의 오버라이딩 없이도 내용 비교가 가능하다.
 */
class IntNumber {
    int num;
    public IntNumber(int num) {
        this.num = num;
    }

    /*
    equals() 메서드가 어떻게 인스턴스간의 내용을 비교하는지 설명하기 위한 메서드를 정의
     */

    // 비교를 위해 IntNumber 타입의 인스턴스를 매개변수로 받은 후..
    public boolean myEquals(IntNumber numObj) {
        // 전달된 인스턴스의 멤버 변수와 값을 비교하여..
        if (this.num == numObj.num) {
            // 값이 동일하면 true
            return true;
        } else {
            return false;
        }
    }
}
public class E04Object2MyEquals {
    public static void main(String[] args) {
        /*
        String과 같은 기본 클래스는 별도의 오버라이딩 없이도
        내용 비교가 가능하다.
         */
        String str1 = new String("java");
        String str2 = "java";
        if (str1.equals(str2)) {
            System.out.println("same");
        } else {
            System.out.println("diff");
        }

        // 정의한 클래스를 통해 인스턴스를 생성
        IntNumber num1 = new IntNumber(10);
        IntNumber num2 = new IntNumber(20);
        IntNumber num3 = new IntNumber(10);

        /*
        개발자가 직접 정의한 myEquals() 메서드를 통해 인스턴스간의 내용을 비교
         */
        if (num1.myEquals(num2)) {
            System.out.println("num1, num2 same int");
        } else {
            System.out.println("num1, num2 diff int");
        }

        /*
        인스턴스간의 비교를 할때는 단순히 참조변수에 대한 비교를 하면 안되고, 실제 내용에 대한 비교를 해야한다.
         */
        if (num1.myEquals(num3)) {
            System.out.println("num1, num3 same int");
        } else {
            System.out.println("num1, num3 diff int");
        }
    }
}
