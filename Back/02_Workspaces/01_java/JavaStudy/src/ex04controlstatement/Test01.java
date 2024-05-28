package ex04controlstatement;

public class Test01 {
    // 최대값 찾기 알고리즘 디버깅 표
    public static void main(String[] args) {
        int[] datas = new int[5];

        datas[0] = 2;

        datas[1] = 3;

        datas[2] = 1;

        datas[3] = 5;

        datas[4] = 4;

        System.out.print("[");

        for (int data : datas) {
            System.out.print(+data + " ");
        }
        System.out.println("]");

        // int max = datas[0]; // max == 현재 예상중인 가장 큰 숫자
        int maxIndex = 0; // max 값이 저장된 Index의 위치 번호
        for (int i = 1; i < datas.length; i++) {

            // datas[i]의 밸류값이 저장된 밸류 값보다 클 경우에만 맥스 인덱스를 변경 시켜준다.
            if (datas[i] > datas[maxIndex]) {

                datas[maxIndex] = datas[i];

                maxIndex = i;
            }
        }System.out.println("최대값은 " +datas[maxIndex]+ "이고,");
        System.out.println("그 위치는[" +maxIndex+ "]입니다");
    }
}
