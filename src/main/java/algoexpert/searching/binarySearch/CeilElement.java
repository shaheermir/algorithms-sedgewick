package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class CeilElement {
  public static int findCeiling(int[] a, int target) {
    int ans = -1;

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] >= target) {
        ans = a[mid];
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 8, 10, 10, 12, 19};

    StdOut.println(findCeiling(a, 0) + " Expected 1");
    StdOut.println(findCeiling(a, 1) + " Expected 1");
    StdOut.println(findCeiling(a, 5) + " Expected 8");
    StdOut.println(findCeiling(a, 20) + " Expected -1");
  }
}
