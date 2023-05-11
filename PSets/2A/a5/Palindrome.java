package a5;

public class Palindrome {
    public static boolean isPalindrome (char[] S) {
        // Base cases
        if (S.length == 1) { return true; }
        else if (S.length == 2) {
            if (S[0] == S[1]) { return true; }
        }
        // Recursive case
        if (S[0] == S[S.length-1]) {
            char[] newS = new char[S.length-2];
            System.arraycopy(S, 1, newS, 0, S.length - 2);
            return isPalindrome(newS);
        }
        else { return false; }
    }
}
