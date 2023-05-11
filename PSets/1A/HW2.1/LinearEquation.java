package HW21.lib;

public class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double aval, double bval, double cval,
                          double dval, double eval, double fval) {
        a = aval;
        b = bval;
        c = cval;
        d = dval;
        e = eval;
        f = fval;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
    public double getD() { return d; }
    public double getE() { return e; }
    public double getF() { return f; }

    public boolean isSolvable() { return a*d - b*c != 0; }
    public double getX() { return (b*f - d*e) / (b*c - a*d); }
    public double getY() { return (a*f - c*e) / (a*d - b*c); }

}
