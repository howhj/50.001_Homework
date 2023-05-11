package a6;

import java.util.ArrayList;

public class TestPermutation {
    public static void main(String[] args) {
        ArrayList<String> v;
        Permutation p = new Permutation("hat");
        p.permute();
        v = p.getA();
        System.out.println(v);
    }
}
