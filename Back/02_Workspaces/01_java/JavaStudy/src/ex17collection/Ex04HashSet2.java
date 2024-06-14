package ex17collection;

import common.Student;
import common.Teacher;

import java.util.HashSet;

public class Ex04HashSet2 {
    public static void main(String[] args) {
        HashSet<Teacher> hashSet = new HashSet<>();

        Teacher t1 = new Teacher("정우성", 40, "eng");
        Teacher t2 = new Teacher("원빈", 41, "math");
        Teacher t3 = new Teacher("장동건", 42, "kor");

        hashSet.add(t1);
        hashSet.add(t2);
        hashSet.add(t3);

        System.out.println("hashSet의 크기" + hashSet.size());

        Teacher t1Same = new Teacher("이정재", 40, "kor");

        System.out.println("t1Same의 저장여부" + hashSet.add(t1Same));
        System.out.println("hashSet의 크기" + hashSet.size());
    }
}
