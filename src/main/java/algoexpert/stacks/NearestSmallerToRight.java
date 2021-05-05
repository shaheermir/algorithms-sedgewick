package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRight {
  public static int[] nearestSmallerToRight(int[] a) {
    int[] result = new int[a.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = a.length - 1; i >= 0; i--) {
      int current = a[i];

      if (stack.isEmpty()) result[i] = -1;

      while (!stack.isEmpty() && stack.peek() >= current) {
        stack.pop();
      }

      result[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(current);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 2, 4};
    StdOut.println(Arrays.toString(nearestSmallerToRight(a)) + " Expected [-1, 2, -1, -1]");

    int[] b = {11, 13, 21, 3};
    StdOut.println(Arrays.toString(nearestSmallerToRight(b)) + " Expected [3, 3, 3, -1]");
  }
}
