package ex12inheritance;

/*
구성관계로 표현하기에 적합한 Has-A 관계
:X has a Y => X가 Y를 소유하다. 여기서는 권총을 소유한 경찰을 표현

Has-A와 같이 소유의 관계를 상속으로 표현하면 클래스간의 강한 연결고리가
형성되어 권총이 없는 경찰을 표현하기 힘들어진다. 따라서 이 경우에는
구성(Composition)관계로 표현하는 것이 좋다.
구성관계랑 클래스의 멤버로 또 다른 클래스를 사용하는 것을 말한다.
 */

// 권총을 추상화
class Gun {
    // 멤버 변수: 총알
    int bullet;
    // 생성자
    public Gun(int bNum) {
        bullet = bNum;
    }
    // 총 발사 후 총알 감소
    public void shutGun() {
        System.out.println("빵야");
        bullet--;
    }
}

// 경찰을 추상화
class Police {
    /*
    권총과 수갑을 보유한 경찰을 표현. 상속으로 구현하지 않고
    멤버변수로 정의하고 있다.
     */
    // 수갑: 정수형 멤버 변수
    int handCuffs;

    // 권총: 인스턴스형 멤버 변수(다른 클래스를 통해 생성)
    Gun gun;

    // 생성자
    public Police(int bNum, int hCuff) {
        // 수갑은 정수값을 통해 보유 여부를 설정
        handCuffs = hCuff;
        /*
        권총의 보유여부는 총알이 없는 상태라면 권총이 없는것으로 간주하여 null로 초기화한다.
        참조변수가 null을 할당 받았다는 것은 참조할 인스턴스가 없는것을 의미한다.
        즉 힙 영역에 생성된 인스턴스가 아예 없으므로 소유하지 않은 것을 표현할 수 있다.
         */
        if (bNum <= 0) {
            gun = null;
        } else {
            gun = new Gun(bNum);
        }
    }

   // 수갑을 채우는 것을 표현
    public void putHandCuff() {
        System.out.println("수갑채움");
        handCuffs--;
    }

    // 권총을 발사하는것을 표현
    public void shut() {
        // 조건문을 통해서 소유한 총이 있을때만 발사할 수 있다.
        if (gun == null) {
            System.out.println("권총 없음 헛빵");
        } else {
            gun.shutGun();
        }
    }
}


public class E05HasAComposite {
    public static void main(String[] args) {
        // 권총을 보유한 경찰로 총알 5발, 수갑3개로 인스턴스 생성
        System.out.println("police");
        Police police1 = new Police(5,3);
        police1.shut(); // 발사 가능
        police1.putHandCuff();

        // 권총을 보유하지 않은 경찰로 수갑만 3개있다
        System.out.println("police2");
        Police police2 = new Police(0,3);
        police2.shut(); // 발사할 수 없음
        police2.putHandCuff();
    }
}
