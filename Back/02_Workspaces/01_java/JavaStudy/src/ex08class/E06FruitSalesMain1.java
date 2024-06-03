package ex08class;

//
class FruitSeller {

//  멤버 변수
    int numOfApple = 100; // 사과 수
    int myMoney = 0; // 판매 수입금

    // 멤버 상수 - 초기 선언 후 변경이 불가함
    final int APPLE_PRICE = 1000;
    /*
    멤버 변수의 경우 초기값이 없는 상태로 정의한 후 인스턴스를 생성하고
    차후 초기화 할 수 있다.
    하지만 멤버 상수는 인스턴스 생성과 상관없이 정의하는 시점에 반드시 초기화 해야한다.
    즉 1000을 지우면 에러가 발생한다.
     */

    // 멤버 메서드: 매개변수로 받은 money원 만큼의 사과의 갯수를 반환한다.
    public int saleApple(int money) {
        // 금액을 단가로 나눠서 갯수를 계산
        int num = money / APPLE_PRICE;
        this.numOfApple -= num;
        this.myMoney += money;
        return  num;
    }



    public void showSaleResult() {
        System.out.println("apple cnt" + numOfApple);
        System.out.println("수익" + myMoney);
    }
}

class FruitBuyer {
    int myMoney = 5000;
    int numOfApple = 0;

    public void buyApple(FruitSeller seller, int money) {
        numOfApple += seller.saleApple(money);
        myMoney -= money;
    }

    public void showBuyResult() {
        System.out.println("잔액" + myMoney);
        System.out.println("구매자 사과개수" + numOfApple);
    }
}

public class E06FruitSalesMain1 {

    public static void main(String[] args) {
        FruitSeller seller = new FruitSeller();
        FruitBuyer buyer = new FruitBuyer();

        System.out.println("초기 상태");
        seller.showSaleResult();
        buyer.showBuyResult();

        buyer.buyApple(seller, 5000);

        System.out.println("구매 후 상태");
        seller.showSaleResult();
        buyer.showBuyResult();
    }
}
