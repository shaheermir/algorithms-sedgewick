package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class IsSquare {
  public static boolean isNumberSquare(int n) {
    int[] a = new int[n];
    for (int i = 1; i <= a.length; i++) a[i - 1] = i;

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + right;
      int square = a[mid] * a[mid];
      if (square < n) left = mid + 1;
      else if (square > n) right = mid - 1;
      else return true;
    }

    return false;
  }

  public static void main(String[] args) {
    StdOut.println("25 " + isNumberSquare(25) + " Expected true");
    StdOut.println("16 " + isNumberSquare(16) + " Expected true");
    StdOut.println("17 " + isNumberSquare(17) + " Expected false");
  }
}
