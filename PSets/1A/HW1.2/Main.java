package HW12.lib;

public class Main {
    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D();
        MyRectangle2D r3 = new MyRectangle2D(3, 1, 4, 4);
        r1.setX(100);
        r1.setY(-100);
        System.out.println(r3.overlaps(r1));
    }
}
