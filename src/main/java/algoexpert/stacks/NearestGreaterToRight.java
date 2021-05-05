package algoexpert.stacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * For each element in the given array, find its nearest greater element to the right. If there are
 * no greater elements to the right, mark it as -1.
 */
public class NearestGreaterToRight {

  public static int[] nextLargestElement(int[] a) {
    int[] result = new int[a.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = a.length - 1; i >= 0; i--) {
      int current = a[i];
      if (stack.isEmpty()) {
        result[i] = -1;
      } else {
        while (!stack.isEmpty() && stack.peek() <= current) {
          stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
      }

      stack.push(current);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 2, 4};
    StdOut.println(Arrays.toString(nextLargestElement(a)) + " Expected [3, 4, 4, -1]");

    int[] b = {11, 13, 21, 3};
    StdOut.println(Arrays.toString(nextLargestElement(b)) + " Expected [13, 21, -1, -1]");
  }
}
