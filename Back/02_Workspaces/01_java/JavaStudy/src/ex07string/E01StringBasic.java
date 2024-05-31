package ex07string;

public class E01StringBasic {
    public static void main(String[] args) {
        int num1 = 10, num2 = 20;
        String numResult = (num1 == num2) ? "equal" : "diff";
        System.out.println(numResult);

        System.out.println("===========");
        String str1 = new String("hello java");
        String str2 = new String("hello java");

        // 두 문자열의 참조 주소는 다르므로 else로 빠짐
        if (str1 == str2) {
            System.out.println("str1 str2 참조 주소 같음");
        } else {
            System.out.println("str1 str2 참조 주소 다름");
        }

        // 참조 주소가 아니라 저장된 내용을 바탕으로 비교 하므로 same 출력
        if (str1.equals(str2)) {
            System.out.println("same");
        } else {
            System.out.println("diff");
        }


        String str3 = "flutter";
        String str4 = "flutter";

        System.out.println(str3.equals(str4));

        // new 키워드를 사용하지 않고 동일한 문자이면 같은 주소를 할당하므로  주소가 동일하다고 찍힌다.
        if (str3 == str4) {
            System.out.println("주소 동일");
        } else {
            System.out.println("주소 다름");
        }
    }
}
