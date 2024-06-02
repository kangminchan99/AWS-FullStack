package ex04controlstatement;

public class QuPyramid03 {
    public static void main(String[] args) {
//      문제4) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
        int star = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j > i; j --) {
                System.out.print(" ");
            }
            for (int k = 0; k < star; k++) {
                System.out.print("*");
            }
            star += 2;
            System.out.println();
        }

    }
}
