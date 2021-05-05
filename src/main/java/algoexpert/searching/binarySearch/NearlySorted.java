package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class NearlySorted {
  public static int search(int[] a, int target) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] == target) return mid;
      if ((mid > 0 && a[mid - 1] == target)) return mid - 1;
      if ((mid < a.length - 1 && a[mid + 1] == target)) return mid + 1;

      if (a[mid] < target) left = mid + 2;
      if (a[mid] > target) right = mid - 2;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 16, 17, 18, 19};

    StdOut.println(search(a, 4) + " Expected 2");
    StdOut.println(search(a, 3) + " Expected 3");
    StdOut.println(search(a, 2) + " Expected 1");
    StdOut.println(search(a, 17) + " Expected 17");
    StdOut.println(search(a, 15) + " Expected 14");
    StdOut.println(search(a, 0) + " Expected -1");
    StdOut.println(search(a, 20) + " Expected -1");
  }
}
