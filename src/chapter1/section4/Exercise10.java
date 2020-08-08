package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise10 {
  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15, 15, 15, 15};
    StdOut.println(binarySearch(nums, 3));

    StdOut.println(recursiveBinarySearch(nums, 3, 0, nums.length));
  }

  public static int recursiveBinarySearch(int[] array, int elem, int left, int right) {
    if (left > right) return -1;

    int middle = left + (right - left) / 2;
    int middleValue = array[middle];

    if (middleValue < elem) {
      return recursiveBinarySearch(array, elem, middle + 1, right);
    } else if (middleValue > elem) {
      return recursiveBinarySearch(array, elem, left, middle - 1);
    }

    // Found a match at middle index
    int possibleSmallest = recursiveBinarySearch(array, elem, left, middle - 1);
    if (possibleSmallest == -1) return middle;
    return possibleSmallest;
  }

  public static int binarySearch(int[] array, int elem) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int middle = left + (right - left) / 2;
      int midValue = array[middle];

      if (midValue < elem) {
        left = middle + 1;
      } else if (midValue > elem || middle > 0 && array[middle - 1] == elem) {
        // elems are sorted, so when we do find a match, we are checking the element left of us
        // to see if that value is repeated.
        right = middle - 1;
      } else {
        return middle;
      }
    }

    return -1;
  }
}
