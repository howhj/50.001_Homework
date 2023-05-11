package piwords;

import java.util.HashMap;
import java.util.Map;

public class WordFinder {
    /**
     * Given a String (the haystack) and an array of Strings (the needles),
     * return a Map<String, Integer>, where keys in the map correspond to
     * elements of needles that were found as substrings of haystack, and the
     * value for each key is the lowest index of haystack at which that needle
     * was found. A needle that was not found in the haystack should not be
     * returned in the output map.
     * 
     * @param haystack The string to search into.
     * @param needles The array of strings to search for. This array is not
     *                mutated.
     * @return The list of needles that were found in the haystack.
     */
    public static Map<String, Integer> getSubstrings(String haystack,
                                                     String[] needles) {
        HashMap result = new HashMap<String,Integer>();
        char h[] = haystack.toCharArray();

        for (String str : needles) {
            char[] s = str.toCharArray();
            boolean found = false;

            for (int i=0; i<h.length && !found; i++) {
                if (s[0] == h[i]) {
                    if (s.length == 1) { found = true; }
                    else {
                        boolean temp = true;
                        for (int j=1; j<s.length && i+j<h.length && temp; j++) {
                            if (s[j] != h[i+j]) { temp = false; }
                        }
                        if (temp) { found = true; }
                    }
                    if (found) { result.put(str, i); }
                }
            }
        }

        return result;
    }
}
