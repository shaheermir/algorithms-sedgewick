package chapter2.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Insertion {
  public static void sort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      int val = a[i];
      int hole = i;
      while (hole > 0 && a[hole - 1] > val) {
        a[hole] = a[hole - 1];
        hole--;
      }
      a[hole] = val;
    }
  }

  public static int[] insertionSort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      int hole = i;
      while (hole > 0 && a[hole - 1] > a[hole]) {
        swap(a, hole, hole - 1);
        hole--;
      }
    }
    return a;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static boolean isSorted(int[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i] < a[i - 1]) return false;
    }
    return true;
  }

  public static void main(String[] args) {

    int[] a = {10, 9, 8, 8, 7, 6, 3, 3, -1, 2, 1};
    sort(a);
    assert isSorted(a);
    StdOut.println(Arrays.toString(a));

    int[] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sort(b);
    assert isSorted(b);
    StdOut.println(Arrays.toString(b));
  }
}
