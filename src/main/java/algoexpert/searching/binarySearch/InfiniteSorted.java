package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

/**
 * Array is sorted but is infinite in length. That means we we are unable to achieve an upper bound
 * for our BS.
 */
public class InfiniteSorted {
  public static int search(int[] a, int target) {
    int left = 0;
    int right = 1;

    while (a[right] <= target) {
      left = right;
      right = right * 2;

      if (right >= a.length) {
        right = a.length - 1;
        break;
      }
    }

    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid] < target) left = mid + 1;
      else if (a[mid] > target) right = mid - 1;
      else return mid;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] a = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};

    StdOut.println(search(a, 10) + " Expected 4");
    StdOut.println(search(a, 160) + " Expected 9");
    StdOut.println(search(a, 3) + " Expected 0");
    StdOut.println(search(a, 170) + " Expected 10");
    StdOut.println(search(a, 200) + " Expected -1");
    StdOut.println(search(a, 0) + " Expected -1");
  }
}
