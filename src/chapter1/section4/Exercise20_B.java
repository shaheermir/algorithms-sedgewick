package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise20_B {
  public static void main(String[] args) {

    int[] bitonicArray = {1, 2, 3, 4, 5, 6, -1, -2, -3, -4};
    StdOut.println(Arrays.toString(bitonicArray));

    StdOut.println("Searching for 3 : Index " + bitonicSearch(bitonicArray, 3));
    StdOut.println("Searching for -3 : Index " + bitonicSearch(bitonicArray, -3));
    StdOut.println("Searching for -5 : Index " + bitonicSearch(bitonicArray, -5));
  }

  public static int bitonicSearch(int[] a, int key) {
    // we are gonna split the array at the peak so that
    // left side is in asc order, while right side is in desc order.
    int peakIndex = findPeakIndex(a);
    int indexFromAscArray = binarySearch(a, key, 0, peakIndex - 1);
    int indexFromDescArray = binarySearchOnReverse(a, key, peakIndex, a.length - 1);

    return indexFromAscArray != -1 ? indexFromAscArray : indexFromDescArray;
  }

  private static int binarySearch(int[] a, int key, int left, int right) {
    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (a[middle] == key) return middle;
      else if (a[middle] < key) left = middle + 1;
      else if (a[middle] > key) right = middle - 1;
    }
    return -1;
  }

  private static int binarySearchOnReverse(int[] a, int key, int left, int right) {
    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (a[middle] == key) return middle;
      else if (a[middle] < key) right = middle - 1;
      else if (a[middle] > key) left = middle + 1;
    }
    return -1;
  }

  private static int findPeakIndex(int[] a) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (mid > 0 && mid < a.length - 1) {
        if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
          return mid;
        } else if (a[mid] < a[mid - 1]) {
          right = mid - 1;
        } else if (a[mid] < a[mid + 1]) {
          left = mid + 1;
        }
      } else if (mid == 0) {
        if (a[mid] > a[mid + 1]) return mid;
        else break;
      } else if (mid == a.length - 1) {
        if (a[mid] > a[mid - 1]) return mid;
        else break;
      }
    }

    return -1;
  }
}
