package algoexpert.stacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MaximumAreaHistogram {
  static class Element {
    int index;
    int value;

    Element(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  public static int[] maximmumAreaHistogram(int[] a) {
    int[] nsl = nearestSmallerLeft(a);
    int[] nsr = nearestSmallerRight(a);

    int[] areas = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      int width = nsr[i] - nsl[i] - 1;
      int height = a[i];
      areas[i] = width * height;
    }

    return areas;
  }

  private static int[] nearestSmallerLeft(int[] a) {
    int[] nearestSmallerLeft = new int[a.length];
    Stack<Element> stack = new Stack<>();

    for (int i = 0; i < a.length; i++) {
      while (!stack.isEmpty() && stack.peek().value >= a[i]) stack.pop();

      nearestSmallerLeft[i] = stack.isEmpty() ? -1 : stack.peek().index;
      stack.push(new Element(i, a[i]));
    }
    return nearestSmallerLeft;
  }

  private static int[] nearestSmallerRight(int[] a) {
    int[] nearestSmallerRight = new int[a.length];
    Stack<Element> stack = new Stack<>();

    for (int i = a.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek().value >= a[i]) stack.pop();

      nearestSmallerRight[i] = stack.isEmpty() ? a.length : stack.peek().index;
      stack.push(new Element(i, a[i]));
    }
    return nearestSmallerRight;
  }

  public static void main(String[] args) {
    int[] histogram = {6, 2, 5, 4, 5, 1, 6};

    //    StdOut.println(Arrays.toString(nearestSmallerLeft(histogram)));
    //    StdOut.println(Arrays.toString(nearestSmallerRight(histogram)));

    StdOut.println(Arrays.toString(maximmumAreaHistogram(histogram)));
  }
}
