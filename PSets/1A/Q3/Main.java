package Q3;

import java.*;
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args){

        // Adjust this value
        int n = 10;
        // Or use this instead if you are passing command-line arguments from your IDE
        // int n = Integer.parseInt(args[0]);

        // Generate the input ArrayList
        List<Integer> integerList = new ArrayList<>();
        for( int i = 1; i <= n; i++){
            integerList.add(i);
        }

        //Recall that 1 + 2 + .. + n = n(n+1)/2.
        String ans = "" + IteratingExamples.Act2ForEach(integerList);
        ans = "ForEach Sum = " + ans;
        System.out.println(ans);
    }
}
