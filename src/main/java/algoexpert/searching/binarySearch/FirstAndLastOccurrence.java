package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class FirstAndLastOccurrence {

  public static int firstOccurrence(int[] a, int target) {
    int left = 0;
    int right = a.length - 1;

    int result = -1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] < target) left = mid + 1;
      else if (a[mid] > target) {
        right = mid - 1;
      } else {
        result = mid;
        right = mid - 1;
      }
    }

    return result;
  }

  public static int firstOccurrenceRecursive(int[] a, int target, int result, int left, int right) {
    int mid = left + (right - left) / 2;
    if (left > right) return result;

    if (a[mid] < target) return firstOccurrenceRecursive(a, target, result, mid + 1, right);
    else if (a[mid] > target) return firstOccurrenceRecursive(a, target, result, left, mid - 1);
    else return firstOccurrenceRecursive(a, target, mid, left, mid - 1);
  }

  public static int lastOccurrence(int[] a, int target) {
    int left = 0;
    int right = a.length - 1;

    int result = -1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (a[mid] < target) left = mid + 1;
      else if (a[mid] > target) {
        right = mid - 1;
      } else {
        result = mid;
        left = mid + 1;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] a = {2, 4, 10, 10, 10, 10, 10, 10, 18, 18, 18, 18, 20};
    int n = a.length - 1;

    StdOut.println(firstOccurrence(a, 10) + " Expected 2");
    StdOut.println(firstOccurrence(a, 18) + " Expected 8");
    StdOut.println(firstOccurrence(a, 1) + " Expected -1");

    StdOut.println();
    StdOut.println(lastOccurrence(a, 10) + " Expected 7");
    StdOut.println(lastOccurrence(a, 18) + " Expected 11");
    StdOut.println(lastOccurrence(a, 1) + " Expected -1");

    StdOut.println();
    StdOut.println(firstOccurrenceRecursive(a, 10, -1, 0, n) + " Expected 2");
    StdOut.println(firstOccurrenceRecursive(a, 18, -1, 0, n) + " Expected 8");
    StdOut.println(firstOccurrenceRecursive(a, 1, -1, 0, n) + " Expected -1");
    StdOut.println(firstOccurrenceRecursive(a, 2, -1, 0, n) + " Expected 0");
    StdOut.println(firstOccurrenceRecursive(a, 20, -1, 0, n) + " Expected 12");
  }
}
