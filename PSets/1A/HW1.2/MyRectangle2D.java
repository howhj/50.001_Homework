package HW12.lib;

public class MyRectangle2D {
    private double x = 0;
    private double y = 0;
    private double width = 1;
    private double height = 1;

    public MyRectangle2D() {

    }

    public MyRectangle2D(double x, double y, double width, double height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public double getX() {
        return x;
    }

    public void setX(double value) {
        x = value;
    }

    public double getY() {
        return y;
    }

    public void setY(double value) {
        y = value;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double value) {
        if (value > 0) {
            width = value;
        }
        else {
            System.out.println("Width must be a positive value.");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        if (value > 0) {
            height = value;
        }
        else {
            System.out.println("Height must be a positive value.");
        }
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double xval, double yval) {
        if (xval < x - width/2 || xval > x + width/2) {
            return false;
        }
        else if (yval < y - height/2 || yval > y + height/2) {
            return false;
        }
        return true;
    }

    public boolean contains(MyRectangle2D r) {
        double rwidth = r.getWidth();
        double rheight = r.getHeight();
        double rx = r.getX();
        double ry = r.getY();

        // Check if r is larger
        if (rwidth > width || rheight > height) {
            return false;
        }
        // Check if center of r is out of bounds
        else if (!contains(rx, ry)) {
            return false;
        }
        // Check if extremes of r are out of bounds
        else if (!contains(rx - rwidth/2, ry - rheight/2)) {
            return false;
        }
        else if (!contains(rx + rwidth/2, ry + rheight/2)) {
            return false;
        }
        return true;
    }

    public boolean overlaps(MyRectangle2D r) {
        double rwidth = r.getWidth();
        double rheight = r.getHeight();
        double rx = r.getX();
        double ry = r.getY();

        if (contains(rx - rwidth/2, ry - rheight/2)) {
            return true;
        }
        else if (contains(rx - rwidth/2, ry + rheight/2)) {
            return true;
        }
        else if (contains(rx + rwidth/2, ry - rheight/2)) {
            return true;
        }
        else if (contains(rx + rwidth/2, ry + rheight/2)) {
            return true;
        }
        return false;
    }
}
