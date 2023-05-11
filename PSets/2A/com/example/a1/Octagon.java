package com.example.a1;

public class Octagon implements Comparable<Octagon> {
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    public int compareTo(Octagon o) {
        if (side > o.getSide()) { return 1; }
        else if (side == o.getSide()) { return 0; }
        else { return -1; }
    }
}
