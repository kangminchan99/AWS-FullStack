package ex12inheritance;

public class DeChild extends DeParent{
    String stNum;

    public DeChild(String name, int age, String stNum) {
        super(name, age);
        this.stNum = stNum;
    }

    public void study() {
        System.out.println(getName() + "study");
    }
    private void eat() {
        System.out.println("child eat");
    }

    @Override
    public String sleep() {
        System.out.println("child sleep");
        return null;
    }

    public int walk(int age) {
        System.out.println("age" + age +"child walk");
        return 0;
    }

    @Override
    public void exercise() {
        System.out.println("child exercise");
    }

    @Override
    public void printParent() {
        super.printParent();
        System.out.printf(", 학번:%s\n", stNum);
    }

    public static void staticMethod() {
        System.out.println("child static method");
    }
}
