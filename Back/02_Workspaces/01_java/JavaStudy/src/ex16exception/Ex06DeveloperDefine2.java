package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
개발자 정의 예외 클래스
1. Exception 클래스를 상속한다.
2. 생성자에서 예외 발생 시 출력할 메세지를 super()를 통해 입력한다.
3. 예외 발생 지점에서 if문으로 감지한 후 예외 인스턴스를 생성 및 throw한다.
4. catch문에서 예외 인스턴스를 처리한다,
 */
class AgeErrorException2 extends Exception {
    public AgeErrorException2() {
        super("나이 입력 잘못됨");
    }
}
public class Ex06DeveloperDefine2 {
    public static void main(String[] args) {
        System.out.print("나이를 입력하세요: ");
        int age = readAge();
        System.out.println("당신의 나이는 " + age + "입니다.");
    }



    // 예외 던지기를 하여 호출한 지점으로 예외 인스턴스를 전달한다.
    public static int readAge() {
        Scanner scanner = new Scanner(System.in);
        int inputAge = 0;
        try {
            inputAge = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
            System.exit(0);
        }

        /*
        개발자가 직접 예외 상황을 if문으로 확인한 후 예외 인스턴스를 만들어 프로그램으로 throw한다.
        그 즉시 에러가 발생하므로 '예외 던지기'를 하지 않고 여기서 직접
        try~catch문으로 '예외 처리'한다.
         */
        try {
            if (inputAge < 0) {
                AgeErrorException2 ex = new AgeErrorException2();
                throw ex;
            }
        } catch (AgeErrorException2 e){
            System.out.println(e.getMessage());
            // 예외처리 후 프로그램을 즉시 종료한다.
            System.exit(0);

        }
        return inputAge;
    }

}
