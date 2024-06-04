package ex09package;

import ex09package.study.perimeter.Circle;

public class E02CircleMain {

    public static void main(String[] args) {
        ex09package.study.area.Circle circle1 = new ex09package.study.area.Circle(6.5);
        System.out.println("반지름이 6.5인 원의 넓이" + circle1.getArea());

        Circle circle2 = new Circle(4.5);
        System.out.println("반지름이 4.5인 원의 넓이" + circle2.getPerimeter());
    }
}
