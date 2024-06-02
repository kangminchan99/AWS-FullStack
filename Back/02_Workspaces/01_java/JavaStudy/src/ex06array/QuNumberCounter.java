package ex06array;

public class QuNumberCounter {
    public static void main(String[] args) {
        int[] answer = { 1,4,4,3,1,4,4,2,1,3,2};
        int[] counter = new int[4];

        for (int i: answer){
            counter[i - 1] += 1;
        }
        System.out.println(counter[0]);
        System.out.println(counter[1]);
        System.out.println(counter[2]);
        System.out.println(counter[3]);
    }
}
