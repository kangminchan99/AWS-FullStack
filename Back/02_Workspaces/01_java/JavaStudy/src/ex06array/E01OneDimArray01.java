package ex06array;


/*
배열: 순차적인 메모리의 공간이 할당되는 형태로써 하나가 아니라 여러개의 변수가 필요한 경우에 사용한다.
자바에서는 배열을 인스턴스 형태로 생성하므로 new를 사용한다.
생성된 배열은 힙 메모리 공간에 저장되고, 할당된 메모리의 주소값을 반환
따라서 배열명은 주소값을 할당받게 된다.
우리는 해당 주소값을 통해 배열에 접근 할 수 있다.
 */

public class E01OneDimArray01 {
    public static void main(String[] args) {
        // 정수형의 크기가 3인 배열을 선언
        int[] numArr = new int[3];
        // 인덱스 0 ~ 2 까지 접근하여 배열을 초기화
        numArr[0] = 10;
        numArr[1] = 20;
        numArr[2] = 30;
        System.out.println(numArr[0]);
        System.out.println(numArr[1]);
        System.out.println(numArr[2]);
        // 정수형 배열이 heap영역에 생성된 후 반환된 주소값이 출력된다.
        System.out.println(numArr);
        System.out.println("============");

        /*
        배열의 선언 및 초기화
        : 배열은 여러개의 변수를 사용하기 위해 선언하므로 접근을 위해 일반적으로 반복문을 사용한다.
        배열명.length: 해당 배열의 크기를 반환한다. 배열의 크기가 변경되는 경우 유연하게 대처할 수 있다.
         */
        int[] arrNumber = new int[40];
        // 배열의 각 요소를 10부터 1씩 증가시키면서 초기화
        for(int i =0; i<arrNumber.length; i++){
            arrNumber[i] = i + 10;
        }
        // 배열의 각 요소를 출력한다.
        for(int i =0; i<40; i++){
            System.out.println(arrNumber[i]);
        }
        System.out.println("==========");

        // 인스턴스 배열: 기본 자료형을 저장하는 배열이 아닌 인스턴스의 참조값을 저장할 목적으로 생성한 배열을 말한다. 사용법은 일반 배열과 동일
        String[] strArr = new String[3];
        strArr[0] = "java";
        strArr[1] = "spring";
        strArr[2] = "dart";
        for (int j = 0; j < strArr.length; j++) {
            System.out.println(strArr[j]);
        }
        System.out.println("=========");

        System.out.println("배열 선언과 초기화");
        // 가장 기본적인 배열 선언과 초기화 방법
        System.out.println("배열의 선언 이후 초기화");
        int[] initArr = new int[1];
        initArr[0] = 100;
        System.out.println(initArr[0]);
        // 배열을 선언과 동시에 초기화하는 경우 자바 컴파일러는 초기값의 갯수를 통해 배열의 크기를 결정할 수 있다.
        // 따라서 이 경우에는 크기는 생략하도록 약속되어있다.
        System.out.println("선언과 동시에 초기화1");
//        int[] initArr2 = new int[3] {1, 20, 30}; //
        int[] initArr3 = new int[] {1, 20, 30};

        System.out.println("초기값만으로 선언");
        /*
        배열의 선언과 동시에 초기화 하므로 new키워드를 생략할 수 있다.
         */
        int[] initArr4 = {11, 13, 17, 19, 23};
        int arrSum = 0;
        for (int x = 0; x < initArr4.length; x++) {
            arrSum += initArr4[x];
        }
        System.out.println(arrSum);
    }
}
