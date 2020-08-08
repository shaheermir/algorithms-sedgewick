package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise11 {
  public static void main(String[] args) {
    int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
    int key1 = 5;
    int key2 = 2;
    int key3 = 9;
    int key4 = 10;

    StdOut.println(Arrays.toString(nums));
    StdOut.println();
    StdOut.println("How many " + key1 + "s ? " + howMany(nums, key1));
    StdOut.println("How many " + key2 + "s ? " + howMany(nums, key2));
    StdOut.println("How many " + key3 + "s ? " + howMany(nums, key3));
    StdOut.println("How many " + key4 + "s ? " + howMany(nums, key4));
  }

  private static int howMany(int[] array, int elem) {
    int leftMostIndex = binarySearch(array, elem, true);
    if (leftMostIndex == -1) return 0;
    int rightMostIndex = binarySearch(array, elem, false);

    return rightMostIndex - leftMostIndex + 1;
  }

  /**
   * @param array - list to search through.
   * @param elem - number to search for.
   * @param searchFirst - will return left most index if true, and right most index otherwise.
   * @return
   */
  private static int binarySearch(int[] array, int elem, boolean searchFirst) {
    int left = 0;
    int right = array.length - 1;
    int index = -1;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (array[middle] == elem) {
        index = middle;
        if (searchFirst) right = middle - 1;
        else left = middle + 1;
      }

      if (array[middle] < elem) left = middle + 1;
      else if (array[middle] > elem) right = middle - 1;
    }

    return index;
  }
}
