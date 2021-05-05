package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class ReverseSorted {
  // desc array essentially
  public static int binarySearchOnReverseSorted(int[] a, int target) {

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (a[mid] < target) right = mid - 1;
      else if (a[mid] > target) left = mid + 1;
      else return mid;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] a = {20, 17, 15, 14, 13, 12, 10, 9, 8, 4};

    StdOut.println(binarySearchOnReverseSorted(a, 17) + " Expected 1");
    StdOut.println(binarySearchOnReverseSorted(a, 8) + " Expected 8");
  }
}
