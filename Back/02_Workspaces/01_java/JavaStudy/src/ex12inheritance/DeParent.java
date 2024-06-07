package ex12inheritance;

public class DeParent {
    private String name;
    private int age;
    public DeParent() {}
    public DeParent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void eat() {
        System.out.println("eat");
    }

    String sleep() {
        System.out.println("sleep");
        return null;
    }
    protected void walk() {
        System.out.println("walk");
    }

    public void exercise() {
        System.out.println("exercise");
    }

    public void printParent() {
        System.out.printf("name:%s, age:%d", name, age);
    }

    public static void staticMethod(){
        System.out.println("parent static method");
    }
}
