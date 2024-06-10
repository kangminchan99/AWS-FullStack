package quiz;

public class QuUpgradeGuGu {
    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++) {
            System.out.print(i + "X" + "1" + "=");
            System.out.println(i * 1);
            int sum = i * 1;
            for (int j = 2; j <= 9; j++) {
                for (int q = 1; q <= j; q++){
                    if (q != j) {
                        System.out.print(i + "X");
                    } else {
                        System.out.print(i);
                    }
                }
                System.out.print("=");
                sum *= i;
                System.out.print(sum);
                System.out.println();
            }

        }
    }
}
