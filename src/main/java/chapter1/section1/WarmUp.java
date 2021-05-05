package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class WarmUp {

  public static int findMax(int[] nums) {
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) if (nums[i] > max) max = nums[i];
    return max;
  }

  public static double computeAverage(int[] nums) {
    double sum = 0;
    for (int i = 0; i < nums.length; i++) sum += nums[i];
    return sum / nums.length;
  }

  public static void reverseArray(int[] nums) {
    for (int i = 0; i < nums.length / 2; i++) {
      int temp = nums[i];
      nums[i] = nums[nums.length - 1 - i];
      nums[nums.length - 1 - i] = temp;
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    StdOut.println(Arrays.toString(nums));
    StdOut.println("Max: " + findMax(nums));
    StdOut.println("Avg: " + computeAverage(nums));
  }
}
