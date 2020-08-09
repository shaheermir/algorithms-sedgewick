package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise20 {
  public static void main(String[] args) {
    int[] bitonicArray = {200, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -3, -2};
    StdOut.println(Arrays.toString(bitonicArray));
    StdOut.println();

    //    StdOut.println("Searching for 2: " + bitonicSearch(bitonicArray, 2));
    StdOut.println("Finding Peak: " + findPeak(bitonicArray));
  }

  public static int bitonicSearch(int[] a) {
    return -1;
  }

  public static int findPeak(int[] a) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if ((mid == 0 && a[mid] > a[mid + 1]) || (mid == a.length - 1 && a[mid] > a[mid - 1])) {
        return a[mid];
      } else if (mid > 0 && a[mid - 1] < a[mid] && mid < a.length - 1 && a[mid] > a[mid + 1]) {
        return a[mid];
      } else if (mid > 0 && a[mid] < a[mid - 1]) {
        right = mid - 1;
      } else if (mid < a.length - 1 && a[mid] < a[mid + 1]) {
        left = mid + 1;
      }
    }

    return -1;
  }
}
