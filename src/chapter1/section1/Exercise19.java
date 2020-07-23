package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19 {
    // Fibonacci using dynamic programming.
    public static int fibonacci(int n) {
        int[] fibs = new int[n + 2];

        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        return fibs[n];
    }


    public static void main(String[] args) {
        StdOut.println(fibonacci(8));
    }
}
