package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

// Sorting order is not known.
public class OrderAgnosticSearch {
  public static int orderAgnosticSearch(int[] a, int target) {
    if (a.length == 0) return -1;
    if (a.length == 1) return a[0] == target ? 0 : -1;

    if (a[0] < a[a.length - 1]) return BinarySearch.binarySearch(a, target);
    else return ReverseSorted.binarySearchOnReverseSorted(a, target);
  }

  public static void main(String[] args) {
    int[] a = {20, 17, 15, 14, 13, 12, 10, 9, 8, 4};

    StdOut.println(orderAgnosticSearch(a, 17) + " Expected 1");
    StdOut.println(orderAgnosticSearch(a, 8) + " Expected 8");
  }
}
