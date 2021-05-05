package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
  public static int[] stockSpan(int[] a) {
    int[] result = new int[a.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < a.length; i++) {
      Stack<Integer> temp = new Stack<>();

      int current = a[i];
      int counter = 1;

      if (stack.isEmpty()) result[i] = counter;

      while (!stack.isEmpty() && stack.peek() <= current) {
        temp.push(stack.pop());
        counter++;
      }

      while (!temp.isEmpty()) stack.push(temp.pop());

      result[i] = counter;
      stack.push(current);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] stocks = {100, 80, 60, 70, 60, 75, 85};
    int[] expected = {1, 1, 1, 2, 1, 4, 5};

    StdOut.println(Arrays.toString(stockSpan(stocks)));
  }
}
