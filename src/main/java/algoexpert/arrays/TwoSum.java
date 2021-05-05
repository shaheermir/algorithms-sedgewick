package algoexpert.arrays;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes in a non-empty array of distinct integers and an integer representing
 * a target sum. If any two numbers in the input array sum up to the target sum, the function should
 * return them in an array, in any order. If no two numbers sum up to the target sum, the function
 * should return an empty array.
 *
 * <p>Note that target sum has to eb obtained by summing two different integers in the array; you
 * can't add a single integer to itself in order to obtain the target sum.
 *
 * <p>You can assume that there will be at most one pair of numbers summing up to the target sum.
 */
public class TwoSum {

  // O(n) |  O(n) space
  public static int[] twoSum(int[] a, int target) {
    int[] result = new int[2];
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < a.length; i++) {
      if (set.contains(a[i])) {
        result[0] = target - a[i];
        result[1] = a[i];
        return result;
      }

      int complement = target - a[i];
      set.add(complement);
    }
    return new int[] {};
  }

  // O(nlog(n)) | O(1) space
  public static int[] twoSumFaster(int[] a, int target) {
    Arrays.sort(a);
    int left = 0, right = a.length - 1;

    while (left < right) {
      int sum = a[left] + a[right];
      if (sum > target) right--;
      else if (sum < target) left++;
      else return new int[] {a[left], a[right]};
    }

    return new int[] {};
  }

  public static void main(String[] args) {
    int[] a = twoSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
    int[] b = twoSum(new int[] {4, 6}, 10);
    int[] c = twoSum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);
    int[] cFaster = twoSumFaster(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);

    StdOut.println(Arrays.toString(c));
    StdOut.println(Arrays.toString(cFaster));
  }
}
