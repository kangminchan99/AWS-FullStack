package ex04controlstatement;

public class E03While {
    public static void main(String[] args) {
        int i = 1;
        while(i<=10) {
            System.out.println("var i = " + i);
            i++;
        }
        int sum = 0;
        int j = 1;
        while (j <= 10) {
            sum += j;
            j++;
        }
        System.out.println("1 ~ 10 sum=" + sum);

        int total = 0;
        int k = 1;

        while (k <= 100) {

            if (k % 3 == 0 || k % 4 == 0) {
                total += k;

                System.out.println("k = "+ k);
            }
            k++;
        }
        System.out.println("3 또는 4의 배수의 합: "+ total);

        int dan = 2;
        while (dan <= 9) {
            int su = 1;
            while (su <= 9) {
                System.out.printf("%-2d * %-2d = %2d", dan, su, (dan * su));
                // 각 곱셈 사이에 공백을 넣기 위함
                System.out.print(" ");
                su++;
            }
            System.out.println();
            dan++;
        }
        System.out.println("\n======================================================================================================================\n");

        int x = 1;
        while (x<=4) {
            int y = 1;
            while (y<=4) {
                if (x==y) {
                    System.out.print("1 ");
                }
                else {
                    System.out.print("0 ");
                }
                y++;
            }
            System.out.println();
            x++;
        }
    }
}
