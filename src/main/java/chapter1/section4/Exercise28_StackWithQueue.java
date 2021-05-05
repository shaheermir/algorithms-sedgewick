package chapter1.section4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Exercise28_StackWithQueue<T> {
  private Queue<T> q = new Queue<>();

  public int size() {
    return q.size();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void push(T item) {
    q.enqueue(item);
  }

  public T pop() {
    if (q.isEmpty()) throw new NoSuchElementException("Queue is empty");

    for (int i = 0; i < q.size() - 1; i++) {
      q.enqueue(q.dequeue());
    }

    return q.dequeue();
  }

  public static void main(String[] args) {
    Exercise28_StackWithQueue<Integer> stack = new Exercise28_StackWithQueue<>();

    StdOut.println("Pushing 1 through 5");
    for (int i = 1; i < 6; i++) stack.push(i);

    StdOut.println();
    StdOut.println("Popped " + stack.pop());
    StdOut.println("Popped " + stack.pop());

    StdOut.println();
    StdOut.println("Pushing 6 and 7.");
    stack.push(6);
    stack.push(7);

    StdOut.println();
    StdOut.println("Emptying Stack");
    while (!stack.isEmpty()) StdOut.println("Popped " + stack.pop());
  }
}
