package com.example.lib;

import java.util.*;

public class Q2Main
{
    public static void main(String[] args){

        // Adjust this value
        int n = 10;
        // Or use this instead if you are passing command-line arguments
        // int n = Integer.parseInt(args[0]);

        // Generate the input ArrayList
        List<Integer> integerList = new ArrayList<>();
        for( int i = 1; i <= n; i++){
            integerList.add(i);
        }

        //Recall that 1 + 2 + .. + n = n(n+1)/2.
        String ans = "" + IteratingExamples.Act2Iterator(integerList);
        ans = "Iterator Sum = " + ans;
        System.out.println(ans);
    }
}
