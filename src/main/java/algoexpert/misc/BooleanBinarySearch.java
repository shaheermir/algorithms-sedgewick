package algoexpert.misc;

import edu.princeton.cs.algs4.StdOut;

public class BooleanBinarySearch {
  /**
   * Given an array of boolean values which ALWAYS start off as true, might stay true, turn to
   * false, and remain and end as false, find the index of the first false.
   */
  public static int binarySearch(boolean[] a) {
    int left = 1;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid]) left = mid + 1;
      else right = mid - 1;
    }
    return left;
  }

  public static double findPercentage(boolean[] a) {
    double indexOfFirstFalse = binarySearch(a);
    return (indexOfFirstFalse / a.length) * 100;
  }

  public static void main(String[] args) {
    boolean[] a = {true, true, true, false, false};
    boolean[] b = {true, true, true, true, false};

    //    StdOut.println(binarySearch(a) + " Expected 3");
    //    StdOut.println(binarySearch(b) + " Expected 4");

    StdOut.println(findPercentage(a));
    StdOut.println(findPercentage(b));
  }
}
