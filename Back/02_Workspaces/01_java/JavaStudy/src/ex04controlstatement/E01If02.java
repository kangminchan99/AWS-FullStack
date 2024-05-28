package ex04controlstatement;

public class E01If02 {
    public static void main(String[] args) {

        int kor = 99, eng = 70, math = 64;
        double avg = (kor + eng + math) / 3.0;

        System.out.println("avg" + avg);
        System.out.printf("avg:%.2f\n", avg);
        if (avg >= 90) {
            System.out.println("a");
        } else if (avg >= 80) {
            System.out.println("B");
        } else if (avg >= 70) {
            System.out.println("C");
        } else if (avg >= 60) {
            System.out.println("D");
        } else  {
            System.out.println("F");
        }
        System.out.println("error");
    }
}
