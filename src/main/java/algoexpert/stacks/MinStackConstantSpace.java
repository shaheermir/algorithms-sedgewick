package algoexpert.stacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

// if we find a value in stack thats lower than the minimum, thats a flag.
// this means that the valye in the stack is hashed.

public class MinStackConstantSpace {
  int min;
  Stack<Integer> stack = new Stack<>();

  public void push(int item) {
    if (stack.isEmpty()) {
      stack.push(item);
      min = item;
      return;
    }

    if (item >= min) {
      stack.push(item);
    } else {
      int hashedValue = (2 * item) - min;
      min = item;
      stack.push(hashedValue);
    }
  }

  public int peek() {
    if (stack.isEmpty()) throw new RuntimeException("Stack underflow");

    if (stack.peek() >= min) return stack.peek();

    return min;
  }

  public int pop() {
    if (stack.isEmpty()) throw new RuntimeException("Stack underflow");

    if (stack.peek() >= min) return stack.pop();

    int newMin = (2 * min) + stack.peek();
    stack.pop(); // pop the hashed value
    int valueToBeReturned = min;
    min = newMin;
    return valueToBeReturned;
  }

  public int peekMin() {
    if (stack.isEmpty()) throw new RuntimeException("Stack underflow");
    return min;
  }

  public static void main(String[] args) {
    MinStackConstantSpace stack = new MinStackConstantSpace();

    StdOut.println("Pushed 18");
    StdOut.println("Pushed 19");
    StdOut.println("Pushed 29");

    stack.push(18);
    stack.push(19);
    stack.push(29);

    StdOut.println();
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
