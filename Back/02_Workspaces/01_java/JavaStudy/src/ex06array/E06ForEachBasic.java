package ex06array;

import java.util.Arrays;

public class E06ForEachBasic {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

        for(int e: arr){
            sum += e;
        }
        System.out.println(sum);

        for (int b: arr) {
            System.out.println(++b);
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("이차원 배열을 foreach문으로 출력");
        int[][] twoDim = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };

        for (int[] a: twoDim) {
            System.out.println(Arrays.toString(a));
            for (int b: a) {
                System.out.println(b);
            }
            System.out.println();
        }
    }
}
