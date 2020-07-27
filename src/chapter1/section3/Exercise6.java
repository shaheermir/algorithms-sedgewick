package chapter1.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i <= 5; i++) q.enqueue(i);

        StdOut.println("Queue - " + q);
        reverseQ(q);
        StdOut.println("Reversed Queue - " + q);
    }

    public static <T> void reverseQ(Queue<T> q) {
        Stack<T> stack = new Stack<T>();

        while (!q.isEmpty())
            stack.push(q.dequeue());

        while (!stack.isEmpty())
            q.enqueue(stack.pop());
    }
}
