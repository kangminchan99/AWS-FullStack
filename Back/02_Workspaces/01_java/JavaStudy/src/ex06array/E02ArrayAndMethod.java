package ex06array;

public class E02ArrayAndMethod {
    public static void main(String[] args) {
        /*
        배열을 선언과 동시에 초기화 한다. 초기값의 갯수를 통해 크기가 결정된다.
        생성된 배열 인스턴스의 주소값을 int형 배열 변수인 arr에 할당하게 된다.
         */
        int[] arr = {1, 2, 3, 4, 5};
        // 배열 변수만 선언했고 아직은 참조할 인스턴스가 없는 상태
        int[] ref;
        System.out.println("초기화 직후 출력");
        // 초기값 그대로인 1 ~5 까지 출력된다.
        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
        // 
        ref = addAllArray(arr, 7);
        System.out.println("output");
        for(int i = 0; i <ref.length; i ++) {
            System.out.println(ref[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    static int[] addAllArray(int[] ar , int addVal) {
        for(int i = 0; i < ar.length; i ++) {
            ar[i] += addVal;
        }
        return ar;
    }
}
