package ex12inheritance.animal;

public class Dog extends Animal{
    public String dogKind;
    public String name;


//    "포유류", "2", "수컷", "포메", "뽀미"

    public Dog(String species, int age, String gender , String dogKind, String name) {
        super(species, age, gender);
        this.dogKind = dogKind;
        this.name = name;
    }

    // 멤버 변수가 public으로 선언된 경우 직접 사용할 수 있는데 private로 사용할 경우 getter를 통해 값을 반환받아야한다.
    public void bark() {
        System.out.println(name + "인 강아지가 " + super.getSpecies() + "짖다");
    }

    public void showDog() {
        System.out.println(name + "인 강아지가 " + super.getSpecies() + "종" );
    }
}
