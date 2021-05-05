package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise22 {
  public static int iterativeBinarySearch(int[] nums, int n) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int middle = (left + right) / 2;

      if (nums[middle] < n) left = middle + 1;
      else if (nums[middle] > n) right = middle - 1;
      else return middle;
    }
    return -1;
  }

  private static int innerBinarySearch(int[] nums, int n, int left, int right) {
    if (left > right) return -1;

    int middle = (left + right) / 2;

    if (nums[middle] == n) return middle;
    if (nums[middle] < n) return innerBinarySearch(nums, n, middle + 1, right);
    if (nums[middle] > n) return innerBinarySearch(nums, n, left, middle - 1);

    return -1;
  }

  public static int recursiveBinarySearch(int[] nums, int n) {
    return innerBinarySearch(nums, n, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 100};
    int indexAt = recursiveBinarySearch(nums, 100);
    StdOut.println(indexAt);
  }
}
