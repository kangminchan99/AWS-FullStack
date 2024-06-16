package common;

public class Student extends Person{
    private String stNumber;
    public Student(String name, int age, String stNumber) {
        super(name, age);
        this.stNumber = stNumber;
    }

    public String getStNumber() {
        return stNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", 학번:" + stNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 만일 현 객체 this와 매개변수 객체가 같을 경우 true
        if (!(obj instanceof Student)) return false; // 만일 매개변수 객체가 Student 타입과 호환되지 않으면 false
        Student student = (Student) obj; // 만일 매개변수 객체가 Student 타입과 호환된다면 다운캐스팅(down casting) 진행
        if (this.getName().equals(student.getName())) {
            System.out.println("오버라이딩 한 equals() 호출됨: " + student.getName());
            return true;
        }
        return false;
    }
}
