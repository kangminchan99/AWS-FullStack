package ex17collection;

import java.util.*;

public class Ex08AsList {
    // List컬렉션을 매개변수로 받은 후 전체를 출력한다.
    public static void listPrint(String title, List<String> list) {
        System.out.println("# " + title);
        // 확장 for문으로 리스트 출력
        for(Object obj: list){
            /*
            출력할 인스턴스
             */
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /*
        String 인스턴스 배열을 생성과 동시에 초기화한다. 이 경우 초기 데이터를 통해
        크기를 유추할 수 있으므로 크기는 선언 문장에서 생략해야한다.
         */
        String[] strArr = new String[]{"marine", "firebat", "medic", "marine"};
        /*
        Arrays.asList(): 일반 배열을 List<T> 컬렉션으로 변경할 때 사용한다.
        단, 값을 참조만 할 수 있고 입력이나 삭제는 할 수 없다.
         */
        List<String> list = Arrays.asList(strArr);
        listPrint("출력1", list);
        // 현 상태에서는 데이터를 추가할 수 없다. 런타임에러 발생됨.
//        list.add("tank");

        /*
        ArrayList<E>의 생성자를 통해 앞의 인스턴스를 복사하면 데이터를 변경할 수 있다.
         */
        list = new ArrayList<>(list);
        // 복사한 이후에는 데이터를 추가할 수 있다.
        boolean isAdd = list.add("tank");
        System.out.println("add result"+isAdd);
        listPrint("출력2",list);

        /*
        이터레이터를 for문을 이용해서 출력한다.
        for(초기값; 조건식; 증감식) {
            print(next()가 증감식을 대체한다.);
        }
         */
        System.out.println("# 출력3");
        for(Iterator<String> iterator = list.listIterator(); iterator.hasNext();) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        /*
        Set<E> 컬렉션은 중복을 허용하지 않으므로 List에 저장된
        중복값을 제거할 수 있다.
         */
        HashSet<String> set = new HashSet<>(list);
        list = new ArrayList<>(set);
        listPrint("출력4 중복제거", list);
    }
}
