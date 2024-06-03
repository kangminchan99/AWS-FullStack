package ex08class;

class Account {
    // 멤버 변수
    String name;
    // 계좌 번호는 연산의 대상이 아니므로 String으로 선언한다.
    String accountNumber;
    // 잔고의 경우 입출금을 위한 연산이 필요하므로 int로 선언한다.
    int balance;

    public Account() {
        // 자동으로 생성되는 디폴트 생성자 메서드
    }

    // 입금 처리를 위한 멤버 메서드
    void deposit(int money) {
        balance += money;
        System.out.println(money +"입금됨");
    }


    // 출금처리
    void withdraw(int money) {
        // 출금을 위해 잔고와 출금액을 비교하여 처리한다.
        if (balance >= money) {
            // 잔고가 충분하다면 money원을 차감한다.
            balance -= money;
            System.out.println(money + "출금");
        } else {
            System.out.println("잔고 부족 출금 불가");
        }
    }

    // 계좌를 조회하는 멤버 메서드
    void showAccount() {
        System.out.println(name);
        System.out.println(accountNumber);
        System.out.println(balance);
    }

    // 초기화를 위한 멤버 메서드
    void init(String n, String a, int b) {
        name = n;
        accountNumber = a;
        balance = b;
    }
}
public class E04AccountMain {

    public static void main(String[] args) {
        // 첫번째 계좌 인스턴스 생성
        Account account = new Account();
        // 초기화 메서드를 통해 인스턴스 초기화
        account.init("minchan", "11203-1293", 1000);
        account.deposit(9000);
        account.withdraw(5000);
        account.showAccount();

        // 두번째 계좌 인스턴스 생성
        Account account2 = new Account();
        // 멤버 변수에 직접 접근하므로 첫번째 방법 사용하는게 좋다.
        account2.name = "yeji";
        account2.accountNumber = "123-23940-2394";
        account2.balance = 900000;
        account2.showAccount();

    }
}
