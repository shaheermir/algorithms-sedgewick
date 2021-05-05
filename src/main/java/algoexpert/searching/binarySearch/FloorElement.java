package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class FloorElement {
  public static int findFloor(int[] a, int target) {
    int ans = -1;

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] <= target) {
        ans = a[mid];
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 8, 10, 10, 12, 19};
    int target = 5;
    int expected = 2;

    StdOut.println(findFloor(a, target) + " Expected " + expected);

    int[] b = {1, 2, 8, 10, 10, 12, 19};
    int bTarget = 0;
    int bExpected = -1;

    StdOut.println(findFloor(b, bTarget) + " Expected " + bExpected);
  }
}
