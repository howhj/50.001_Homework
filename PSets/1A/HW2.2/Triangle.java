package HW22.lib;

public class Triangle extends GeometricObject {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    public Triangle() {}

    public Triangle(double s1, double s2, double s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public double getArea() {
        double s = 0.5 * getPerimeter();
        return Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
    }

    public double getPerimeter() { return side1 + side2 + side3; }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}
