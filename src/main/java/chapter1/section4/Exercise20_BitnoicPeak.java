package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20_BitnoicPeak {

  public static int findPeakElementInBitonicArray(int[] a) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (mid > 0 && mid < a.length - 1) {
        if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) return mid;
        else if (a[mid] > a[mid - 1]) left = mid + 1;
        else right = mid - 1;
      } else if (mid == 0) {
        return mid + 1;
      } else if (mid == a.length - 1) {
        if (a[mid] > a[mid - 1]) return mid;
        else return mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 4, 3, 2, 1};
    int[] b = {1, 100, 99, 98, 97, 96, 95, 50, 40, 30, 20, 10};
    int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 100, 99};
    int[] d = {1, 2, 3, 4, 5};

    StdOut.println(findPeakElementInBitonicArray(a) + " Expected 4");
    StdOut.println(findPeakElementInBitonicArray(b) + " Expected 1");
    StdOut.println(findPeakElementInBitonicArray(c) + " Expected 15");
    StdOut.println(findPeakElementInBitonicArray(d) + " Expected 4");
  }
}
