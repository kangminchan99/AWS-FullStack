package ex13interface;

import ex13interface.figure.*;

public class E05FigureDrawableMain {
    public static void main(String[] args) {
        // 부모 인터페이스의 참조변수로 자식 인스턴스를 참조한다.
        IFigure figure = new Circle(30);
        /*
        오버라이딩 한 메서드는 항상 자식쪽에 정의된 메서드가 호출되므로
        별도의 형변환없이 호출할 수 있다.
         */
        figure.area("원");
        /*
        IFigure 인터페이스 area() 추상 메서드만 정의되어 있으므로
        draw()를 호출하려면 다운 캐스팅 해야한다.
         */
        ((Circle)figure).draw("나도 원");

        IFigure figure1 = new Rectangle(100, 90);
        figure1.area("사각형");
        ((Rectangle)figure1).draw("나도 사각형");

        IDrawable drawable = new Triangle(100, 90);
        drawable.draw("삼각형");

        ((Triangle)drawable).area("나도 삼각형");

        // 자식타입의 인스턴스로 참조하므로 별도의 형변환 없이 모두 호출할 수 있다.
        Circle circle = new Circle(40);
        circle.area("원");
        circle.draw("나도 원");
    }
}


