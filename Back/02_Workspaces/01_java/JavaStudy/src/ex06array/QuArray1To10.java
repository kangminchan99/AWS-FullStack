package ex06array;

import java.util.Arrays;

public class QuArray1To10 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
            sum += i + 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(sum);

    }
}
