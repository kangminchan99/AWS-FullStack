package ex06array;

import java.util.Random;

public class E01OneDimArray02 {
    public static void main(String[] args) {
        /*
        난수 생성 방법1
        Math클래스의 random() 메서드는 0 ~ 1 사이의 실수를 랜덤하게 반환해준다.
        정수형태의 난수가 필요하다면 10이나 100과 같은 정수를 곱한 후 필요한 데이터를 만들어준다.
         */
        double rndNum = Math.random();
        System.out.println("실수 랜덤" +rndNum);
        // 정수와 실수를 연산하면 실수가 반환되므로 int로 강제 형변환
        int intNum = (int)(Math.random() * 100);
        System.out.println("정수 랜덤" + intNum);

        /*
        난수 생성 방법2
        random 클래스를 사용한다. 사용법은 스캐너와 동일하게
        정수형 난수를 생성하고 싶다면 nextInt()를 사용한다.
         */
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println("=====");

        // 원하는 구간 내의 난수 생성 1 ~45 사이의 난수를 생성하는 방법
        // 45로 % 연산하여 나머지를 구한다. 정수를 45로 나누면 나머지는 0 ~ 44가 되므로 1을 더해주면 1 ~ 45 까지의 난수가 생성된다.
        System.out.println(((int)(Math.random() * 100) % 45) + 1) ;

        // 크기가 6인 배열을 생성하고 난수를 저장한 후 출력한다. 중복된 난수가 생성될 수 있고 정렬또한 되지 않는다. 이부분은 컬렉션에서 다룬다.
        int[] lottoNum = new int[6];
        // 난수 생성 후 배열에 순서대로 입력
        for (int i = 0; i < lottoNum.length; i++) {
            lottoNum[i] = (int)((Math.random() * 100) % 45) + 1;
        }
        // 순서대로 출력
        for (int i = 0; i < lottoNum.length; i++) {
            System.out.printf("%d ", lottoNum[i]);
        }
    }
}
