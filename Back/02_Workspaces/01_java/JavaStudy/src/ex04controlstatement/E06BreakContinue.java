package ex04controlstatement;

public class E06BreakContinue {
    public static void main(String[] args) {
        int i = 0;
        // 무한루프
        while(true) {
            /*

             */
            i++;
            System.out.printf("i가 %d일때\n", i);

            System.out.println("continue이전 출력문");
            if (i%2==0) continue;
            System.out.println("continue이후 출력문");
            System.out.println("break이전 출력문");
            if (i == 3) break;
            System.out.println("break이후 출력문");
        }
        /*
        중첩된 반복문 안에서 break를 만나면 가장 가까운 반복문 하나만 탈출한다. 반복문 전체를 탈출하는것이 아니므로 주의해야한다.
         */
        for (int x = 1; x <=5; x++){
            System.out.println("x=" + x);
            for (int y = 1; y <=5; y++){
                System.out.println("y=" + y);
                if (y == 3)
                    break;
            }
        }
    }
}
