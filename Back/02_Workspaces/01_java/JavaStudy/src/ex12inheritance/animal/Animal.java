package ex12inheritance.animal;

public class Animal {
    private String species;
    public int age;
    public String gender;

    public Animal(String species, int age, String gender) {
        this.species = species;
        this.age = age;
        this.gender = gender;
    }

    public void showAnimal() {
        System.out.println("species" + species + "age" + age + "gender" + gender);
    }

    // getter메서드: private으로 선언된 멤버 변수를 클래스 외부로 반환할 때 사용하는 메서드
    public String getSpecies() {
        return species;
    }
}
