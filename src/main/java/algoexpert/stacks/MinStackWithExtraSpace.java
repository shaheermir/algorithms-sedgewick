package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class MinStackWithExtraSpace<T extends Comparable<T>> {
  Stack<T> stack = new Stack<>();
  Stack<T> ss = new Stack<>(); // supporting stack that houses the minimum values

  public void push(T item) {
    if (stack.isEmpty()) {
      stack.push(item);
      ss.push(item);
      return;
    }

    T currentMin = ss.peek();
    if (item.compareTo(currentMin) <= 0) ss.push(item);
    stack.push(item);
  }

  public T peek() {
    return stack.peek();
  }

  public T peekMin() {
    if (stack.isEmpty()) throw new RuntimeException("Stack underflow");
    return ss.peek();
  }

  public T pop() {
    if (stack.isEmpty()) throw new RuntimeException("Stack underflow");

    T currentMin = ss.peek();
    T valueToBeReturned = stack.pop();

    if (valueToBeReturned.compareTo(currentMin) == 0) ss.pop();

    return valueToBeReturned;
  }

  public static void main(String[] args) {
    MinStackWithExtraSpace<Integer> stack = new MinStackWithExtraSpace<>();
    stack.push(18);
    stack.push(19);
    stack.push(29);

    StdOut.println("Peek " + stack.peek() + " Expected 29");
    StdOut.println("Peek Min " + stack.peekMin() + " Expected 18");

    StdOut.println("Pop " + stack.pop() + " Expected 29");

    StdOut.println();
    StdOut.println("Pushing 15");
    stack.push(15);

    StdOut.println();
    StdOut.println("Peek " + stack.peek() + " Expected 15");
    StdOut.println("Peek Min " + stack.peekMin() + " Expected 15");

    StdOut.println();
    StdOut.println("Pushing 16");
    stack.push(16);

    StdOut.println();
    StdOut.println("Peek " + stack.peek() + " Expected 16");
    StdOut.println("Peek Min " + stack.peekMin() + " Expected 15");
  }
}
