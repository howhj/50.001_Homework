package Q3;

import java.util.*;

public class IteratingExamples {

    public static int Act2ForEach(List<Integer> integers) {
        int sum = 0;
        for (int num : integers) {
            sum += num;
        }
        return sum;

    }
}
