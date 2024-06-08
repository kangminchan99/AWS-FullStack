package ex12inheritance;


class Point {
    int xDot, yDot;
    public Point(int x, int y) {
        xDot=x;
        yDot=y;
    }
    public void showPointInfo() {
        System.out.println("[x좌표:"+xDot+", y좌표"+yDot+"]");
    }
}
//Point클래스를 기반으로 원(Circle) 클래스 표현하기
class Circle{
    //멤버변수
    int radian;//반지름
    Point center;

    public Circle(int x, int y, int radian) {
        center = new Point(x, y);
        this.radian = radian;
    }

    public void showCircleInfo() {
        System.out.println("반지름: " + radian);
        center.showPointInfo();
    }
}
//원 2개를 겹쳐서 링을 표현하는 클래스
class Ring{
    //멤버변수
    Circle innerCircle;//안쪽의 원
    Circle outerCircle;//바깥쪽의 원

    public Ring(int x1, int y1, int radian1, int x2, int y2, int radian2) {
        innerCircle = new Circle(x1, y1, radian1);
        outerCircle = new Circle(x2, y2, radian2);
    }

    public void showRingInfo() {
        System.out.println("안쪽 원의 정보:");
        innerCircle.showCircleInfo();
        System.out.println("바깥쪽 원의 정보:");
        outerCircle.showCircleInfo();
    }
}

public class QuRingMake {

    public static void main(String[] args) {
        Ring c = new Ring(1,1,3,2,2,9);
        c.showRingInfo();
    }
}
