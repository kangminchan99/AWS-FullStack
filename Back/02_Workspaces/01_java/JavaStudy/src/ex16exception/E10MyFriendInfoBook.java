package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

class Friend {
    String name;
    String phone;
    String address;
    public Friend(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void showAllData() {
        System.out.println("name:" + name);
        System.out.println("phone:" + phone);
        System.out.println("address:" + address);
    }

    public void showBasicInfo(){}
}

class HighFriend extends Friend {
    String nickname;
    public HighFriend(String name, String phone, String address, String nickname) {
        super(name, phone, address);
        this.nickname = nickname;
    }

    @Override
    public void showAllData() {
        System.out.println("high school friend(info)");
        super.showAllData();
        System.out.println("nickname" + nickname);
    }

    @Override
    public void showBasicInfo() {
        System.out.println("high school friend");
        System.out.println("nickname" + nickname);
        System.out.println("phone" + phone);
    }
}

class UnivFriend extends Friend {
    String major;
    public UnivFriend(String name, String phone, String address, String major) {
        super(name, phone, address);
        this.major = major;
    }
    @Override
    public void showAllData() {
        System.out.println("university friend(info)");
        super.showAllData();
        System.out.println("major" + major);
    }

    @Override
    public void showBasicInfo() {
        System.out.println("university friend");
        System.out.println("name" + name);
        System.out.println("phone" + phone);
    }
}

public class E10MyFriendInfoBook {
    public static void menuShow() {
        System.out.println("====menu====");
        System.out.println("1. high school friend");
        System.out.println("2. university friend");
        System.out.println("3. 전체 정보 출력");
        System.out.println("4. 간략 정보 출력");
        System.out.println("5. search");
        System.out.println("6. delete");
        System.out.println("7. exit");
        System.out.println("메뉴선택>>>");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FriendInfoHandler handler = new FriendInfoHandler(100);

        while (true) {
            try {
                menuShow();
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1, 2:
                        handler.addFriend(choice);
                        break;
                    case 3:
                        handler.showAllData();
                        break;
                    case 4:
                        handler.showSimpleData();
                        break;
                    case 5:
                        handler.searchInfo();
                        break;
                    case 6:
                        handler.deleteInfo();
                        break;
                    case 7:
                        System.out.println("exit");
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력하세요.");
                break;
            }

        }

    }

}
