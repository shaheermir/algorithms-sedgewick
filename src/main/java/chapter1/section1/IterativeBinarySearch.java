package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class IterativeBinarySearch {

  public static int binarySearch(int[] nums, int key) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (nums[mid] < key) left = mid + 1;
      else if (nums[mid] > key) right = mid - 1;
      else return mid;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 11, 18, 99};

    StdOut.println(Arrays.toString(nums));

    StdOut.println("Search for 3 yields " + binarySearch(nums, 3));
    StdOut.println("Search for 4 yields " + binarySearch(nums, 4));
    StdOut.println("Search for 55 yields " + binarySearch(nums, 55));
    StdOut.println("Search for 18 yields " + binarySearch(nums, 18));
    StdOut.println("Search for 99 yields " + binarySearch(nums, 99));
  }
}
