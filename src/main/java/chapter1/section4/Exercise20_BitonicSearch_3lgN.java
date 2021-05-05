package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20_BitonicSearch_3lgN {

  public static int bitnoicSearch(int[] a, int key) {
    int peakIndex = findPeakIndex(a);

    int ascendingSearch = ascendingBinarySearch(a, key, 0, peakIndex);
    int descendingSearch = descendingBinarySearch(a, key, peakIndex + 1, a.length - 1);

    if (ascendingSearch != -1) return ascendingSearch;
    if (descendingSearch != -1) return descendingSearch;

    return -1;
  }

  private static int findPeakIndex(int[] a) {
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

  private static int ascendingBinarySearch(int[] a, int key, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (a[mid] == key) return mid;
      else if (a[mid] < key) left = mid + 1;
      else if (a[mid] > key) right = mid - 1;
    }

    return -1;
  }

  private static int descendingBinarySearch(int[] a, int key, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (a[mid] == key) return mid;
      else if (a[mid] < key) right = mid - 1;
      else if (a[mid] > key) left = mid + 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 4, 3, 2, 1};
    int[] b = {1, 100, 99, 98, 97, 96, 95, 50, 40, 30, 20, 10};
    int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 100, 99};
    int[] d = {1, 2, 3, 4, 5};

    StdOut.println(bitnoicSearch(c, 1));
  }
}
