// **ATTENTION**
// Edit just this file to submit your answer
// You need not edit the TestPset1.java file 

import java.lang.Math;

public class Pset1 {
    public static boolean isAllCharacterUnique(String sIn) {
        //todo: add your implementation
        if (sIn.length() > 128) { return false; }

        char[] array = sIn.toCharArray();
        int n = sIn.length();
        HeapSort(array);

        for (int i=1; i<n; i++) {
            if (array[i] == array[i-1]) { return false; }
        }
        return true;
    }
    public static boolean isPermutation(String sIn1, String sIn2) {
        //todo: add your implementation
        if (sIn1.length() != sIn2.length()) { return false; }
        else {
            int n = sIn1.length() - 1;
            char[] array1 = sIn1.toCharArray();
            char[] array2 = sIn2.toCharArray();
            HeapSort(array1);
            HeapSort(array2);

            for (int i=0; i<n; i++) {
                if (array1[i] != array2[i]) { return false; }
            }
            return true;
        }
    }

    private static void BuildMaxHeap(char[] array) {
        int i = Math.floorDiv(array.length, 2);
        while (i >= 0) {
            MaxHeapify(array, i, array.length);
            i--;
        }
    }
    
    private static void MaxHeapify(char[] array, int i, int heapsize) {
        int left = 2*i;
        int right = left+1;
        int largest = i;
        
        if (left < heapsize && array[left] > array[i]) { largest = left; }
        if (right < heapsize && array[right] > array[largest]) { largest = right; }
        
        if (i != largest) {
            char temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;
            MaxHeapify(array, largest, heapsize);
        }
    }
    
    private static void HeapSort(char[] array) {
        BuildMaxHeap(array);
        char temp;
        int heapsize = array.length;
        while (heapsize > 0) {
            temp = array[0];
            array[0] = array[heapsize-1];
            array[heapsize-1] = temp;
            heapsize--;
            MaxHeapify(array, 0, heapsize);
        }
    }
}

