package ex04controlstatement;

public class QuPyramid02 {
    public static void main(String[] args) {
//      문제3). 다음과 같은 모양을 출력하는 프로그램을 do~while문으로 작성하시오.
        // do-while
        int count = 4;
        do {
            for (int i = 0; i <= count; i ++) {
                System.out.print('*');
            }
            System.out.println();
            count--;
        } while (count >= 0);

    }
}
