package com.example.lib;

import java.util.*;

public class IteratingExamples {

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;

        // Insert code here to sum up input using an Iterator ...
        for (int i=0; i<integers.size(); i++) {
            sum += integers.get(i);
        }

        return sum;
    }
}
