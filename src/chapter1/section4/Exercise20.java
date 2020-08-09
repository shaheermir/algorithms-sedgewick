package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise20 {
  public static void main(String[] args) {
    int[] bitonicArray = {200, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -3, -2};
    int[] bitonicArray2 = {200, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] bitonicArray3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] bitonicArray4 = {-9, -20, -2, -3, -4, -5, -6, -7, -8};
    int[] bitonicArray5 = {-9, -1, -2, -3, -4, -5, -6, -7, -8};

    StdOut.println(Arrays.toString(bitonicArray));
    StdOut.println("Finding Peak: " + findPeak(bitonicArray));

    StdOut.println();
    StdOut.println(Arrays.toString(bitonicArray2));
    StdOut.println("Finding Peak: " + findPeak(bitonicArray2));

    StdOut.println();
    StdOut.println(Arrays.toString(bitonicArray3));
    StdOut.println("Finding Peak: " + findPeak(bitonicArray3));

    StdOut.println();
    StdOut.println(Arrays.toString(bitonicArray4));
    StdOut.println("Finding Peak: " + findPeak(bitonicArray4));

    StdOut.println();
    StdOut.println(Arrays.toString(bitonicArray5));
    StdOut.println("Finding Peak: " + findPeak(bitonicArray5));
  }

  public static int findPeak(int[] a) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (mid > 0 && mid < a.length - 1) {
        if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
          return a[mid];
        } else if (a[mid] < a[mid - 1]) {
          right = mid - 1;
        } else if (a[mid] < a[mid + 1]) {
          left = mid + 1;
        }
      } else if (mid == 0) {
        if (a[mid] > a[mid + 1]) return a[mid];
        else break;
      } else if (mid == a.length - 1) {
        if (a[mid] > a[mid - 1]) return a[mid];
        else break;
      }
    }

    return -9999;
  }

  public static int findPeak2(int[] a) {
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

    return -9999;
  }
}
