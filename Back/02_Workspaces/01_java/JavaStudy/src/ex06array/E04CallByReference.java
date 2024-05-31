package ex06array;

public class E04CallByReference {
    public static void main(String[] args) {
        int[] arr = {100, 200};
        System.out.println("swap전 출력");
        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();

        callByReference(arr);

        System.out.println("swap후 출력");
        for (int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i] + " ");
        }
    }

    // 배열의 주소를 전달하므로 원본 배열이 변경 되는 걸 확인 할 수 있다.
    static void callByReference(int[] ref) {
        int temp;
        temp = ref[0];
        ref[0] = ref[1];
        ref[1] = temp;

        System.out.println("callByReference swap이후 출력");
        for (int i = 0; i < ref.length; i ++) {
            System.out.println(ref[i] + " ");
        }
        System.out.println();
    }
}
