package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
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

public class Ex07MyFriendInfoBook {
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
        }

    }

}

// 핸들러
class FriendInfoHandler {
//    private ex17collection.Friend[] myFriends;
//    private int numOfFriends;

    /*
    기존에 인스턴스 배열에 저장했던 것을 컬렉션으로 변경한다.
    컬렉션은 제네릭을 기반으로 하므로 인스턴스 생성 시 저장할 타입을 결정하게 된다.
    여기서는 Friend클래스를 상속한 High, Univ를 저장할 것이므로 이와같이 선언하면 된다.
     */
    private ArrayList<Friend> lists;

    public FriendInfoHandler(int num) {
//        myFriends = new ex17collection.Friend[num];
//        numOfFriends = 0;

        // 생성자에서 정보를 저장할 리스트 컬렉션을 생성한다.
        lists = new ArrayList<>();
    }

    public void addFriend(int choice) {
        Scanner scanner = new Scanner(System.in);
        String iName, iPhone, iAddress, iNickname, iMajor;
        System.out.println("name"); iName = scanner.nextLine();
        System.out.println("phone"); iPhone = scanner.nextLine();
        System.out.println("address"); iAddress = scanner.nextLine();

        if (choice == 1) {
            System.out.println("nickname:"); iNickname = scanner.nextLine();
            ex17collection.HighFriend highFriend = new ex17collection.HighFriend(iName, iPhone, iAddress,iNickname);
            lists.add(highFriend);
        } else if (choice == 2) {
            System.out.println("major:"); iMajor = scanner.nextLine();
            lists.add(new ex17collection.UnivFriend(iName, iPhone, iAddress, iMajor));
        }

        System.out.println("친구 정보 입력 완료");
    }


    public void showAllData() {
        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).showAllData();
        }
        System.out.println("전체 정보가 출력됨");
    }

    public void showSimpleData() {
        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).showBasicInfo();
        }
        System.out.println("간략 정보가 출력됨");
    }

    public void searchInfo() {
        boolean isFind = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 이름 입력");
        String searchName = scanner.nextLine();

        // 이터레이터 인스턴스 생성
        Iterator<Friend> iterator = lists.iterator();
        while (iterator.hasNext()) {
            Friend friend = iterator.next();
            if(searchName.compareTo(friend.name) == 0) {
                friend.showAllData();
                System.out.println("정보를 찾았다!!");
                isFind = true;
            }
        }
//        for (int i = 0; i < lists.size(); i++) {
//            if (searchName.compareTo(lists.get(i).name) == 0){
//                lists.get(i).showAllData();
//                System.out.println("귀하가 요청한 정보를 찾았습니다.");
//                isFind = true;
//            }
//        }

        if (isFind == false){
            System.out.println("찾는 정보가 없습니다.");
        }

    }

    public void deleteInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 이름 입력");
        String deleteName = scanner.nextLine();
        int deleteIndex = -1;

        // 확장 for문을 통해 반복하여 삭제할 이름을 검색한다.
        for (Friend friend : lists) {
            if (deleteName.compareTo(friend.name) == 0) {
                lists.remove(friend);
                deleteIndex = 1;
                break;
            }
        }

//        for (int i = 0; i < lists.size(); i++) {
//            if(deleteName.compareTo(lists.get(i).name) == 0){
//                lists.remove(i);
//                deleteIndex = i;
////                numOfFriends--;
//                break;
//            }
//        }


        if (deleteIndex == -1) {
            System.out.println("삭제할 데이터가 없습니다.");
        } else {
            for (int i = deleteIndex; i < lists.size(); i++){
                lists.set(i, lists.get(i + 1));
            }
            System.out.println("== data("+ deleteIndex + "번)이 삭제되었습니다.");
        }
    }
}
