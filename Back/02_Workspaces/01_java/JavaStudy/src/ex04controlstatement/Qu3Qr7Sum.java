package ex04controlstatement;

public class Qu3Qr7Sum {

//    문제1) 1~100까지의 숫자중 3의배수 이거나 7의배수인 숫자의 합을 구하는 프로그램을 while, do~while, for문으로 각각 작성하시오. 단, 3과 7의 공배수인 경우 합에서 제외해야 한다. 출력의 결과는 누적되는 모든 수를 콘솔에 print한다.
//    하나의 파일에 한꺼번에 작성하므로 동일한 결과가 3번 출력됩니다.
    public static void main(String[] args) {
        // #1. for
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if ((i % 3 == 0 || i % 7 ==0) && i % 21 != 0 ) {
                sum += i;
            }
        }
        System.out.println(sum);

        // #2. while
        int count = 0;
        int sum1 = 0;
        while (count <= 100) {
            if ((count % 3 == 0 || count % 7 == 0) && count % 21 != 0) {
                sum1 += count;
            }
            count++;
        }
        System.out.println(sum1);

        // #3. do-while
        int count1 = 0;
        int sum2 = 0;
        do {
            if ((count1 % 3 == 0 || count1 % 7 == 0) && count1 % 21 != 0) {
                sum2 += count1;
            }
            count1++;
        } while (count1 <= 100);
        System.out.println(sum2);
    }
}
