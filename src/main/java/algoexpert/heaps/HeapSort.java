package algoexpert.heaps;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class HeapSort {
  public static int[] heapSort(int[] a) {
    heapify(a);
    sortDown(a);
    return a;
  }

  // build max heap
  private static void heapify(int[] a) {
    for (int k = a.length / 2; k >= 0; k--) {
      sink(a, k, a.length - 1);
    }
  }

  // pops an element from max heap and puts it into back of the array
  private static void sortDown(int[] a) {
    int endIndex = a.length - 1;

    while (endIndex >= 0) {
      swap(a, 0, endIndex);
      endIndex--;
      sink(a, 0, endIndex);
    }
  }

  private static void sink(int[] a, int k, int endIndex) {
    while (true) {
      int left = (2 * k) + 1;
      int right = (2 * k) + 2;

      int greaterChild = left;

      if (right <= endIndex && a[right] > a[left]) greaterChild = right;

      if (greaterChild > endIndex || a[k] > a[greaterChild]) break;
      swap(a, k, greaterChild);
      k = greaterChild;
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = {10, 9, 9, 8, 7, 6, 5, 4, 3, 0, 2, 1};
    heapSort(a);

    StdOut.println(Arrays.toString(a));
    StdOut.println();
  }
}
