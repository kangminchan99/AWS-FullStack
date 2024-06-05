package ex12inheritance.animal;

public class AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog("포유류", 2, "수컷", "포메", "뽀미");

        dog.showAnimal();
        System.out.println("===============");
        dog.bark();
        System.out.println("================");
        dog.showDog();
    }
}
