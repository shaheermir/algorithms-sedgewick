package chapter1.section4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise27_QueueWithStacks<T> {
  private Stack<T> stack1 = new Stack<>();
  private Stack<T> stack2 = new Stack<>();

  public int size() {
    return stack1.size() + stack2.size();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void enqueue(T item) {
    stack1.push(item);
  }

  public T dequeue() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }

    return stack2.pop();
  }

  public static void main(String[] args) {
    Exercise27_QueueWithStacks<Integer> q = new Exercise27_QueueWithStacks<>();

    StdOut.println("Enqueuing 1 through 5");
    for (int i = 1; i < 6; i++) q.enqueue(i);

    StdOut.println();
    StdOut.println("Dequeued: " + q.dequeue());
    StdOut.println("Dequeued: " + q.dequeue());

    StdOut.println("\nEnqueuing 6\n");
    q.enqueue(6);

    StdOut.println("Dequeued: " + q.dequeue());
    StdOut.println("Dequeued: " + q.dequeue());
    StdOut.println("Dequeued: " + q.dequeue());
    StdOut.println("Dequeued: " + q.dequeue());
  }
}
