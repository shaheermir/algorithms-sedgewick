package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

/**
 * Given an infinite sorted array consisting 0s and 1s. The problem is to find the index of first
 * ‘1’ in that array. As the array is infinite, therefore it is guaranteed that number ‘1’ will be
 * present in the array. All 0s will come before all the 1s.
 *
 * <p>Example:
 *
 * <p>Input : arr[] = {0, 0, 1, 1, 1, 1} Output : 2
 */
public class FirstOneInBinarySortedArray {
  public static int search(int[] a) {
    int ans = -1;

    int left = 0;
    int right = 1;

    while (a[right] != 1) {
      left = right;
      right = right * 2;

      // should'nt have to check for out of bounds since array is infinite, but we are in the real
      // world.
      if (right >= a.length) right = a.length - 1;
    }

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] == 1) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {

    int[] a = {0, 0, 1, 1, 1, 1};
    int[] b = {1, 1, 1, 1, 1, 1, 1};
    int[] c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    StdOut.println(search(a) + " Expected 2");
    StdOut.println(search(b) + " Expected 0");
    StdOut.println(search(c) + " Expected " + (c.length - 1));
  }
}
