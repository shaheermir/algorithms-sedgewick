package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise23 {
  public static void main(String[] args) {
    int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
    int key1 = 5;
    int key2 = 9;
    int key3 = 2;
    int key4 = 10;

    StdOut.println(Arrays.toString(nums));
    StdOut.println();

    StdOut.println("Searching for left most " + key1 + ": " + binarySearch(nums, key1, true));
    StdOut.println("Searching for right most " + key1 + ": " + binarySearch(nums, key1, false));

    StdOut.println("\nSearching for left most " + key2 + ": " + binarySearch(nums, key2, true));
    StdOut.println("Searching for right most " + key2 + ": " + binarySearch(nums, key2, false));

    StdOut.println("\nSearching for left most " + key3 + ": " + binarySearch(nums, key3, true));
    StdOut.println("Searching for right most " + key3 + ": " + binarySearch(nums, key3, false));

    StdOut.println("\nSearching for left most " + key4 + ": " + binarySearch(nums, key4, true));
  }

  /**
   * binary search with duplicates
   *
   * @param array - list to search through.
   * @param elem - number to search for.
   * @param searchLeft - will return left most index if true, and right most index otherwise.
   * @return
   */
  private static int binarySearch(int[] array, int elem, boolean searchLeft) {
    int left = 0;
    int right = array.length - 1;
    int index = -1;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (array[middle] == elem) {
        index = middle;
        if (searchLeft) right = middle - 1;
        else left = middle + 1;
      }

      if (array[middle] < elem) left = middle + 1;
      else if (array[middle] > elem) right = middle - 1;
    }

    return index;
  }
}
