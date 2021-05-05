package algoexpert.arrays;

import chapter1.section4.BinarySearch;
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

  public static int[] twoSumFaster(int[] a, int target) {
    Arrays.sort(a);

    for (int i = 0; i < a.length; i++) {
      int complement = target - a[i];
      int indexOfComplement = BinarySearch.ascendingBinarySearch(a, complement);

      if (indexOfComplement != -1 && indexOfComplement > i) {
        int[] result = new int[2];
        result[0] = a[i];
        result[1] = complement;
        return result;
      }
    }

    return new int[] {};
  }

  // O(nlog(n)) | O(1) space
  public static int[] twoSumEvenFaster(int[] a, int target) {
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
    int[] a = twoSumFaster(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
    int[] b = twoSumFaster(new int[] {4, 6}, 10);
    int[] c = twoSumFaster(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);

    StdOut.println(Arrays.toString(a));
    StdOut.println(Arrays.toString(b));
    StdOut.println(Arrays.toString(c));

    int[] cFaster = twoSumFaster(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);
    StdOut.println(Arrays.toString(cFaster));

    int[] d = twoSumEvenFaster(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 17);
    StdOut.println(Arrays.toString(d));
  }
}
