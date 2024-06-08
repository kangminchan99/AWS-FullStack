package ex08class;

class Triangle {
    private double height;
    private double width;

    public Triangle(){
    }

    public void init(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return height * width * 0.5;
    }

    public void setBottom(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}


public class QuTriangle {
    public static void main(String[] args)
    {
        Triangle t = new Triangle();
        t.init(10, 17); //밑변10, 높이17로 초기화
        System.out.println("삼각형의 넓이 : "+ t.getArea());
        t.setBottom(50);//밑변 50으로 변경
        t.setHeight(14);//높이 14로 변경
        System.out.println("삼각형의 넓이 : "+ t.getArea());
    }

}
