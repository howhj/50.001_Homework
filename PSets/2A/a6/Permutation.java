package a6;

import java.util.ArrayList;

public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<>();
    // additional attribute if needed

    Permutation(final String str){
        in = str;
        // additional initialization if needed
    }

    public void permute(){
        // produce the permuted sequence of 'in' and store in 'a', recursively

        // Base case
        if (in.length() == 1) {
            a.add(in);
            return;
        }

        // Recursive case
        char[] c = in.toCharArray();
        for (int i=0; i<c.length; i++) {
            // Create substring to permute
            char[] newC = new char[c.length-1];
            for (int j=0; j<c.length; j++) {
                if (j < i) { newC[j] = c[j]; }
                else if (j > i) { newC[j-1] = c[j]; }
            }
            Permutation newP = new Permutation(new String(newC));

            // Create permutations
            newP.permute();
            ArrayList<String> newA = newP.getA();
            for (String s : newA) { a.add(c[i] + s); }
        }
    }

    public ArrayList<String> getA(){
        return a;
    }
}