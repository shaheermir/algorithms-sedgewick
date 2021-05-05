package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

import java.util.Arrays;

public class Heap {
  public static void sort(Comparable[] a) {
    constructHeap(a);
    sortDown(a);
  }

  private static void constructHeap(Comparable[] a) {
    for (int k = a.length / 2; k >= 0; k--) {
      sink(a, k, a.length - 1);
    }
  }

  private static void sortDown(Comparable[] a) {
    int endIndex = a.length - 1;

    while (endIndex >= 0) {
      ArrayUtil.swap(a, 0, endIndex);
      endIndex--;
      sink(a, 0, endIndex);
    }
  }

  private static void sink(Comparable[] a, int k, int endIndex) {
    while (true) {
      int left = (k * 2) + 1;
      int right = (k * 2) + 2;
      int smallerChild = left;

      if (right <= endIndex && !greater(a, right, left)) smallerChild = right;

      if (smallerChild > endIndex || greater(a, smallerChild, k)) break;

      swap(a, k, smallerChild);
      k = smallerChild;
    }
  }

  private static void swap(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private static boolean greater(Comparable[] a, int i, int j) {
    return a[i].compareTo(a[j]) >= 0;
  }

  public static void main(String[] args) {
    Integer[] a = {10, 9, 9, 8, 7, 6, 5, 4, 3, 0, 2, 1};
    Heap.sort(a);

    StdOut.println(Arrays.toString(a));

    StdOut.println();
    StdOut.println();
  }
}
