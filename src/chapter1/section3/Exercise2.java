package chapter1.section3;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (item.equals("-")) {
                if (!stack.isEmpty()) StdOut.println(stack.pop());
            } else {
                stack.push(item);
            }
        }

        System.out.println("Items Remaining On Stack: " + stack.size());
    }
}
