package chapter2.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Shell {
  public static void sort(int[] a) {
    int n = a.length;
    for (int gap = n / 2; gap >= 1; gap = gap / 2) {
      for (int j = gap; j < n; j++) {
        for (int i = j - gap; i >= 0; i = i - gap) {
          if (a[i] < a[i + gap]) break;
          swap(a, i, i + gap);
        }
      }
    }
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
