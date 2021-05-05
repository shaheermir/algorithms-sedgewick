package chapter2.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Selection {
  public static void sort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      int minimumIndex = i;

      for (int j = i + 1; j < a.length; j++) {
        if (a[j] < a[minimumIndex]) minimumIndex = j;
      }
      int temp = a[i];
      a[i] = a[minimumIndex];
      a[minimumIndex] = temp;
    }
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
