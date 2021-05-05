package chapter2.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Insertion {
  public static void sort(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      Comparable val = a[i];
      int hole = i;
      while (hole > 0 && a[hole - 1].compareTo(val) > 0) {
        a[hole] = a[hole - 1];
        hole--;
      }

      a[hole] = val;
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
