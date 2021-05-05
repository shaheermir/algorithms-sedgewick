package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

  public static int ascendingBinarySearch(int[] a, int key) {
    int left = 0, right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (a[mid] == key) return mid;
      else if (a[mid] < key) left = mid + 1;
      else if (a[mid] > key) right = mid - 1;
    }

    return -1;
  }

  public static int descendingBinarySearch(int[] a, int key) {
    int left = 0, right = a.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (a[mid] == key) return mid;
      else if (a[mid] < key) right = mid - 1;
      else if (a[mid] > key) left = mid + 1;
    }

    return -1;
  }

  public static int firstOccurrence(int[] a, int key) {
    int index = -1;
    int left = 0, right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (a[mid] == key) {
        index = mid;
        right = mid - 1;
      } else if (a[mid] > key) {
        right = mid - 1;
      } else if (a[mid] < key) {
        left = mid + 1;
      }
    }

    return index;
  }

  public static int lastOccurence(int[] a, int key) {
    int index = -1;
    int left = 0, right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (a[mid] == key) {
        index = mid;
        left = mid + 1;
      } else if (a[mid] < key) {
        left = mid + 1;
      } else if (a[mid] > key) {
        right = mid - 1;
      }
    }

    return index;
  }

  public static void main(String[] args) {
    int[] a = {0, 1, 2, 3, 4, 5, 6, 7};

    StdOut.println(Arrays.toString(a));
    StdOut.println("Search for 7. BS returned " + ascendingBinarySearch(a, 7) + ". Expected 7");
    StdOut.println("Search for 4. BS returned " + ascendingBinarySearch(a, 4) + ". Expected 4");
    StdOut.println("Search for 9. BS returned " + ascendingBinarySearch(a, 9) + ". Expected -1");

    int[] d = {7, 6, 5, 4, 3, 2, 1, 0};
    StdOut.println("\n" + Arrays.toString(d));
    StdOut.println("Search for 7. BS returned " + descendingBinarySearch(d, 7) + ". Expected 0");
    StdOut.println("Search for 4. BS returned " + descendingBinarySearch(d, 4) + ". Expected 3");
    StdOut.println("Search for 9. BS returned " + descendingBinarySearch(d, 9) + ". Expected -1");

    int[] b = {0, 1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
    StdOut.println("\n" + Arrays.toString(b));
    StdOut.println(
        "Search for 0. FirstOccurence returned " + firstOccurrence(b, 0) + ". Expected 0");
    StdOut.println(
        "Search for 1. FirstOccurence returned " + firstOccurrence(b, 1) + ". Expected 1");
    StdOut.println(
        "Search for 2. FirstOccurence returned " + firstOccurrence(b, 2) + ". Expected 4");
    StdOut.println(
        "Search for 9. FirstOccurence returned " + firstOccurrence(b, 9) + ". Expected 12");
    StdOut.println(
        "Search for 100. FirstOccurence returned " + firstOccurrence(b, 100) + ". Expected -1");

    StdOut.println("\n" + Arrays.toString(b));
    StdOut.println("Search for 0. LastOccurence returned " + lastOccurence(b, 0) + ". Expected 0");
    StdOut.println("Search for 1. LastOccurence returned " + lastOccurence(b, 1) + ". Expected 3");
    StdOut.println("Search for 2. LastOccurence returned " + lastOccurence(b, 2) + ". Expected 5");
    StdOut.println("Search for 9. LastOccurence returned " + lastOccurence(b, 9) + ". Expected 12");
    StdOut.println(
        "Search for 100. LastOccurence returned " + lastOccurence(b, 100) + ". Expected -1");
  }
}
