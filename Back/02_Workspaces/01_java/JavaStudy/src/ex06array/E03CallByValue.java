package ex06array;

public class E03CallByValue {
    public static void main(String[] args) {
        int first = 100, second = 200;

        System.out.println("main 호출 전" + "first" + first + "second" + second);
        callByValue(first, second);
        System.out.println("main 호출 후" + "first" + first + "second" + second);
    }

    public static void callByValue(int fNum, int sNum) {
        int temp;
        temp = fNum;
        fNum = sNum;
        sNum = temp;

        System.out.println("callByValue 함수 안" + "first" + fNum + "second" + sNum);

    }
}
