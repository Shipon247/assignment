class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class CircleCalculator {
    public double calculateArea(Circle c) {
        return Math.PI * c.getRadius() * c.getRadius();
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        CircleCalculator calculator = new CircleCalculator();
        double area = calculator.calculateArea(circle);
        System.out.println(area);
    }
}
