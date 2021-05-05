package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToLeft {
  public static int[] nearestSmallerToLeft(int[] a) {
    int[] result = new int[a.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < a.length; i++) {
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
    StdOut.println(Arrays.toString(nearestSmallerToLeft(a)) + " Expected [-1, 1, 1, 2]");

    int[] b = {11, 13, 21, 3};
    StdOut.println(Arrays.toString(nearestSmallerToLeft(b)) + " Expected [-1, 11, 13, -1]");
  }
}
