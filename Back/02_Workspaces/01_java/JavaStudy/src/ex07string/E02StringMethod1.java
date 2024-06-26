package ex07string;

public class E02StringMethod1 {
    public static void main(String[] args) {
        System.out.println("string method");

        String str1 = "Welcome To";
        String str2 = "환영";

        /*
        length - 문자열의 길이를 반환
         */
        System.out.println("length");
        System.out.println("str1 len" + str1.length());
        System.out.println("str2 len" + str2.length());


        /*
        charAt(index) - 특정 인덱스에 해당하는 문자 하나를 반환
         */
        System.out.println("charAt");
        System.out.println("str1의 두번째 문자" + str1.charAt(1));
        System.out.println("str2 두번째 문자" + str2.charAt(1));

        /*
        compareTo() - 2개의 문자열의 첫번째 문자부터 순차적으로 비교하면서 앞문자의 아스키 코드가 크면 양수를 반환하고
        뒷문자의 아스키 코드가 크면 음수를 반환한다. 두 문자열이 같을 때 0을 반환한다.
         */
        System.out.println("compareTo");
        String str3 = "A";
        String str4 = "으아ㅡㅁㄴ이ㅏㅡㅁ니ㅏㅇ";
        System.out.println(str3.compareTo(str4));
        System.out.println(str4.compareTo(str3));
        System.out.println("ABC".compareTo("ABC") == 0 ? "same" : "diff");

        /*
        concat() - 두개의 문자열을 연결한다. print()문에서 + 와 동일한 역할이다.
         */
        System.out.println("concat()");
        System.out.println("JAVA".concat(" WORLD").concat(" Go"));
        System.out.println("JAVA" + " WORLD" + " GO");

        /*
        contains() - 문자열에 특정 문자열이 포함되었는지 판단하여 포함되었다면 true반환
         */
        System.out.println("contains()");
        System.out.println(str1.contains("To"));
        System.out.println(str1.contains("to"));
    }
}
