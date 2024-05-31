package ex07string;

public class E02StringMethod4 {
    public static void main(String[] args) {
        String[] member = {"190419-3000000", "190419-4000000" };

        for (String e: member) {
            if (e.charAt(7) == '3' || e.charAt(7) == '1') {
                System.out.println("남자");
            } else if (e.charAt(7) == '5' || e.charAt(7) == '6'){
                System.out.println("외국인");
            } else if (e.charAt(7) == '2' || e.charAt(7) == '4') {
                System.out.println("여자");
            } else {
                System.out.println("error");
            }
        }

        String s1 = "hong@daum.net";
        String s2 = "not@naver";

        System.out.println(s1.contains("net") && s1.contains(".") ? "email" : "not email ㅠㅜ");
        System.out.println(s2.contains("net") && s1.contains(".") ? "email" : "not email ㅠㅜ");

        for (String e: member) {
            if (e.charAt(e.indexOf('-') + 1) ==  '3' || e.charAt(e.indexOf('-') + 1) == '1') {
                System.out.println("남자");
            } else if (e.charAt(e.indexOf('-') + 1) == '5' || e.charAt(e.indexOf('-') + 1) == '6'){
                System.out.println("외국인");
            } else if (e.charAt(e.indexOf('-') + 1) == '2' || e.charAt(e.indexOf('-') + 1) == '4') {
                System.out.println("여자");
            } else {
                System.out.println("error");
            }
        }
        String file1 = "my.filemklk.sdkfmlk.images.jpg";
        // 마지막 .의 위치를 검색하고 + 1
        System.out.println(file1.substring(file1.lastIndexOf(".") + 1));
    }
}
