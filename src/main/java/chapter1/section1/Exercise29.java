package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise29 {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10};
    StdOut.println(Arrays.toString(nums));

    StdOut.println();
    StdOut.println("Key: " + 6 + " Less Than: " + lessThan(nums, 6) + " Expected: 8");
    StdOut.println("Key: " + 30 + " Less Than: " + lessThan(nums, 30) + " Expected: 13");
    StdOut.println("Key: " + 3 + " Less Than: " + lessThan(nums, 3) + " Expected: 2");

    StdOut.println();
    StdOut.println("Key: " + 6 + " Greater Than: " + greaterThan(nums, 6) + " Expected: 4");
    StdOut.println("Key: " + 30 + " Greater Than: " + greaterThan(nums, 30) + " Expected: 0");
    StdOut.println("Key: " + 3 + " Greater Than: " + greaterThan(nums, 3) + " Expected: 7");

    StdOut.println();
    StdOut.println("Key: " + 2 + " Count: " + count(nums, 2) + " Expected: 1");
    StdOut.println("Key: " + 3 + " Count: " + count(nums, 3) + " Expected: 4");
    StdOut.println("Key: " + 20 + " Count: " + count(nums, 20) + " Expected: 0");
  }

  public static int count(int[] nums, int key) {
    int lessThanKey = lessThanKey(nums, key, 0, nums.length - 1);
    int greaterThanKey = greaterThanKey(nums, key, 0, nums.length - 1);
    return nums.length - lessThanKey - greaterThanKey;
  }

  public static int lessThan(int[] nums, int key) {
    return lessThanKey(nums, key, 0, nums.length - 1);
  }

  public static int lessThanKey(int[] nums, int key, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] < key) return lessThanKey(nums, key, mid + 1, right);
      if (nums[mid] >= key) return lessThanKey(nums, key, left, mid - 1);
    }
    return left;
  }

  public static int greaterThan(int[] nums, int key) {
    return greaterThanKey(nums, key, 0, nums.length - 1);
  }

  public static int greaterThanKey(int[] nums, int key, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] <= key) return greaterThanKey(nums, key, mid + 1, right);
      if (nums[mid] > key) return greaterThanKey(nums, key, left, mid - 1);
    }

    return nums.length - 1 - right;
  }
}
