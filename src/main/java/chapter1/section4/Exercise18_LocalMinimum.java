package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

// Peak / Min Finding
public class Exercise18_LocalMinimum {
  public static int recursiveLocalMinimum(int[] a) {
    return innerLocalMinimum(a, 0, a.length - 1);
  }

  private static int innerLocalMinimum(int[] a, int left, int right) {

    int mid = (left + right) / 2;

    //    (mid == 0 || a[mid - 1] > a[mid]) && (mid == a.length - 1 || a[mid] < a[mid + 1]) -->
    // works, but too confusing to read

    if ((mid == 0 && a[mid] < a[mid + 1]) || (mid == a.length - 1 && a[mid] < a[mid - 1])) {
      return mid;
    } else if (a[mid] < a[mid + 1] && a[mid] < a[mid - 1]) {
      return mid;
    } else if (mid > 0 && a[mid] > a[mid - 1]) {
      return innerLocalMinimum(a, left, mid - 1);
    } else {
      return innerLocalMinimum(a, mid + 1, right);
    }
  }

  // Iterative is easier to understand - check Aditya Vermas video if not sure whats going on here.
  // (Peak Finding)
  public static int localMinimum(int[] a) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (mid > 0 && mid < a.length - 1) {
        if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) return mid;
        else if (a[mid - 1] < a[mid]) right = mid - 1;
        else left = mid + 1;
      } else if (mid == 0) {
        if (a[mid] < a[mid + 1]) return 0;
        else return 1;
      } else if (mid == a.length - 1) {
        if (a[mid] < a[mid - 1]) return mid;
        else return mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] a = {9, 6, 3, 14, 5, 7, 4};
    int[] b = {23, 8, 15, 2, 3};
    int[] c = {1, 2, 3};
    int[] d = {3, 2, 1};

    StdOut.println("Recursive Algo");
    StdOut.println(recursiveLocalMinimum(a) + " Expected 2");
    StdOut.println(recursiveLocalMinimum(b) + " Expected 1");
    StdOut.println(recursiveLocalMinimum(c) + " Expected 0");
    StdOut.println(recursiveLocalMinimum(d) + " Expected 2");

    StdOut.println("\nIterative Algo");
    StdOut.println(localMinimum(a) + " Expected 2");
    StdOut.println(localMinimum(b) + " Expected 1");
    StdOut.println(localMinimum(c) + " Expected 0");
    StdOut.println(localMinimum(d) + " Expected 2");
  }
}
