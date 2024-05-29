package ex04controlstatement;

public class E05For {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++){
            System.out.println("i=" + i);
        }

        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum += i;
        }
        System.out.println(sum);

        int total = 0;
        // 2씩 증가 시킨다.
        for (int i = 0; i <= 10; i += 2) {
            total += i;
        }
        System.out.println(total);

        int total1 = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                total1 += i;
            }

        }
        System.out.println(total1);

        int a = 1;
        // while(true) == for문에서는 for(;;)
        for (;;) {
            System.out.println("무한루프");
            a++;
            System.out.println(a);
            if (a == 10) break;
        }
        // for문의 초기값을 외부에서 선언하면 해당 변수는 for문의 안쪽에서 사용할 수 있다.
        // 즉 아래에 선언한 변수i는 main의 지역변수로 선언된다.
        int i = 0;
        // 지역변수는 벗어나면 소멸됨
        for (; i<=5; i++) {
            System.out.println("in" + i);
        }
        System.out.println("out" + i);
        /*
        자바에서 중괄호가 나오면 하나의 지역이라 생각하면 된다.
        즉 if문, while문,등의 제어문도 하나의 지역을 형성하고 main도 마찬가지이다.
         */

        // 구구단 표
        for (int j = 2; j <= 9; j++){
            System.out.println("----------------------------------" + j + "단" + "--------------------------------");
            for (int k = 1; k <= 9; k++){
//                System.out.print(j + "*" + k + "=" + (j * k) );
                System.out.printf("%d * %d = %2d", j, k, j * k); // result를 2칸으로 만들어서 간격을 일정하게 맞춰준다.
                System.out.print("  ");

            }
            System.out.println("");
        }
    }
}
