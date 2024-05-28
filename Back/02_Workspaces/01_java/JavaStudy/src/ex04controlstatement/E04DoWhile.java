package ex04controlstatement;

import java.io.IOException;
import java.util.Scanner;

public class E04DoWhile {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        int i = 1;
        // 무조건 한번은 실행 됨
        do {
            sum += i;
            i++;
        } while (i <= 10);
        System.out.println("1~10 sum" + sum);

        int total = 0;
        int j = 1;
        do {
            if (j % 4 == 0 || j % 7 == 0){
                total += j;
            }
            j++;
        } while (j <= 1000);
        System.out.println("1 ~ 1000사이의 4 와 7의 배수 합" + sum);

        Scanner scanner = new Scanner(System.in);
        int kor, eng, math, avg;
        int exitCode;
        do {
            System.out.println("kor:");
            kor = scanner.nextInt();
            System.out.println("eng:");
            eng = scanner.nextInt();
            System.out.println("math:");
            math = scanner.nextInt();

            avg = (kor + eng + math) / (3 * 10);
            switch (avg) {
                case 10: case 9:
                    System.out.println("A"); break;
                    case 8:
                    System.out.println("B"); break;
                    case 7:
                    System.out.println("C"); break;
                    case 6:
                    System.out.println("D"); break;
                default:
                    System.out.println("F");
            }
            System.out.println("exit press x or X");
            System.out.println("exit press any key");
            // add - throws IOException
            exitCode = System.in.read();
        } while (!(exitCode == 'x' || exitCode =='X'));
    }
}
