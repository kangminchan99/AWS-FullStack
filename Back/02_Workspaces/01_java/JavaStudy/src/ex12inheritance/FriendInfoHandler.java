package ex12inheritance;

import java.util.Scanner;

class FriendInfoHandler {
    private Friend[] myFriends;
    private int numOfFriends;

    public FriendInfoHandler(int num) {
        myFriends = new Friend[num];
        numOfFriends = 0;
    }

    public void addFriend(int choice) {
        Scanner scanner = new Scanner(System.in);
        String iName, iPhone, iAddress, iNickname, iMajor;
        System.out.println("name"); iName = scanner.nextLine();
        System.out.println("phone"); iPhone = scanner.nextLine();
        System.out.println("address"); iAddress = scanner.nextLine();

        if (choice == 1) {
            System.out.println("nickname:"); iNickname = scanner.nextLine();
            HighFriend highFriend = new HighFriend(iName, iPhone, iAddress,iNickname);
            myFriends[numOfFriends++] = highFriend;
        } else if (choice == 2) {
            System.out.println("major:"); iMajor = scanner.nextLine();
            myFriends[numOfFriends++] = new UnivFriend(iName, iPhone, iAddress, iMajor);
        }

        System.out.println("친구 정보 입력 완료");
    }

    public void showAllData() {
        for (int i = 0; i < numOfFriends; i++) {
            myFriends[i].showAllData();
        }
        System.out.println("전체 정보가 출력됨");
    }

    public void showSimpleData() {
        for (int i = 0; i < numOfFriends; i++) {
            myFriends[i].showBasicInfo();
        }
        System.out.println("간략 정보가 출력됨");
    }

    public void searchInfo() {
        boolean isFind = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 이름 입력");
        String searchName = scanner.nextLine();

        for (int i = 0; i < numOfFriends; i++) {
            if (searchName.compareTo(myFriends[i].name) == 0){
                myFriends[i].showAllData();
                System.out.println("귀하가 요청한 정보를 찾았습니다.");
                isFind = true;
            }
        }

        if (isFind == false){
            System.out.println("찾는 정보가 없습니다.");
        }

    }

    public void deleteInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제할 이름 입력");
        String deleteName = scanner.nextLine();
        int deleteIndex = -1;

        for (int i = 0; i < numOfFriends; i++) {
            if(deleteName.compareTo(myFriends[i].name) == 0){
                myFriends[i] = null;
                deleteIndex = i;
                numOfFriends--;
                break;
            }
        }


        if (deleteIndex == -1) {
            System.out.println("삭제할 데이터가 없습니다.");
        } else {
            for (int i = deleteIndex; i <numOfFriends; i++){
                myFriends[i] = myFriends[i + 1];
            }
            System.out.println("== data("+ deleteIndex + "번)이 삭제되었습니다.");
        }
    }
}