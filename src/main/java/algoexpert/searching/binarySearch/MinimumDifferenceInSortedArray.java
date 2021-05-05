package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

/**
 * Given a sorted array, find the element in the array which has minimum difference with the given
 * number.
 *
 * <p>Could also field ceiling and floor. Then find respective differences with the target, and
 * return the one with smaller diff. BUt that reqs 2 Binary Searches. This soln does it in one.
 */
public class MinimumDifferenceInSortedArray {
  public static int search(int[] a, int target) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] < target) left = mid + 1;
      else if (a[mid] > target) right = mid - 1;
      else return a[mid];
    }

    int leftDiff = Math.abs(target - a[left]);
    int rightDiff = Math.abs(target - a[right]);

    int closest = leftDiff < rightDiff ? left : right;
    return a[closest];
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 8, 10, 15};
    int[] b = {1, 3, 8, 10, 12, 15};
    StdOut.println(search(a, 12) + " Expected 10");
    StdOut.println(search(b, 12) + " Expected 12");
  }
}
