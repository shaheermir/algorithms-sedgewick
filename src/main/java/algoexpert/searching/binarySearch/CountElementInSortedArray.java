package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

public class CountElementInSortedArray {
  public static int countElement(int[] a, int target) {

    int firstOccurrence = FirstAndLastOccurrence.firstOccurrence(a, target);
    int lastOccurrence = FirstAndLastOccurrence.lastOccurrence(a, target);

    if (firstOccurrence == -1) return 0;
    if (firstOccurrence == lastOccurrence) return 1;
    return lastOccurrence - firstOccurrence + 1;
  }

  public static void main(String[] args) {
    int[] a = {2, 4, 10, 10, 10, 10, 10, 10, 18, 18, 18, 18, 20};

    StdOut.println(countElement(a, 10) + " Expected 6");
    StdOut.println(countElement(a, 18) + " Expected 4");
    StdOut.println(countElement(a, 1) + " Expected 0");
  }
}
