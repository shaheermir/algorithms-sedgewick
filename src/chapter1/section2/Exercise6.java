package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {

    public static void main(String[] args) {
        String s = "cat";
        String t = "dog";
        StdOut.printf("String1: %s, String2: %s - Is Circular ? %b \n", s, t, isCircularShift(s, t));

        String s2 = "cat";
        String t2 = "atc";
        StdOut.printf("String1: %s, String2: %s - Is Circular ? %b \n", s2, t2, isCircularShift(s2, t2));
    }

    public static boolean isCircularShift(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }
}
