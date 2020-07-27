package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise5 {
    public static void main(String[] args) {

        while (!StdIn.isEmpty()) {
            int number = StdIn.readInt();
            StdOut.println(binary(number));
        }
    }

    private static String binary(int number) {
        int n = number;
        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }

        StringBuilder result = new StringBuilder();
        for (int d : stack) result.append(d);

        return result.toString();
    }
}
