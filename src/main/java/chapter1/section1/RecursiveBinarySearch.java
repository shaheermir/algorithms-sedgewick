package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class RecursiveBinarySearch {

  public static int recursiveBinarySearch(int[] nums, int key) {
    return innerBinarySearch(nums, key, 0, nums.length - 1);
  }

  private static int innerBinarySearch(int[] nums, int key, int left, int right) {
    if (left > right) return -1;

    int mid = (left + right) / 2;

    if (nums[mid] == key) return mid;
    else if (nums[mid] < key) return innerBinarySearch(nums, key, mid + 1, right);
    else if (nums[mid] > key) return innerBinarySearch(nums, key, left, mid - 1);

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 11, 18, 99};

    StdOut.println(Arrays.toString(nums));

    StdOut.println("Search for 2 yields " + recursiveBinarySearch(nums, 2));
    StdOut.println("Search for 4 yields " + recursiveBinarySearch(nums, 4));
    StdOut.println("Search for 55 yields " + recursiveBinarySearch(nums, 55));
    StdOut.println("Search for 18 yields " + recursiveBinarySearch(nums, 18));
    StdOut.println("Search for 99 yields " + recursiveBinarySearch(nums, 99));
  }
}
