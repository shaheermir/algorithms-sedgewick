package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class FirstValueBiggerThanTarget {
  // look for valyes that are equal or larger than target, but then try n find the left most one
  public static int find(int[] a, int target) {
    int ans = -1;

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] < target) left = mid + 1;
      else if (a[mid] >= target) {
        ans = a[mid];
        right = mid - 1;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 5, 6, 8, 10, 12};
    int target = 4;

    StdOut.println(find(a, target) + " Expected 5");
  }
}
