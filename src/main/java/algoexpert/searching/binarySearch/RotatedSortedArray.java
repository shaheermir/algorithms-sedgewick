package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class RotatedSortedArray {
  public static int find(int[] a, int target) {

    int minElementIndex = findMinElementIndex(a);

    int leftSideSearch = binarySearch(a, target, 0, minElementIndex - 1);
    int rightSideSearch = binarySearch(a, target, minElementIndex, a.length - 1);

    return leftSideSearch != -1 ? leftSideSearch : rightSideSearch;
  }

  private static int findMinElementIndex(int[] a) {
    int left = 0;
    int right = a.length - 1;
    int last = a.length - 1;

    int ans = -1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid] <= a[last]) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  private static int binarySearch(int[] a, int target, int left, int right) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid] < target) left = mid + 1;
      else if (a[mid] > target) right = mid - 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {4, 5, 6, 7, 0, 1, 2};
    StdOut.println(find(a, 0) + " Expected 4");
    StdOut.println(find(a, 3) + " Expected -1");

    int[] b = {0, 1};
    StdOut.println(find(b, 0) + " Expected 0");
    StdOut.println(find(b, 1) + " Expected 0");
  }
}
