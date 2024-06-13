package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/*
ArrayList<E> : List 계열의 컬렉션
- 데이터의 중복 저장 허용
- 데이터의 저장 순서 보장
- 데이터 접근 시 get() 혹은 iterator()를 이용
- Array라는 이름처럼 '배열'의 특성을 가지고 있어 index를 통한
저장 및 접근이 가능하다.
 */
public class Ex03ArrayList1 {
    public static void main(String[] args) {

        /*
        String 인스턴스를 저장할 수 있는 list 컬렉션 생성
        ArrayList와 나머지 컬렉션들은 데이터를 저장하는 내부적인
        자료구조만 다를뿐 사용법은 100% 동일하다.
         */
        ArrayList<String> list = new ArrayList<>();
//        LinkedList<String> list = new LinkedList<>();
//        Vector<String> list = new Vector<>();


        /*
        인스턴스 저장: add()
            add(인스턴스): 순차적으로 저장하면서 인덱스는 0부터 자동을 부여한다.
            add(idx, instance): 데이터 저장 시 인덱스를 직접 부여한다.
                 단, 인덱스를 건너뛰면 에러가 발생하므로 주의해야됨
                 만약 지정한 인덱스에 이미 저장된 인스턴스가 있다면
                 삽입이 된다.
         */
        // 객체 저장
        list.add("sosi");
        list.add("bigbang");
        list.add("twice");
        list.add(3, "itzy");
//        list.add(5,"ioi"); // 런타임 에러 발생
        /*
        저장된 객체 수 (리스트의 크기): size()
                컬렉션에 저장된 인스턴스의 갯수를 반환한다. 배열에서 사용하는 length와 동일한 값을 반환한다.
         */
        list.add(list.size(), "ohmygirl");
        list.add(list.size(),"bts");
        System.out.println("중복 저장전 객체수" + list.size()); // size = 6

        // 중복저장 : List는 배열의 특성을 가지므로 데이터를 중복저장할 수 있다.
        // 동일한 데이터라도 idx로 구분할 수 있기 때문이다. add()는 인스턴스
        // 추가에 성공할 경우 true를 반환한다.
        System.out.println(list.add("twice") ? "중복저장됨" : "중복저장안됨");
        System.out.println("중복 저장 후 객체수" + list.size()); // size = 7

        /*
        컬렉션 출력시에는 아래 3가지 방법을 사용
        방법1: 일반 for문 사용. 이때는 인덱스를 통해 접근해야 하므로 get() 메서드를 사용한다.
         */
        System.out.print("일반 for문");
        for (int i = 0; i < list.size(); i ++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        /*
        방법 2: 향상 for문의 경우 인덱스 값이 전체 원소를 반복해주므로
        좀 더 간단한 표현이 가능하다. 가장 많이 사용되는 방식이다.
         */
        System.out.print("향상 for");
        for (String obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println("==========");


        /*
        방벙3: Iterator 사용
            1. 컬렉션에 저장된 내용을 Iterator 객체에게 알려주기 위해 인스턴스를 생성
            2. hasNext()로 인출할 인스턴스가 있는지 검사한다. 만약 없다면 false를 반환
            3. 앞에서 확인 후 next()를 통해 인스턴스를 인출
         */
        // iterator
        System.out.println("반복자(iterator) 사용");
        Iterator<String> itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
        System.out.println("===========");

        // 덮어쓰기
        // 기존의 내용을 변경한다. 즉 기존 내용은 삭제한 후 새로운 내용으로 갱신한다.
        list.set(4, "omygirl copy");
        for (Object obj : list) {
            System.out.println(obj + " ");
        }
        System.out.println("------");

        // 삽입하기(끼워넣기) add(삽입할 인덱스, 인스턴스)
        // 해당 인덱스에 인스턴스를 삽입한다. 기존 인스턴스는 뒤로 1칸씩 밀려난다.
        // 즉 인덱싱을 자동으로 해준다.
        list.add(4, "blackpink > 삽입하기");
        for (Object obj : list) {
            System.out.println(obj + " ");
        }
        System.out.println("------");

        // 포함여부 확인
        // contains(instance): 특정 인스턴스가 저장되어 있는지 확인할 때 사용한다. 존재하면 true 반환
        System.out.println(list.contains("bigbang") ? "빅뱅있음" : "빅뱅 없음");
        System.out.println(list.contains("blackpink") ? "black pink true" : "black pink false");


        /*
        삭제하기:
         */
        // 방법1 : 인덱스로 삭제: 인덱스를 통해 삭제를 진행한 후 삭제가 완료되면 해당 인스턴스를 반환.
        // 삭제후에는 인덱스가 자동으로 부여된다. 삭제 성공 시 해당 인스턴스의 참조값을 반환하므로 삭제 즉시 확인 가능
        Object obj = list.remove(2);
        System.out.println("delete" + obj);

        // 방법 2
        // indexOf()를 통해 해당 인스턴스의 인덱스를 찾은 후 삭제한다.
        int index = list.indexOf("bigbang");
        System.out.println("bigbang idx" + index);
        list.remove(index);

        // 방법 3: 인스턴스의 참조값을 통해 삭제한다. 이 경우에는 삭제에 성공했을 때 true를 반환. 즉
        // boolean타입의 반환값을 가진다.
        System.out.println(list.remove("bts") ? "delete true": "delete false");
        System.out.println(list.remove("ohmygirl") ? "delete true": "delete false");
        System.out.println("삭제후 출력");
        for (Object ob : list) {
            System.out.println(ob + " ");
        }
        /*
        전체 삭제: 아래 2개의 메서드를 통해 컬렉션에 저장된 전체 데이터를 삭제 가능
         */
        System.out.println();
        list.removeAll(list);
        list.clear();
        System.out.println("all del" + list.size());
    }

}
