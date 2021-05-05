package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class PeakElement {

  // MIT 6.006 Introduction to Algorithms, Fall 2011
  public static int findPeak(int[] a) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (mid > 0 && a[mid] <= a[mid - 1]) {
        right = mid - 1;
      } else if (mid < a.length - 1 && a[mid] <= a[mid + 1]) {
        left = mid + 1;
      } else {
        return a[mid];
      }
    }

    return a[0];
  }

  public static void main(String[] args) {
    int[] a = {5, 10, 20, 15};
    StdOut.println(findPeak(a) + " Expected " + 2);
  }
}
