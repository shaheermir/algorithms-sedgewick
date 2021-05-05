package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

// smallest index binary search - MyCodeSchool has a really good vid.
public class Exercise10 {

  public static int binarySearch(int[] nums, int key) {
    int index = -1;

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (nums[mid] < key) {
        left = mid + 1;
      } else if (nums[mid] > key) {
        right = mid - 1;
      } else {
        index = mid;
        right = mid - 1;
      }
    }

    return index;
  }

  public static int recursiveBinarySearch(int[] nums, int key) {
    return innerBinarySearch(nums, key, 0, nums.length - 1);
  }

  private static int innerBinarySearch(int[] nums, int key, int left, int right) {
    if (left <= right) {
      int mid = (left + right) / 2;

      if (nums[mid] < key) {
        return innerBinarySearch(nums, key, mid + 1, right);
      } else if (nums[mid] > key) {
        return innerBinarySearch(nums, key, left, mid - 1);
      } else {
        int possibleSmallerIndex = innerBinarySearch(nums, key, left, mid - 1);
        if (possibleSmallerIndex == -1) return mid;
        else return possibleSmallerIndex;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10};
    StdOut.println(Arrays.toString(nums));

    StdOut.println();
    StdOut.println("Key: " + 6 + " Binary Search: " + binarySearch(nums, 6) + " Expected: 8");
    StdOut.println("Key: " + 30 + " Binary Search: " + binarySearch(nums, 30) + " Expected: -1");
    StdOut.println("Key: " + 3 + " Binary Search: " + binarySearch(nums, 3) + " Expected: 2");
    StdOut.println("Key: " + 1 + " Binary Search: " + binarySearch(nums, 1) + " Expected: 0");

    StdOut.println();
    StdOut.println("Recursive Binary Search");
    StdOut.println(
        "Key: " + 6 + " Binary Search: " + recursiveBinarySearch(nums, 6) + " Expected: 8");
    StdOut.println(
        "Key: " + 30 + " Binary Search: " + recursiveBinarySearch(nums, 30) + " Expected: -1");
    StdOut.println(
        "Key: " + 3 + " Binary Search: " + recursiveBinarySearch(nums, 3) + " Expected: 2");
    StdOut.println(
        "Key: " + 1 + " Binary Search: " + recursiveBinarySearch(nums, 1) + " Expected: 0");
  }
}
