package chapter2.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Selection {
  public static void sort(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[j].compareTo(a[minIndex]) < 0) minIndex = j;
      }
      Comparable temp = a[i];
      a[i] = a[minIndex];
      a[minIndex] = temp;
    }
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i].compareTo(a[i - 1]) < 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {

    Integer[] a = {10, 9, 8, 8, 7, 6, 3, 3, -1, 2, 1};
    sort(a);

    assert isSorted(a);
    StdOut.println(Arrays.toString(a));
  }
}
