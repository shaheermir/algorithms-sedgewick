package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class SearchForRange {
  public static int[] searchForRange(int[] a, int target) {

    int firstOccurrence = firstOccurrence(a, target);
    int lastOccurrence = lastOccurrence(a, target);

    return new int[] {firstOccurrence, lastOccurrence};
  }

  private static int firstOccurrence(int[] a, int target) {
    int ans = -1;

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid] > target) right = mid - 1;
      else if (a[mid] < target) left = mid + 1;
      else {
        ans = mid;
        right = mid - 1;
      }
    }

    return ans;
  }

  private static int lastOccurrence(int[] a, int target) {
    int ans = -1;

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] > target) right = mid - 1;
      else if (a[mid] < target) left = mid + 1;
      else {
        ans = mid;
        left = mid + 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
    int[] expected = {4, 9};
    int[] output = searchForRange(a, 45);

    StdOut.println(Arrays.toString(output) + " Expected " + Arrays.toString(expected));
  }
}
