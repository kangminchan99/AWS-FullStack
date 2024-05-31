package ex07string;

public class E02StringMethod3 {
    public static void main(String[] args) {
        String str1 = "Welcome To JAVA";
        String str2 = "자바야 놀자!";

        /*
        lastIndexOf() - indexOf()와 사용법은 동일하나 문자열의 뒤에서 부터 찾는 것이 특징이다. 파일의 확장자를 찾아야하는
        업무에서는 뒤에서부터 찾아야 하는 경우가 발생하게 된다.
         */
        System.out.println("lastIndexOf()");
        System.out.println(str1.lastIndexOf("AVA"));
        System.out.println(str1.lastIndexOf("j"));
        System.out.println("index of" + str1.indexOf("a"));
        System.out.println("index of" + str1.lastIndexOf("a"));

        /*
        replace() - 특정 문자열을 찾아서 지정된 문자열로 변경한다.  찾는 문자열이 없다고 하더라도 에러가 발생하진 않는다.
        // 영구적으로 바뀌는건 아님
         */
        System.out.println("replace()");
        System.out.println("J -> G");
        System.out.println(str1.replace("J", "G"));
        System.out.println("JAVA -> korea");
        System.out.println(str1.replace("JAVA", "Korea"));

        /*
        split() - 문자열을 구분자를 통해 분리해서 String형의 배열로 반환한다. 해당 구분자가 없는 경우에는 크기가 1인 배열로 반환한다.
         */
        System.out.println("split()");
        String num = "010-1239-2139";
        String[] phoneArr = num.split("-");
        for (int i = 0; i < phoneArr.length; i ++) {
            System.out.printf("phoneArr [%d] = %s \n", i, phoneArr[i]);
        }

        // 구분자로 사용한 문자열이 없는 경우 문자열 전체가 통째로 반환되어 크기가 1인 배열이 된다.
        phoneArr = num.split("%");
        for (int i = 0; i < phoneArr.length; i ++) {
            System.out.printf("phoneArr [%d] = %s \n", i, phoneArr[i]);
        }

        /*
        substring() - 시작 인덱스와 마지막 인덱스 사이의 문자열을 잘라서 반환한다. (해당 길이를 초과할 경우 에러 발생)
        방법1: 인덱스 하나만 사용 >> 사용한 인덱스 부터 끝까지를 잘라낸다
        방법2: 2개의 인덱스 사용 >> 시작, 종료 인덱스가 되므로 해당 구간의 문자열을 잘라낸다.
        (영구적으로 바뀌지 않음)
         */
        System.out.println(str1.substring(20));
        System.out.println(str1.substring(3, 7));

    }

}
