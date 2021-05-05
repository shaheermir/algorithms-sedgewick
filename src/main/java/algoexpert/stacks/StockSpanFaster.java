package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanFaster {
  static class Element {
    int index;
    int value;

    Element(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  public static int[] stockSpan(int[] a) {
    int[] result = new int[a.length];
    Stack<Element> stack = new Stack<>();

    for (int i = 0; i < a.length; i++) {
      if (stack.isEmpty()) {
        result[i] = 1;
        stack.push(new Element(i, a[i]));
        continue;
      }

      while (!stack.isEmpty() && stack.peek().value <= a[i]) {
        stack.pop();
      }

      result[i] = stack.isEmpty() ? i + 1 : i - stack.peek().index;
      stack.push(new Element(i, a[i]));
    }

    return result;
  }

  public static void main(String[] args) {
    int[] stocks = {100, 80, 60, 70, 60, 75, 85, 200};
    int[] expected = {1, 1, 1, 2, 1, 4, 6, 8};

    StdOut.println("Actual   " + Arrays.toString(stockSpan(stocks)));
    StdOut.println("Expected " + Arrays.toString(expected));
  }
}
