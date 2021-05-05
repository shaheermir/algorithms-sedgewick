package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class PeakFinding {
  public static int peak(int[] a) {
    int ans = a[0];

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (mid == 0 || a[mid - 1] <= a[mid]) {
        ans = a[mid];
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 4, 6, 9, 12, 11, 8, 6, 4, 1};
    int[] b = {5, 3, 1};
    int[] c = {1, 3, 5};
    int[] d = {10, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4};
    StdOut.println(peak(a) + " Expected 12");
    StdOut.println(peak(b) + " Expected 5");
    StdOut.println(peak(c) + " Expected 5");
    StdOut.println(peak(d) + " Expected 10");
  }
}
