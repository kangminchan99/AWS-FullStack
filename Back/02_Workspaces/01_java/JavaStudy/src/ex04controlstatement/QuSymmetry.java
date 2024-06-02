package ex04controlstatement;

public class QuSymmetry {
    public static void main(String[] args) {
        rotationSymmetry();
    }


    static void rotationSymmetry() {
        int cnt = 3;
        // for
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (cnt == j) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            cnt -= 1;
            System.out.println();
        }


        // while
        int[] demi = {1, 2, 4, 8};
        int index = 0;
        while (index < demi.length) {
            int number = demi[index];
            String binary = Integer.toBinaryString(number);
            String formatBinary = String.format("%4s", binary).replace(' ', '0');
            System.out.println(formatBinary);
            index++;
        }
    }
}
