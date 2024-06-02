package ex04controlstatement;

public class QuPyramid01 {
    public static void main(String[] args) {
//      문제2) 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
        int count = 0;
        while (count <= 4) {
            for (int i = 0; i <= count; i ++) {
                System.out.print('*');
            }
            System.out.println();
            count++;
        }

    }
}
