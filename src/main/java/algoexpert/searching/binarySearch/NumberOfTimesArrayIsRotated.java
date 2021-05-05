package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

/**
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated
 * (clockwise) k number of times. Given such an array, find the value of k.
 */
public class NumberOfTimesArrayIsRotated {
  public static int countRotations(int[] a) {
    int minElementIndex = findIndexOfMinElement(a);
    int n = a.length;
    return (n - minElementIndex) % n;
  }

  private static int findIndexOfMinElement(int[] a) {
    int ans = -1;
    int left = 0;
    int right = a.length - 1;
    int last = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid] <= a[last]) {
        ans = mid;
        right = mid - 1;
      } else left = mid + 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] a = {0, 1, 2, 3, 4, 5, 6};
    int[] b = {2, 3, 4, 5, 6, 0, 1};
    int[] c = {6, 0, 1, 2, 3, 4, 5};
    StdOut.println(countRotations(b) + " Expected 2");
    StdOut.println(countRotations(a) + " Expected 0");
    StdOut.println(countRotations(c) + " Expected 6");
  }
}
